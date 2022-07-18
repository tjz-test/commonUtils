package com.inspur.gs.commonutils.demo.design.Mementos;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tianjinzan01
 * @date 2022/6/28
 * @describe
 */
public class CareTaker {
    private List<Memento> mementoList = new ArrayList<>();

    public void add(Memento state){
        mementoList.add(state);
    }

    public Memento get(int index){
        return mementoList.get(index);
    }
}