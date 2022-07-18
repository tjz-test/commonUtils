package com.inspur.gs.commonutils.demo.design.abstractfactory.impl;

import com.inspur.gs.commonutils.demo.design.abstractfactory.Color;

/**
 * @author tianjinzan01
 * @date 2022/6/28
 * @describe
 */
public class Blue implements Color {

    @Override
    public void fill() {
        System.out.println("Inside Blue::fill() method.");
    }
}
