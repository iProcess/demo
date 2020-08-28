package com.example.demo.zjtd.interview.merge;



public class LinkedListCarry {

    class Node{
        int val;
        Node next;
        Node(int val){
            this.val = val;
        }
    }


    private int size;
    private Node head;

    /**
     * 在头部添加节点
     * @return
     */
    public Node addHead(int val){
        Node node = new Node(val);
        if(head == null){
            head = node;
        }else{
            node.next = head;
            head = node;
        }
        size++;
        return head;
    }

    public void display(){
        Node curr = head;
        if(curr == null){
            System.out.println("[]");
        }
        while (curr != null){
            System.out.print(curr.val + " ");
            curr = curr.next;
        }
        System.out.println();
    }

    public void display(Node head){
        this.head = head;
        display();
    }

    /**
     * https://blog.csdn.net/weixin_40807247/article/details/91435275
     * 链表的反转
     * @return
     */
    public Node reverse(){
        Node pre = null;
        Node next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    public Node merge(Node nodeA, Node nodeB){

        Node currA = nodeA;
        Node currB = nodeB;

        int carry = 0;
        while (currA != null && currB != null){
            int valA = currA.val;
            int valB = currB.val;

            int temp = valA + valB + carry;
            carry = temp / 10;
            temp = temp % 10;

            addHead(temp);

            currA = currA.next;
            currB = currB.next;

        }

        while (currA != null){
            addHead(currA.val);
        }

        while (currB != null){
            addHead(currB.val);
        }

        return head;

    }



    public static void main(String[] args) {
        LinkedListCarry linkedListA = new LinkedListCarry();
        linkedListA.addHead(1);
        linkedListA.addHead(6);
        linkedListA.addHead(2);
        linkedListA.display();//2 6 1

        LinkedListCarry linkedListB = new LinkedListCarry();
        linkedListB.addHead(3);
        linkedListB.addHead(5);
        linkedListB.addHead(1);
        linkedListB.display();//1 5 3

        LinkedListCarry linkedListC = new LinkedListCarry();
        linkedListC.merge(linkedListA.head, linkedListB.head);
        linkedListC.display();//4 11 3

        //因为每次添加都是在链表头部添加元素的，合并后的链表节点顺序是和原来的顺序相反的，所以需要做反转
        Node node = linkedListC.reverse();
        linkedListC.display(node);

    }

}
