package com.example.demo.test.thread;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * 诡异的java.lang.IllegalMonitorStateException
 * https://blog.csdn.net/historyasamirror/article/details/6709693
 */
public class IllegalMonitorStateExceptionTest {

    private Boolean wait1 = false;
    private AtomicBoolean wait2 = new AtomicBoolean(false);
    private Object wait3 = new Object();

    public boolean pleaseWait1() {
        synchronized (this.wait1) {
            if (this.wait1 == true) {
                return false;
            }
            this.wait1 = true;
            try {
                this.wait1.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return true;
        }
    }

    public boolean pleaseWait2() {
        synchronized (this.wait2) {
            if (this.wait2.get() == true) {
                return false;
            }
            this.wait2.set(true);
            try {
                this.wait2.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return true;
        }
    }

    public boolean pleaseWait3() {
        synchronized (this.wait3) {
            if (this.wait1 == true) {
                return false;
            }
            this.wait1 = true;
            try {
                this.wait3.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return true;
        }
    }


    public static void main(String[] args) {
        IllegalMonitorStateExceptionTest test = new IllegalMonitorStateExceptionTest();
        //test.pleaseWait1();
        //test.pleaseWait2();
        test.pleaseWait3();
    }

}
