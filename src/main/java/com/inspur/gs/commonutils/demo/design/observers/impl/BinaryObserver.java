package com.inspur.gs.commonutils.demo.design.observers.impl;

import com.inspur.gs.commonutils.demo.design.observers.Observer;
import com.inspur.gs.commonutils.demo.design.observers.Subject;

/**
 * @author tianjinzan01
 * @date 2022/6/28
 * @describe
 */
public class BinaryObserver extends Observer {

    public BinaryObserver(Subject subject){
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println( "Binary String: " + Integer.toBinaryString( subject.getState() ) );
    }
}
