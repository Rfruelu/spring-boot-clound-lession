package com.lujia.async;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

/**
 *
 * @EnableAsync  表示开启异步支持
 * @Configuration  配置类
 * @author :lujia
 * @date :2018/12/13  17:04
 */
@Configuration
@EnableAsync
public class AsyncListenerConfiguration implements AsyncConfigurer{

    /**
     * 设置异步执行的线程池对象
     * @return
     */
    @Override
    public Executor getAsyncExecutor() {
        //spring 内部的线程池对象
        ThreadPoolTaskExecutor threadPoolTaskExecutor =new ThreadPoolTaskExecutor();
        threadPoolTaskExecutor.setCorePoolSize(5);
        threadPoolTaskExecutor.setMaxPoolSize(10);
        threadPoolTaskExecutor.setQueueCapacity(25);
        threadPoolTaskExecutor.initialize();

        return threadPoolTaskExecutor;
    }
}
