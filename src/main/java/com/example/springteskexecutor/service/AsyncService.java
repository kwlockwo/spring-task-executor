package com.example.springteskexecutor.service;

import com.example.springteskexecutor.ExampleThread;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.task.TaskExecutor;

public class AsyncService {

    @Autowired
    private TaskExecutor taskExecutor;

    @Autowired
    private ApplicationContext applicationContext;

    public void executeAsync() {
        ExampleThread exampleThread = applicationContext.getBean(ExampleThread.class);
        taskExecutor.execute(exampleThread);
    }
}
