package com.inspur.gs.commonutils.demo.design.abstractfactory;

/**
 * @author tianjinzan01
 * @date 2022/6/28
 * @describe
 */
public abstract class AbstractFactory {
    public abstract Color getColor(String color);
    public abstract Shape getShape(String shape);
}
