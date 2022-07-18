package com.inspur.gs.commonutils.demo.design.chainofresponsibility;

import com.inspur.gs.commonutils.demo.design.chainofresponsibility.impl.ConsoleLogger;
import com.inspur.gs.commonutils.demo.design.chainofresponsibility.impl.ErrorLogger;
import com.inspur.gs.commonutils.demo.design.chainofresponsibility.impl.FileLogger;

/**
 * @author tianjinzan01
 * @date 2022/6/28
 * @describe
 */
public class ChainPatternDemo {

    private static AbstractLogger getChainOfLoggers(){

        AbstractLogger errorLogger = new ErrorLogger(AbstractLogger.ERROR);
        AbstractLogger fileLogger = new FileLogger(AbstractLogger.DEBUG);
        AbstractLogger consoleLogger = new ConsoleLogger(AbstractLogger.INFO);

        errorLogger.setNextLogger(fileLogger);
        fileLogger.setNextLogger(consoleLogger);

        return errorLogger;
    }

    public static void main(String[] args) {
        AbstractLogger loggerChain = getChainOfLoggers();

        loggerChain.logMessage(AbstractLogger.INFO, "This is an information.");

        loggerChain.logMessage(AbstractLogger.DEBUG,
                "This is a debug level information.");

        loggerChain.logMessage(AbstractLogger.ERROR,
                "This is an error information.");
    }
}
