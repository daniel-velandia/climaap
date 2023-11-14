package com.example.climaap.domain.model;

import com.google.gson.annotations.SerializedName;

public class MainWeatherModel {

    @SerializedName("temp")
    private String temp;
    @SerializedName("feels_like")
    private String feelsLike;
    @SerializedName("humidity")
    private String humidity;

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    public String getFeelsLike() {
        return feelsLike;
    }

    public void setFeelsLike(String feelsLike) {
        this.feelsLike = feelsLike;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }
}
