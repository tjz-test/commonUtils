package com.inspur.gs.commonutils.demo.design.observers;

/**
 * @author tianjinzan01
 * @date 2022/6/28
 * @describe
 */
public abstract class Observer {
    protected Subject subject;
    public abstract void update();
}
