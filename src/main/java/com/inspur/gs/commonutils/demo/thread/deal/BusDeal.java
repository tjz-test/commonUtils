package com.inspur.gs.commonutils.demo.thread.deal;

import java.util.concurrent.CountDownLatch;

public class BusDeal {

    private CountDownLatch latch;

    public BusDeal() {}

    public BusDeal(CountDownLatch latch) {
        this.latch = latch;
    }

    public static BusDeal get() {
        return new BusDeal();
    }

    public static BusDeal get(CountDownLatch latch) {
        return new BusDeal(latch);
    }


    public void dealFunc(String str) {
        //业务处理
    }

    public void dealFunc1(String str) {
        //业务处理
        //str ...
        latch.countDown();
    }
}
