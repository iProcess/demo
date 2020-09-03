package com.example.demo.test.structure.tree;

public interface Tree {

    /**
     * 插入
     * @param data
     * @return
     */
    boolean insert(int data);

    /**
     * 查找
     * @param key
     * @return
     */
    Node find(int key);

    /**
     * 中序遍历
     * 左节点、根节点、右节点
     * @param current
     */
    void infixOrder(Node current);

    /**
     * 前序遍历
     * 根节点、左节点、右节点
     * @param current
     */
    void preOrder(Node current);

    /**
     * 后序遍历
     * 左节点、右节点、根节点
     * @param current
     */
    void postOrder(Node current);

    /**
     * 查找最大值
     * @return
     */
    Node findMax();

    /**
     * 查找最小值
     * @return
     */
    Node findMin();

    /**
     * 删除（移除元素）
     * @param key
     * @return
     */
    boolean delete(int key);

    /**
     * 删除（标记删除）
     * @param key
     * @return
     */
    boolean deleteFlag(int key);

    /**
     * 中序遍历（排除标记删除的节点）
     * @param current
     */
    void infixOrderFlag(Node current);

    /**
     * 获取根元素
     * @return
     */
    Node getRoot();

    /**
     * https://blog.csdn.net/weixin_42289193/article/details/81741756
     * https://blog.csdn.net/q_Q_wang/article/details/105425275
     * https://blog.csdn.net/mingwanganyu/article/details/72033122?utm_medium=distribute.pc_relevant.none-task-blog-BlogCommendFromMachineLearnPai2-1.nonecase&depth_1-utm_source=distribute.pc_relevant.none-task-blog-BlogCommendFromMachineLearnPai2-1.nonecase
     *
     * 深度优先搜索
     * 从根节点出发，沿着左子树方向进行纵向遍历，直到找到叶子节点为止。
     * 然后回溯到前一个节点，进行右子树节点的遍历，直到遍历完所有可达节点为止。
     *
     * 利用栈Stack先进后出的特点来实现
     * 1、从根节点出发，根节点先入栈；
     * 2、栈不为空时，进行出栈（第一次是根节点出栈），然后右子树入栈，左子树入栈;
     * 3、重复第2步骤，此时，左子树出栈（后进先出），左子树的右节点入栈，左子树的左节点入栈；
     * 4、栈为空时，完成深度优先搜索。
     * @param current
     */
    void depthFirstSearch(Node current);

    /**
     * https://blog.csdn.net/weixin_42289193/article/details/81741756
     * https://blog.csdn.net/q_Q_wang/article/details/105425275
     * https://blog.csdn.net/mingwanganyu/article/details/72033122?utm_medium=distribute.pc_relevant.none-task-blog-BlogCommendFromMachineLearnPai2-1.nonecase&depth_1-utm_source=distribute.pc_relevant.none-task-blog-BlogCommendFromMachineLearnPai2-1.nonecase
     *
     * 广度优先搜索
     * 从根节点出发，在横向遍历二叉树层段节点的基础上纵向遍历二叉树的层次。
     *
     * 利用队列Queue来实现先进先出的特点来实现
     *
     * @param current
     */
    void broadFirstSearch(Node current);

}
