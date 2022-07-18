package com.inspur.gs.commonutils.demo.design.Prototype;

/**
 * @author tianjinzan01
 * @date 2022/6/28
 * @describe
 */
public class Square extends Shape {

    public Square(){
        type = "Square";
    }

    @Override
    public void draw() {
        System.out.println("Inside Square::draw() method.");
    }
}
