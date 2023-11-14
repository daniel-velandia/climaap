package com.example.climaap.domain.model;

import com.google.gson.annotations.SerializedName;

public class SysModel {

    @SerializedName("country")
    private String country;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
