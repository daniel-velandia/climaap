package com.example.climaap.Thread;

import com.example.climaap.domain.executor.Executor;

import javax.inject.Inject;

public class ExecutorImpl implements Executor {

    @Inject
    public ExecutorImpl() {
    }

    @Override
    public void execute(Runnable runnable) {
        new Thread(runnable).start();
    }
}
