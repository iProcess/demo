package com.example.demo.test.proxy.dynamic.jdk;

//subject接口，这个是jdk动态代理必须的前提。
public interface Subject {
    void request();
    void hello();
}
