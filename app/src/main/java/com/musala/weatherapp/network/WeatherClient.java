package com.musala.weatherapp.network;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class WeatherClient {
    private static final String BASE_URL = "http://api.openweathermap.org/data/2.5/";
    private static final String API_KEY= "83002212824feb100326704f965999ae";
    private WeatherInterface weatherInterface;
    private static WeatherClient INSTANCE;

    public WeatherClient() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        weatherInterface = retrofit.create(WeatherInterface.class);
    }

    public static WeatherClient getINSTANCE() {
        if (null == INSTANCE){
            INSTANCE = new WeatherClient();
        }
        return INSTANCE;
    }

    public Call<WeatherPresenter> getWeather(String cityName){
        return weatherInterface.getWeather(cityName, API_KEY);
    }
}
