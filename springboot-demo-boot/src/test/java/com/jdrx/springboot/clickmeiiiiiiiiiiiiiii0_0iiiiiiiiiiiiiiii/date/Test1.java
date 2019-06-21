package com.jdrx.springboot.clickmeiiiiiiiiiiiiiii0_0iiiiiiiiiiiiiiii.date;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;

/**
 * Created by dengxuelong on 2017/12/25.
 */
public class Test1 {
    @Test
    public void localDate() {
        LocalDate today = LocalDate.now();//获取当前【日期】
        LocalDate date = LocalDate.of(2017, 12, 26);//根据参数创建【日期】
        System.out.println(today);//比如：2017-12-26
        System.out.println(today.getDayOfMonth());//当月的第几天即【日】  26
        System.out.println(today.getDayOfYear());//当年第几天    360
        System.out.println(today.getDayOfWeek().getValue());//当周的第几天    2
        System.out.println(today.getMonthValue());//获取月 12
        System.out.println(today.getYear());//获取年   2017
        System.out.println(today.equals(date));//【比较2个日期是否相等】
        System.out.println(today + " " + today.plusYears(1));//日期【加减操作】 2017-12-26 2018-12-26
        System.out.println(today + " " + today.minusYears(1));//日期【加减操作】 2017-12-26 2016-12-26
        System.out.println(today.plus(1, ChronoUnit.WEEKS));//日期【加减操作】
    }

    @Test
    public void localTime() {
        LocalTime now = LocalTime.now();//获取当前【时间】
        System.out.println(now);//比如hh:mm:ss:nnn 时:分:秒:纳秒 比如 22:50:41.442
        LocalTime time1 = LocalTime.of(22, 56, 11);//根据参数创建【时间】
        System.out.println(now.getHour());//获取hour
        System.out.println(now + " " + now.plusHours(5));//日期【加减操作】 23:00:01.323 04:00:01.323
    }

    @Test
    public void clockTset() {
        Clock clock = Clock.systemUTC();
        System.out.println(clock.millis());
    }

    @Test
    public void zonedDateTimeTest() {
        ZoneId zoneId1 = ZoneId.of("UTC");
        ZoneId zoneId2 = ZoneId.of("UTC+7");
        LocalDateTime localDateTime = LocalDateTime.now();
        ZonedDateTime zonedDateTime1 = ZonedDateTime.of(localDateTime, zoneId1);
        ZonedDateTime zonedDateTime2 = ZonedDateTime.of(localDateTime, zoneId2);
        System.out.println(zonedDateTime1);//2017-12-27T11:06:51.543-05:00[America/New_York]
        System.out.println(zonedDateTime2);//2017-12-27T11:06:51.543+07:00[UTC+07:00]
    }

    @Test
    public void yearMonthTest() {
        YearMonth yearMonth = YearMonth.now();
        System.out.println(yearMonth);
        System.out.println(yearMonth.lengthOfMonth());//【当月有多少天】
        System.out.println(yearMonth.lengthOfYear());//【当年多少天】 可用来判断是否是闰年 也可直接用LocalDate.isLeapYear()
    }

    @Test
    public void periodTets() {//周期 期间
        LocalDate localDate1 = LocalDate.now();
        LocalDate localDate2 = LocalDate.of(2018, 1, 28);
        Period period = Period.between(localDate1, localDate2);
        System.out.println(period.getDays());
        System.out.println(period.getMonths());
    }

    @Test
    public void tt() {
//        LocalDateTime dateTime = LocalDateTime.now();
//        System.out.println(dateTime);
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
//        System.out.println(dateTime.format(formatter));//【格式化时间】
//        String s = "2017-12-28 23:03:42";
//        LocalDateTime tim = LocalDateTime.parse(s, formatter);//【解析时间】
//        System.out.println(tim);
        Date date = new Date(1514516984685L);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(format.format(date) + "  " + date.getTime());//2017-12-29 11:09:44  1514516984685
//        format.setTimeZone(TimeZone.getTimeZone("UTC+6:00"));
        System.out.println(format.format(date) + "  " + date.getTime());
    }

    @Test
    public void te1(){
        System.out.println(dateFormat(1514516984685L,"yyyy-MM-dd HH:mm:ss","UTC",8L));
    }

    /**
     * 把时间戳格式化为对应时区下的时间
     * @param instant  时间戳
     * @param format 时间格式 比如：yyyy-MM-dd HH:mm:ss
     * @param timeZoneType  时区类型：UTC/GMT/DST
     * @param timeZoneValue 时区值 比如：+1/+2/-1
     * @return
     */
    public String dateFormat(Long instant,String format,String timeZoneType,Long timeZoneValue){
        Instant ins = Instant.ofEpochMilli(instant);
        LocalDateTime dateTime = LocalDateTime.ofInstant(ins,ZoneId.of(timeZoneType));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        //加减hour
        LocalDateTime dateTime1 = dateTime.plusHours(timeZoneValue);
        return formatter.format(dateTime1);
    }
}
