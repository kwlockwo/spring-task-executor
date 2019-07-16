package com.example.springteskexecutor;

import com.example.springteskexecutor.service.AsyncService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class MyScheduler {

    @Autowired
    private AsyncService asyncService;

    private int aCount = 0;
    private int bCount = 0;

    @Scheduled(fixedRate = 15000)
    public void runTheTask() {
        aCount++;
        asyncService.executeAsync(aCount);;
    }

    @Scheduled(fixedRate = 15000)
    public void runTheThread() {
        bCount++;
        asyncService.executeThread(bCount);;
    }
}