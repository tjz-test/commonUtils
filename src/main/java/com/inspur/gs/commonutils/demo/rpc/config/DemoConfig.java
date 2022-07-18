package com.inspur.gs.commonutils.demo.rpc.config;

import com.inspur.gs.commonutils.demo.rpc.DemoInterface;
import com.inspur.gs.commonutils.demo.rpc.impl.DemoImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DemoConfig {
    @Bean("xxxDemoRpcDemoFunc")
    public DemoInterface demoFunc(){
        return new DemoImpl();
    }
}
