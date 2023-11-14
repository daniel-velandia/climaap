package com.example.climaap.presentation.di;

import com.example.climaap.data.WeatherRepositoryImpl;
import com.example.climaap.domain.boundary.WeatherRepository;
import com.example.climaap.presentation.navigator.WeatherNavigatorImpl;
import com.example.climaap.presentation.presenter.boundary.WeatherNavigator;

import dagger.Binds;
import dagger.Module;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ActivityComponent;

@Module
@InstallIn(ActivityComponent.class)
public interface WeatherModule {

    @Binds
    WeatherRepository bindsWeatherRepository(WeatherRepositoryImpl weatherRepository);

    @Binds
    WeatherNavigator bindsWeatherNavigator(WeatherNavigatorImpl weatherNavigator);
}
