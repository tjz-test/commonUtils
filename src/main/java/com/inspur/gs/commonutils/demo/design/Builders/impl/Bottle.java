package com.inspur.gs.commonutils.demo.design.Builders.impl;

import com.inspur.gs.commonutils.demo.design.Builders.Packing;

/**
 * @author tianjinzan01
 * @date 2022/6/28
 * @describe
 */
public class Bottle implements Packing {

    @Override
    public String pack() {
        return "Bottle";
    }
}
