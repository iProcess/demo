package com.example.demo.controller;

import com.example.demo.domain.Customer;
import com.example.demo.domain.Member;
import com.example.demo.util.LoginContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.HashMap;
import java.util.Map;

/**
 * 注意：@RestController相当于@Controller和@ResponseBody组合
 */
@Slf4j
@RequestMapping("/index")
//@Controller
@RestController
public class IndexController {

    @Value("${student.name}")
    private String name;

    @Value("${student.age}")
    private Integer age;

    @Value("${student.address}")
    private String address;

    @Value("${teacher}")
    private String teacher;

    @Autowired
    private Customer customer;

    @Autowired
    private Member member;

    @GetMapping("/init")
//    @ResponseBody
    public Map init(){
        log.info("init");
        log.info(LoginContext.getLoginContext().getPin());
        Map<Integer, Object> map = new HashMap<>(16);
        map.put(1, "one");
        map.put(2, "two");
        map.put(3, "three");
        map.put(4, "four");
        map.put(5, "five");

        map.put(6, "student(name:" + name + ", age:" + age + ", address:" + address + ")");
        map.put(7, "teacher(" + teacher + ")");

        map.put(8, "customer(name:" + customer.getName() + ", age:" + customer.getAge() + ", address:" + customer.getAddress() + ", totalPrice:" + customer.getTotalPrice() +", totalOrder:" + customer.getTotalOrder() + ")");

        return map;
    }

    @GetMapping("/hi/{id}")
    public String say(@PathVariable("id") Integer id){
        System.out.println("say");
        return id.toString();
    }

    /**
     * 参数名必须是 id，不是这个名，也能访问该方法，但参数值为默认值0
     * @param id
     * @return
     */
    @GetMapping("/see")
    public String see(@RequestParam(value = "id", required = false, defaultValue = "0") Integer id){
        System.out.println("see");
        return id.toString();
    }

    /**
     * 参数名必须是 id，不是这个名，也能访问该方法，但参数没有值
     * @param id
     * @return
     */
    @GetMapping("/see1")
    public String see1(Integer id){
        System.out.println("see1");
        return id.toString();
    }

    /**
     * 参数名必须是 ids，不是这个名，也能访问该方法，但参数值为默认值0
     * @param id
     * @return
     */
    @GetMapping("/see2")
    public String see2(@RequestParam(value = "ids", defaultValue = "0") Integer id){
        System.out.println("see2");
        return id.toString();
    }

    /**
     * 参数名必须是 ids，否则不能访问该方法
     * @param id
     * @return
     */
    @GetMapping("/see3")
    public String see3(@RequestParam(value = "ids") Integer id){
        System.out.println("see3");
        return id.toString();
    }

    /**
     * 被@PostConstruct修饰的方法会在服务器加载Servlet的时候运行，并且只会被服务器调用一次，
     * 类似于Serclet的inti()方法。被@PostConstruct修饰的方法会在构造函数之后，init()方法之前运行。
     */
    @PostConstruct
    public void postConstruct() {
        System.out.println("postConstruct");
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("preDestroy");
    }

    /**
     * 执行顺序： postConstruct  init    preDestroy
     */
}
