package com.example.climaap.data.remote;

import com.example.climaap.data.remote.apiClient.WeatherApiClient;
import com.example.climaap.domain.model.WeatherModel;

import java.io.IOException;

import javax.inject.Inject;

public class WeatherRemoteDataSource {

    private final WeatherApiClient weatherApiClient;
    private final String API_KEY = "07dd8fef7c7509613c491da20ef0d1d9";
    private final String UNITS = "metric";

    @Inject
    public WeatherRemoteDataSource(WeatherApiClient weatherApiClient) {
        this.weatherApiClient = weatherApiClient;
    }

    public WeatherModel fetchWeather(String city) throws IOException {
        retrofit2.Response<WeatherModel> response =
                weatherApiClient.fetchWeather(API_KEY, UNITS, city).execute();

        if (response.isSuccessful())
            return response.body();
        else
            throw new IOException("Error fetching weather: " + response.message());

    }
}
