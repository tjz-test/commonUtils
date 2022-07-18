package com.inspur.gs.commonutils.demo.thread.handler;

import com.inspur.gs.commonutils.demo.thread.deal.BusDeal;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * 多线程方法
 * @author tianjinzan01
 */
@Component("DF434BC62939D142E05301CB010A1E92a")
public class ThreadHandle {

    /**
     * 主线程不等子线程
     */
    @Async("DF434BC62938D142E05301CB010A1E92a")
    public void busDealHandler(String str) {
        try {
            //业务处理
            BusDeal.get().dealFunc(str);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 主线程等子线程执行完
     * @param latch
     */
    @Async("DF434BC62938D142E05301CB010A1E92a")
    public void busDealHandler(String str, CountDownLatch latch) {
        try {
            //业务处理
            BusDeal.get(latch).dealFunc1(str);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
