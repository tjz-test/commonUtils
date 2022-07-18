package com.inspur.gs.commonutils.demo.thread.deal;

import com.inspur.edp.cdp.common.utils.spring.SpringUtil;
import com.inspur.gs.commonutils.demo.thread.handler.ThreadHandle;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * @author tianjinzan01
 */
public class TestDemo {

    /**
     * 处理器
     */
    ThreadHandle threadHandle = (ThreadHandle) SpringUtil.getBean("DF434BC62939D142E05301CB010A1E92a");

    /**
     * 主线程不等子线程
     */
    public void busDealDemo() {
        List<String> list = Arrays.asList("A","B","C","D","E");

        list.forEach(item -> threadHandle.busDealHandler(item));
    }

    /**
     * 主线程等子线程
     */
    public void busDealDemo1() throws InterruptedException {
        List<String> list = Arrays.asList("A","B","C","D","E");
        //设置线程计数器
        CountDownLatch latch = new CountDownLatch(list.size());

        list.forEach(item -> threadHandle.busDealHandler(item, latch));

        //等待子线程执行完毕
        latch.await();
    }

}
