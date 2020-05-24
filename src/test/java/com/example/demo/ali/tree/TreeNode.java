package com.example.demo.ali.tree;

import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

//题目1：请基于以下数节点信息构建一棵树，构建树。节点信息如下（getter和setter方法省略）
@Data
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


}
