package com.example.demo.proxy.nondynamic;

//Proxy代理类
public class Proxy implements Subject {

    private RealSubject realSubject;

    public Proxy(RealSubject realSubject) {
        this.realSubject = realSubject;
    }

    @Override
    public void request() {
        System.out.println("before");
        try{
            realSubject.request();
        }catch (Exception e){
            System.out.println("ex:"+e.getMessage());
            throw e;
        }finally {
            System.out.println("after");
        }
    }
}
