package com.example.demo.test.ali.elm;

import lombok.Data;

@Data
public class ListNode {
    private int val;
    private ListNode next;
    public ListNode(int x){
        val = x;
    }
}
