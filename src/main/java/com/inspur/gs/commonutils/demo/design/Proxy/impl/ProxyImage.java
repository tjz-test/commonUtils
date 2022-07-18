package com.inspur.gs.commonutils.demo.design.Proxy.impl;

import com.inspur.gs.commonutils.demo.design.Proxy.Image;

/**
 * @author tianjinzan01
 * @date 2022/6/28
 * @describe
 */
public class ProxyImage implements Image {

    private RealImage realImage;
    private String fileName;

    public ProxyImage(String fileName){
        this.fileName = fileName;
    }

    @Override
    public void display() {
        if(realImage == null){
            realImage = new RealImage(fileName);
        }
        realImage.display();
    }
}
