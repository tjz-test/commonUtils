package com.inspur.gs.commonutils.demo.design.Bridge;

/**
 * @author tianjinzan01
 * @date 2022/6/28
 * @describe
 */
public abstract class Shape {
    protected DrawAPI drawAPI;
    protected Shape(DrawAPI drawAPI){
        this.drawAPI = drawAPI;
    }
    public abstract void draw();
}
