package com.jdrx.springboot.clickmeiiiiiiiiiiiiiii0_0iiiiiiiiiiiiiiii.mian_shi_jin_dian;

/**
 * 在现实生活中，盘子堆到一定高度后就会另外堆一堆盘子，使用栈模拟这种行为。
 * @author : dengxuelong
 * @date : 2019/06/10 9:38
 */
public class _3_3_SetOfStacks {
    //每个栈中保存的最大元素树
    int maxSize;

    Stack<Stack> stacks = new Stack<>();

    //当前栈的元素个数
    int currentSize;
    //当前栈
    Stack currentStack;

    public _3_3_SetOfStacks(int maxSize) {
        this.maxSize = maxSize;

        currentSize = 0;
        this.currentStack = new Stack();
    }

    public void push(Object value){
        if (currentSize == maxSize) {
            //扩容
            grow();
        }
        currentStack.push(value);
        currentSize++;
    }
    public Object pop(){
        if (currentSize == 0) {
            //当前盘子堆为空，获取上一个堆
            Stack lastStack = stacks.pop();
            if (lastStack != null) {
                //上一堆不为空,当前堆指向上一堆
                currentStack = lastStack;
            }
        }
        return currentStack.pop();
    }

    /** 扩容 在另一堆上堆盘子*/
    private void grow(){
        currentStack = new Stack();
        stacks.push(currentStack);
        currentSize = 0;
    }
}








