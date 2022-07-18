package com.inspur.gs.commonutils.demo.design.Prototype;

/**
 * @author tianjinzan01
 * @date 2022/6/28
 * @describe
 */
public class Rectangle extends Shape{

    public Rectangle(){
        type = "Rectangle";
    }

    @Override
    public void draw() {
        System.out.println("Inside Rectangle::draw() method.");
    }
}
