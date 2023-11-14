package com.example.climaap.data;

import com.example.climaap.data.remote.WeatherRemoteDataSource;
import com.example.climaap.domain.boundary.WeatherRepository;
import com.example.climaap.domain.model.WeatherModel;

import java.io.IOException;

import javax.inject.Inject;

public class WeatherRepositoryImpl implements WeatherRepository {

    private final WeatherRemoteDataSource weatherRemoteDataSource;

    @Inject
    public WeatherRepositoryImpl(WeatherRemoteDataSource weatherRemoteDataSource) {
        this.weatherRemoteDataSource = weatherRemoteDataSource;
    }

    @Override
    public WeatherModel fetchWeather(String city) {
        try {
            return weatherRemoteDataSource.fetchWeather(city);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
