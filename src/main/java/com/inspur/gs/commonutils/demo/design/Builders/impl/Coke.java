package com.inspur.gs.commonutils.demo.design.Builders.impl;

/**
 * @author tianjinzan01
 * @date 2022/6/28
 * @describe
 */
public class Coke extends ColdDrink {

    @Override
    public float price() {
        return 30.0f;
    }

    @Override
    public String name() {
        return "Coke";
    }
}
