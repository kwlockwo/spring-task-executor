package com.example.springteskexecutor.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
@EnableAsync
public class ThreadConfig {

    @Bean
    @Primary
    public TaskExecutor threadPoolTaskExecutor() {
        boolean WAIT_FOR_TASK_COMPLETION = Boolean.parseBoolean(System.getenv("WAIT_FOR_TASK_COMPLETION"));
        int AWAIT_TERMINATION = Integer.parseInt(System.getenv("AWAIT_TERMINATION"));

        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(5);
        executor.setMaxPoolSize(5);
        executor.setThreadNamePrefix("TaskExecutorThread");

        executor.setWaitForTasksToCompleteOnShutdown(WAIT_FOR_TASK_COMPLETION);
        executor.setAwaitTerminationSeconds(AWAIT_TERMINATION);

        executor.initialize();

        return executor;
    }

    @Bean(name = "asyncTaskExecutor")
    public TaskExecutor asyncTaskExecutor() {
        boolean WAIT_FOR_TASK_COMPLETION_ASYNC = Boolean.parseBoolean(System.getenv("WAIT_FOR_TASK_COMPLETION_ASYNC"));
        int AWAIT_TERMINATION_ASYNC = Integer.parseInt(System.getenv("AWAIT_TERMINATION_ASYNC"));

        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(5);
        executor.setMaxPoolSize(5);
        executor.setThreadNamePrefix("TaskExecutorThreadAsync");

        executor.setWaitForTasksToCompleteOnShutdown(WAIT_FOR_TASK_COMPLETION_ASYNC);
        executor.setAwaitTerminationSeconds(AWAIT_TERMINATION_ASYNC);

        executor.initialize();

        return executor;
    }
}
