package com.inspur.gs.commonutils.demo.event.async;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;

/**
 * @author tjz
 * @date 2022/7/20
 * @description
 */
@Slf4j
public class UseEventDemo {

    private final ApplicationEventPublisher applicationEventPublisher;

    public UseEventDemo(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }

    public void sendMsg(String msg) {
        applicationEventPublisher.publishEvent(new MsgEvent(msg));
    }
}
