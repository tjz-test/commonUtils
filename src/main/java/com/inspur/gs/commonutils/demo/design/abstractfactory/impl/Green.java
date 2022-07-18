package com.inspur.gs.commonutils.demo.design.abstractfactory.impl;

import com.inspur.gs.commonutils.demo.design.abstractfactory.Color;

/**
 * @author tianjinzan01
 * @date 2022/6/28
 * @describe
 */
public class Green implements Color {

    @Override
    public void fill() {
        System.out.println("Inside Green::fill() method.");
    }
}