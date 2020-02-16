package com.example.demo.exception;

public class TestExceptionMain {

    public static void main(String[] args) {

        try {
            TestA a = new TestA();
            a.getTestAA(1);
        }catch (ClientTimeoutException te){
            System.out.println("main Timeout:" + te.getErrorCode());
        }catch (RpcException re){
            System.out.println("main Rpc:" + re.getErrorCode());
        }catch (Exception e){
            System.out.println("main Exce:" + e.getMessage());
        }


    }
}
