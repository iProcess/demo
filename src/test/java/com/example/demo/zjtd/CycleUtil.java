package com.example.demo.zjtd;

import com.example.demo.structure.linked.Node;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个单链表，判断链表中是否有环的几种方法
 * https://blog.csdn.net/weixin_43695091/article/details/88372778
 */
public class CycleUtil {

    /**
     * 方法一：循环遍历节点，遍历一个便标记一个，遍历过程判断是否被标记，若已被标记则表示有环
     * 方法说明：头指针移动，若到达之前到达过的位置则表示有环，若无环则会走到链表末端。
     * @param head
     * @return
     */
    public static boolean hasCycle1(Node head){
        //声明一个set存放已遍历的节点，即为标记节点（Set中不允许重复元素）
        Set<Node> set = new HashSet<>();
        while (head != null){
            if(set.contains(head)){
                return true;
            }else {
                set.add(head);
                head = head.getNext();
            }
        }
        return false;
    }

    /**
     * 方法二：声明两个指针，一个指针走一次经过两个节点(快指针quick)，另一个走一次经过一个节点(慢指针slow)
     * 方法说明：快指针走的比较快，若链表有环，则一定会追上慢指针，若无环，则会走到链表末端。
     * @param head
     * @return
     */
    public static boolean hasCycle2(Node head){
        //声明两个节点从头开始遍历节点
        Node fast = head;
        Node slow = head;
        //当快指针能够走到头表示无环
        while (fast != null && fast.getNext() != null){
            fast = fast.getNext().getNext();
            slow = slow.getNext();
            if(fast == slow){
                return true;
            }
        }
        return false;
    }

    /**
     * 环的长度
     * @param head
     * @return
     */
    public static int exitCircle(Node head){
        Node fast = head;
        Node slow = head;
        while(fast != null && fast.getNext() != null){//判断是否由环，注意fast.next = null的情况
            fast = fast.getNext().getNext();
            slow = slow.getNext();
            if(fast == slow){//存在环
                int count = 0;
                while(true){
                    count ++;
                    fast = fast.getNext().getNext();
                    slow = slow.getNext();

                    if(fast == slow){//快慢指针在第二次相遇，这个点肯定是第一次相遇的点
                        System.out.println("环的长度：" + count);
                        return count;
                    }
                }
            }
        }
        System.out.println("false!");
        return -1;
    }

    //环入口节点
    //环的入口节点到快慢指针相遇的距离 与 链表头节点到环入口节点的距离相等
    public static Node findLoopPort(Node head){
        Node slow = head;
        Node fast = head;
        while(fast != null && fast.getNext() != null){
            slow = slow.getNext();
            fast = fast.getNext().getNext();
            if(slow == fast){
                fast = head;
                while(fast != slow){
                    head = head.getNext();
                    slow = slow.getNext();
                }
                return slow;
            }
        }
        System.out.print("NoLoop !");
        return null;
    }

}
