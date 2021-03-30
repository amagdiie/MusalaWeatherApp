package com.musala.weatherapp.pojo.ui.main;

import android.util.Log;
import android.widget.Toast;

import com.musala.weatherapp.network.WeatherClient;
import com.musala.weatherapp.network.WeatherPresenter;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WeatherViewModel extends ViewModel {

    MutableLiveData<WeatherPresenter> weatherMutableLiveData = new MutableLiveData<>();

    public void getWeather(String cityName){
        WeatherClient.getINSTANCE().getWeather(cityName).enqueue(new Callback<WeatherPresenter>() {
            @Override
            public void onResponse(Call<WeatherPresenter> call, Response<WeatherPresenter> response) {
                weatherMutableLiveData.setValue(response.body());
            }

            @Override
            public void onFailure(Call<WeatherPresenter> call, Throwable t) {
                Log.e("MVVM", t.getMessage());
            }
        });
    }
}
