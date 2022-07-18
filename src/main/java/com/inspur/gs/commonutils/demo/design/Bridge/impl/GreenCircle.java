package com.inspur.gs.commonutils.demo.design.Bridge.impl;

import com.inspur.gs.commonutils.demo.design.Bridge.DrawAPI;

/**
 * @author tianjinzan01
 * @date 2022/6/28
 * @describe
 */
public class GreenCircle implements DrawAPI {
    @Override
    public void drawCircle(int radius, int x, int y) {
        System.out.println("Drawing Circle[ color: green, radius: "
                + radius +", x: " +x+", "+ y +"]");
    }
}
