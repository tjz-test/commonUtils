package com.inspur.gs.commonutils.demo.rpc.impl;

import com.inspur.gs.commonutils.demo.rpc.DemoInterface;

public class DemoImpl implements DemoInterface {

    /**
     * 禁止使用非 final 的全局变量
     * 如果如此使用，则方法需要增加同步锁 来保证线程安全
     */
    private String msg;

    @Override
    public synchronized void demoFunction(String xxx) {
        //具体实现
        msg = xxx;
    }
}
