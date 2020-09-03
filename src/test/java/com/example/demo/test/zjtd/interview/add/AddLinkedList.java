package com.example.demo.test.zjtd.interview.add;

/**
 * https://www.cnblogs.com/leavescy/p/5877755.html
 */
class Node{
    int val;
    Node next;
    Node(int val){
        this.val = val;
    }
}

public class AddLinkedList {

    int size;
    Node head;

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
     * head1与head2对应的值相加，向后进位
     * @param head1
     * @param head2
     * @return
     */
    public Node addTwoNumbers(Node head1, Node head2){
        if(head1 == null || head2 == null){
            return null;
        }
        Node curr1 = head1;
        Node curr2 = head2;
        Node prev = null; //进位
        int carry = 0;
        while (curr1 != null){
            curr1.val += carry;
            if(curr2 != null){
                curr1.val = curr1.val + curr2.val;
                curr2 = curr2.next;
            }
            carry = curr1.val / 10;
            curr1.val = curr1.val % 10;
            prev = curr1;
            curr1 = curr1.next;
        }
        //head1比head2短的情况
        while (curr2 != null){
            curr2.val += carry;
            carry = curr2.val / 10;
            curr2.val = curr2.val % 10;
            prev.next = curr2;
            curr2 = curr2.next;
            prev = prev.next;
        }
        if(carry > 0){ //最后还要进一位
            prev.next = new Node(carry);
        }
        return head1;
    }

    public static void main(String[] args) {
        AddLinkedList list1 = new AddLinkedList();
        list1.addHead(3);
        list1.addHead(4);
        list1.addHead(2);
        list1.display();

        AddLinkedList list2 = new AddLinkedList();
        list2.addHead(4);
        list2.addHead(6);
        list2.addHead(5);
        list2.display();

        Node node = list1.addTwoNumbers(list1.head, list2.head);
        list1.display(node);

    }


}
