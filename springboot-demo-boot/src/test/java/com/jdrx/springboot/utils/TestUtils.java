package com.jdrx.springboot.utils;

import com.jdrx.springboot.demo.beans.commons.RetrofitUtils;
import com.jdrx.springboot.demo.beans.commons.utils.MapUtils;
import com.jdrx.springboot.demo.beans.vo.ResposeVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import retrofit2.Call;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.util.*;

/**
 * Created by dengxuelong on 2017/11/15.
 */
public class TestUtils {
    public static final Logger logger = LoggerFactory.getLogger(TestUtils.class);
    public static final String EXPEND_FILE_NAME = "/expend.txt";
    public static final String EXPEND_DIRECTORY = "expend/sentRecordPage";
    public static final String SUCCESS_STATUS = "0";

    /**
     * @param baseUrl
     * @param api
     * @param interface1 Helper接口
     * @param methodName 要执行接口的方法名
     * @param token
     * @param count      执行的次数
     * @param map        接口参数
     * @param <T>
     */
    public static <T> void apiTest(String baseUrl, String api, Class<T> interface1, String methodName
            , String token, Map map, int count) {

        //为接口创建Retrofit代理实现类
        T helper = RetrofitUtils.getHelperInstance(interface1, baseUrl);
        ArrayList<Long> timeList = new ArrayList();
        for (int i = 0; i < count; i++) {
            try {
                //通过方法名获取接口方法
                Method method = interface1.getMethod(methodName, String.class, HashMap.class);
                Call<ResposeVO> call = (Call<ResposeVO>) method.invoke(helper, token, map);
                //获取结果
                long startTime = System.currentTimeMillis();
                ResposeVO response = call.execute().body();
                long endTime = System.currentTimeMillis();
                long expend = endTime - startTime;

                if (SUCCESS_STATUS.equals(response.getStatus())) {
                    timeList.add(expend);
                    logger.info(String.format("%s 执行时间:%d毫秒  [request:%s] [response:%s]", api, expend, MapUtils.mapToString(map), response));
                } else {
                    logger.error(String.format("%s 执行时间:%d毫秒  [request:%s] [response:%s]", api, expend, MapUtils.mapToString(map), response));
                }
            } catch (SocketTimeoutException e) {
                recordErrorLog(api, map, e);
            } catch (SocketException e) {
                recordErrorLog(api, map, e);
            } catch (Exception e) {
                recordErrorLog(api, map, e);
            }
        }
        //统计平均时间
        long sum = 0;
        long avg;
        for (Long t : timeList) {
            sum += t;
        }
        if (timeList.size() == 0) {
            avg = 0;
        } else {
            avg = sum / timeList.size();
        }
        logger.info("-------------------------------------------------------------------");
        logger.info(String.format("执行了%d次  平均时间为：%d毫秒", timeList.size(), avg));
        logger.info("-------------------------------------------------------------------");

    }

    /**记录日志*/
    private static void recordErrorLog(String api, Map map, Exception e) {
        logger.error(String.format("%s  [request:%s]  [exception:]", api, MapUtils.mapToString(map)),e);
    }



















    /**
     * 使用随机的参数
     *
     * @param baseUrl
     * @param api        打印日志时使用
     * @param interface1 Helper接口
     * @param methodName 要执行接口的方法
     * @param token
     * @param count      执行的次数
     * @param <T>
     */
    @Deprecated
    public static <T> void apiTestWithRandomParam(String baseUrl, String api, Class<T> interface1, String methodName, String token, int count) {
        T helper = RetrofitUtils.getHelperInstance(interface1
                , baseUrl);
        ArrayList<Long> timeList = new ArrayList();
        HashMap map = new HashMap();
        for (int i = 0; i < count; i++) {
            try {
                Method method = interface1.getMethod(methodName, String.class, HashMap.class);
                map = createQueryMsgParam();//TODO 生成随机参数列表

                long startTime = System.currentTimeMillis();

                Call<ResposeVO> call = (Call<ResposeVO>) method.invoke(helper, token, map);
                ResposeVO response = call.execute().body();

                long endTime = System.currentTimeMillis();
                long expend = endTime - startTime;

                if ("0".equals(response.getStatus())) {

                    timeList.add(expend);
                    writeExpend(EXPEND_DIRECTORY, (int) expend);//TODO 文件保存的目录

                    if (expend < 2000) {
                        logger.info(api + " 执行时间:" + expend + "毫秒  [request:" + MapUtils.mapToString(map) + "]  |||||[response:" + response + "]");
                    } else {
                        logger.info(api + " 执行时间:" + expend + "毫秒  [request:" + MapUtils.mapToString(map) + "]  [response:" + response + "]");
                    }
                } else {
                    logger.error(api + " 执行时间:" + expend + "毫秒  [request:" + MapUtils.mapToString(map) + "]  [response:" + response + "]");
                }
            } catch (SocketTimeoutException e) {
                logger.error(api + "  [request:" + MapUtils.mapToString(map) + "]  [exception:" + e + "]");
            } catch (SocketException e) {
                logger.error(api + "  [request:" + MapUtils.mapToString(map) + "]  [exception:" + e + "]");
            } catch (Exception e) {
                e.printStackTrace();
                logger.error(api + "  [request:" + MapUtils.mapToString(map) + "]  [exception:" + e.getMessage() + "]");
            }
        }

        long sum = 0;
        long avg = 0;
        for (Long t : timeList) {
            sum += t;
        }
        avg = sum / timeList.size();

        logger.info("-------------------------------------------------------------------");
        logger.info("执行了" + timeList.size() + "次  " + "平均时间为：" + avg + "毫秒");
        logger.info("-------------------------------------------------------------------");

    }

    /**
     * @param directory 目录格式为：aaa/bbb或aaa
     * @param time
     * @param <T>
     */
    private static <T> void writeExpend(String directory, int time) {
        File dire = new File(directory);
        //如果目录不存在就创建
        if (!dire.exists()) {
            dire.mkdirs();
        }
        try (FileOutputStream fos = new FileOutputStream(directory + EXPEND_FILE_NAME, true)
        ) {
            fos.write(new String(time + ",").getBytes());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 适用于
     * api/0/message/query
     * api/0/message/queryAll
     * api/0/overallMsg/queryReceivedMessagePage
     * api/0/overallMsg/topInfo
     * api/0/overallMsg/sentRecordPage
     *
     * @return
     */
    private static HashMap createQueryMsgParam() {
        HashMap map = new HashMap();
        if (new Random().nextBoolean()) {
            map.put("status", 1);
        }
        if (new Random().nextBoolean()) {
            map.put("sendId", "202057");
        }
        if (new Random().nextBoolean()) {
            map.put("pushStatus", 0);
        }
        if (new Random().nextBoolean()) {
            map.put("title", "title");
        }
        if (new Random().nextBoolean()) {
            map.put("platformPrefix", "INNERMSG");
        }
        if (new Random().nextBoolean()) {
            map.put("warningType", "MAIL");
        }
        if (new Random().nextBoolean()) {
            map.put("sendName", "zhangjin");
        }
        return map;
    }


    private static String s;

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        sb.append(s);
        System.out.println(sb.toString());
    }
}
