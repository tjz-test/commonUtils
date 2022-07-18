package com.inspur.gs.commonutils.demo.design.Decorators;

/**
 * @author tianjinzan01
 * @date 2022/6/28
 * @describe
 */
public abstract class ShapeDecorator implements Shape {
    protected Shape decoratedShape;

    public ShapeDecorator(Shape decoratedShape){
        this.decoratedShape = decoratedShape;
    }

    @Override
    public void draw(){
        decoratedShape.draw();
    }
}
