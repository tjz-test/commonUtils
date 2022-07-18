package com.inspur.gs.commonutils.demo.design.Builders.impl;

/**
 * @author tianjinzan01
 * @date 2022/6/28
 * @describe
 */
public class ChickenBurger extends Burger {

    @Override
    public float price() {
        return 50.5f;
    }

    @Override
    public String name() {
        return "Chicken Burger";
    }
}
