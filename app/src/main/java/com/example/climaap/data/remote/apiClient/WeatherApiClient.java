package com.example.climaap.data.remote.apiClient;

import com.example.climaap.domain.model.WeatherModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WeatherApiClient {

    @GET("weather")
    Call<WeatherModel> fetchWeather(@Query("appid") String apiKey,
                                    @Query("units") String units,
                                    @Query("q") String city);
}
