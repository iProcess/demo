package com.example.demo.ali.tree;

import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

//题目1：请基于以下数节点信息构建一棵树，构建树。节点信息如下（getter和setter方法省略）
@Data
public class TreeNodeBack<T> {
    private String myCode;
    private String parentCode;
    private TreeNodeBack<T> parentNode;
    private List<TreeNodeBack<T>> children;
    private T data;

//    public TreeNode(String myCode, String parentCode, T data){
//        this.myCode = myCode;
//        this.parentCode = parentCode;
//        this.data = data;
//    }


    public void buildTreeNode(TreeNodeBack<T> node, String myCode, String parentCode, T data) {

        if (node == null) {
            return;
        }

        if (StringUtils.isNotEmpty(node.getParentCode())) {

        }

        node.setMyCode(myCode);
        node.setData(data);
        node.setParentCode(parentCode);

        if (StringUtils.isNotEmpty(node.getParentCode())) {
            List<TreeNodeBack<T>> children = new ArrayList<>();
            TreeNodeBack child = new TreeNodeBack();
            child.setMyCode(myCode);
            child.setParentCode(myCode);
            child.setData(data);
            children.add(child);
            node.setChildren(children);

//            return;
        } else {
            node.setParentNode(node);
            return;
//            buildTreeNode(node.getParentNode(), myCode, parentCode, data);
        }

        if (node.getMyCode().equals(parentCode)) {
            List<TreeNodeBack<T>> children = new ArrayList<>();
//            TreeNode child = new TreeNode();
//            child.setMyCode(myCode);
//            child.setParentCode(parentCode);
//            child.setData(data);
            children.add(node);
            node.setChildren(children);
        } else {
            buildTreeNode(node.getParentNode(), myCode, parentCode, data);
        }

    }
}
