package com.inspur.gs.commonutils.demo.design.factory;

import com.inspur.gs.commonutils.demo.design.factory.impl.Circle;
import com.inspur.gs.commonutils.demo.design.factory.impl.Rectangle;
import com.inspur.gs.commonutils.demo.design.factory.impl.Square;

/**
 * @author tianjinzan01
 * @date 2022/6/28
 * @describe
 */
public class ShapeFactory {
    //使用 getShape 方法获取形状类型的对象
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
}
