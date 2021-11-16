package com.example.springboot.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.PrintWriter;
import java.io.StringWriter;

public class LogUtil {

    private static Logger logger = LogManager.getLogger();

    public static Logger getTransactionLogger() {
        return LogManager.getLogger("transactionLogger");
    }

    public static void debug(String msg) {
        logger.debug(msg);
    }

    public static void debug(String msg, Object... vars) {
        logger.debug(msg, vars);
    }

    public static void info(String msg) {
        logger.info(msg);
    }

    public static void info(String msg, Object... vars) {
        logger.info(msg, vars);
    }

    public static void warn(String msg) {
        logger.warn(msg);
    }

    public static void warn(String msg, Object... vars) {
        logger.warn(msg, vars);
    }

    public static void error(String msg) {
        logger.error(msg);
    }

    public static void error(Throwable e) {
        logger.error(e);
    }

    public static void error(String msg, Throwable e) {
        logger.error(msg, e);
    }

    public static void error(String msg, Object... vars) {
        logger.error(msg, vars);
    }

    public static void fatal(String msg) {
        logger.fatal(msg);
    }

    public static void fatal(String msg, Throwable e) {
        logger.fatal(msg, e);
    }

    public static void fatal(String msg, Object... vars) {
        logger.fatal(msg, vars);
    }

    /**
     * 记录启动时间
     *
     * @param startTime 起始时间
     * @param endTime   结束时间
     * @param appName   项目名称
     */
    public static void logAppLaunch(long startTime, long endTime, String appName) {
        long cost = (endTime - startTime) / 1000;
        logger.info(
                "*****************************************************************************************************");
        logger.info(String.format(
                "%s has been started successfully and it takes %s seconds",
                appName, String.valueOf(cost)));
        logger.info(
                "*****************************************************************************************************");
    }

    public static String getErrorStackTrace(Throwable e) {
        StringWriter sw = new StringWriter();
        e.printStackTrace(new PrintWriter(sw));
        return sw.toString();
    }
}

