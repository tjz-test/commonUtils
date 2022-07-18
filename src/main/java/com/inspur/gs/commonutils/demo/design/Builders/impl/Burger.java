package com.inspur.gs.commonutils.demo.design.Builders.impl;

import com.inspur.gs.commonutils.demo.design.Builders.Item;
import com.inspur.gs.commonutils.demo.design.Builders.Packing;

/**
 * @author tianjinzan01
 * @date 2022/6/28
 * @describe
 */
public abstract class Burger implements Item {
    @Override
    public Packing packing() {
        return new Wrapper();
    }

    @Override
    public abstract float price();
}
