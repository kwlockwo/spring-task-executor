package com.example.springteskexecutor;

import com.example.springteskexecutor.service.AsyncService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Worker {

    @Autowired
    private AsyncService asyncService;

    private int count = 0;

    @Scheduled(fixedDelay = 10000)
    public void checkTheScedule() {
        count++;
        asyncService.executeAsync(count);;
    }
}