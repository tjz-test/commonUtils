package com.inspur.gs.commonutils.demo.event.delay;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.DelayQueue;

/**
 * @author tjz
 * @date 2022/7/20
 * @description
 */
@Slf4j
@Component
public class ApplicationDelayEventPublisher implements ApplicationRunner {

    private final DelayQueue<ApplicationDelayedEvent> delayQueue = new DelayQueue<>();

    @Autowired
    private ApplicationEventPublisher eventPublisher;

    @Autowired
    @Qualifier("DF434BC62938D142E05301CB010A1E92c")
    private ThreadPoolTaskExecutor poolTaskExecutor;

    public void publishEvent(ApplicationDelayedEvent event) {
        boolean result = delayQueue.offer(event);
        log.info("加入延迟队列。。。。{}", result);
    }

    @Override
    public void run(ApplicationArguments args) {
        poolTaskExecutor.execute(this :: watchThread);
    }

    private void watchThread() {
        while (true) {
            try {
                log.info("启动延时任务的监听线程。。。。");
                ApplicationDelayedEvent event = this.delayQueue.take();
                log.info("接收到延时任务执行。。。{}", ZonedDateTime.now().format(DateTimeFormatter.ISO_OFFSET_DATE_TIME));
                eventPublisher.publishEvent(event);
            } catch (InterruptedException e) {
                log.info("启动延时任务的监听线程关闭");
                this.delayQueue.clear();
                break;
            }
        }
    }
}