package com.kangtong.nalingweather.service;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by kangt on 2017/4/4.
 */

public class ApiService {

  public static HeWeatherService createHeWeatherService() {
    return retrofit().create(HeWeatherService.class);
  }

  private static Retrofit retrofit() {
    Retrofit retrofit = new Retrofit.Builder()
        .baseUrl("https://free-api.heweather.com/v5/")
        .addConverterFactory(GsonConverterFactory.create())
        .build();
    return retrofit;
  }
}
