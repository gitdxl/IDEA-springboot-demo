package com.proxy;

public class MoveImpl implements Say,Move {
    @Override
    public void move() {
        System.out.println("move...");
    }

    @Override
    public void say() {
        System.out.println("ga ga ga...");
    }
}
