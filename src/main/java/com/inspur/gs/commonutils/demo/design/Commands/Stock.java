package com.inspur.gs.commonutils.demo.design.Commands;

/**
 * @author tianjinzan01
 * @date 2022/6/28
 * @describe
 */
public class Stock {

    private String name = "ABC";
    private int quantity = 10;

    public void buy(){
        System.out.println("Stock [ Name: "+name+", Quantity: " + quantity +" ] bought");
    }
    public void sell(){
        System.out.println("Stock [ Name: "+name+", Quantity: " + quantity +" ] sold");
    }
}
