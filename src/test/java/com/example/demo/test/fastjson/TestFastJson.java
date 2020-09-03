package com.example.demo.test.fastjson;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;

public class TestFastJson {

    public static void main(String[] args) {
        Result<Item> result = new Result<>();
        result.setRet(200);
        result.setMsg("成功！");
        Item item = new Item();
        item.setName("test1");
        item.setValue("value1");
        result.setData(item);

        String json = JSONObject.toJSONString(result);

        //json={"data":{"name":"test1","value":"value1"},"msg":"成功！","ret":200}
        System.out.println("json=" + json);

        Result<Item> result1 = JSONObject.parseObject(json, Result.class);

        //result1=ret=200, msg=成功！, data={{"name":"test1","value":"value1"}}
        System.out.println("result1=" + result1.toString());

        //{"name":"test1","value":"value1"}
        System.out.println(result1.getData());

        //java.lang.ClassCastException: com.alibaba.fastjson.JSONObject cannot be cast to com.example.demo.test.fastjson.Item
//        System.out.println(result1.getData().getName());

        Result<Item> result2 = JSONObject.parseObject(json, new TypeReference<Result<Item>>(){});

        //result2=ret=200, msg=成功！, data={name=test1, value=value1}
        System.out.println("result2=" + result2.toString());

        //name=test1, value=value1
        System.out.println(result2.getData());

        //test1
        System.out.println(result2.getData().getName());

        Result<Item> result3 = parseResultV1(json);

        //result3=ret=200, msg=成功！, data={{"name":"test1","value":"value1"}}
        System.out.println("result3=" + result3.toString());

        //{"name":"test1","value":"value1"}
        System.out.println(result3.getData());

        //java.lang.ClassCastException: com.alibaba.fastjson.JSONObject cannot be cast to com.example.demo.test.fastjson.Item
        //System.out.println(result3.getData().getName());


        Result<Item> result4 = parseResultV2(json, Item.class);

        //result3=ret=200, msg=成功！, data={{"name":"test1","value":"value1"}}
        System.out.println("result4=" + result4.toString());

        //{"name":"test1","value":"value1"}
        System.out.println(result4.getData());

        //test1
        System.out.println(result4.getData().getName());

    }

    private static <T> Result<T> parseResultV2(String json, Class<T> clazz) {
        return JSONObject.parseObject(json, new TypeReference<Result<T>>(clazz) {
        });
    }

    private static <T> Result<T> parseResultV1(String json) {
        return JSONObject.parseObject(json, new TypeReference<Result<T>>() {
        });
    }
}
