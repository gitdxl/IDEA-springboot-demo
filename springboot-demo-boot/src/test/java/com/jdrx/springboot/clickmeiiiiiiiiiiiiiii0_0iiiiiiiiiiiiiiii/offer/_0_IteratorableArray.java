package com.jdrx.springboot.clickmeiiiiiiiiiiiiiii0_0iiiiiiiiiiiiiiii.offer;


import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * @author : dengxuelong
 * @date : 2019/05/31 15:07
 */
public class _0_IteratorableArray implements Iterable{
    int array[] = new int[10];

    @Override
    public Iterator iterator() {
        return new Itr();
    }

    class Itr implements Iterator{
        //上一个元素的位置
        int cursor = -1;

        @Override
        public boolean hasNext() {
            //【下一个元素的位置】小于数组的长度
            return cursor + 1 < array.length;
        }

        @Override
        public Integer next() {
            return array[++cursor];
        }
    }

    public static void main(String[] args) {
        LinkedList l = new LinkedList();

        _0_IteratorableArray o = new _0_IteratorableArray();
        for (int i = 0; i < o.array.length; i++) {
            o.array[i] = i;
        }
        for (Object o1 : o) {
            System.out.println(o1);
        }

    }
}