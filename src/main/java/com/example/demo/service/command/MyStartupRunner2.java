package com.example.demo.service.command;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * springboot启动时执行任务CommandLineRunner
 * https://www.cnblogs.com/myblogs-miller/p/9046425.html
 * # SpringBoot中CommandLineRunner的作用
 * > 平常开发中有可能需要实现在项目启动后执行的功能，SpringBoot提供的一种简单的实现方案就是添加一个model并实现CommandLineRunner接口，实现功能的代码放在实现的run方法中
 */
@Component
@Order(value = 1)
public class MyStartupRunner2 implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        System.out.println("MyStartupRunner2");
    }
}
