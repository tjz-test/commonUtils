package com.inspur.gs.commonutils.demo.design.chainofresponsibility.impl;

import com.inspur.gs.commonutils.demo.design.chainofresponsibility.AbstractLogger;

/**
 * @author tianjinzan01
 * @date 2022/6/28
 * @describe
 */
public class ErrorLogger extends AbstractLogger {

    public ErrorLogger(int level){
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("Error Console::Logger: " + message);
    }
}
