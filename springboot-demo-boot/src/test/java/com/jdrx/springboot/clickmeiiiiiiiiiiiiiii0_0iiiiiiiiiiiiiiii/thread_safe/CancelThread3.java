package com.jdrx.springboot.clickmeiiiiiiiiiiiiiii0_0iiiiiiiiiiiiiiii.thread_safe;

import java.util.Random;
import java.util.concurrent.*;

/**
 * 使用FutureTask取消线程
 */
public class CancelThread3 {
    public static void main(String[] args) throws InterruptedException, TimeoutException, ExecutionException {
        ExecutorService es = Executors.newFixedThreadPool(1);
        //提交一个任务
        Future<Object> future = es.submit(new Calculate());
        try {
            //如果任务执行超过2秒，get()就抛出TimeoutException，在finally块中中断任务
            Object o = future.get(2, TimeUnit.SECONDS);
            System.out.println("执行结果：" + o);
        } catch (ExecutionException e) {
            System.out.println("任务执行出错");
        } catch (TimeoutException e) {
            System.out.println("任务执行超时");
        }finally {
            //中断任务 (如果任务执行完毕，执行此方法是不受影响的)
            System.out.println(future.cancel(true));
        }
    }

    public static class Calculate implements Callable{
        @Override
        public Object call() throws Exception {
            try {
                //模拟计算  这个'计算'【能够响应中断】
                Thread.sleep(1000 * new Random().nextInt(5));
                return 1;
            } catch (InterruptedException e) {
                //处理中断
                System.out.println("任务被取消");
                return null;
            }
        }
    }

}