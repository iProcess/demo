package com.example.demo.test.ali.queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://blog.csdn.net/weixin_40739833/article/details/80554996
 */
public class TestQueue {
    public static void main(String[] args) {
        // LinkedList是Queue的子类，一般采用其进行队列操作
        Queue<Character> queue = new LinkedList<>();
        queue.add('a');
        queue.add('b');
        queue.add('c');
        queue.add('d');

        // LinkedList的peek()方法在空队列时会返回一个null
        while (queue.peek() != null) {
            // 出队列队首元素并打印
            System.out.println(queue.poll());
        }
    }
}
