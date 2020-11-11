package com.example.demo.test.reflect;

public class TestMain {
    public static void main(String[] args) {
        // 创建对象
        ReflectClass.reflectNewInstance();

        // 反射私有的构造方法
        ReflectClass.reflectPrivateConstructor();

        // 反射私有属性
        ReflectClass.reflectPrivateField();

        // 反射私有方法
        ReflectClass.reflectPrivateMethod();
    }
}
