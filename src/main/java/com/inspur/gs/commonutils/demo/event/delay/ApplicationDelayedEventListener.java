package com.inspur.gs.commonutils.demo.event.delay;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;

/**
 * @author tjz
 * @date 2022/7/20
 * @description
 */
@Slf4j
public class ApplicationDelayedEventListener {

    @Async ("DF434BC62938D142E05301CB010A1E92b")
    @EventListener
    public void listenDelayEvent(ApplicationDelayedEvent event) {
        log.info("收到执行事件：{}", event.getSource());
    }
}
