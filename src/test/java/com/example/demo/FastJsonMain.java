package com.example.demo;

import com.alibaba.fastjson.JSON;

import java.util.*;

/**
 * 数组、List、Set、Map基本序列化和反序列化，代码案例：
 */
public class FastJsonMain {
    /**
     * Array to JSON
     */
    public static void array2Json(){
        // 数组序列化
        String[] array = new String[4];
        array[0]="北京";
        array[1]="上海";
        array[2]="广州";
        array[3]="深圳";
        String json = JSON.toJSONString(array);
        System.out.println("序列化 Array to JSON -> ");
        System.out.println(json);
        // 数组反序列化
        array = (String[])JSON.parseObject(json,String[].class);
        System.out.println("反序列化 数组内容 -> ");
        System.out.print(array[0] + " ");
        System.out.print(array[1] + " ");
        System.out.print(array[2] + " ");
        System.out.println(array[3]);
    }

    /**
     * List to JSON
     */
    public static void list2Json(){
        // List序列化
        List<String> list = new ArrayList<String>();
        list.add("北京");
        list.add("上海");
        list.add("广州");
        list.add("深圳");
        String json = JSON.toJSONString(list);
        System.out.println("序列化 List to JSON -> ");
        System.out.println(json);
        // List反序列化
        list = (List)JSON.parseObject(json,List.class);
        System.out.println("反序列化 List内容 -> ");
        System.out.println(list);
    }

    /**
     * Set to JSON
     */
    public static void set2Json(){
        // List序列化
        Set<String> set = new HashSet<String>();
        set.add("北京");
        set.add("上海");
        set.add("广州");
        set.add("深圳");
        String json = JSON.toJSONString(set);
        System.out.println("序列化 Set to JSON -> ");
        System.out.println(json);
        // Set反序列化
        set = (Set)JSON.parseObject(json,Set.class);
        System.out.println("反序列化 Set内容 -> ");
        System.out.println(set);
    }

    /**
     * Map to JSON
     */
    public static void map2Json(){
        Map<String,String> map = new HashMap<String,String>();
        map.put("1","北京");
        map.put("2","上海");
        map.put("3","广州");
        map.put("4","深圳");
        String json = JSON.toJSONString(map);
        System.out.println("序列化 Map to JSON -> ");
        System.out.println(json);
        // Map反序列化
        map = (Map)JSON.parseObject(json,Map.class);
        System.out.println("反序列化 Map内容 -> ");
        System.out.println(map);
    }

    /**
     * Container to JSON
     */
    public static void container2Json(){
        List<String> list = new ArrayList<String>();
        list.add("北京");
        list.add("上海");
        list.add("广州");
        list.add("深圳");
        Set<String> set = new HashSet<String>();
        set.add("天津");
        set.add("杭州");
        set.add("青岛");
        set.add("苏州");
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("one", list);
        map.put("two", set);
        String jsonString = JSON.toJSONString(map);
        System.out.println("Container to JSON -> ");
        System.out.println(jsonString);
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // 数组格式化输出
        array2Json();
        // List格式化输出
        list2Json();
        // Set格式化输出
        set2Json();
        // MAP格式化输出
        map2Json();
        // 混合容器格式化输出
        container2Json();
    }

}
