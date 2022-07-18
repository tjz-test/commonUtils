package com.inspur.gs.commonutils.demo.design.Builders.impl;

/**
 * @author tianjinzan01
 * @date 2022/6/28
 * @describe
 */
public class Pepsi extends ColdDrink {

    @Override
    public float price() {
        return 35.0f;
    }

    @Override
    public String name() {
        return "Pepsi";
    }
}
