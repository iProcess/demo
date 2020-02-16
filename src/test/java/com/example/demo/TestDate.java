package com.example.demo;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestDate {

    public static void main(String[] args) throws Exception {

        String start = "2019-11-25 20:00:00";
        String end = "2019-11-25 21:00:00";
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date startDate = df.parse(start);
        Date endDate = df.parse(end);

        System.out.println(startDate.getTime());
        System.out.println(endDate.getTime());

    }
}
