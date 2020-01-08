package com.jdrx.springboot.clickmeiiiiiiiiiiiiiii0_0iiiiiiiiiiiiiiii;

public class Test2222{
    public static boolean b = true;
    public static void main(String[] args) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                while(b){
                }
            }
        }).start();

        try {
            Thread.sleep(111);
        } catch (Exception e) {
            e.printStackTrace();
        }

        b=false;
    }
    public synchronized static boolean getStatus(){return b;}
    public synchronized static void setStatus(){b=false;}
}