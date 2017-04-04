package com.kangtong.nalingweather.service;

import com.kangtong.nalingweather.model.HeWeather5;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by kangt on 2017/4/4.
 */

public interface HeWeatherService {
  @GET("weather") Call<HeWeather5> getWeather(@Query("city") String city, @Query("key") String key);
}
