package com.example.climaap.presentation.navigator;

import android.app.Activity;
import android.content.Intent;

import com.example.climaap.presentation.presenter.boundary.WeatherNavigator;
import com.example.climaap.presentation.view.WeatherActivity;

import javax.inject.Inject;

public class WeatherNavigatorImpl implements WeatherNavigator {

    private Activity activity;
    private Intent intent;

    @Inject
    public WeatherNavigatorImpl() {
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    public void setIntent(Intent intent) {
        this.intent = intent;
    }

    @Override
    public void launch(String city) {
        Intent intentLaunch = new Intent(activity, WeatherActivity.class);
        intentLaunch.putExtra("city", city);

        activity.startActivity(intentLaunch);
    }

    @Override
    public String getCity() {
        return intent.getExtras().getString("city");
    }

    @Override
    public void finish() {
        activity.finish();
    }
}
