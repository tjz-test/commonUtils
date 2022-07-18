package com.inspur.gs.commonutils.demo.design.abstractfactory;

/**
 * @author tianjinzan01
 * @date 2022/6/28
 * @describe
 */
public class FactoryProducer {
    public static AbstractFactory getFactory(String choice){
        if(choice.equalsIgnoreCase("SHAPE")){
            return new ShapeFactory();
        } else if(choice.equalsIgnoreCase("COLOR")){
            return new ColorFactory();
        }
        return null;
    }
}