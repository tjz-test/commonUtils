package com.inspur.gs.commonutils.demo.design.singleton.enums;

/**
 * @author tianjinzan01
 * @date 2022/6/28
 * @describe
 */
public class UserDemo {
    /**
     * 私有化构造函数
     */
    private UserDemo(){ }

    /**
     * 定义一个静态枚举类
     */
    enum SingletonEnum{
        //创建一个枚举对象，该对象天生为单例
        INSTANCE;
        private final UserDemo user;

        SingletonEnum(){
            user = new UserDemo();
        }

        public UserDemo getInstnce(){
            return user;
        }
    }

    /**
     * 对外暴露一个获取User对象的静态方法
     */
    public static UserDemo getInstance(){
        return SingletonEnum.INSTANCE.getInstnce();
    }
}
