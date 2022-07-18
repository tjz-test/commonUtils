package com.inspur.gs.commonutils.demo.exception;

import io.iec.edp.caf.commons.exception.CAFRuntimeException;
import io.iec.edp.caf.commons.exception.ExceptionLevel;

/**
 * 在使用异常框架的时候，需要遵循以下几个规范：
 *（1）异常编号的命名规范，建议该属性按照“ 关键应用_模块_功能_4位数字编号”形式编码，
 * 如ECP_CAF_EXCP_0101表示异常框架的处理程序为空；ECP_RTF_SYS_0101表示系统管理的异常；
 *（2）各个模块可以定义自己的异常基类，需要继承CAFRuntimeException，需要将异常类标识为可序列化的，
 * 同时需要提供序列化的构造函数；
 *
 * maven依赖
 * <dependency>
 *    <groupId>io.iec.edp</groupId>
 *    <artifactId>caf-boot-commons-exception</artifactId>
 *    <version>0.3.7</version>
 * </dependency>
 */
public class CafException extends CAFRuntimeException {

    /**
     * 传入异常编号和服务单元编号
     * @param serviceUnitCode 服务单元编号
     * @param resourceFile    资源文件
     * @param exceptionCode   异常编号
     * @param messageParams   提示消息的上下文参数
     * @param innerException  异常类
     */
    public CafException(String serviceUnitCode, String resourceFile, String exceptionCode, String[] messageParams, Exception innerException) {
        super(serviceUnitCode, resourceFile, exceptionCode, messageParams, innerException);
    }

    /**
     * 传入异常编号和服务单元编号
     * @param serviceUnitCode 服务单元编号
     * @param resourceFile    资源文件
     * @param exceptionCode   异常编号
     * @param messageParams   提示消息的上下文参数
     * @param innerException  异常类
     * @param level           异常级别
     */
    public CafException(String serviceUnitCode, String resourceFile, String exceptionCode, String[] messageParams, Exception innerException, ExceptionLevel level) {
        super(serviceUnitCode, resourceFile, exceptionCode, messageParams, innerException, level);
    }

    /**
     * 传入异常编号和服务单元编号
     * @param serviceUnitCode 服务单元编号
     * @param resourceFile    资源文件
     * @param exceptionCode   异常编号
     * @param messageParams   提示消息的上下文参数
     * @param innerException  异常类
     * @param level           异常级别
     * @param bizException    是否业务异常
     */
    public CafException(String serviceUnitCode, String resourceFile, String exceptionCode, String[] messageParams, Exception innerException, ExceptionLevel level, boolean bizException) {
        super(serviceUnitCode, resourceFile, exceptionCode, messageParams, innerException, level, bizException);
    }

    /**
     * 传入异常编号和异常消息
     * @param serviceUnitCode 服务单元编号
     * @param exceptionCode   异常编号
     * @param message         异常消息
     * @param innerException  异常类
     */
    public CafException(String serviceUnitCode, String exceptionCode, String message, Exception innerException) {
        super(serviceUnitCode, exceptionCode, message, innerException);
    }

    /**
     * 传入异常编号和异常消息
     * @param serviceUnitCode 服务单元编号
     * @param exceptionCode   异常编号
     * @param message         异常消息
     * @param innerException  异常类
     * @param level           异常级别
     */
    public CafException(String serviceUnitCode, String exceptionCode, String message, Exception innerException, ExceptionLevel level) {
        super(serviceUnitCode, exceptionCode, message, innerException, level);
    }

    /**
     * 传入异常编号和服务单元编号
     * @param serviceUnitCode 服务单元编号
     * @param exceptionCode   异常编号
     * @param message         异常消息
     * @param innerException  异常类
     * @param level           异常级别
     * @param bizException    是否业务异常
     */
    public CafException(String serviceUnitCode, String exceptionCode, String message, Exception innerException, ExceptionLevel level, boolean bizException) {
        super(serviceUnitCode, exceptionCode, message, innerException, level, bizException);
    }
}