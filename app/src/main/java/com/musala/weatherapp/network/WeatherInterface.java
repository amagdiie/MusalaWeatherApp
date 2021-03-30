package com.musala.weatherapp.network;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WeatherInterface {

    @GET("weather")
    Call<WeatherPresenter> getWeather(@Query("q") String cityName, @Query("appid") String apiKey);
}
