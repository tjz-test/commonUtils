package com.inspur.gs.commonutils.demo.design.Commands;

import com.inspur.gs.commonutils.demo.design.Commands.impl.BuyStock;
import com.inspur.gs.commonutils.demo.design.Commands.impl.SellStock;

/**
 * @author tianjinzan01
 * @date 2022/6/28
 * @describe
 */
public class CommandPatternDemo {
    public static void main(String[] args) {
        Stock abcStock = new Stock();

        BuyStock buyStockOrder = new BuyStock(abcStock);
        SellStock sellStockOrder = new SellStock(abcStock);

        Broker broker = new Broker();
        broker.takeOrder(buyStockOrder);
        broker.takeOrder(sellStockOrder);

        broker.placeOrders();
    }
}
