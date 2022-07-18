package com.inspur.gs.commonutils.demo.design.abstractfactory.impl;

import com.inspur.gs.commonutils.demo.design.abstractfactory.Shape;

/**
 * @author tianjinzan01
 * @date 2022/6/28
 * @describe
 */
public class Square implements Shape {
    @Override
    public void draw() {
        System.out.println("Inside Square::draw() method.");
    }
}
