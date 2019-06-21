package com.jdrx.springboot.clickmeiiiiiiiiiiiiiii0_0iiiiiiiiiiiiiiii.param_protected_clone;


import java.util.*;

public class Test {
    public static void main(String[] args) {
        new B(1).getDate().setYear(11);
        System.out.println(returnTest());
    }

    static Integer returnTest(){
        Integer i = 129;
        Integer j = i;
        i ++;
        System.out.println("---"+ j);
        try {
            return i;
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            i ++;
            return 222;
        }
    }

    /**
     * evaluation min value
     *
     * <p>sss  <i>not</i><p>
     * {@code i < 10 || i >100}
     * <p/> i < 10 || i >100
     * @param arg
     */
    static void min(int...arg){
       int min = 0;
        for (int i : arg) {
            if (i < min) min = i;
        }
        List<int[]> ints = Arrays.asList(arg);
        int[][] i = new int[1][2];
        ints.toArray(i);
        System.out.println(min);
    }
    static void setTest(){
        A a1 = new A("a");
        A a2 = new A("b");
        Set<A> set = new HashSet<>();
        set.add(a1);
        set.add(a2);
        for (A a : set) {
            System.out.println(a);
        }
        a1.s="b";
        System.out.println("===========================================================");
        for (A a : set) {
            System.out.println(a);
        }
    }
}
class A {
    String s ;

    public A(String s) {
        this.s = s;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        A a = (A) o;

        return s != null ? s.equals(a.s) : a.s == null;
    }

    @Override
    public int hashCode() {
        return s != null ? s.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "A{" +
                "s='" + s + '\'' +
                '}';
    }
}

class B{
    private final int i=0;
    private final Date date = new Date();

    public Date getDate() {
        return new Date(this.date.getTime());
    }

    public B(int i) {
    }

    public int getI(){
        return i;
    }

    public B add(B b){
        return new B(b.i + 1);
    }

}