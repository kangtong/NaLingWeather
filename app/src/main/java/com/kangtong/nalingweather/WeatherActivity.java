package com.kangtong.nalingweather;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.bumptech.glide.Glide;
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
  @BindView(R.id.bing_pic_img) ImageView bingPicImg;
  @BindView(R.id.layout_aqi) LinearLayout layoutAqi;
  @BindView(R.id.swipe_refresh) SwipeRefreshLayout swipeRefresh;
  @BindView(R.id.drawer_layout) DrawerLayout drawerLayout;

  private HeWeatherService mHeWeatherService;
  private String weatherId;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    Window window = getWindow();
    window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS
        | WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
    window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
        | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
    window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
    window.setStatusBarColor(Color.TRANSPARENT);
    window.setNavigationBarColor(Color.TRANSPARENT);
    setContentView(R.layout.activity_weather);
    ButterKnife.bind(this);
    SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
    final String weatherString = preferences.getString("weather", null);
    mHeWeatherService = ApiService.createHeWeatherService();

    if (weatherString != null) {
      HeWeather5 heWeather5 = Utility.handleWeatherResponse(weatherString);
      weatherId = heWeather5.getHeWeather5().get(0).getBasic().getId();
      showWeather(heWeather5.getHeWeather5().get(0));
    } else {
      weatherId = getIntent().getStringExtra("weather_id");
      weatherLayout.setVisibility(View.INVISIBLE);
      requestWeather(weatherId);
    }
    swipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
      @Override public void onRefresh() {
        requestWeather(weatherId);
      }
    });
    Glide.with(this)
        .load("https://unsplash.it/720/1280/?random")
        .placeholder(R.drawable.background)
        .into(bingPicImg);
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
        swipeRefresh.setRefreshing(false);
      }

      @Override public void onFailure(Call<HeWeather5> call, Throwable t) {
        Log.d("key", t.getMessage());
        swipeRefresh.setRefreshing(false);
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
    } else {
      layoutAqi.setVisibility(View.GONE);
    }
    comfortText.setText("舒适度：" + heWeather5Bean.getSuggestion().getComf().getTxt());
    carWashText.setText("洗车指数：" + heWeather5Bean.getSuggestion().getCw().getTxt());
    sportText.setText("运动建议：" + heWeather5Bean.getSuggestion().getSport().getTxt());
    weatherLayout.setVisibility(View.VISIBLE);
  }

  @OnClick(R.id.nav_button) public void onViewClicked() {
    drawerLayout.openDrawer(GravityCompat.START);
  }
}
