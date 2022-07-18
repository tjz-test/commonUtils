package com.inspur.gs.commonutils.demo.design.Facade;

import com.inspur.gs.commonutils.demo.design.Facade.impl.*;

/**
 * @author tianjinzan01
 * @date 2022/6/28
 * @describe
 */
public class ShapeMaker {
    private Shape circle;
    private Shape rectangle;
    private Shape square;

    public ShapeMaker() {
        circle = new Circle();
        rectangle = new Rectangle();
        square = new Square();
    }

    public void drawCircle(){
        circle.draw();
    }
    public void drawRectangle(){
        rectangle.draw();
    }
    public void drawSquare(){
        square.draw();
    }
}
