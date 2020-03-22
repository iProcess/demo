package com.example.demo.ali;

/**
 * @Auther: shijincheng
 * @Date: 2019/2/18 15:04
 * @Description: qps控制
 */
public class QpsController {

    /**
     * qps时间限制
     */
    private int QPSTIME = 1000;

    /**
     * 初始化qps次数
     */
    private int initQpsLimit = 0;

    /**
     * 自定义qps次数
     */
    private volatile int qpsLimit = 0;

    /**
     * 初始化qps时间
     */
    private volatile long initQpsTime = System.currentTimeMillis();

    /**
     * 对象锁
     */
    private Object lock = new Object();

    public QpsController(int qpsLimit){
        this.initQpsLimit = qpsLimit;
        this.qpsLimit = qpsLimit;
    }

    public void control() {

        synchronized (lock){
            try {
                // 时间在1s以内，继续执行
                if(System.currentTimeMillis() - initQpsTime <= QPSTIME){
                    // 未达到指定次数，继续执行
                    if(qpsLimit > 0){
                        qpsLimit--;
                        return;
                    }
                    // 1s内达到指定次数，需要等待
                    if(qpsLimit == 0){
                        lock.wait(1000);
                    }
                // 时间超出1s，重置条件
                }else{
                    qpsLimit = initQpsLimit;
                    initQpsTime = System.currentTimeMillis();
                    lock.notifyAll();
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
