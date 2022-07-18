package com.inspur.gs.commonutils.demo.design.Mediator;

import java.util.Date;

/**
 * @author tianjinzan01
 * @date 2022/6/28
 * @describe
 */
public class ChatRoom {
    public static void showMessage(User user, String message){
        System.out.println(new Date().toString()
                + " [" + user.getName() +"] : " + message);
    }
}
