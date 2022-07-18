package com.inspur.gs.commonutils.demo.design.Commands.impl;

import com.inspur.gs.commonutils.demo.design.Commands.Order;
import com.inspur.gs.commonutils.demo.design.Commands.Stock;

/**
 * @author tianjinzan01
 * @date 2022/6/28
 * @describe
 */
public class SellStock implements Order {
    private Stock abcStock;

    public SellStock(Stock abcStock){
        this.abcStock = abcStock;
    }

    @Override
    public void execute() {
        abcStock.sell();
    }
}