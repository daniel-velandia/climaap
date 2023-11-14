package com.example.climaap.domain.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class WeatherModel {

    @SerializedName("main")
    private MainWeatherModel mainWeatherModel;
    @SerializedName("sys")
    private SysModel sysModel;
    @SerializedName("name")
    private String name;

    public MainWeatherModel getMainWeatherModel() {
        return mainWeatherModel;
    }

    public void setMainWeatherModel(MainWeatherModel mainWeatherModel) {
        this.mainWeatherModel = mainWeatherModel;
    }

    public SysModel getSysModel() {
        return sysModel;
    }

    public void setSysModel(SysModel sysModel) {
        this.sysModel = sysModel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
