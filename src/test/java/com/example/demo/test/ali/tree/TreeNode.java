package com.example.demo.test.ali.tree;

import java.util.ArrayList;
import java.util.List;

//题目1：请基于以下数节点信息构建一棵树，构建树。节点信息如下（getter和setter方法省略）
public class TreeNode<T> {
    private String myCode;
    private String parentCode;
    private TreeNode<T> parentNode;
    private List<TreeNode<T>> children;
    private T data;

    public TreeNode(String myCode, String parentCode, T data){
        this.myCode = myCode;
        this.parentCode = parentCode;
        this.data = data;
    }

    // 获取子节点的递归方法
    public static List<TreeNode> getChildrenNode(String myCode, List<TreeNode> treeNodes) {
        List<TreeNode> list = new ArrayList<TreeNode>();
        for (TreeNode treeNode : treeNodes) {
            if (treeNode.getParentCode().equals(myCode)) {
                // 递归获取子节点
                treeNode.setChildren(getChildrenNode(treeNode.getMyCode(), treeNodes));
                list.add(treeNode);
            }
        }
        return list;
    }

    public String getMyCode() {
        return myCode;
    }

    public void setMyCode(String myCode) {
        this.myCode = myCode;
    }

    public String getParentCode() {
        return parentCode;
    }

    public void setParentCode(String parentCode) {
        this.parentCode = parentCode;
    }

    public TreeNode<T> getParentNode() {
        return parentNode;
    }

    public void setParentNode(TreeNode<T> parentNode) {
        this.parentNode = parentNode;
    }

    public List<TreeNode<T>> getChildren() {
        return children;
    }

    public void setChildren(List<TreeNode<T>> children) {
        this.children = children;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
