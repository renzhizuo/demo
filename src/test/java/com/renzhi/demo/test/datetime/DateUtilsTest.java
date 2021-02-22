package com.renzhi.demo.test.datetime;

import cn.hutool.core.date.DateField;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import com.renzhi.demo.BaseTest;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Description : 类描述
 * Created on : 2021-02-21
 * author : renzhi.zuo
 */
@Slf4j
public class DateUtilsTest extends BaseTest {
    @Test
    public void test(){
        log.info("年龄:{}",DateUtil.ageOfNow(new Date()));

        log.info("一天开始的时间:{}",DateUtil.beginOfDay(new Date()));
        log.info("一天结束的时间:{}",DateUtil.endOfDay(new Date()));

        DateTime dateTime = DateUtil.beginOfDay(new Date());
        Date to = dateTime.toJdkDate();

        LocalDateTime begin = LocalDateTime.of(2021, 2, 21, 1, 30, 00);
        Date from = localDateTime2Date(begin);
        List<DateTime> dateTimes = DateUtil.rangeToList(from, to, DateField.HOUR_OF_DAY);
        log.info("dateTimes={}",dateTimes);
    }

    private Date localDateTime2Date(LocalDateTime localDateTime) {
        //获取时间地区ID
        ZoneId zoneId = ZoneId.systemDefault();
        //转换为当地时间
        ZonedDateTime zonedDateTime = localDateTime.atZone(zoneId);
        //转为Date类型
        return Date.from(zonedDateTime.toInstant());
    }

    /**
     * 2019-03-27
     */
    public static LocalDate today() {
        return LocalDate.now();
    }

    /**
     * 10:36:24.425
     */
    public static LocalTime nowTime() {
        return LocalTime.now();
    }

    public void test1() {
        LocalDate today = today();
        /**
         * 一般用法如下：
         */
        // 根据年月日取日期：
        // -> 2014-12-25
        LocalDate crischristmas = LocalDate.of(2014, 12, 25);
        // 根据字符串取：
        // 严格按照ISO yyyy-MM-dd验证，02写成2都不行，当然也有一个重载方法允许自己定义格式
        LocalDate endOfFeb = LocalDate.parse("2014-02-28");
        // 无效日期无法通过：DateTimeParseException: Invalid date
        LocalDate.parse("2014-02-29");

        /**
         * 一般日期转换：
         */
        // 取本月第1天：
        LocalDate firstDayOfThisMonth = today.with(TemporalAdjusters.firstDayOfMonth());
        // 取本月第2天：
        LocalDate secondDayOfThisMonth = today.withDayOfMonth(2);
        // 取本月最后一天，再也不用计算是28，29，30还是31：
        LocalDate lastDayOfThisMonth = today.with(TemporalAdjusters.lastDayOfMonth());
        // 取下一天：
        LocalDate firstDayOf2015 = lastDayOfThisMonth.plusDays(1);
        // 取2017年1月第一个周一，用Calendar要死掉很多脑细胞：
        LocalDate firstMondayOf2015 = LocalDate.parse("2017-01-01").with(TemporalAdjusters.firstInMonth(DayOfWeek.MONDAY));


        /**
         【LocalTime】
         */
        //        LocalTime只包含时间，获得当前时间：

        LocalTime now = LocalTime.now();
        //        构造时间：

        LocalTime zero = LocalTime.of(0, 0, 0);
        LocalTime mid = LocalTime.parse("12:00:00");

        //        JDBC
        //        最新JDBC映射将把数据库的日期类型和Java 8的新类型关联起来：

        /**    SQL -> Java
         --------------------------
         date -> LocalDate
         time -> LocalTime
         timestamp -> LocalDateTime*/
    }

    /**
     * 格式 2019-05-18 10:00:00
     */
    public static String getHourStart() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:00:00"));
    }

    public static String getDayStart() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd 00:00:00"));
    }

    /**
     * @param dateStr 2018-04-09
     */
    public static String getDayStart(String dateStr) {
        LocalDate localDate = LocalDate.parse(dateStr);
        LocalDateTime localDateTime = localDate.atTime(0, 0, 0);
        return localDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }


    /**
     * 格式 2019-05-18 10:59:59
     */
    public static String getHourEnd() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:59:59"));
    }

    public static String getDayEnd() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd 23:59:59"));
    }

    /**
     * @param dateStr 2018-04-09
     */
    public static String getDayEnd(String dateStr) {
        LocalDate localDate = LocalDate.parse(dateStr);
        LocalDateTime localDateTime = localDate.atTime(23, 59, 59);
        return localDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }


    /**
     * 2019-05-18_11
     */
    public static String getHourStartKey() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd_HH"));
    }


    /**
     * [2019-05-18_00,,,2019-05-18_09]
     */
    private static List<String> getBeforeHoursList() {
        ArrayList<String> list = new ArrayList<>();
        int hour = LocalDateTime.now().getHour();
        for (int i = 0; i < hour; i++) {
            LocalDateTime localDateTime = LocalDateTime.of(LocalDate.now(), LocalTime.of(i, 0));
            String format = localDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd_H"));
            list.add(format);
        }
        return list;
    }
    /**今天yyyy-MM-dd*/
    private static String getToday(){
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }
    /**明天yyyy-MM-dd*/
    private static String getTomorrow(){
        return LocalDateTime.now().plusDays(1).format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }

    private static void queryStartEndTime() {
        log.info("当前小时开始,{}", getHourStart());
        log.info("当前小时结束,{}", getHourEnd());
        log.info("当前天开始,{}", getDayStart());
        log.info("当前天结束,{}", getDayEnd());
        List<String> stringList = Arrays.asList("2019-12-18", "2019-12-24");
        stringList.forEach(dayStr->{
            log.info("给定天:{}开始,{}", dayStr, getDayStart(dayStr));
            log.info("给定天:{}结束,{}", dayStr, getDayEnd(dayStr));
        });
    }

    private static void queryDayHour() {
        log.info("今天:{},明天:{}",getToday(),getTomorrow());
        log.info("当前时间前的小时列表:{}}",getBeforeHoursList());

        LocalDateTime localDateTime = LocalDateTime.now().plusHours(-1);
        String timeLocalDate = localDateTime.toLocalDate().toString();
        log.info("过去一小时时间:{},过去一小时:{},当前日期:{}",localDateTime,localDateTime.getHour(),timeLocalDate);

        log.info("当前小时数:{}",LocalDateTime.now().getHour());
    }

    private static void queryLocal(){
        log.info("LocalDate:{}",LocalDate.now());
        log.info("LocalTime:{}",LocalTime.now());
        log.info("LocalDateTime:{}",LocalDateTime.now());

        log.info("LocalDate前一天:{}",LocalDate.now().plusDays(-1));
        log.info("LocalDate后一天:{}",LocalDate.now().plusDays(1));

        log.info("LocalTime前一小时:{}",LocalTime.now().plusHours(-1));
        log.info("LocalTime后一小时:{}",LocalTime.now().plusHours(8));
        log.info("LocalTime后一小时:{}",LocalTime.now().plusHours(7));
        log.info("LocalTime后一小时:{}",LocalTime.now().plusHours(6));

        log.info("LocalDate--天开始:{}",LocalDate.now().atStartOfDay());
    }

    @Test
    public void testStatic(){
//        queryStartEndTime();
//        queryDayHour();
        queryLocal();

        log.info("1:{},2:{}",LocalDate.parse("2020-07-31"),LocalTime.parse("14:23:23"));
    }

}
