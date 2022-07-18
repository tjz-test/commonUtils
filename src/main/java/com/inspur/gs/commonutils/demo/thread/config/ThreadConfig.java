package com.inspur.gs.commonutils.demo.thread.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import java.util.concurrent.ThreadPoolExecutor;

@Configuration(value = "configtestaa")
@EnableAsync
public class ThreadConfig {

    /**
     * 线程池配置
     * 核心线程数量：CorePoolSize
     * 看业务场景设置（通常设置为CPU核心*1）
     *
     * 最大线程数量：MaxPoolSize
     * 当核心线程数量都在使用状态时，会调用最大线程数量里的线程，使用的总线程不会超过最大线程数量，其余则等待（通常设置为CPU核心*2）
     *
     * 队列程度：QueueCapacity
     * 线程队列的大小
     *
     * 线程空闲时间：KeepAliveSeconds
     *
     * 线程前缀名称：ThreadNamePrefix
     *
     * 停机策略：WaitForTasksToCompleteOnShutdown
     * 该方法用来设置 线程池关闭 的时候 等待 所有任务都完成后，再继续 销毁 其他的 Bean，这样这些 异步任务 的 销毁 就会先于 数据库连接池对象 的销毁。
     *
     * 任务的等待时间：AwaitTerminationSeconds
     * 任务的等待时间 如果超过这个时间还没有销毁就 强制销毁，以确保应用最后能够被关闭，而不是阻塞住
     *
     * 拒接策略：RejectedExecutionHandler
     * 线程不够用时由调用的线程处理该任务
     */
    @Bean(name = "DF434BC62938D142E05301CB010A1E92a")
    public TaskExecutor taskExecutor(){
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        // 设置核心线程数
        executor.setCorePoolSize(20);
        // 设置最大线程数
        executor.setMaxPoolSize(40);
        // 设置队列容量
        executor.setQueueCapacity(1000);
        // 设置线程活跃时间（秒）
        executor.setKeepAliveSeconds(60);
        // 设置默认线程名称(自定义)
        executor.setThreadNamePrefix("threadxxx-");
        // 设置拒绝策略
        //ThreadPoolExecutor.AbortPolicy 默认拒绝策略，丢弃任务并抛出异常
        //ThreadPoolExecutor.DiscardOldestPolicy 丢弃队列最头部（最旧的）的任务，再次执行
        //ThreadPoolExecutor.CallerRunsPolicy 由调用线程处理任务（同步）
        //ThreadPoolExecutor.DiscardPolicy 丢弃新任务，不抛出异常
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        // 等待所有任务结束后再关闭线程池
        executor.setWaitForTasksToCompleteOnShutdown(true);
        return executor;
    }
}

