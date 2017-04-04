package com.kangtong.nalingweather;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.kangtong.nalingweather.model.HeWeather5;
import com.kangtong.nalingweather.service.ApiService;
import com.kangtong.nalingweather.service.HeWeatherService;
import com.kangtong.nalingweather.util.Constant;
import com.kangtong.nalingweather.util.Utility;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WeatherActivity extends AppCompatActivity {

  @BindView(R.id.title_city) TextView titleCity;
  @BindView(R.id.title_update_time) TextView titleUpdateTime;
  @BindView(R.id.degree_text) TextView degreeText;
  @BindView(R.id.weather_info_text) TextView weatherInfoText;
  @BindView(R.id.forecast_layout) LinearLayout forecastLayout;
  @BindView(R.id.aqi_text) TextView aqiText;
  @BindView(R.id.pm25_text) TextView pm25Text;
  @BindView(R.id.comfort_text) TextView comfortText;
  @BindView(R.id.car_wash_text) TextView carWashText;
  @BindView(R.id.sport_text) TextView sportText;
  @BindView(R.id.weather_layout) ScrollView weatherLayout;

  private HeWeatherService mHeWeatherService;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_weather);
    ButterKnife.bind(this);
    SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
    String weatherString = preferences.getString("weather", null);
    mHeWeatherService = ApiService.createHeWeatherService();
    if (weatherString != null) {
      HeWeather5 heWeather5 = Utility.handleWeatherResponse(weatherString);
      showWeather(heWeather5.getHeWeather5().get(0));
    } else {
      String weatherId = getIntent().getStringExtra("weather_id");
      weatherLayout.setVisibility(View.INVISIBLE);
      requestWeather(weatherId);
    }
  }

  public void requestWeather(final String weatherId) {
    Call<HeWeather5> weather = mHeWeatherService.getWeather(weatherId, Constant.KEY);
    weather.enqueue(new Callback<HeWeather5>() {
      @Override public void onResponse(Call<HeWeather5> call, Response<HeWeather5> response) {
        SharedPreferences.Editor editor =
            PreferenceManager.getDefaultSharedPreferences(WeatherActivity.this).edit();
        editor.putString("weather", Utility.handleWeatherString(response.body()));
        editor.apply();
        showWeather(response.body().getHeWeather5().get(0));
      }

      @Override public void onFailure(Call<HeWeather5> call, Throwable t) {
        Log.d("key", t.getMessage());
      }
    });
  }

  private void showWeather(HeWeather5.HeWeather5Bean heWeather5Bean) {
    titleCity.setText(heWeather5Bean.getBasic().getCity());
    titleUpdateTime.setText(heWeather5Bean.getBasic().getUpdate().getLoc());
    degreeText.setText(heWeather5Bean.getNow().getTmp() + "℃");
    weatherInfoText.setText(heWeather5Bean.getNow().getCond().getTxt());
    forecastLayout.removeAllViews();
    for (HeWeather5.HeWeather5Bean.DailyForecastBean daily :
        heWeather5Bean.getDaily_forecast()) {
      View view = LayoutInflater.from(this).inflate(R.layout.forecast_item, forecastLayout, false);
      TextView dateText = (TextView) view.findViewById(R.id.date_text);
      TextView infoText = (TextView) view.findViewById(R.id.info_text);
      TextView maxText = (TextView) view.findViewById(R.id.max_text);
      TextView minText = (TextView) view.findViewById(R.id.min_text);
      dateText.setText(daily.getDate());
      infoText.setText(daily.getCond().getTxt_d() + "~" + daily.getCond().getTxt_n());
      maxText.setText(daily.getTmp().getMax() + "℃");
      minText.setText(daily.getTmp().getMin() + "℃");
      forecastLayout.addView(view);
    }
    if (heWeather5Bean.getAqi() != null) {
      aqiText.setText(heWeather5Bean.getAqi().getCity().getAqi());
      pm25Text.setText(heWeather5Bean.getAqi().getCity().getPm25());
    }
    comfortText.setText("舒适度：" + heWeather5Bean.getSuggestion().getComf().getTxt());
    carWashText.setText("洗车指数：" + heWeather5Bean.getSuggestion().getCw().getTxt());
    sportText.setText("运动建议：" + heWeather5Bean.getSuggestion().getSport().getTxt());
    weatherLayout.setVisibility(View.VISIBLE);
  }
}
