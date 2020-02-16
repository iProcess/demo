package com.example.demo.exception;

public class TestA {

    public void getTestA(int a) throws RpcException{
        System.out.println(a);
//        int i = 3/0;
        throw new RpcException("getTestA");
    }

    public void getTestAA(int a){
        try {
            getTestA(a);
        }catch (RpcException re){
            throw  re;
        }catch (Exception e){
            System.out.println("getTestAA Exception");
        }
    }

}
