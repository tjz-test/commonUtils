package com.inspur.gs.commonutils.demo.design.abstractfactory;

import com.inspur.gs.commonutils.demo.design.abstractfactory.impl.Circle;
import com.inspur.gs.commonutils.demo.design.abstractfactory.impl.Rectangle;
import com.inspur.gs.commonutils.demo.design.abstractfactory.impl.Square;

/**
 * @author tianjinzan01
 * @date 2022/6/28
 * @describe
 */
public class ShapeFactory extends AbstractFactory {

    @Override
    public Shape getShape(String shapeType){
        if(shapeType == null){
            return null;
        }
        if(shapeType.equalsIgnoreCase("CIRCLE")){
            return new Circle();
        } else if(shapeType.equalsIgnoreCase("RECTANGLE")){
            return new Rectangle();
        } else if(shapeType.equalsIgnoreCase("SQUARE")){
            return new Square();
        }
        return null;
    }

    @Override
    public Color getColor(String color) {
        return null;
    }
}