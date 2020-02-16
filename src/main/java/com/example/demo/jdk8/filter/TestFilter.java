package com.example.demo.jdk8.filter;

import com.alibaba.fastjson.JSON;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author shijincheng
 * @version V1.0
 * date 2020/1/20 15:04
 * Description: TODO
 */
public class TestFilter {

    public static void main(String[] args) {
        List<User> userList = new ArrayList<>();
        for(int i = 20; i < 30; i++){
            User user = new User();
            user.setUserName("test_" + i % 2);
            user.setAge(i);
            userList.add(user);
        }
        /**
         * [
         * {"age":20,"userName":"test_0"},
         * {"age":21,"userName":"test_1"},
         * {"age":22,"userName":"test_0"},
         * {"age":23,"userName":"test_1"},
         * {"age":24,"userName":"test_0"},
         * {"age":25,"userName":"test_1"},
         * {"age":26,"userName":"test_0"},
         * {"age":27,"userName":"test_1"},
         * {"age":28,"userName":"test_0"},
         * {"age":29,"userName":"test_1"}
         * ]
         */
        System.out.println(JSON.toJSONString(userList));

        /**
         * 如果不用collectingAndThen包裹maxBy，那么最后返回的结果为Map< String,Optional< Person>>。
         * 使用collectingAndThen包裹maxBy后，首先会执行maxBy函数，该函数执行完后便会执行Optional::get，从而将Optional中的元素取出来。
         */
        Map<String, User> map =
        userList.parallelStream()
                .collect(Collectors.groupingBy(User::getUserName, Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparingInt(User::getAge)), Optional::get)));
        /**
         * {
         * "test_1":{"age":29,"userName":"test_1"},
         * "test_0":{"age":28,"userName":"test_0"}
         * }
         */
        System.out.println(JSON.toJSONString(map));

        Map<String, Integer> mapAge =
                userList.parallelStream()
                        .collect(Collectors.groupingBy(User::getUserName, Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparingInt(User::getAge)), o -> o.get().getAge())));
        /**
         * {"test_1":29,"test_0":28}
         */
        System.out.println(JSON.toJSONString(mapAge));
    }
}
