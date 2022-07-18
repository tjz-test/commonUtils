package com.inspur.gs.commonutils.demo.rpc.client;

import com.inspur.gs.commonutils.demo.rpc.DemoInterface;
import io.iec.edp.caf.commons.utils.SpringBeanUtils;
import io.iec.edp.caf.rpc.client.RpcClassHolder;

/**
 * rpc调用
 * 1、maven引用
 * <dependency>
 *    <groupId>io.iec.edp</groupId>
 *    <artifactId>caf-rpc-api</artifactId>
 *    <version>0.3.2</version>
 * </dependency>
 *
 * rpc 底层通讯走http
 */
public class ClientDemo {

    private final RpcClassHolder rpcClassHolder = SpringBeanUtils.getBean(RpcClassHolder.class);

    public void getDemoInfo() {
        DemoInterface rpcDemo = rpcClassHolder.getRpcClass(DemoInterface.class);
        rpcDemo.demoFunction("xxx");
    }
}
