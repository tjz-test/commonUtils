package com.inspur.gs.commonutils.demo.design.Flyweights;

import com.inspur.gs.commonutils.demo.design.Flyweights.impl.Circle;

import java.util.HashMap;

/**
 * @author tianjinzan01
 * @date 2022/6/28
 * @describe
 */
public class ShapeFactory {
    private static final HashMap<String, Shape> circleMap = new HashMap<>();

    public static Shape getCircle(String color) {
        Circle circle = (Circle)circleMap.get(color);

        if(circle == null) {
            circle = new Circle(color);
            circleMap.put(color, circle);
            System.out.println("Creating circle of color : " + color);
        }
        return circle;
    }
}
