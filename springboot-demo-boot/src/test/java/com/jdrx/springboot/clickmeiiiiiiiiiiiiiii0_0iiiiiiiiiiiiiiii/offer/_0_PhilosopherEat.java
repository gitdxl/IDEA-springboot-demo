package com.jdrx.springboot.clickmeiiiiiiiiiiiiiii0_0iiiiiiiiiiiiiiii.offer;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 哲学家吃饭
 * @author : dengxuelong
 * @date : 2019/05/23 14:42
 */
public class _0_PhilosopherEat {
    /** 筷子 实际上就是锁Lock */
    private Lock[] chopsticks;
    /** 哲学家 */
    private Philosopher[] Philosophers;

    /**
     *
     * @param size  哲学家/筷子 个数
     */
    public _0_PhilosopherEat(int size) {
        //筷子集合
        chopsticks = new Lock[size];
        //哲学家集合
        Philosophers = new Philosopher[size];

        //实例筷子集合
        for (int i = 0; i < size; i++) {
            chopsticks[i] = new ReentrantLock();
        }

        //实例哲学家集合
        for (int i = 0; i < size; i++) {
            Philosopher philosopher = new Philosopher(chopsticks, i + "", i);
            Philosophers[i] = philosopher;
            //哲学家开始吃饭  每个哲学家吃到10次就退出...
            philosopher.start();
        }
    }

    public static void main(String[] args) {
        new _0_PhilosopherEat(4);
    }
}
/** 哲学家*/
class Philosopher extends Thread {
    //锁集合
    private Lock[] chopsticks;
    //哲学家名称
    private String name;
    //哲学家索引  第几个
    private int index;
    //哲学家右边的筷子的索引
    int rightChopsticksIndex;

    public Philosopher(Lock[] chopsticks, String name, int index) {
        this.chopsticks = chopsticks;
        this.name = name;
        this.index = index;
        rightChopsticksIndex = (chopsticks.length + index - 1 ) % chopsticks.length;
    }

    /** 哲学家吃饭 */
    public void eat() throws Exception {
        while (true) {
            //获取左边的筷子
            chopsticks[index].lock();
            try {
                System.out.printf("哲学家%s 获得了左边的筷子%d...%n" ,name ,index);
                //获取右边的筷子
                if (chopsticks[rightChopsticksIndex].tryLock()) {
                    try {
                        System.out.printf("哲学家%s 获得了右边的筷子%d..%n",name
                                ,rightChopsticksIndex);
                        System.out.printf("哲学家%s 吃饭...%n", name);
                        //退出...
                        break;
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        //放下右边的筷子
                        chopsticks[rightChopsticksIndex].unlock();
                    }
                }else{
                    //没有获取到右方的筷子，放下左边的筷子，进行下次循环
                    System.out.printf("哲学家%s 没有获得右边的筷子%d... 放下左边的筷子%d %n" ,name,
                            rightChopsticksIndex,index);
                    continue;
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                //放下左边的筷子
                chopsticks[index].unlock();
                // 这样代码能极大地提高速度：立即重新尝试获取锁基本上不会成功，加上sleep后当前线程就会在
                //    【不持有锁的情况】下退出cpu,其他线程就能够获取到释放的锁。（否则此线程极有可能在持
                //    有锁的时候退出cpu，其他线程就可能获取不到锁）
                Thread.sleep(1 * new Random().nextInt(10));
            }
        }
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                //吃到10次就退出
                eat();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
