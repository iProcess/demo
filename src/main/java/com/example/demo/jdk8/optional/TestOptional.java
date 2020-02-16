package com.example.demo.jdk8.optional;

import com.alibaba.fastjson.JSON;

import java.util.Optional;

/**
 * @author shijincheng
 * @version V1.0
 * date 2020/1/16 16:21
 * Description: TODO
 */
public class TestOptional {


    private void testEmpty(){
        Optional<User> opt = Optional.empty();
        //Optional.empty
        System.out.println(opt);
        //java.util.NoSuchElementException: No value present
        System.out.println(opt.get());
    }

    /**
     * 可以使用  of() 和 ofNullable() 方法创建包含值的 Optional。
     * 两个方法的不同之处在于如果你把 null 值作为参数传递进去，of() 方法会抛出 NullPointerException
     */
    private void testOf(){
        User user = null;
        //java.lang.NullPointerException
        Optional<User> opt = Optional.of(user);
        System.out.println(opt);
    }

    private void testOfNullable(){
        User user = null;
        //正常执行
        Optional<User> opt = Optional.ofNullable(user);
        //正常执行
        System.out.println(opt);
        //java.util.NoSuchElementException: No value present
        System.out.println(opt.get());
    }

    private User createNewUser() {
        System.out.println("createNewUser");
        return new User("userName_new", "province_new", "city_new", "county_new", "town_new");
    }

    private void testOrElse(){
//        User user1 = null;
        User user1 = new User("userName1", "province1", "city1", "county1", "town1");
        User user2 = Optional.ofNullable(user1).orElse(createNewUser());
        System.out.println(JSON.toJSONString(user2));
    }

    private void testOrElseGet(){
//        User user1 = null;
        User user1 = new User("userName1", "province1", "city1", "county1", "town1");
        User user2 = Optional.ofNullable(user1).orElseGet(() -> createNewUser());
        System.out.println(JSON.toJSONString(user2));
    }

    private void testOrElseThrow(){
        User user1 = null;
        User user2 = Optional.ofNullable(user1).orElseThrow(() -> new IllegalArgumentException());
        System.out.println(JSON.toJSONString(user2));
    }

    private String testlam(){
        return "123";
    }

    private void testNp(){
        User user1 = null;
        //打印 123，不会抛出NP异常
        String str = Optional.ofNullable(user1).map(u -> u.getUserName()).filter( n -> n.indexOf("N") > 0).orElse(testlam());
        System.out.println(str);
    }

    public static void main(String[] args) {
        TestOptional optional = new TestOptional();
//        optional.testEmpty();
//        optional.testOf();
//        optional.testOfNullable();
        /**
         * createNewUser
         * {"city":"city1","county":"county1","province":"province1","town":"town1","userName":"userName1"}
         * {"city":"city1","county":"county1","province":"province1","town":"town1","userName":"userName1"}
         *
         * 这个示例中，两个 Optional  对象都包含非空值，两个方法都会返回对应的非空值。
         * 不过，orElse() 方法仍然创建了 User 对象。与之相反，orElseGet() 方法不创建 User 对象。
         * 在执行较密集的调用时，比如调用 Web 服务或数据查询，这个差异会对性能产生重大影响。
         */
//        optional.testOrElse();
//        optional.testOrElseGet();
//        optional.testOrElseThrow();
        optional.testNp();
    }
}
