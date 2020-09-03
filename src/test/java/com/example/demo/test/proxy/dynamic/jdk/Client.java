package com.example.demo.test.proxy.dynamic.jdk;

import java.lang.reflect.Proxy;

//客户端Client
public class Client {
    /*
     *newProxyInstance方法参数解析
     *ClassLoader loader：类加载器
     *Class<?>[] interfaces：得到全部的接口
     *InvocationHandler h：得到InvocationHandler接口的子类实例
     */
    public static void main(String[] args){

        Subject subject = (Subject) Proxy.newProxyInstance(
                Client.class.getClassLoader(),
                new Class[]{Subject.class},
                new JdkProxySubject(new RealSubject()));

        subject.hello();
        subject.request();
    }
}
