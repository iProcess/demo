package com.example.demo.date;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;

import java.text.ParseException;
import java.util.*;

@Slf4j
public class DateTest {

    /**
     * 字符类型转换为时间类型
     * @param date
     * @return
     */
    public static Date parseDate(String date){
        try {
            return DateUtils.parseDate(date, "YYYY-MM-dd");
        } catch (ParseException e) {
            log.error("parseDate error:", e);
        }
        return null;
    }

    public static String getDayOfLastWeek(String date){
        return DateFormatUtils.ISO_8601_EXTENDED_DATE_FORMAT.format(DateUtils.addWeeks(parseDate(date), -1));
    }

    public static void getDayForWeeks(String date, int weekNum, List<String> weekList){
        weekList.add(date);
        if(weekNum == 1){
            return;
        }
        getDayForWeeks(getDayOfLastWeek(date), --weekNum, weekList);
    }

    /**
     * 指定某日减去一个月
     * @param date
     * @return
     */
    public static String getDayOfLastMonth(String date){
        return DateFormatUtils.ISO_8601_EXTENDED_DATE_FORMAT.format(DateUtils.addMonths(parseDate(date), -1));
    }

    public static void getDayForMonths(String date, int monthNum, List<String> monthList){
        monthList.add(date);
        if(monthNum == 1){
            return;
        }
        getDayForMonths(getDayOfLastMonth(date), --monthNum, monthList);
    }

    /**
     * 获取一个时间范围内的所有日期
     * @param begin 开始日期
     * @param end   结束日期
     * @return
     */
    public static List<String> getDates(String begin, String end) {
        List<String> dates = new ArrayList<>();
        Date beginDate = parseDate(begin);
        Date endDate = parseDate(end);
        if (endDate.compareTo(beginDate) == 0) {
            dates.add(begin);
            return dates;
        }
        while (beginDate.compareTo(endDate) <= 0) {
            dates.add(DateFormatUtils.ISO_8601_EXTENDED_DATE_FORMAT.format(beginDate));
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
     * 获取某天在一年中的第几周
     * @return
     */
    public static int getWeekOfYear(String date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(parseDate(date));
        //设置星期一为一周开始的第一天
        calendar.setFirstDayOfWeek(Calendar.MONDAY);
        return calendar.get(Calendar.WEEK_OF_YEAR);
    }

    public static void main(String[] args) {
//        String date = "2020-08-01";
//        List<String> weekList = new ArrayList<>();
//        getDayForWeeks(date, 13, weekList);
//        System.out.println(weekList);
//
//        Collections.reverse(weekList);
//        System.out.println(weekList);
//
//        List<String> monthList = new ArrayList<>();
//        getDayForMonths(date, 13, monthList);
//        System.out.println(monthList);
//
//        Collections.reverse(monthList);
//        System.out.println(monthList);

//        String begin = "2020-07-20";
//        String end = "2020-07-20";
//        List<String> dates = getDates(begin, end);
//        System.out.println(dates);

        String date = "2020-06-01";
        System.out.println(getWeekOfYear(date));


    }

}
