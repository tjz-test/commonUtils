package com.inspur.gs.commonutils.demo.design.Facade.impl;

import com.inspur.gs.commonutils.demo.design.Facade.Shape;

/**
 * @author tianjinzan01
 * @date 2022/6/28
 * @describe
 */
public class Circle implements Shape {

    @Override
    public void draw() {
        System.out.println("Circle::draw()");
    }
}
