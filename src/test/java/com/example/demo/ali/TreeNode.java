package com.example.demo.ali;

import com.alibaba.fastjson.JSON;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

//题目1：请基于以下数节点信息构建一棵树，构建树。节点信息如下（getter和setter方法省略）
@Data
public class TreeNode<T> {
    private String            myCode;
    private String            parentCode;
    private TreeNode<T>       parentNode;
    private List<TreeNode<T>> children;
    private T                 data;

//    public TreeNode(String myCode, String parentCode, T data){
//        this.myCode = myCode;
//        this.parentCode = parentCode;
//        this.data = data;
//    }



    public void buildTreeNode(TreeNode<T> node, String myCode, String parentCode, T data){

        if(node == null){
            return;
        }

        if(StringUtils.isNotEmpty(node.getParentCode())){

        }

        node.setMyCode(myCode);
        node.setData(data);
        node.setParentCode(parentCode);

        if(StringUtils.isNotEmpty(node.getParentCode())){
            List<TreeNode<T>> children = new ArrayList<>();
            TreeNode child = new TreeNode();
            child.setMyCode(myCode);
            child.setParentCode(myCode);
            child.setData(data);
            children.add(child);
            node.setChildren(children);

//            return;
        }else {
            node.setParentNode(node);
            return;
//            buildTreeNode(node.getParentNode(), myCode, parentCode, data);
        }

        if(node.getMyCode().equals(parentCode)){
            List<TreeNode<T>> children = new ArrayList<>();
//            TreeNode child = new TreeNode();
//            child.setMyCode(myCode);
//            child.setParentCode(parentCode);
//            child.setData(data);
            children.add(node);
            node.setChildren(children);
        }else {
            buildTreeNode(node.getParentNode(), myCode, parentCode, data);
        }

    }

    public static void main(String[] args) {
        TreeNode<String> node = new TreeNode<>();
        node.buildTreeNode(node, "files", "root", "files_data");
        System.out.println(JSON.toJSONString(node));

        node.buildTreeNode(node, "m1", "musics", "She'll be loved");
        System.out.println(JSON.toJSONString(node));

        node.buildTreeNode(node, "root", "", "root_data");
        System.out.println(JSON.toJSONString(node));

        node.buildTreeNode(node, "musics", "root", "musics_data");
        System.out.println(JSON.toJSONString(node));

        node.buildTreeNode(node, "m2", "musics", "Hey Soul Sister");
        System.out.println(JSON.toJSONString(node));
    }

}

// 原始的节点数据如下(三个字段用逗号分隔，假设各字段均不包含逗号：节点key，父节点key，当前节点data)
// files,root,files_data
// m1,musics,She'll be loved
// root,,root_data
// musics,root,musics_data
// m2,musics,Hey Soul Sister






