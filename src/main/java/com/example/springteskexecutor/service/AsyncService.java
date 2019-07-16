package com.example.springteskexecutor.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalTime;
import java.util.concurrent.TimeUnit;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class AsyncService {

    private static final Logger LOGGER = LoggerFactory.getLogger(AsyncService.class);

    @Autowired
    private DataSource dataSource;

    @Async
    public void executeAsync(int count) {
        for (int i = 1; i <= 15; i++) {
            try (Connection conn = dataSource.getConnection()) {
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("select uuid_generate_v4()");

                while (rs.next()) {
                    LOGGER.info("Run: {}:{}, Thread: {}, UUID: {}, Time: {}", count, i, Thread.currentThread().getName(), rs.getString(1), LocalTime.now());
                }

                rs.close();
                stmt.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                LOGGER.info("Run: {}:{}, Thread: {}, Thread interrupted during sleep, Time: {}", count, i, Thread.currentThread().getName(), LocalTime.now());
            }
        }
    }
}
