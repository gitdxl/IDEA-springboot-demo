package com.jdrx.springboot.clickmeiiiiiiiiiiiiiii0_0iiiiiiiiiiiiiiii.test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class SortTest {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        Student[] arr = new Student[4];
        int y,s,w;
        int i = 0;
        while(i < 4 && cin.hasNext())
        {
            String name = cin.next();
            y = cin.nextInt();
            s = cin.nextInt();
            w = cin.nextInt();
            arr[i] = new Student(name, y, s, w, i);
            i ++;
        }

        sort(arr);
    }


    static class Student{
        int index;
        String name;
        int y;
        int s;
        int w;
        int sum;

        public Student(String name, int y, int s, int w,int index) {
            this.name = name;
            this.y = y;
            this.s = s;
            this.w = w;
            this.sum = y + s + w;
        }
    }

    public static void sort(Student[] arr){
        Arrays.sort(arr, (o1, o2) -> {
            if(o1.sum != o2.sum){
                return o2.sum - o1.sum;
            }
            if(o1.y != o2.y){
                return o2.y - o1.y;
            }
            if(o1.s != o2.s){
                return o2.s - o1.s;
            }
           return o1.index - o2.index;
        });

        for (Student student : arr) {
            System.out.printf("%s %d %s %s%n", student.name, student.y, student.s, student.y);
        }
    }
}
