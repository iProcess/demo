package com.example.demo.test.lru.lru2;

import java.util.HashMap;
import java.util.Map;

/**
 * https://www.jianshu.com/p/ec1952b9d84a
 */
class Node{
    Node prev;
    Node next;
    int key;
    int val;
    Node(int key, int val){
        this.key = key;
        this.val = val;
    }
}

class DoubleLinkedList{
    Node head;
    Node tail;
    int size;

    public void addHead(Node node){
        if(node == null){
            return;
        }
        if(head == null){
            head = node;
            tail = node;
        }else {
            node.next = head;
            head.prev = node;
            head = node;
        }
        size++;
    }

    public void addTail(Node node){
        if(node == null){
            return;
        }
        if(head == null){
            head = node;
            tail = node;
        }else {
            tail.next = node;
            node.prev = tail;
            tail = node;
        }
        size++;
    }

    public Node removeHead(){
        if(head == null){
            return null;
        }
        Node curr = head;
        if(head == tail){
            head = null;
            tail = null;
        }else {
            head = head.next;
            head.prev = null;
        }
        return curr;
    }

    public void moveToTail(Node node){
        if(node == null || node == tail){
            return;
        }
        if(head == node){
            head = node.next;
            head.prev = null;
        }else {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

        tail.next = node;
        node.prev = tail;
        node.next = null;
        tail = tail.next;

    }

}

public class LRUCache {
    private DoubleLinkedList list;
    private Map<Integer, Node> map;
    private int capacity;

    public LRUCache(int capacity){
        this.list = new DoubleLinkedList();
        this.map = new HashMap<>();
        this.capacity = capacity;
    }

    public int get(int key){
        if(!map.containsKey(key)){
            return -1;
        }
        Node node = map.get(key);
        list.moveToTail(node);
        return node.val;
    }

    public void put(int key, int val){
        if(!map.containsKey(key)){
            Node node = new Node(key, val);
            map.put(key, node);
            list.addTail(node);

            if(map.size() > capacity){}{
                Node removeNode = list.removeHead();
                map.remove(removeNode.key);
            }
        }else {
            Node node = map.get(key);
            node.val = val;
            list.moveToTail(node);
        }
    }

}
