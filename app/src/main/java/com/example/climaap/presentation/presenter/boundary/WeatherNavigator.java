package com.example.climaap.presentation.presenter.boundary;

public interface WeatherNavigator {

    void launch(String city);
    String getCity();
    void finish();
}
