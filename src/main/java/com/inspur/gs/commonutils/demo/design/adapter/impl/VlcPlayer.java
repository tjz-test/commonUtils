package com.inspur.gs.commonutils.demo.design.adapter.impl;

import com.inspur.gs.commonutils.demo.design.adapter.AdvancedMediaPlayer;

/**
 * @author tianjinzan01
 * @date 2022/6/28
 * @describe
 */
public class VlcPlayer implements AdvancedMediaPlayer {
    @Override
    public void playVlc(String fileName) {
        System.out.println("Playing vlc file. Name: "+ fileName);
    }

    @Override
    public void playMp4(String fileName) {

    }
}
