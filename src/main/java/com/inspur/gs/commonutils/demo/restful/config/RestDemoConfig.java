package com.inspur.gs.commonutils.demo.restful.config;

import com.inspur.gs.commonutils.demo.restful.RestDemoInterface;
import com.inspur.gs.commonutils.demo.restful.impl.RestDemoImpl;
import io.iec.edp.caf.rest.RESTEndpoint;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 服务发布时必须遵从以下URL模板，否则将会影响到应用程序上下文参数的确定、MSU微服务单元的路由等：
 * http://ip:port  /api/[Application]/[ServiceUnit]/v[Version]/[Path]/[MethodRoute]
 * 其中，Application为关键应用标识，ServiceUnit为服务单元编号。
 */
@Configuration(proxyBeanMethods = false)
public class RestDemoConfig {
    @Bean("xxxTestApiRestEndPoint")
    public RESTEndpoint myTestApiRestEndPoint(){
        RestDemoInterface service = new RestDemoImpl();
        return new RESTEndpoint("api/runtime/test/v1.0",service);
    }
}
