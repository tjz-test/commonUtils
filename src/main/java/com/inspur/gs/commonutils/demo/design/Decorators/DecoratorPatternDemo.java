package com.inspur.gs.commonutils.demo.design.Decorators;

import com.inspur.gs.commonutils.demo.design.Decorators.impl.Circle;
import com.inspur.gs.commonutils.demo.design.Decorators.impl.Rectangle;
import com.inspur.gs.commonutils.demo.design.Decorators.impl.RedShapeDecorator;

/**
 * @author tianjinzan01
 * @date 2022/6/28
 * @describe
 */
public class DecoratorPatternDemo {
    public static void main(String[] args) {

        Shape circle = new Circle();
        ShapeDecorator redCircle = new RedShapeDecorator(new Circle());
        ShapeDecorator redRectangle = new RedShapeDecorator(new Rectangle());

        System.out.println("Circle with normal border");
        circle.draw();

        System.out.println("\nCircle of red border");
        redCircle.draw();

        System.out.println("\nRectangle of red border");
        redRectangle.draw();
    }
}
