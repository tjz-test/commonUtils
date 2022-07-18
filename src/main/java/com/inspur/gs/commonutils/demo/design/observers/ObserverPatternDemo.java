package com.inspur.gs.commonutils.demo.design.observers;

import com.inspur.gs.commonutils.demo.design.observers.impl.BinaryObserver;
import com.inspur.gs.commonutils.demo.design.observers.impl.HexaObserver;
import com.inspur.gs.commonutils.demo.design.observers.impl.OctalObserver;

/**
 * @author tianjinzan01
 * @date 2022/6/28
 * @describe
 */
public class ObserverPatternDemo {
    public static void main(String[] args) {
        Subject subject = new Subject();

        new HexaObserver(subject);
        new OctalObserver(subject);
        new BinaryObserver(subject);

        System.out.println("First state change: 15");
        subject.setState(15);
        System.out.println("Second state change: 10");
        subject.setState(10);
    }
}
