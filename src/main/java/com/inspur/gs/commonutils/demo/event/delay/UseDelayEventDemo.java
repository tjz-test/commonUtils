package com.inspur.gs.commonutils.demo.event.delay;

import com.inspur.gs.commonutils.demo.event.async.MsgEvent;

/**
 * @author tjz
 * @date 2022/7/20
 * @description
 */
public class UseDelayEventDemo {

    private final ApplicationDelayEventPublisher applicationDelayEventPublisher;

    public UseDelayEventDemo(ApplicationDelayEventPublisher applicationDelayEventPublisher) {
        this.applicationDelayEventPublisher = applicationDelayEventPublisher;
    }

    public void sendMsg(String msg) {
        applicationDelayEventPublisher.publishEvent(new ApplicationDelayedEvent(msg, 3L));
    }
}
