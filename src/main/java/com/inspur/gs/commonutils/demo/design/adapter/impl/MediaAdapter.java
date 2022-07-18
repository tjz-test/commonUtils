package com.inspur.gs.commonutils.demo.design.adapter.impl;

import com.inspur.gs.commonutils.demo.design.adapter.AdvancedMediaPlayer;
import com.inspur.gs.commonutils.demo.design.adapter.MediaPlayer;

/**
 * @author tianjinzan01
 * @date 2022/6/28
 * @describe
 */
public class MediaAdapter implements MediaPlayer {

    AdvancedMediaPlayer advancedMusicPlayer;

    public MediaAdapter(String audioType){
        if("vlc".equalsIgnoreCase(audioType) ){
            advancedMusicPlayer = new VlcPlayer();
        } else if ("mp4".equalsIgnoreCase(audioType)){
            advancedMusicPlayer = new Mp4Player();
        }
    }

    @Override
    public void play(String audioType, String fileName) {
        if("vlc".equalsIgnoreCase(audioType)){
            advancedMusicPlayer.playVlc(fileName);
        }else if("mp4".equalsIgnoreCase(audioType)){
            advancedMusicPlayer.playMp4(fileName);
        }
    }
}