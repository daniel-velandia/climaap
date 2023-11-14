package com.example.climaap.presentation.presenter;

import com.example.climaap.presentation.presenter.boundary.WeatherNavigator;

import javax.inject.Inject;

public class MainPresenter {

    private WeatherNavigator weatherNavigator;

    @Inject
    public MainPresenter() {
    }

    public void setWeatherNavigator(WeatherNavigator weatherNavigator) {
        this.weatherNavigator = weatherNavigator;
    }

    public void navigateToWeatherActivity(String city) {
        weatherNavigator.launch(city);
    }
}
