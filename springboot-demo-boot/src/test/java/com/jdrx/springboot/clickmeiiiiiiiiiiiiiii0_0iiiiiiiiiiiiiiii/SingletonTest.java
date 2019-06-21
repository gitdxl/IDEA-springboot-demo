package com.jdrx.springboot.clickmeiiiiiiiiiiiiiii0_0iiiiiiiiiiiiiiii;

/**
 * @author : dengxuelong
 * @date : 2019/03/28 16:34
 */
public class SingletonTest {
    //老版本jvm中,懒汉模式相对于饿汉模式，能够提高程序的启动速度，但是现代JVM提供了
    //惰性初始化容器，启动时不会加载所有类。
    private SingletonTest instance;

    //双重检查
    public SingletonTest getInstance(){
        //因为早期JVM的synchronized太消耗性能，这种方式在[安全实例化好对象后]可以避免进入同步块
        if (instance == null) {
            synchronized (this){
                if (instance == null) {
                    instance = new SingletonTest();//这条操作可以分为3个操作
                        //1、分配内存空间
                        //2、在内存中创建对象(比如设置成员的值)
                        //3、让instance指向分配的空间

                    //第2、3步可能会重排序，如果第3步先执行，那么[对变量instance的修改]对
                    //  其他线程是可见的(sure，测试时是这样的，但这种情况不知道是偶然还是必然)
                    //  ，那么其他线程就能获取到一个未完全创建的对象（此时步骤2还未执行，锁也未释放)

                    //synchronized能够确保对变量的修改对于其它线程是可见的，但是在这里比较特殊：
                    //  可以说是过早地暴露了变量，即使是不用synchronized也可能会有这种情况发生

                    //使用volatile能够避免这种情况发生，它能确保2、3不被重排序
                }
            }
        }
        //这样问题是：其他线程可能会获取到一个未完全创建的对象
        return instance;
    }
}