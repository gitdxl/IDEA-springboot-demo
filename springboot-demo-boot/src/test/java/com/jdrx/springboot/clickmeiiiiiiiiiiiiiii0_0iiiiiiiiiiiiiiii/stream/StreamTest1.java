package com.jdrx.springboot.clickmeiiiiiiiiiiiiiii0_0iiiiiiiiiiiiiiii.stream;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamTest1 {

    /**
     * 初试Stream
     */
    @Test()
    public void t1(){
        Student stuA = new Student(1, "A", "M", 184);
        Student stuB = new Student(2, "B", "G", 163);
        Student stuC = new Student(3, "C", "M", 175);
        Student stuD = new Student(4, "D", "G", 158);
        Student stuE = new Student(5, "E", "M", 170);
        List<Student> list = new ArrayList<>();
        list.add(stuA);
        list.add(stuB);
        list.add(stuC);
        list.add(stuD);
        list.add(stuE);
        list.stream()
                .filter((s)->{return s.no == 1;})
                .forEach(s -> System.out.println(s.name));
    }

    /**
     * 创建流的各种方法
     */
    @Test
    public void t2(){
        Stream<Integer> stream = new ArrayList<Integer>().stream();
        Stream<Integer> integerStream =Stream.of(1, 2, 3);
    }

    @Test
    public void t3(){
        long l = System.currentTimeMillis();
        for (int i = 0;i < Integer.MAX_VALUE;i++){
            int j = i;
        }
        System.out.println("耗时："+(System.currentTimeMillis() - l));
//---------------------------------------------
        l = System.currentTimeMillis();
        for (int i = 0;i < Integer.MAX_VALUE;i++){
            Integer j = i;
        }
        System.out.println("耗时："+(System.currentTimeMillis() - l));
    }

    public static void main(String[] args) {
        long long1 = 0;
        Long long2 = 0L;
        long l = System.currentTimeMillis();
        for (int i = 0;i < Integer.MAX_VALUE;i++){
            long1 +=i;
        }
        System.out.println("耗时："+(System.currentTimeMillis() - l));
//---------------------------------------------
        l = System.currentTimeMillis();
        for (int i = 0;i < Integer.MAX_VALUE;i++){
            long2 +=i;
        }
        System.out.println("耗时："+(System.currentTimeMillis() - l));
    }


    @Test
    public void t4(){
        long l = System.currentTimeMillis();
        for (int i = 0;i < Integer.MAX_VALUE;i++){
            Integer j = i;
        }
        System.out.println("耗时："+(System.currentTimeMillis() - l));
//---------------------------------------------
        l = System.currentTimeMillis();
        for (int i = 0;i < Integer.MAX_VALUE;i++){
            int j = i;
        }
        System.out.println("耗时："+(System.currentTimeMillis() - l));
    }

}












