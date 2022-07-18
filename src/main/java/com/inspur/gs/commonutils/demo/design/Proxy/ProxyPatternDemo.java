package com.inspur.gs.commonutils.demo.design.Proxy;

import com.inspur.gs.commonutils.demo.design.Proxy.impl.ProxyImage;

/**
 * @author tianjinzan01
 * @date 2022/6/28
 * @describe
 */
public class ProxyPatternDemo {

    public static void main(String[] args) {
        Image image = new ProxyImage("test_10mb.jpg");

        // 图像将从磁盘加载
        image.display();
        System.out.println("");
        // 图像不需要从磁盘加载
        image.display();
    }
}
