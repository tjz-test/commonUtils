package com.inspur.gs.commonutils.demo.design.Mediator;

/**
 * @author tianjinzan01
 * @date 2022/6/28
 * @describe
 */
public class User {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User(String name){
        this.name  = name;
    }

    public void sendMessage(String message){
        ChatRoom.showMessage(this,message);
    }
}
