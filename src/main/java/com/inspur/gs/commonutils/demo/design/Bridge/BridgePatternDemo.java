package com.inspur.gs.commonutils.demo.design.Bridge;

import com.inspur.gs.commonutils.demo.design.Bridge.impl.Circle;
import com.inspur.gs.commonutils.demo.design.Bridge.impl.GreenCircle;
import com.inspur.gs.commonutils.demo.design.Bridge.impl.RedCircle;

/**
 * @author tianjinzan01
 * @date 2022/6/28
 * @describe
 */
public class BridgePatternDemo {
    public static void main(String[] args) {
        Shape redCircle = new Circle(100,100, 10, new RedCircle());
        Shape greenCircle = new Circle(100,100, 10, new GreenCircle());

        redCircle.draw();
        greenCircle.draw();
    }
}
