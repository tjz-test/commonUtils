package com.inspur.gs.commonutils.demo.design.Builders.impl;

import com.inspur.gs.commonutils.demo.design.Builders.Item;
import com.inspur.gs.commonutils.demo.design.Builders.Packing;

/**
 * @author tianjinzan01
 * @date 2022/6/28
 * @describe
 */
public abstract class ColdDrink implements Item {
    @Override
    public Packing packing() {
        return new Bottle();
    }

    @Override
    public abstract float price();
}
