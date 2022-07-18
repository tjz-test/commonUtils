package com.inspur.gs.commonutils.demo.aop;

import java.lang.annotation.*;

/**
 *  * 面向切面编程，通过预编译方式和运行期动态代理实现程序功能的统一维护的一种技术。
 *  * 利用AOP可以对业务逻辑的各个部分进行隔离，从而使得业务逻辑各部分之间的耦合度降低，提高程序的可重用性，同时提高了开发的效率。
 *
 *  * 使用场景
 *  * 权限检查、缓存、内容传递、错误处理、日志记录，跟踪，优化，校准、性能优化，效率检查
 *
 *  * 举例：记录调用接口传参，回参

/**
 * Annotation可被用于 packages、types（类、接口、枚举、Annotation类型）、类型成员（方法、构造方法、成员变量、枚举值）、方法参数和本地变量（如循环变量、catch参数）
 * 在Annotation类型的声明中使用了target可更加明晰其修饰的目标。
 * 1.TYPE——用于描述类、接口(包括注解类型) 或enum声明
 * 2.FIELD——用于字段声明（包括枚举常量）
 * 3.METHOD——用于方法声明
 * 4.PARAMETER——用于参数声明
 * 5.CONSTRUCTOR——用于构造函数声明
 * 6.LOCAL_VARIABLE——用于本地变量声明
 * 7.ANNOTATION_TYPE——用于注解类型声明
 * 8.PACKAGE——用于包声明
 * 9.TYPE_PARAMETER—— 用于类型参数声明，JavaSE8引进，可以应用于类的泛型声明之处
 * 10.TYPE_USE——JavaSE8引进，此类型包括类型声明和类型参数声明，是为了方便设计者进行类型检查，例如，如果使用@Target（ElementType.TYPE_USE）对@NonNull进行标记，则类型检查器可以将@NonNull class C {...} C类的所有变量都视为非null
 *
 */
@Target(ElementType.METHOD)
/**
 * 定义注解保留阶段
 * 1.RetentionPolicy.SOURCE —— 这种类型的Annotations只在源代码级别保留,编译时就会被忽略
 * 2.RetentionPolicy.CLASS —— 这种类型的Annotations编译时被保留,在class文件中存在,但JVM将会忽略
 * 3.RetentionPolicy.RUNTIME —— 这种类型的Annotations将被JVM保留,所以他们能在运行时被JVM或其他使用反射机制的代码所读取和使用
 */
@Retention(RetentionPolicy.RUNTIME)
/**
 * 注解标记的元素，Javadoc工具会将此注解标记元素的注解信息包含在javadoc中。默认，注解信息不会包含在Javadoc中。
 */
@Documented
public @interface OperLog {
    /**
     *  介绍
     */
    String message() default "adsaf";

    String title();
}
