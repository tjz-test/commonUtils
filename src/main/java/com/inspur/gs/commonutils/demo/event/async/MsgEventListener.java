package com.inspur.gs.commonutils.demo.event.async;

import com.inspur.gs.commonutils.demo.event.async.MsgEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;

/**
 * @author tjz
 * @date 2022/7/20
 * @description 事件监听实现类
 */
public class MsgEventListener {

    @Async("DF434BC62938D142E05301CB010A1E92b")
    @EventListener
    public void onMsgListener(MsgEvent msgEvent) {
        String msg = msgEvent.getMsg();
    }
}
