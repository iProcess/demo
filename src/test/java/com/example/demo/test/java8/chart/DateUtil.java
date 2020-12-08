package com.example.demo.test.java8.chart;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.apache.commons.lang3.time.FastDateFormat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Slf4j
public class DateUtil {

    public static void main(String[] args) {
//        String begin = "2020-09-28 23:59:57.0";
//        String end = "2020-10-28 23:59:57.0";
//        String srcPattern = YYYY_MM_DD_HH_MM_SS_SSS;
//        String targetPattern = YYYYMMDD;
//        String begin = "2020-09-28";
//        String end = "2020-10-28";
//        String srcPattern = YYYY_MM_DD;
//        String targetPattern = MM_DD;
//        List<String> listDate = getDatesFormat(begin, end, srcPattern, targetPattern);
//        System.out.println(JSON.toJSONString(listDate));

        String begin = "20200928";
        String date = format(begin, YYYYMMDD, MM_DD);
        System.out.println(date);

    }

    /**
     * 一天的毫秒数
     */
    public static final long MILLS_DAY = 1000L * 60L * 60L * 24L;
    public static final String YYYYMMDD = "yyyyMMdd";
    public static final String YYYY_MM_DD = "yyyy-MM-dd";
    public static final String YYYY_MM_DD_HH_MM_SS_SSS = "yyyy-MM-dd HH:mm:ss.SSS";
    public static final String MM_DD = "MM-dd";

    /**
     * 字符类型转换为时间类型
     * @param date
     * @return
     */
    public static Date parseDate(String date){
        return parseDate(date, YYYY_MM_DD);
    }
    /**
     * 字符类型转换为时间类型
     * @param date
     * @return
     */
    public static Date parseDate(String date, String parsePattern){
        try {
            return DateUtils.parseDate(date, parsePattern);
        } catch (ParseException e) {
            log.error("parseDate error:", e);
        }
        return null;
    }

    /**
     * 将字符串日期格式进行转换
     * @param date 字符串日期
     * @param srcPattern 源格式
     * @param targetPattern 目标格式
     * @return
     */
    public static String format(String date, String srcPattern, String targetPattern){
        Date targetDate = parseDate(date, srcPattern);
        SimpleDateFormat sdf = new SimpleDateFormat(targetPattern);
        return sdf.format(targetDate);
    }

    /**
     * 获取某天在一年中的第几周
     * @return
     */
    public static int getWeekOfYear(String date){
        return getWeekOfYear(date, YYYY_MM_DD);
    }
    /**
     * 获取某天在一年中的第几周
     * @return
     */
    public static int getWeekOfYear(String date, String parsePattern){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(parseDate(date, parsePattern));
        //设置星期一为一周开始的第一天
        calendar.setFirstDayOfWeek(Calendar.MONDAY);
        return calendar.get(Calendar.WEEK_OF_YEAR);
    }
    /**
     * 获取某天在一年中的第几周
     * @return
     */
    public static String getWeekOfYearStr(String date){
        return getWeekOfYearStr(date, YYYY_MM_DD);
    }

    /**
     * 获取某天在一年中的第几周
     * @return
     */
    public static String getWeekOfYearStr(String date, String parsePattern){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(parseDate(date, parsePattern));
        //设置星期一为一周开始的第一天
        calendar.setFirstDayOfWeek(Calendar.MONDAY);
        int week = calendar.get(Calendar.WEEK_OF_YEAR);
        return String.format("%02d", week);
    }

    /**
     * 获取一个时间范围内的所有日期
     * @param begin 开始时间
     * @param end 结束时间
     * @param srcPattern 源格式
     * @param targetPattern 目标格式
     * @return
     */
    public static List<String> getDatesFormat(String begin, String end, String srcPattern, String targetPattern) {
        List<String> dates = new ArrayList<>();
        Date beginDate = parseDate(begin, srcPattern);
        Date endDate = parseDate(end, srcPattern);
        if (endDate.compareTo(beginDate) == 0) {
            dates.add(FastDateFormat.getInstance(targetPattern).format(beginDate));
            return dates;
        }
        while (beginDate.compareTo(endDate) <= 0) {
            dates.add(FastDateFormat.getInstance(targetPattern).format(beginDate));
            beginDate = getNextDay(beginDate);
        }
        return dates;
    }

    /**
     * 指定某天的下一天
     * @return
     */
    public static Date getNextDay(Date date){
        return DateUtils.addDays(date, 1);
    }
    /**
     * 获取前一天
     * @return
     */
    public static String getLastDay(){
        return getLastDay(new Date());
    }
    /**
     * 指定某天减去一天
     * @param date
     * @return
     */
    public static String getLastDay(String date){
        return DateFormatUtils.ISO_8601_EXTENDED_DATE_FORMAT.format(DateUtils.addDays(parseDate(date), -1));
    }
    /**
     * 指定某天减去一天
     * @param date
     * @return
     */
    public static String getLastDay(Date date){
        return DateFormatUtils.ISO_8601_EXTENDED_DATE_FORMAT.format(DateUtils.addDays(date, -1));
    }
    /**
     * 指定某天加上n天，n传负数为减去n天
     * @param date
     * @return
     */
    public static String getDayAddN(String date, int n){
        return DateFormatUtils.ISO_8601_EXTENDED_DATE_FORMAT.format(DateUtils.addDays(parseDate(date), n));
    }
    /**
     * 指定某天减去一年
     * @param date
     * @return
     */
    public static String getLastYear(String date){
        return DateFormatUtils.ISO_8601_EXTENDED_DATE_FORMAT.format(DateUtils.addYears(parseDate(date), -1));
    }
    /**
     * 当天减去一周
     * @return
     */
    public static String getDayOfLastWeek(){
        return getDayOfLastWeek(new Date());
    }
    /**
     * 指定某天减去一周
     * @param date
     * @return
     */
    public static String getDayOfLastWeek(Date date){
        return DateFormatUtils.ISO_8601_EXTENDED_DATE_FORMAT.format(DateUtils.addWeeks(date, -1));
    }
    /**
     * 指定某天减去一周
     * @param date
     * @return
     */
    public static String getDayOfLastWeek(String date){
        return DateFormatUtils.ISO_8601_EXTENDED_DATE_FORMAT.format(DateUtils.addWeeks(parseDate(date), -1));
    }
    /**
     * 指定某天之前连续的周(包含当周)
     * @param date
     * @param weekNum
     * @param weekList
     */
    public static void getDayForWeeks(String date, int weekNum, List<String> weekList){
        weekList.add(date);
        if(weekNum == 1){
            return;
        }
        getDayForWeeks(getDayOfLastWeek(date), --weekNum, weekList);
    }
    /**
     * 获取输入日期的当月第一天
     *
     * @param currentDateStr 输入日期
     * @return 输入日期的当月第一天
     */
    public static String getFirstDayOfMonth(String currentDateStr) {
        Date currentDate = parseDate(currentDateStr);
        Calendar c = Calendar.getInstance();
        c.setTime(currentDate);
        c.set(Calendar.DATE, 1);
        Date d = c.getTime();
        return DateFormatUtils.ISO_8601_EXTENDED_DATE_FORMAT.format(d);
    }
    /**
     * 获取本周一所在日期
     * @return
     */
    public static String getFirstDayOfWeek (String currentDateStr) {
        Date currentDate = parseDate(currentDateStr);
        Calendar cal = Calendar.getInstance();
        cal.setTime(currentDate);
        cal.setFirstDayOfWeek(Calendar.MONDAY);
        cal.set(Calendar.DAY_OF_WEEK,Calendar.MONDAY);
        Date d = cal.getTime();
        return DateFormatUtils.ISO_8601_EXTENDED_DATE_FORMAT.format(d);
    }

    public static String getEndDayOfWeek (String currentDateStr) {
        Date currentDate = parseDate(currentDateStr);
        Calendar cal = Calendar.getInstance();
        cal.setTime(currentDate);
        cal.setFirstDayOfWeek(Calendar.MONDAY);
        cal.set(Calendar.DAY_OF_WEEK,Calendar.MONDAY);
        Date d = cal.getTime();
        return DateFormatUtils.ISO_8601_EXTENDED_DATE_FORMAT.format(DateUtils.addDays(d, 6));
    }

    /**
     * 获取输入日期当月最后一天
     *
     * @param currentDateStr
     * @return
     */
    public static String getEndDayOfMonth(String currentDateStr) {
        Date currentDate = parseDate(currentDateStr);
        Calendar cal = Calendar.getInstance();
        cal.setTime(currentDate);
        int value = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        cal.set(Calendar.DAY_OF_MONTH, value);
        Date d = cal.getTime();
        return DateFormatUtils.ISO_8601_EXTENDED_DATE_FORMAT.format(d);
    }
    /**
     * 当天减去一个月
     * @return
     */
    public static String getDayOfLastMonth(){
        return getDayOfLastMonth(new Date());
    }
    /**
     * 指定某天减去一个月
     * @param date
     * @return
     */
    public static String getDayOfLastMonth(Date date){
        return DateFormatUtils.ISO_8601_EXTENDED_DATE_FORMAT.format(DateUtils.addMonths(date, -1));
    }
    /**
     * 指定某天减去一个月
     * @param date
     * @return
     */
    public static String getDayOfLastMonth(String date){
        return DateFormatUtils.ISO_8601_EXTENDED_DATE_FORMAT.format(DateUtils.addMonths(parseDate(date), -1));
    }
    /**
     * 指定某天之前连续的月(包含当月)
     * @param date
     * @param monthNum
     * @param monthList
     */
    public static void getDayForMonths(String date, int monthNum, List<String> monthList){
        monthList.add(date);
        if(monthNum == 1){
            return;
        }
        getDayForMonths(getDayOfLastMonth(date), --monthNum, monthList);
    }

    public static long calculateDisDays(String dateBegin, String dateEnd) {
        Date begin = parseDate(dateBegin);
        Date end = parseDate(dateEnd);
        Calendar calBegin = Calendar.getInstance();
        Calendar calEnd = Calendar.getInstance();
        calBegin.setTime(begin);
        calEnd.setTime(end);
        calBegin.set(Calendar.HOUR_OF_DAY, 0);
        calBegin.set(Calendar.MINUTE, 0);
        calBegin.set(Calendar.SECOND, 0);

        long minllsBegin = calBegin.getTimeInMillis();
        long minllsEnd = calEnd.getTimeInMillis();
        long dis = (minllsEnd - minllsBegin) / MILLS_DAY;
        dis = (minllsEnd - minllsBegin) % MILLS_DAY == 0 ? dis : (dis + 1);
        return dis;
    }

    /**
     * 获取指定日期的月份
     * @param date 日期，格式为"yyyy-MM-dd"
     * @return 日期对应的月份，字符串格式
     */
    public static String getMonthValue(String date){
        DateTimeFormatter da = DateTimeFormatter.ofPattern(YYYY_MM_DD);
        LocalDate localDate = LocalDate.parse(date, da);
        int month = localDate.getMonthValue();
        return String.format("%02d", month);
    }

    /**
     * 获取指定日期的年份
     * @param date 日期，格式为"yyyy-MM-dd"
     * @return 日期对应的月份，字符串格式
     */
    public static String getYearValue(String date){
        DateTimeFormatter da = DateTimeFormatter.ofPattern(YYYY_MM_DD);
        LocalDate localDate = LocalDate.parse(date, da);
        int year = localDate.getYear();
        return String.valueOf(year);
    }

}
