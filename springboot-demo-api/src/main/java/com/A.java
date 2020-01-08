package com;

import java.time.LocalDateTime;

public class A {
    public void say(){
        System.out.println("api say()...");
    }

    public static void main(String[] args) {
        System.out.println(LocalDateTime.now().toString());
    }
}
