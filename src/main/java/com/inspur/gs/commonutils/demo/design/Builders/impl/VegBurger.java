package com.inspur.gs.commonutils.demo.design.Builders.impl;

/**
 * @author tianjinzan01
 * @date 2022/6/28
 * @describe
 */
public class VegBurger extends Burger{

    @Override
    public float price() {
        return 25.0f;
    }

    @Override
    public String name() {
        return "Veg Burger";
    }
}
