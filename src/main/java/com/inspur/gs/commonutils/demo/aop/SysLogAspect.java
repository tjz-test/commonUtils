package com.inspur.gs.commonutils.demo.aop;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;

/**
 *
 * 方面（Aspect）：一个关注点的模块化，这个关注点实现可能另外横切多个对象。事务管理是J2EE应用中一个很好的横切关注点例子。
 * 方面用Spring的Advisor或拦截器实现。将那些影响了 多个类的公共行为封装到一个可重用模块。
 * 简单地说，就是将那些与业务无关，却为业务模块所共同调用的 逻辑或责任封装起来，比如日志记录，便于减少系统的重复代码，降低模块间的耦合度，并有利于未来的可操作性和可维护性。
 *
 *
 * 切入点（Pointcut）：指定一个通知将被引发的一系列连接点的集合。
 * 连接点（Joinpoint）：程序执行过程中明确的点，如方法的调用或特定的异常被抛出。
 * 通知（Advice）：在特定的连接点，AOP框架执行的动作。
 * 目标对象（Target Object）：包含连接点的对象，也被称作被通知或被代理对象。
 * AOP代理（AOP Proxy）：AOP框架创建的对象，包含通知。在Spring中，AOP代理可以是JDK动态代理或CGLIB代理。
 * 引入（Introduction）：添加方法或字段到被通知的类。Spring允许引入新的接口到任何被通知的对象。
 * 编织（Weaving）：组装方面来创建一个被通知对象。
 *
 */
@Aspect
@Component
@Slf4j
public class SysLogAspect {
    /**
     * 定义切点 @Pointcut
     * 在注解的位置切入代码
     *
     * @ 注解(value=“表达标签 （ 表达式格式)”)
     * execution()：用于匹配方法执行的连接点
     * args(): 用于匹配当前执行的方法传入的参数为指定类型的执行方法
     * this(): 用于匹配当前AOP代理对象类型的执行方法；注意是AOP代理对象的类型匹配，这样就可能包括引入接口也类型匹配；
     * target(): 用于匹配当前目标对象类型的执行方法；注意是目标对象的类型匹配，这样就不包括引入接口也类型匹配；
     * within(): 用于匹配指定类型内的方法执行；
     * @args():于匹配当前执行的方法传入的参数持有指定注解的执行；
     * @target():用于匹配当前目标对象类型的执行方法，其中目标对象持有指定的注解；
     * @within():用于匹配所以持有指定注解类型内的方法；
     * @annotation:用于匹配当前执行方法持有指定注解的方法；
     *
     * 切点定义方法详解：
     * https://blog.csdn.net/justlpf/article/details/103400452
     */
    @Pointcut(value= "@annotation(com.inspur.gs.commonutils.demo.aop.OperLog)")
    public void logPointCut() { }

    /**
     * 通知执行顺序
     * 正常情况：
     * aop -> @Around -> @Before -> Method -> @Around -> @After -> @AfterReturning
     *
     * 异常情况：
     * aop -> @Around -> @Before -> Method -> @Around -> @After -> @AfterThrowing
     *
     * 在aop中校验不通过如何不让程序进入核心代码？
     * 通过aop中注解的执行的先后顺序我们知道，校验发生在核心代码前面的只剩下两个——@Before,@Around。
     * @Before : 这个注解只有在异常时才不会走核心方法——连接点。正常@Before无法阻止当前线程进入连接点。
     * @Around : 这个注解在连接点前后执行。并且注解的方法传入的ProceedingJionPoint类中封装的代理方法proceed()可以让当前线程从aop方法转到连接点——核心代码方法。
     * 所以一般用这个注解，如果aop的安全校验不通过，则不调用proceed()方法，就永远不会进入连接点。
     * 除此外，要注意除了Around注解的方法可以传ProceedingJionPoint 外，别的几个都不能传这个类。
     * 但是普通的数据类型是不限制的。注解的方法的返回值也不限制，可以自由限制。
     */

    /**
     * 环绕增强，目标方法执行前后分别执行一些方法
     * 前置 -》 目标方法 -》 后置
     * @Around环绕通知：它集成了@Before、@AfterReturing、@AfterThrowing、@After四大通知。
     * 需要注意的是，他和其他四大通知注解最大的不同是需要手动进行接口内方法的反射后才能执行接口中的方法，换言之，@Around其实就是一个动态代理。
     */
    @Around(value= "logPointCut()", argNames = "proceedingJoinPoint")
    public Object logAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        try {
            //region 前置
            //保存日志
            SysOperLog operLog = new SysOperLog();
            //从切面织入点处通过反射机制获取织入点处的方法
            MethodSignature signature = (MethodSignature) proceedingJoinPoint.getSignature();
            //获取切入点所在的方法
            Method method = signature.getMethod();
            //获取操作
            OperLog myLog = method.getAnnotation(OperLog.class);
            if (myLog != null) {
                operLog.setTitle(myLog.title());
                operLog.setBusinessType(6);
            }
            //获取请求的类名
            String className = proceedingJoinPoint.getTarget().getClass().getName();

            //获取请求的方法名
            String methodName = method.getName();
            operLog.setMethod(className + "." + methodName+"()");

            //请求的参数
            Object[] args = proceedingJoinPoint.getArgs();
            //将参数所在的数组转换成json
            String params = JSON.toJSONString(args);
            JSONArray jsonArray = JSON.parseArray(params);
            operLog.setOperParam(params);
            operLog.setOperName(jsonArray.get(0).toString());
            operLog.setOperTime(new Date());
            // 接收到请求，记录请求内容
            ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
            assert attributes != null;
            HttpServletRequest request = attributes.getRequest();
            //获取用户ip地址
            operLog.setOperIp(request.getRemoteHost());
            //请求地址
            operLog.setOperUrl(request.getRequestURI());
            //调用service保存SysLog实体类到数据库
            //...
            //endregion

            //region 启动目标方法执行
            proceedingJoinPoint.proceed();
            //endregion

            //region 后置
            System.out.println("实现@AfterReturning");
            //endregion

            return "";
        } catch (Throwable e) {
            //region 异常抛出执行
            System.out.println("实现@AfterThrowing");
            //endregion
            throw e;
        } finally {
            //region 最后执行
            System.out.println("实现@After");
            //endregion
        }
    }

    /**
     * 前置增强，目标方法执行前
     */
    @Before(value= "logPointCut()", argNames = "joinPoint")
    public void logBefore(JoinPoint joinPoint) {
        System.out.println("前置进入");
        //可在此处进行校验判断
        MethodSignature ms = (MethodSignature) joinPoint.getSignature();
        Method method = ms.getMethod();
        OperLog operLog = method.getAnnotation(OperLog.class);
        //读取注解传的值
        String message = operLog.message();;
        //读取方法名称
        String name = method.getName();
    }

    /**
     * 后置增强，目标方法执行完毕时执行
     */
    @AfterReturning(value= "logPointCut()", argNames = "joinPoint")
    public void logAfterReturning(JoinPoint joinPoint) {
        System.out.println("正常后置进入");
    }

    /**
     * 后置增强，异常抛出执行，目标方法异时执行
     */
    @AfterThrowing(value= "logPointCut()", argNames = "joinPoint, e", throwing = "e")
    public void logAfterThrowing(JoinPoint joinPoint, Exception e) {
        System.out.println("异常后置进入");
        MethodSignature ms = (MethodSignature) joinPoint.getSignature();
        Method method = ms.getMethod();
        OperLog operLog = method.getAnnotation(OperLog.class);
        //读取注解传的值
        String message = operLog.message();
        String errerMessage = e.getMessage();
        //读取方法名称
        String name = method.getName();

        //在此处进行统一异常处理  如 发短信  发邮件 等
    }

    /**
     * 后置增强，不管目标正常、异常返回，都执行
     */
    @After(value= "logPointCut()", argNames = "joinPoint")
    public void logAfter(JoinPoint joinPoint) {
        System.out.println("后置进入");
    }
}
