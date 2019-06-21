package com.jdrx.springboot.clickmeiiiiiiiiiiiiiii0_0iiiiiiiiiiiiiiii.thread_safe.uncaughtException;


/**
 * @author : dengxuelong
 * @date : 2019/01/28 16:58
 */
public class MyUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        String msg = String.format("%s非正常退出，原因：%s", t.getName(), e.getMessage());
        System.out.println(msg);
        e.printStackTrace();
    }
}