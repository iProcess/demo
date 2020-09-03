package com.example.demo.test.structure.linked;

//import lombok.Data;

/**
 * 使用lombok会有这个提示：
 * Method threw 'java.lang.StackOverflowError' exception. Cannot evaluate com.example.demo.test.structure.linked.DoubleNode.toString()
 */
//@Data
public class DoubleNode {

    private Object data;
    private DoubleNode next;
    private DoubleNode prev;

    public DoubleNode(Object data){
        this.data = data;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public DoubleNode getNext() {
        return next;
    }

    public void setNext(DoubleNode next) {
        this.next = next;
    }

    public DoubleNode getPrev() {
        return prev;
    }

    public void setPrev(DoubleNode prev) {
        this.prev = prev;
    }
}
