package com.example.demo.ali;

/**
 * @Auther: shijincheng
 * @Date: 2019/2/18 15:03
 * @Description:
 *
 * 注：按目前control方法的实现方式，实际的qpsLimit会比限制的数量大2次，原因在于：
 * 1、lock.wait(1000);在线程被唤醒后，继续往下执行时，会执行1次worker.work();
 * 2、重置条件后，程序继续往下执行时，会执行1次worker.work();
 * 故：实际的qpsLimit会比限制的数量大2次
 * 这是在原来代码结构改动最小的情况进行的QPS限制，如要解决此问题，可以在QpsController的构造函数中传入对象锁，lock.wait(1000)修改为lock.wait()，
 * 并在主线程中经过1s后lock.notifyAll()唤醒沉睡的线程
 */
public class TestMain {

    //假设有这样的一个执行场景，确保 Worker的实际执行受到给定的QPS限制。请实现QpsController 的 control 方法。
    //运行main后  应该看到 每秒打印出 qpsLimit条 'Thread.currentThread().getName() + " work " ' 信息
    public static void main(String[] args) throws InterruptedException {
        //线程数和qps值都不要设置过大，避免系统性能差别导致测试断言不准  建议线程数控制在2位数  qps控制在3位数
        int threadSize = 55;
        int qpsLimit = 888;
        QpsController controller = new QpsController(qpsLimit);
        for(int i = 0 ; i < threadSize ; i++){
            Thread t  = new Thread(){
                Worker worker = new Worker();
                @Override
                public void run() {
                    while(true){
                        controller.control();
                        worker.work();
                    }
                }
            };
            t.setName("worker-threads-" + i);
            t.start();
        }
        while(true){
            System.out.println("=======================");
            Thread.sleep(1000);
        }
    }

}
