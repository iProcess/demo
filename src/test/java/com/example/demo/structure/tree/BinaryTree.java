package com.example.demo.structure.tree;

/**
 * https://www.cnblogs.com/ysocean/p/8032642.html
 */
public class BinaryTree implements Tree {

    private int size;
    private Node root;

    public BinaryTree(){
        this.size = 0;
        root = null;
    }

    @Override
    public boolean insert(int data) {
        Node newNode = new Node(data);
        if(root == null){
            root = newNode;
            size++;
            return true;
        }
        Node current = root;
        Node parentNode = null;
        while (current != null){
            parentNode = current;
            if(current.getData() > data){
                current = current.getLeftChild();
                if(current == null){
                    parentNode.setLeftChild(newNode);
                    size++;
                    return true;
                }
            }else {
                current = current.getRightChild();
                if(current == null){
                    parentNode.setRightChild(newNode);
                    size++;
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public Node find(int key) {
        Node current = root;
        while (current != null){
            if(current.getData() > key){
                current = current.getLeftChild();
            }else if(current.getData() < key){
                current = current.getRightChild();
            }else {
                return current;
            }
        }
        return null;
    }

    /**
     * 中序遍历
     * 左节点、根节点、右节点
     * @param current
     */
    @Override
    public void infixOrder(Node current) {
        if(current != null){
            infixOrder(current.getLeftChild());
            System.out.print(current.getData() + " ");
            infixOrder(current.getRightChild());
        }
    }

    /**
     * 前序遍历
     * 根节点、左节点、右节点
     * @param current
     */
    @Override
    public void preOrder(Node current) {
        if(current != null){
            System.out.print(current.getData() + " ");
            preOrder(current.getLeftChild());
            preOrder(current.getRightChild());
        }
    }

    /**
     * 后序遍历
     * 左节点、右节点、根节点
     * @param current
     */
    @Override
    public void postOrder(Node current) {
        if(current != null){
            postOrder(current.getLeftChild());
            postOrder(current.getRightChild());
            System.out.print(current.getData() + " ");
        }
    }

    @Override
    public Node findMax() {
        Node current = root;
        Node maxNode = current;
        while (current != null){
            maxNode = current;
            current = current.getRightChild();
        }
        return maxNode;
    }

    @Override
    public Node findMin() {
        Node current = root;
        Node minNode = current;
        while (current != null){
            minNode = current;
            current = current.getLeftChild();
        }
        return minNode;
    }

    @Override
    public boolean delete(int key) {
        Node current = root;
        Node parent = root;
        boolean isLeftChild = false;
        while (current.getData() != key){
            parent = current;
            if(current.getData() > key){
                isLeftChild = true;
                current = current.getLeftChild();
            }else {
                isLeftChild = false;
                current = current.getRightChild();
            }
            if(current == null){
                return false;
            }
        }

        if(current.getLeftChild() == null && current.getRightChild() == null){
            if(current == root){
                root = null;
            }else if(isLeftChild){
                parent.setLeftChild(null);
            }else {
                parent.setRightChild(null);
            }
            return true;
        }else if(current.getLeftChild() == null && current.getRightChild() != null){
            if(current == root){
                root = current.getRightChild();
            }else if(isLeftChild){
                parent.setLeftChild(current.getRightChild());
            }else {
                parent.setRightChild(current.getRightChild());
            }
            return true;
        }else if(current.getLeftChild() != null && current.getRightChild() == null){
            if(current == root){
                root = current.getLeftChild();
            }else if(isLeftChild){
                parent.setLeftChild(current.getLeftChild());
            }else {
                parent.setRightChild(current.getLeftChild());
            }
            return true;
        }else {
            Node successor = getSuccessor(current);
            if(current == successor){
                root = successor;
            }else if(isLeftChild){
                parent.setLeftChild(successor);
            }else {
                parent.setRightChild(successor);
            }
            successor.setLeftChild(current.getLeftChild());
        }

        return false;
    }

    public Node getSuccessor(Node delNode){
        Node successorParent = delNode;
        Node successor = delNode;
        Node current = delNode.getRightChild();
        while (current != null){
            successorParent = successor;
            successor = current;
            current = current.getLeftChild();
        }
        if(successor != delNode.getRightChild()){
            successorParent.setLeftChild(successor.getRightChild());
            successor.setRightChild(delNode.getRightChild());
        }
        return successor;
    }

    @Override
    public boolean deleteFlag(int key) {
        Node current = root;
        while (current.getData() != key){
            if(current.getData() > key){
                current = current.getLeftChild();
            }else {
                current = current.getRightChild();
            }
            if(current == null){
                return false;
            }
        }
        current.setDelete(true);
        return true;
    }

    @Override
    public void infixOrderFlag(Node current) {
        if(current != null){
            infixOrderFlag(current.getLeftChild());
            if(!current.isDelete()){
                System.out.print(current.getData() + " ");
            }
            infixOrderFlag(current.getRightChild());
        }
    }

    @Override
    public Node getRoot() {
        return root;
    }


}
