package com.example.demo.ali;

/**
 * @Auther: shijincheng
 * @Date: 2019/2/18 15:06
 * @Description: 业务逻辑处理
 */
public class Worker {

    public void work() {
        // 模拟业务逻辑处理
        System.out.println(Thread.currentThread().getName() + " work " );
    }

}
