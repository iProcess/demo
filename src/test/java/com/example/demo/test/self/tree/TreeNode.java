package com.example.demo.test.self.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TreeNode {

    class Node{
        Node left;
        Node right;
        int val;
        Node(int val){
            this.val = val;
        }
    }

    private int size;
    private Node root;

    public boolean insert(int val){
        Node newNode = new Node(val);
        if(root == null){
            root = newNode;
            size++;
            return true;
        }
        Node curr = root;
        Node prev = null;
        while (curr != null){
            prev = curr;
            if(val < curr.val){
                curr = curr.left;
                if(curr == null){
                    prev.left = newNode;
                    size++;
                    return true;
                }
            }else {
                curr = curr.right;
                if(curr == null){
                    prev.right = newNode;
                    size++;
                    return true;
                }
            }
        }
        return false;
    }

    public Node find(int val){
        Node curr = root;
        while (curr.val != val){
            if(val < curr.val){
                curr = curr.left;
            }else if(val > curr.val) {
                curr = curr.right;
            }else {
                return curr;
            }
        }
        return null;
    }

    public Node findMax(){
        Node curr = root;
        Node max = curr;
        while (curr != null){
            max = curr;
            curr = curr.right;
        }
        return max;
    }

    public Node findMin(){
        Node curr = root;
        Node min = curr;
        while (curr != null){
            min = curr;
            curr = curr.left;
        }
        return min;
    }

    public void infixOrder(Node curr){
        if(curr != null){
            infixOrder(curr.left);
            System.out.println(curr.val);
            infixOrder(curr.right);
        }
    }

    public void preOrder(Node curr){
        if(curr != null){
            System.out.println(curr.val);
            preOrder(curr.left);
            preOrder(curr.right);
        }
    }

    public void postOrder(Node curr){
        if(curr != null){
            postOrder(curr.left);
            postOrder(curr.right);
            System.out.println(curr.val);
        }
    }

    public void depthFirstSearch(Node curr){
        if(curr == null){
            System.out.println("[]");
            return;
        }
        Stack<Node> stack = new Stack<>();
        stack.push(curr);
        while (!stack.empty()){
            Node node = stack.pop();
            System.out.println(node.val);
            if(node.right != null){
                stack.push(node.right);
            }
            if(node.left != null){
                stack.push(node.left);
            }
        }
    }

    public void broadFirstSearch(Node curr){
        if(curr == null){
            System.out.println("[]");
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(curr);//add()方法在失败的时候会抛出异常(不推荐)
        while (!queue.isEmpty()){
            Node node = queue.poll();//返回第一个元素，并在队列中删除
            System.out.println(node.val + " ");
            if(node.left != null){
                queue.offer(node.left);
            }
            if(node.right != null){
                queue.offer(node.right);
            }
        }
    }
}
