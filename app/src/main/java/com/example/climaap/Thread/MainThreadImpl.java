package com.example.climaap.Thread;

import android.os.Handler;
import android.os.Looper;

import com.example.climaap.domain.executor.MainThread;

import javax.inject.Inject;

public class MainThreadImpl implements MainThread {

    private Handler handler;

    @Inject
    public MainThreadImpl() {
        this.handler = new Handler(Looper.getMainLooper());
    }


    @Override
    public void execute(Runnable runnable) {
        handler.post(runnable);
    }
}
