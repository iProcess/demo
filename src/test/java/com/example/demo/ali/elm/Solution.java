package com.example.demo.ali.elm;

import com.alibaba.fastjson.JSON;

/**
 * 作者：LeetCode
 * 链接：https://leetcode-cn.com/problems/swap-nodes-in-pairs/solution/liang-liang-jiao-huan-lian-biao-zhong-de-jie-di-19/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class Solution {

    public ListNode swapPairs(ListNode head) {

        // If the list has no node or has only one node left.
        if ((head == null) || (head.getNext() == null)) {
            return head;
        }

        // Nodes to be swapped
        ListNode firstNode = head;
        ListNode secondNode = head.getNext();

        // Swapping
        firstNode.setNext(swapPairs(secondNode.getNext()));
        secondNode.setNext(firstNode);

        // Now the head is the second node
        return secondNode;
    }

    public static void main(String[] args) {

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(node5);

        System.out.println(JSON.toJSONString(node1));
        Solution solution = new Solution();
        ListNode newListNode = solution.swapPairs(node1);
        System.out.println(JSON.toJSONString(newListNode));

    }


}
