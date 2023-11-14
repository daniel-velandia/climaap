package com.example.climaap.domain.boundary;

import com.example.climaap.domain.model.WeatherModel;

import java.io.IOException;

public interface WeatherRepository {

    WeatherModel fetchWeather(String city);
}
