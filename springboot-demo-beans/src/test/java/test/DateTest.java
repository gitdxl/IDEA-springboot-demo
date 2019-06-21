package test;

import java.io.RandomAccessFile;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by dengxuelong on 2017/11/6.
 */
public class DateTest {
    public static void main(String[] args) throws Exception{

        RandomAccessFile raf = new RandomAccessFile("E:/21.txt","rw");
        raf.write("0123456789".getBytes());
        raf.seek(3);
        raf.write("aaa".getBytes());
        raf.close();
    }
}
