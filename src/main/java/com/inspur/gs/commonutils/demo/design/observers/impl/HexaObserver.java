package com.inspur.gs.commonutils.demo.design.observers.impl;

import com.inspur.gs.commonutils.demo.design.observers.Observer;
import com.inspur.gs.commonutils.demo.design.observers.Subject;

/**
 * @author tianjinzan01
 * @date 2022/6/28
 * @describe
 */
public class HexaObserver extends Observer {

    public HexaObserver(Subject subject){
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println( "Hex String: " + Integer.toHexString( subject.getState() ).toUpperCase() );
    }
}