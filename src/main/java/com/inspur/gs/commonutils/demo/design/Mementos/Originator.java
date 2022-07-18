package com.inspur.gs.commonutils.demo.design.Mementos;

/**
 * @author tianjinzan01
 * @date 2022/6/28
 * @describe
 */
public class Originator {
    private String state;

    public void setState(String state){
        this.state = state;
    }

    public String getState(){
        return state;
    }

    public Memento saveStateToMemento(){
        return new Memento(state);
    }

    public void getStateFromMemento(Memento Memento){
        state = Memento.getState();
    }
}
