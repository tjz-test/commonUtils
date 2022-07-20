package com.inspur.gs.commonutils.demo.event.async;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.ApplicationEvent;

/**
 * @author tjz
 * @date 2022/7/20
 * @description 消息事件
 */
@Getter
@Setter
public class MsgEvent extends ApplicationEvent {

    private String msg;

    public MsgEvent (String msg) {
        super(msg);
        this.msg = msg;
    }
}
