package com.inspur.gs.commonutils.demo.data.ddd.core.config;

import com.inspur.gs.commonutils.demo.data.ddd.api.service.UserService;
import com.inspur.gs.commonutils.demo.data.ddd.api.webservices.UserWebService;
import com.inspur.gs.commonutils.demo.data.ddd.core.domain.managers.UserManager;
import com.inspur.gs.commonutils.demo.data.ddd.core.domain.repository.UserRepositoryTestDemo;
import com.inspur.gs.commonutils.demo.data.ddd.core.service.UserServiceImpl;
import com.inspur.gs.commonutils.demo.data.ddd.core.webservices.UserWebServiceImpl;
import io.iec.edp.caf.rest.RESTEndpoint;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration(value = "userConfigurationTestDemo")
@EnableJpaRepositories("com.inspur.gs.commonutils.demo.data.ddd.core.domain.repository")
@EntityScan({"com.inspur.gs.commonutils.demo.data.ddd.api.entity", "com.inspur.gs.commonutils.demo.data.ddd.core.domain.entity"})
public class UserConfiguration {

    /**
     * UserManager
     */
    //Bean name 以 服务单元+功能模块+具体实现名称(保证全局唯一) 使用驼峰命名
    @Bean(name = "xxxDemoUserManager")
    public UserManager userManager(UserRepositoryTestDemo userRepository) {
        return new UserManager(userRepository);
    }

    /**
     * EmpService
     */
    @Bean(name = "xxxDemoUserService")
    public UserService userService(UserManager userManager) {
        return new UserServiceImpl(userManager);
    }

    /**
     * EmpWebService
     */
    @Bean(name = "xxxDemoUserWebService")
    public UserWebService userWebService(UserService userService) {
        return new UserWebServiceImpl(userService);
    }


    /**
     * RESTEndpoint
     */
    @Bean(name = "xxxDemoUserWebServiceEndPoint")
    public RESTEndpoint userWebServiceEndPoint(UserWebService userWebService){
        return new RESTEndpoint("/cafdemos/userdemo/v1.0/user", userWebService);
    }
}
