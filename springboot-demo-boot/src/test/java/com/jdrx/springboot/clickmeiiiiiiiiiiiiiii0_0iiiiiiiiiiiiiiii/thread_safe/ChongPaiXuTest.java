package com.jdrx.springboot.clickmeiiiiiiiiiiiiiii0_0iiiiiiiiiiiiiiii.thread_safe;

import javax.xml.bind.SchemaOutputResolver;

/**
 * 重排序
 * @author : dengxuelong
 * @date : 2018/09/14 11:34
 */
public class ChongPaiXuTest {
    int a = 0;
    boolean b = false;
    //线程1执行此方法
    public void op1(){
        a=100;
        b=true;
    }
    //线程2执行此方法
    public void op2(){
        if (b) {
    //op1的代码可能会重排序:实际执行的代码顺序为:
    //b=true,a=0然后线程1执行完b=true后,可能就中断了
    //但是线程2获取到b的值为true时，但a的值却为0
    //所以这里重排序导致了预期外的错误
            System.out.println(a);
        }
    }
}