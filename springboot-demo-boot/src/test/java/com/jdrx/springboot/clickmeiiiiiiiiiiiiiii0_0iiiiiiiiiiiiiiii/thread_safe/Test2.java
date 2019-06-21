package com.jdrx.springboot.clickmeiiiiiiiiiiiiiii0_0iiiiiiiiiiiiiiii.thread_safe;

import java.io.*;
import java.util.concurrent.Executors;

/**
 * @author : dengxuelong
 *
 *
 *
 *
 * @date : 2018/11/27 11:09
 */
public class Test2 {
    public static void main(String[] args) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        baos.write("abbb".getBytes());

        FileOutputStream fos1 = new FileOutputStream(new File("F://a.txt"));
        FileOutputStream fos2 = new FileOutputStream(new File("F://b.txt"));
        FileOutputStream fos3 = new FileOutputStream(new File("F://c.txt"));

        baos.writeTo(fos1);
        baos.writeTo(fos2);
        baos.writeTo(fos3);

    }
}