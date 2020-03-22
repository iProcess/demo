package com.example.demo.other;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;
import java.util.Map;

/**
 * Java对象Map序列化和反序列化，代码案例：
 */
public class FastJsonObjMain {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Map<String,User> userMap = new HashMap<String,User>();
        User zsUser = new User();
        zsUser.setId("zhangsan");
        zsUser.setName("张三");
        userMap.put("one", zsUser);
        // 用户二
        User lsUser = new User();
        lsUser.setId("lisi");
        lsUser.setName("李四");
        userMap.put("two", lsUser);

        String jsonString = JSON.toJSONString(userMap);
        System.out.println("Map to JSON -> ");
        System.out.println(jsonString);
    }

}
