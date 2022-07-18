package com.inspur.gs.commonutils.demo.design.Mediator;

/**
 * @author tianjinzan01
 * @date 2022/6/28
 * @describe
 */
public class MediatorPatternDemo {
    public static void main(String[] args) {
        User robert = new User("Robert");
        User john = new User("John");

        robert.sendMessage("Hi! John!");
        john.sendMessage("Hello! Robert!");
    }
}