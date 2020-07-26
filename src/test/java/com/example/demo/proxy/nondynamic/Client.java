package com.example.demo.proxy.nondynamic;

//Client客户端 静态代理例子
public class Client {
    public static void main(String[] args){
        Subject subject = new Proxy(new RealSubject());
        subject.request();
    }
}
