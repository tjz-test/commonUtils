package com.inspur.gs.commonutils.demo.design.Prototype;

/**
 * @author tianjinzan01
 * @date 2022/6/28
 * @describe
 */
public class Circle extends Shape {

    public Circle(){
        type = "Circle";
    }

    @Override
    public void draw() {
        System.out.println("Inside Circle::draw() method.");
    }
}
