package com.inspur.gs.commonutils.demo.design.Facade;

/**
 * @author tianjinzan01
 * @date 2022/6/28
 * @describe
 */
public class FacadePatternDemo {
    public static void main(String[] args) {
        ShapeMaker shapeMaker = new ShapeMaker();

        shapeMaker.drawCircle();
        shapeMaker.drawRectangle();
        shapeMaker.drawSquare();
    }
}