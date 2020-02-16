package com.example.demo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Java Date序列化和反序列化，代码案例：
 */
public class FastJsonDateMain {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // 时间
        Date date = new Date();
        String json = JSON.toJSONString(date);
        System.out.println(json);

        // 格式化输出时间
        String jsonStr = JSON.toJSONString(date, SerializerFeature.WriteDateUseDateFormat);
        System.out.println(jsonStr);

        // 自定义格式输出
        String dataFormat = "yyyy-MM-dd";
        String timeFormat = "yyyy-MM-dd HH:mm:ss SSS";
        String dateJson = JSON.toJSONStringWithDateFormat(date, dataFormat,
                SerializerFeature.WriteDateUseDateFormat);
        System.out.println(dateJson);
        String jsonString = JSON.toJSONStringWithDateFormat(date, timeFormat);
        System.out.println(jsonString);

        // 从容器中输出
        Map<String, Date> map = new HashMap<String, Date>();
        map.put("1", new Date());
        map.put("2", new Date());
        map.put("3", new Date());
        String mapJson = JSON.toJSONStringWithDateFormat(map, dataFormat);
        System.out.println(mapJson);
        String mapJson2 = JSON.toJSONStringWithDateFormat(map, timeFormat);
        System.out.println(mapJson2);
    }

}
