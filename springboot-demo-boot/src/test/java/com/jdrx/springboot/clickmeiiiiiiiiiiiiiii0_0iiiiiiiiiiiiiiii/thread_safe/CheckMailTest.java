package com.jdrx.springboot.clickmeiiiiiiiiiiiiiii0_0iiiiiiiiiiiiiiii.thread_safe;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author : dengxuelong
 * @date : 2018/12/03 16:02
 */
public class CheckMailTest {
    boolean checkMail(Set<String> hosts, long timeout, TimeUnit unit)
            throws InterruptedException {
        ExecutorService exec = Executors.newCachedThreadPool();
        final AtomicBoolean hasNewMail = new AtomicBoolean(false);
        try {
            for (final String host : hosts)
                exec.execute(() -> {
                    if (checkMail(host))
                        hasNewMail.set(true);
                });
            System.out.println("任务提交成功");
        } finally {
            exec.shutdown();
            exec.awaitTermination(timeout, unit);
            System.out.println("111");
        }
        return hasNewMail.get();
    }
    public boolean checkMail(String  host){
        int millis = new Random().nextInt(5) * 1000;
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("host:" + host +" 检查完毕" +  "  耗时：" + millis);
        return true;
    }

    public static void main(String[] args) throws InterruptedException {
        List<String> hosts = Arrays.asList("124.11.3.5", "123.555.444.1", "1234", "6.66.1.1");
        System.out.println("fangfa diao"+new CheckMailTest().checkMail(new HashSet<>(hosts), 1, TimeUnit.SECONDS));
    }
}










