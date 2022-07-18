package com.inspur.gs.commonutils.demo.design.abstractfactory;

import com.inspur.gs.commonutils.demo.design.abstractfactory.impl.Blue;
import com.inspur.gs.commonutils.demo.design.abstractfactory.impl.Green;
import com.inspur.gs.commonutils.demo.design.abstractfactory.impl.Red;

/**
 * @author tianjinzan01
 * @date 2022/6/28
 * @describe
 */
public class ColorFactory extends AbstractFactory {

    @Override
    public Shape getShape(String shapeType){
        return null;
    }

    @Override
    public Color getColor(String color) {
        if(color == null){
            return null;
        }
        if(color.equalsIgnoreCase("RED")){
            return new Red();
        } else if(color.equalsIgnoreCase("GREEN")){
            return new Green();
        } else if(color.equalsIgnoreCase("BLUE")){
            return new Blue();
        }
        return null;
    }
}
