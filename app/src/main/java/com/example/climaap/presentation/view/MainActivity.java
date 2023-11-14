package com.example.climaap.presentation.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.climaap.databinding.ActivityMainBinding;
import com.example.climaap.presentation.navigator.WeatherNavigatorImpl;
import com.example.climaap.presentation.presenter.MainPresenter;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class MainActivity extends AppCompatActivity {

    @Inject
    MainPresenter mainPresenter;
    @Inject
    WeatherNavigatorImpl weatherNavigator;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        initWeatherNavigator();
        initPresenter();
        initComponents();
    }

    private void initWeatherNavigator() {
        weatherNavigator.setActivity(this);
    }

    private void initPresenter() {
        mainPresenter.setWeatherNavigator(weatherNavigator);
    }

    private void initComponents() {
        binding.sendBtn.setOnClickListener(View -> {
            String city = binding.weatherEt.getText().toString().trim();
            mainPresenter.navigateToWeatherActivity(city);
        });
    }
}