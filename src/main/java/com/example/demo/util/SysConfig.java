package com.example.demo.util;

import com.example.demo.domain.Customer;
import com.example.demo.domain.Member;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ConditionalOnBean         //   当给定的在bean存在时,则实例化当前Bean
 * @ConditionalOnMissingBean  //   当给定的在bean不存在时,则实例化当前Bean
 * @ConditionalOnClass        //   当给定的类名在类路径上存在，则实例化当前Bean
 * @ConditionalOnMissingClass //   当给定的类名在类路径上不存在，则实例化当前Bean
 */
@Configuration
public class SysConfig {

    @Bean
    public Customer beanCustomer(){
        return new Customer(); // 创建一个Bean,名称是 beanCustomer，不需要满足什么前置条件,
    }

    @Bean
    @ConditionalOnBean(name="beanCustomer")
    public Member beanMember(){
        // 仅在beanFactory存在一个名称叫做beanCustomer的bean时，当前方法初始化一个名字为beanMember的bean。
        return new Member();
    }

    @Bean
    @ConditionalOnClass(value={java.util.HashMap.class})
    public Member beanMember1(){
        // 仅当类 java.util.HashMap 存在于 classpath 上时才创建一个bean : beanMember1
        // 注意这里使用了 @ConditionalOnClass 的属性value，
        return new Member();
    }

    @Bean
    @ConditionalOnClass(name="com.sample.Dummy")
    public Customer beanCustomer1(){
        // 仅当类 com.sample.Dummy 存在于 classpath 上时才创建一个bean : Customer
        // 注意这里使用了 @ConditionalOnClass 的属性 name，
        return new Customer();
    }

    /**
     * 什么时候使用 name,什么时候使用 value ?
     * name : 不确定指定类在classpath 上
     * value : 确定指定类在 classpath 上
     */


}
