package com.example.climaap.domain.useCase;

import com.example.climaap.domain.boundary.WeatherRepository;
import com.example.climaap.domain.executor.Executor;
import com.example.climaap.domain.executor.MainThread;
import com.example.climaap.domain.model.WeatherModel;

import javax.inject.Inject;

public class FetchWeatherUseCase {

    private final Executor executor;
    private final MainThread mainThread;
    private final WeatherRepository weatherRepository;

    @Inject
    public FetchWeatherUseCase(Executor executor,
                               MainThread mainThread,
                               WeatherRepository weatherRepository) {

        this.executor = executor;
        this.mainThread = mainThread;
        this.weatherRepository = weatherRepository;
    }

    public void execute(String city, Callback callback) {
        executor.execute(new Task(city, callback));
    }

    private class Task implements Runnable {

        private final String city;
        private final Callback callback;

        public Task(String city, Callback callback) {
            this.city = city;
            this.callback = callback;
        }

        @Override
        public void run() {
            WeatherModel weatherModel = weatherRepository.fetchWeather(city);

            if(weatherModel != null)
                onSuccess(weatherModel);
            else
                onError();
        }

        private void onSuccess(WeatherModel weatherModel) {
            mainThread.execute(() -> callback.onSuccess(weatherModel));
        }

        private void onError() {
            mainThread.execute(callback::onError);
        }
    }

    public interface Callback {

        void onSuccess(WeatherModel weatherModel);
        void onError();
    }
}
