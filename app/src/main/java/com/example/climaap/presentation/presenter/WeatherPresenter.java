package com.example.climaap.presentation.presenter;

import com.example.climaap.domain.model.WeatherModel;
import com.example.climaap.domain.useCase.FetchWeatherUseCase;
import com.example.climaap.presentation.presenter.boundary.WeatherNavigator;

import javax.inject.Inject;

public class WeatherPresenter {

    private final FetchWeatherUseCase fetchWeatherUseCase;
    private WeatherNavigator weatherNavigator;
    private View view;

    private String city;

    @Inject
    public WeatherPresenter(FetchWeatherUseCase fetchWeatherUseCase) {
        this.fetchWeatherUseCase = fetchWeatherUseCase;
    }

    public void setWeatherNavigator(WeatherNavigator weatherNavigator) {
        this.weatherNavigator = weatherNavigator;
        this.city = weatherNavigator.getCity();
    }

    public void setView(View view) {
        this.view = view;
    }

    public void fetchWeather() {
        view.onLoading();

        fetchWeatherUseCase.execute(city, new FetchWeatherUseCase.Callback() {
            @Override
            public void onSuccess(WeatherModel weatherModel) {
                view.displayWeather(weatherModel);
            }

            @Override
            public void onError() {
                weatherNavigator.finish();
            }
        });
    }

    public interface View {

        void onLoading();
        void displayWeather(WeatherModel weatherModel);
    }
}
