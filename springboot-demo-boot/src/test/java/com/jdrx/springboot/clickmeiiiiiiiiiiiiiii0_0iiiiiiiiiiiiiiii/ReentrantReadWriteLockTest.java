package com.jdrx.springboot.clickmeiiiiiiiiiiiiiii0_0iiiiiiiiiiiiiiii;

import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author : dengxuelong
 * @date : 2019/03/12 16:56
 */
public class ReentrantReadWriteLockTest {
    public static void main(String[] args) {
        ReentrantReadWriteLock lock = new ReentrantReadWriteLock(true);
    }
}
class ReadWriteMap<K,V>{
    private Map<K,V> map;
    ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    Lock readLock = readWriteLock.readLock();
    Lock writeLock = readWriteLock.writeLock();

    public ReadWriteMap(Map<K, V> map) {
        this.map = map;
    }

    public V put(K key, V value){
        try {
            writeLock.lock();
            return map.put(key, value);
        } finally {
            writeLock.unlock();
        }
    }
    public V get(K key){
        try {
            readLock.lock();
            return map.get(key);
        } finally {
            readLock.unlock();
        }
    }
    //omit putAll,clear,remove and other method
}