package com.inspur.gs.commonutils.demo.design.Facade.impl;

import com.inspur.gs.commonutils.demo.design.Facade.Shape;

/**
 * @author tianjinzan01
 * @date 2022/6/28
 * @describe
 */
public class Rectangle implements Shape {

    @Override
    public void draw() {
        System.out.println("Rectangle::draw()");
    }
}