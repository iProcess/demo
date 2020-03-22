package com.example.demo.lru;

/**
 * 链表节点
 */
public class CacheNode {

    CacheNode() {
    }

    CacheNode prev;//前一节点
    CacheNode next;//后一节点
    Object value;//值
    Object key;//键

}
