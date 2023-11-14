package com.example.climaap.presentation.view;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;

import com.bumptech.glide.Glide;
import com.example.climaap.databinding.ActivityWeatherBinding;
import com.example.climaap.domain.model.WeatherModel;
import com.example.climaap.presentation.navigator.WeatherNavigatorImpl;
import com.example.climaap.presentation.presenter.WeatherPresenter;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class WeatherActivity extends AppCompatActivity implements WeatherPresenter.View {

    @Inject
    WeatherPresenter weatherPresenter;
    @Inject
    WeatherNavigatorImpl weatherNavigator;
    private ActivityWeatherBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityWeatherBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        initWeatherNavigator();
        initAndCallPresenter();
    }

    private void initWeatherNavigator() {
        weatherNavigator.setActivity(this);
        weatherNavigator.setIntent(getIntent());
    }

    private void initAndCallPresenter() {
        weatherPresenter.setWeatherNavigator(weatherNavigator);
        weatherPresenter.setView(this);

        weatherPresenter.fetchWeather();
    }

    @Override
    public void onLoading() {
        binding.progress.setVisibility(View.VISIBLE);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void displayWeather(WeatherModel weatherModel) {
        binding.progress.setVisibility(View.GONE);

        Glide.with(this)
                .load("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQRj6UtmbPRATKyZCQFC6-iHr-nmtOK_kfMn8KQQbuN2omKCA44VA-WwcVUHepxBxcdIsQ&usqp=CAU")
                .into(binding.cityIv);

        binding.cityTv.setText(
                String.format("%s %s", weatherModel.getName(), weatherModel.getSysModel().getCountry()));

        binding.tempTv.setText(
                String.format("Temperatura: %s°C", weatherModel.getMainWeatherModel().getTemp()));

        binding.feelsLikeTv.setText(
                String.format("Sensación térmica: %s°C", weatherModel.getMainWeatherModel().getFeelsLike()));

        binding.humidityTv.setText(
                String.format("Humedad: %s%%", weatherModel.getMainWeatherModel().getHumidity()));
    }
}