package com.inspur.gs.commonutils.demo.design.adapter.impl;

import com.inspur.gs.commonutils.demo.design.adapter.AdvancedMediaPlayer;

/**
 * @author tianjinzan01
 * @date 2022/6/28
 * @describe
 */
public class Mp4Player implements AdvancedMediaPlayer {

    @Override
    public void playVlc(String fileName) {
        //什么也不做
    }

    @Override
    public void playMp4(String fileName) {
        System.out.println("Playing mp4 file. Name: "+ fileName);
    }
}
