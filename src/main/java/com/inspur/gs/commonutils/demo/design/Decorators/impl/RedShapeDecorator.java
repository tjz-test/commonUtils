package com.inspur.gs.commonutils.demo.design.Decorators.impl;

import com.inspur.gs.commonutils.demo.design.Decorators.Shape;
import com.inspur.gs.commonutils.demo.design.Decorators.ShapeDecorator;

/**
 * @author tianjinzan01
 * @date 2022/6/28
 * @describe
 */
public class RedShapeDecorator extends ShapeDecorator {

    public RedShapeDecorator(Shape decoratedShape) {
        super(decoratedShape);
    }

    @Override
    public void draw() {
        decoratedShape.draw();
        setRedBorder(decoratedShape);
    }

    private void setRedBorder(Shape decoratedShape){
        System.out.println("Border Color: Red");
    }
}