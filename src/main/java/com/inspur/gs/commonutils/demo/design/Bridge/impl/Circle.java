package com.inspur.gs.commonutils.demo.design.Bridge.impl;

import com.inspur.gs.commonutils.demo.design.Bridge.DrawAPI;
import com.inspur.gs.commonutils.demo.design.Bridge.Shape;

/**
 * @author tianjinzan01
 * @date 2022/6/28
 * @describe
 */
public class Circle extends Shape {
    private final int x;
    private final int y;
    private final int radius;

    public Circle(int x, int y, int radius, DrawAPI drawAPI) {
        /**
         * super() 只能出现在构造方法第一行，通过当前的构造方法去调用“父类”中的构造方法，
         * 目的是：创建子类对象的时候，先初始化父类型特征。
         */
        super(drawAPI);
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    @Override
    public void draw() {
        drawAPI.drawCircle(radius,x,y);
    }
}
