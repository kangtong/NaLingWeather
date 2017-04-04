package com.kangtong.nalingweather.util;

import android.text.TextUtils;
import com.google.gson.Gson;
import com.kangtong.nalingweather.db.City;
import com.kangtong.nalingweather.db.County;
import com.kangtong.nalingweather.db.Province;
import com.kangtong.nalingweather.model.HeWeather5;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by kangt on 2017/4/3.
 */

public class Utility {
  public static boolean handleProvinceResponse(String response) {
    if (!TextUtils.isEmpty(response)) {
      try {
        JSONArray allProvinces = new JSONArray(response);
        for (int i = 0; i < allProvinces.length(); i++) {
          JSONObject provinceObject = allProvinces.getJSONObject(i);
          Province province = new Province();
          province.setProvinceName(provinceObject.getString("name"));
          province.setProvinceCode(provinceObject.getInt("id"));
          province.save();
        }
        return true;
      } catch (JSONException e) {
        e.printStackTrace();
      }
    }
    return false;
  }

  public static boolean handleCityResponse(String response, int provinceId) {
    if (!TextUtils.isEmpty(response)) {
      try {
        JSONArray allCities = new JSONArray(response);
        for (int i = 0; i < allCities.length(); i++) {
          JSONObject cityObject = allCities.getJSONObject(i);
          City city = new City();
          city.setCityName(cityObject.getString("name"));
          city.setCityCode(cityObject.getInt("id"));
          city.setProvinceId(provinceId);
          city.save();
        }
        return true;
      } catch (JSONException e) {
        e.printStackTrace();
      }
    }
    return false;
  }

  public static boolean handleCountyResponse(String response, int cityId) {
    if (!TextUtils.isEmpty(response)) {
      try {
        JSONArray allCounties = new JSONArray(response);
        for (int i = 0; i < allCounties.length(); i++) {
          JSONObject cityObject = allCounties.getJSONObject(i);
          County county = new County();
          county.setCountyName(cityObject.getString("name"));
          county.setWeatherId(cityObject.getString("weather_id"));
          county.setCityId(cityId);
          county.save();
        }
        return true;
      } catch (JSONException e) {
        e.printStackTrace();
      }
    }
    return false;
  }

  public static HeWeather5 handleWeatherResponse(String response) {
    return new Gson().fromJson(response, HeWeather5.class);
  }

  public static String handleWeatherString(HeWeather5 heWeather5) {
    return new Gson().toJson(heWeather5);
  }
}
