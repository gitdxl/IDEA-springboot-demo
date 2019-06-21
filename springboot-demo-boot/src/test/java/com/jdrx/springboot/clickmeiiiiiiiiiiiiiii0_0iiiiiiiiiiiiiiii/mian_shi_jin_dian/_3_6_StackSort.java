package com.jdrx.springboot.clickmeiiiiiiiiiiiiiii0_0iiiiiiiiiiiiiiii.mian_shi_jin_dian;

/**
 * 有一个无序的栈，最多使用一个额外的栈来完成排序操作
 *
 * @author : dengxuelong
 * @date : 2019/06/10 13:45
 */
public class _3_6_StackSort {
    public static void sortStack(Stack<Integer> originStack,
                                 Stack<Integer> destinationStack) {
        if (originStack.isEmpty()) {
            //退出
            return;
        }
        Integer value = originStack.pop();

        Integer currentMaxValue = destinationStack.peek();

        while (currentMaxValue != null && value < currentMaxValue) {
            //destinationStack弹出最大元素加入到originStack中
            originStack.push(destinationStack.pop());
            currentMaxValue = destinationStack.peek();
        }

        //将元素加入到destinationStack
        destinationStack.push(value);

        sortStack(originStack, destinationStack);
    }


    public static void main(String[] args) {
        int i =1; int k =i + ++i *i++;
        System.out.println(k);
        Stack<Integer> originStack = new Stack<>();
        originStack.push(3);
        originStack.push(31);
        originStack.push(13);
        originStack.push(33);
        originStack.push(553);
        Stack<Integer> destinationStack = new Stack<>();
        sortStack(originStack, destinationStack);
        System.out.println();
    }
}