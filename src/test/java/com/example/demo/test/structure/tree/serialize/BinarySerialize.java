package com.example.demo.test.structure.tree.serialize;


import java.util.LinkedList;
import java.util.Queue;

/**
 * https://www.toutiao.com/i6842638397769515528/?tt_from=weixin&utm_campaign=client_share&wxshare_count=1&timestamp=1593388072&app=news_article&utm_source=weixin&utm_medium=toutiao_ios&use_new_style=1&req_id=202006290747510101300371401D33F032&group_id=6842638397769515528
 * 297.二叉树的序列化与反序列化
 *     1
 *    / \
 *   2   3
 *      / \
 *     4   5
 *
 * 1,2,3,null,null,4,5
 *
 */
public class BinarySerialize {


    class TreeNode {

        private int val;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(int val){
            this.val = val;
        }

    }

    /**
     * 序列化
     * @param root
     * @return
     */
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "nil";
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            TreeNode poll = queue.remove();
            if (poll == null) {
                sb.append("nil").append(",");
                continue;
            }
            sb.append(poll.val).append(",");
            queue.add(poll.left);
            queue.add(poll.right);
        }
        return sb.substring(0, sb.length() - 1);
    }

    /**
     * 反序列化
     * @param data
     * @return
     */
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.isEmpty()) {
            return null;
        }
        String[] split = data.split(",");
        // 这里不要忘记了判断第一个结果就是空的情况，本人在这里提交了几遍才找出问题
        if ("nil".equals(split[0])) {
            return null;
        }
        // 先把root节点放到queue里面去
        TreeNode root = new TreeNode(Integer.parseInt(split[0]));
        // index就是你要开始找的孩子节点的位置了。
        // 第二、三个节点肯定是root节点的左右孩子；
        // 然后以此类推：四、五 节点一定是二号节点的左右孩子
        int index = 1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            // 从队列里拿出一个节点，然后找它的左右孩子
            TreeNode node = queue.remove();
            // 左孩子就是当前index的位置
            String v1 = split[index++];
            // 左孩子
            if (!"nil".equals(v1)) {
                node.left = new TreeNode(Integer.parseInt(v1));
                queue.add(node.left);
            }
            // 右孩子
            String v2 = split[index++];
            if (!"nil".equals(v2)) {
                node.right = new TreeNode(Integer.parseInt(v2));
                queue.add(node.right);
            }
        }

        return root;
    }

}
