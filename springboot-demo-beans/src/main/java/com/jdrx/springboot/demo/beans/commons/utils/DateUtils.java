package com.jdrx.springboot.demo.beans.commons.utils;

/**
 * Created by dengxuelong on 2017/11/8.
 */
public class DateUtils {
    /**
     * 获取两个时间的时间差，精确到毫秒   * @param str   * @return
     */
    public static String TimeDifference(long start, long end) {
        long between = end - start;
        long day = between / (24 * 60 * 60 * 1000);
        long hour = (between / (60 * 60 * 1000) - day * 24);
        long min = ((between / (60 * 1000)) - day * 24 * 60 - hour * 60);
        long s = (between / 1000 - day * 24 * 60 * 60 - hour * 60 * 60 - min * 60);
        long ms = (between - day * 24 * 60 * 60 * 1000 - hour * 60 * 60 * 1000 - min * 60 * 1000 - s * 1000);
//        String timeDifference = day + "天" + hour + "小时" + min + "分" + s + "秒" + ms + "毫秒";
        String timeDifference = hour + "小时" +min + "分" + s + "秒" + ms + "毫秒";
        return timeDifference;
    }
}
