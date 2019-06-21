package com.jdrx.springboot.clickmeiiiiiiiiiiiiiii0_0iiiiiiiiiiiiiiii;

import java.util.*;

/**
 * @author : dengxuelong
 * @date : 2019/02/12 13:44
 */
public class CountHashSet extends HashSet {
    int count;

    @Override
    public boolean add(Object o) {
        count ++;
        return super.add(o);
    }

    @Override
    public boolean addAll(Collection c) {
        count += c.size();
        return super.addAll(c);
    }

    public static void main(String[] args) {
        Collections.synchronizedCollection(new ArrayDeque<>());
        CountHashSet o = new CountHashSet();
        o.addAll(Arrays.asList(1,2,3));
        System.out.println(o.count);
    }
}

















