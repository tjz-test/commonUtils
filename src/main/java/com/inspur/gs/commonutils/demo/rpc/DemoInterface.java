package com.inspur.gs.commonutils.demo.rpc;

import io.iec.edp.caf.rpc.api.annotation.GspServiceBundle;
import io.iec.edp.caf.rpc.api.annotation.RpcParam;
import io.iec.edp.caf.rpc.api.annotation.RpcServiceMethod;

/**
 * 1、maven依赖
 * <dependency>
 *     <groupId>io.iec.edp</groupId>
 *     <artifactId>caf-rpc-api</artifactId>
 * </dependency>
 *
 * 2、注解使用
 * @GspServiceBundle(applicationName = "GSXMMS"（app）, serviceUnitName = "GSXMMSBP"(服务单元), serviceName = "gsxmms_gsxmmsbp_func"（服务名 自定义）)
 * @RpcServiceMethod(serviceId = "com.inspur.gs.commonutils.demo.rpc.DemoInterface.demoFunction"（服务id）) serviceId默认为接口包名+接口类名+方法名。
 * 注意，当自定义方法的serviceId时，应保证serviceId对’.’切片的最后一节与方法名称相同，即serviceId中的方法名要与接口中定义的方法名保持一致。
 * @RpcParam(paramName = "xxx"（参数声明）)
 *
 * 注意事项
 * 1、注册Bean时，必须将实现类注册为接口类型而非实现类型。
 *
 * 2、Bean方式发布下，同一个RPC服务接口只允许注册一个Bean实例。不可重复发布同一个RPC接口的服务。
 *
 * 3、每个Rpc服务方法的serviceId必须是全局唯一的。
 *
 * 4、自定义serviceId时，应保证serviceId对’.’切片的最后一节与方法名称相同。
 *
 * 5、同一接口下，不允许定义同名的重载方法。
 *
 * 6、pojo类 和 rpc 方法参数 最好都使用 封装类
 *
 * 启动服务时扫描注解交给springbean管理，
 * 发布服务到 服务注册中心nacos，
 * 服务消费者
 */

@GspServiceBundle(applicationName = "GSXMMS", serviceUnitName = "GSXMMSBP", serviceName = "gsxmms_gsxmmsbp_demo")
public interface DemoInterface {
    @RpcServiceMethod(serviceId = "com.inspur.gs.commonutils.demo.rpc.DemoInterface.demoFunction")
    void demoFunction(@RpcParam(paramName = "xxx") String xxx);
}
