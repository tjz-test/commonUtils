package com.inspur.gs.commonutils.demo.design.chainofresponsibility.impl;

import com.inspur.gs.commonutils.demo.design.chainofresponsibility.AbstractLogger;

/**
 * @author tianjinzan01
 * @date 2022/6/28
 * @describe
 */
public class ConsoleLogger extends AbstractLogger {

    public ConsoleLogger(int level){
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("Standard Console::Logger: " + message);
    }
}
