package com.example.demo.test.ali.aly;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * https://www.jianshu.com/p/3594ec175d83
 * https://www.cnblogs.com/cxhfuujust/p/10772908.html
 *
 *  简要概述BlockingQueue常用的四个实现类
 *  1)ArrayBlockingQueue:规定大小的BlockingQueue,其构造函数必须带一个int参数来指明其大小.其所含的对象是以FIFO(先入先出)顺序排序的.
 *  2)LinkedBlockingQueue:大小不定的BlockingQueue,若其构造函数带一个规定大小的参数,生成的BlockingQueue有大小限制,若不带大小参数,所生成的BlockingQueue的大小由Integer.MAX_VALUE来决定.其所含的对象是以FIFO(先入先出)顺序排序的
 *  3)PriorityBlockingQueue:类似于LinkedBlockQueue,但其所含对象的排序不是FIFO,而是依据对象的自然排序顺序或者是构造函数的Comparator决定的顺序.
 *  4)SynchronousQueue:特殊的BlockingQueue,对其的操作必须是放和取交替完成的.
 *  其中LinkedBlockingQueue和ArrayBlockingQueue比较起来,它们背后所用的数据结构不一样,导致LinkedBlockingQueue的数据吞吐量要大于ArrayBlockingQueue,但在线程数量很大时其性能的可预见性低于ArrayBlockingQueue.
 *
 *  	    抛出异常	   特殊值	    阻塞	      超时
 * 插入	    add(e)	       offer(e)	    put(e)	      offer(e, time, unit)
 * 移除	    remove()	   poll()	    take()	      poll(time, unit)
 * 检查	    element()	   peek()	    不可用	      不可用
 *
 * add: add: 和collection的add一样，当队列满时，调用add()方法抛出异常IllegalStateException异常
 * offer: 将指定元素插入此队列中（如果立即可行且不会违反容量限制），成功时返回 true，如果当前没有可用的空间，则返回 false，不会抛异常;
 * put: 将指定元素插入此队列中，将等待可用的空间.通俗点说就是>maxSize 时候，阻塞，直到能够有空间插入元素;
 *
 * remove:从队列中删除第一个元素，若队列为空，抛出NoSuchElementException异常
 * poll:有值时返回值，若队列为空，返回null
 * take: 获取并移除此队列的头部，在元素变得可用之前一直等待 。queue的长度 == 0 的时候，一直阻塞
 * poll(time):取走BlockingQueue里排在首位的对象,若不能立即取出,则可以等time参数规定的时间,取不到时返回null
 *
 * element：在队列为空时， element() 抛出一个IllegalStateException异常
 * peek：在队列为空时， 返回 null
 */
public class BlockingQueueTest {

    public static void main(String[] args) {
        ArrayBlockingQueue<Integer> goods = new ArrayBlockingQueue<>(10);
        try {
            goods.put(1);
            goods.put(2);
            goods.put(3);
            goods.put(4);
            goods.put(5);
            goods.put(6);
            goods.put(7);
            goods.put(8);
            goods.put(9);
            goods.put(10);
            goods.put(11);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            System.out.println(goods.take());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
