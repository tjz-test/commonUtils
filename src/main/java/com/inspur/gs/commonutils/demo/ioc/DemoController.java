package com.inspur.gs.commonutils.demo.ioc;

import com.inspur.gs.commonutils.demo.data.ddd.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author tianjinzan01
 * IOC 控制反转
 * 三种注入方式
 *
 * 目的：
 * 降低类之间的耦合
 * 倡导面向接口编程、实施依赖倒换原则
 * 提高系统可插入、可测试、可修改特性
 *
 * 具体做法
 * 将bean之间的依赖关系尽可能地转换为关联关系
 * 将对具体类的关联尽可能地转换为对Java 接口的关联，而不是与具体的服务对象相关联
 * bean实例具体关联相关Java 接口的哪个实现类的实例，在配置信息的元数据中描述
 * 由IOC组件（或称容器）根据配置信息，实例化具体bean类，将bean之间的依赖关系注入进来
 *
 */
@Component
public class DemoController {

    /**
     * 1.变量（Field）注入
     * 代码少，简洁明了
     * 新增依赖十分方便，不需要修改原有代码
     * 注入简单，只需要使用 @Autowired 注解或者 @Resource 注解
     * 缺点：
     * 容易出现空指针异常，Field 注入允许构建对象实例的时候依赖的示例对象为空，这就导致了空指针异常无法尽早的暴露出来，因为你不调用将一直无法发现NullPointException的存在
     * 对于IOC容器以外的环境，除了使用反射来提供它需要的依赖之外，无法复用该实现类。对单元测试不友好，如果使用 Field 注入，那么进行单元测试就需要初始化整个Spring 环境，将所有 Bean 实例化
     * 使用field注入会出现循环依赖的隐患
     * 容易破坏单一职责原则
     */
    @Autowired(required = false)
    private UserService userService;

    /**
     * 2.构造器注入
     * 优点：
     * 保证依赖不可变（final关键字）。
     * 保证依赖不为空，强依赖处理，在编译阶段就能暴露出问题（省去了我们对其检查）。
     * 保证返回客户端（调用）的代码的时候是完全初始化的状态，方便单元测试。
     * 避免了循环依赖。
     * 提升了代码的可复用性。
     * 可以明确成员变量的注入顺序。
     * 缺点：当注入参数较多时，代码臃肿，不够友好。
     */
    private final UserService userService1;

    //如果该类只有一个有参构造器，那么 @Autowired 注解 可以省略。
    @Autowired
    public DemoController(UserService userService)
    {
        this.userService1 = userService;
    }

    /**
     * 3.Setter注入
     * 优点：
     * 相比构造器注入，set注入类似于选择性注入。
     * 允许在类构造完成后重新注入。
     * 缺点：暂无
     */
    private UserService userService2;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService2 = userService;
    }

    /**
     * 应尽量避免Field注入。
     * 推荐使用构造函数或方法来注入依赖项。
     * 两者各有利弊，其用法取决于具体情况。
     * 但是，由于这些方法可以混合使用，所以这不是非必须选择一种，可以将setter和构造函数注入合并到一个类中。
     * 构造函数更适合于强制依赖项和以不变性为目标的情况。
     * 对于可选的依赖项，setter更好。
     */

}
