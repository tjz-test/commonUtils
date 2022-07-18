package com.inspur.gs.commonutils.demo.design.Commands.impl;

import com.inspur.gs.commonutils.demo.design.Commands.Order;
import com.inspur.gs.commonutils.demo.design.Commands.Stock;

/**
 * @author tianjinzan01
 * @date 2022/6/28
 * @describe
 */
public class BuyStock implements Order {
    private Stock abcStock;

    public BuyStock(Stock abcStock){
        this.abcStock = abcStock;
    }

    @Override
    public void execute() {
        abcStock.buy();
    }
}