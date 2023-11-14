package com.example.climaap.presentation.di;

import com.example.climaap.Thread.ExecutorImpl;
import com.example.climaap.Thread.MainThreadImpl;
import com.example.climaap.domain.executor.Executor;
import com.example.climaap.domain.executor.MainThread;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;

@Module
@InstallIn(SingletonComponent.class)
public interface AppModule {

    @Singleton
    @Binds
    Executor bindsExecutor(ExecutorImpl executor);

    @Singleton
    @Binds
    MainThread bindsMainThread(MainThreadImpl mainThread);
}
