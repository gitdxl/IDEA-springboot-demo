package com.jdrx.springboot.clickmeiiiiiiiiiiiiiii0_0iiiiiiiiiiiiiiii.thread_safe;


/**
 * 不变约束
 * @author : dengxuelong
 * @date : 2018/09/14 16:08
 */
public class UnExchangeConstraint {
    /**省*/
    String province = "四川";
    /**省会*/
    String capital = "成都";

    public synchronized void set(){
        this.province = "湖南";
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.capital = "长沙";
    }
    public void get(){
        System.out.println(province+"=>"+capital);
        //这个类隐藏一个不变约束:省与省份必须对应
        //在极端情况下,get方法结果为: 湖南=>成都
    }

    public static void main(String[] args) throws InterruptedException {
        UnExchangeConstraint o = new UnExchangeConstraint();
        new Thread(()->{
            o.set();
        }).start();
        Thread.sleep(200);
        o.get();
    }


}







