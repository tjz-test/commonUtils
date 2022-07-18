package com.inspur.gs.commonutils.demo.design.Proxy.impl;

import com.inspur.gs.commonutils.demo.design.Proxy.Image;

/**
 * @author tianjinzan01
 * @date 2022/6/28
 * @describe
 */
public class RealImage implements Image {

    private String fileName;

    public RealImage(String fileName){
        this.fileName = fileName;
        loadFromDisk(fileName);
    }

    @Override
    public void display() {
        System.out.println("Displaying " + fileName);
    }

    private void loadFromDisk(String fileName){
        System.out.println("Loading " + fileName);
    }
}
