package com.musala.weatherapp.pojo.ui.splash;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.musala.weatherapp.R;
import com.musala.weatherapp.pojo.base.BaseActivity;
import com.musala.weatherapp.pojo.ui.main.MainActivity;

public class SplashActivity extends BaseActivity {

    @Override
    protected void onViewReady(Bundle savedInstanceState, Intent intent) {
        super.onViewReady(savedInstanceState, intent);

        checkAndRequestPermissions();

        new Handler().postDelayed(() -> {
            goToNext(MainActivity.class);
            finish();
        }, 2500);
    }

    @Override
    protected int getContentView() {
        return R.layout.activity_splash;
    }
}
