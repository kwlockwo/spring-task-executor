package com.example.springteskexecutor;

import com.example.springteskexecutor.service.AsyncService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class MyScheduler {

    private static final Logger LOGGER = LoggerFactory.getLogger(AsyncService.class);

    @Autowired
    private AsyncService asyncService;

    private int count = 0;

    @Scheduled(fixedRate = 15000)
    public void runTheTask() {
        LOGGER.info("Schedule Task");
        count++;
        asyncService.executeAsync(count);
        LOGGER.info("Task Scehduled");
    }
}