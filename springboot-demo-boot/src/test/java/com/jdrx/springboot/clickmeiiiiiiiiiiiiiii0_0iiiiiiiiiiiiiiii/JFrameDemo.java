package com.jdrx.springboot.clickmeiiiiiiiiiiiiiii0_0iiiiiiiiiiiiiiii;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.InvocationTargetException;

public class JFrameDemo {

    public void CreateJFrame() throws InvocationTargetException, InterruptedException {
        JFrame jf = new JFrame("这是一个JFrame窗体");        // 实例化一个JFrame对象
        jf.setVisible(true);        // 设置窗体可视
        jf.setSize(500, 350);        // 设置窗体大小
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);        // 设置窗体关闭方式

        Container container = jf.getContentPane();

        JButton button = new JButton("提交");

        button.addActionListener(e -> {
            //1、改变可视化
            button.setEnabled(false);
            button.setText("运算中");

            new Thread(() -> {
                try {
                    //2、执行一个耗时任务
                    // 在事件线程中创建一个线程用来执行任务
                    Thread.sleep(2000);
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }finally {
                    //3、任务执行完成后的可视化反馈
                    SwingUtilities.invokeLater(() -> {
                        //在任务执行完成后向【事件线程】提交一个任务用来更新用户界面
                        //使用【事件线程】来更新用户界面，因为这些组件不是线程安全的
                        button.setText("提交");
                        button.setEnabled(true);
                    });
                }
            }).start();
        });


        container.add(button);

    }

    public static void main(String[] args) throws InvocationTargetException, InterruptedException {
        new JFrameDemo().CreateJFrame();        // 调用CreateJFrame()方法
    }

}