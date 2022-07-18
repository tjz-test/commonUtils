package com.inspur.gs.commonutils.demo.design.Mementos;

/**
 * @author tianjinzan01
 * @date 2022/6/28
 * @describe
 */
public class Memento {
    private String state;

    public Memento(String state){
        this.state = state;
    }

    public String getState(){
        return state;
    }
}
