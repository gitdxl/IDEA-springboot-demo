package com.jdrx.springboot.clickmeiiiiiiiiiiiiiii0_0iiiiiiiiiiiiiiii.atomic;

import java.util.concurrent.atomic.AtomicReference;

/**
 * 使用CAS实现一个区间  维护最小值和最大值
 * @author : dengxuelong
 * @date : 2019/03/21 14:33
 */
public class CasPair {
    private AtomicReference<Pair> value =
            new AtomicReference<>(new Pair(0,0));
    public void setLower(int newLower) throws Exception {
        while(true){
            Pair oldPair = value.get();
            if(newLower <= oldPair.upper){
                Pair newPair = new Pair(newLower, oldPair.upper);
                if (value.compareAndSet(oldPair, newPair)) {
                    //修改成功退出，否则重试
                    return;
                }
            }else {
                throw new Exception("Illegal param");
            }
        }
    }
    private class Pair{
        //最小边界
        int lower;
        //最大边界 不变约束 lower < = upper
        int upper;
        public Pair(int lower, int upper) {
            this.lower = lower;
            this.upper = upper;
        }
    }
}