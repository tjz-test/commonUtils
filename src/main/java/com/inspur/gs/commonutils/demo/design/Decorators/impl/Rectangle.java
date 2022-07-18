package com.inspur.gs.commonutils.demo.design.Decorators.impl;

import com.inspur.gs.commonutils.demo.design.Decorators.Shape;

/**
 * @author tianjinzan01
 * @date 2022/6/28
 * @describe
 */
public class Rectangle implements Shape {

    @Override
    public void draw() {
        System.out.println("Shape: Rectangle");
    }
}
