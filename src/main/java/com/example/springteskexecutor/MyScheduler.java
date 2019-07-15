package com.example.springteskexecutor;

import com.example.springteskexecutor.service.AsyncService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class MyScheduler {

    @Autowired
    private AsyncService asyncService;

    private int count = 0;

    @Scheduled(fixedRate = 15000)
    public void runTheTask() {
        count++;
        asyncService.executeAsync(count);;
    }
}