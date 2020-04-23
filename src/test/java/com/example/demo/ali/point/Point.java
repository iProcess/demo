package com.example.demo.ali.point;

/**
 * https://www.cnblogs.com/ciaociao/p/9502748.html?tt_from=weixin&utm_source=weixin&utm_medium=toutiao_ios&utm_campaign=client_share&wxshare_count=1
 * 题目如下：
 *
 * 如下图，某物流派送员p，需要给 a、b、c、d. 4个快递点派送包裹，请问派送员需要选择什么样的路线，才能完成最短路程的派送。
 * 假设如图派送员的起点坐标(0,0)，派送路线只能沿着图中的方格边行驶，每个小格都是正方形，且边长为1，如p到d的距离就是4。
 * 随机输入n个派送点坐标，求输出最短派送路线值（从起点开始完成n个点派送并回到起始点的距离）。
 */
//定义一个坐标类
class Point{
    //(x,y)坐标
    int x,y;
    //判断是否遍历过的标志变量
    boolean isVisited;

    //构造函数
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
        this.isVisited = false;//初始化为false，若遍历过则置为true
    }

    //获得该点到指定点的距离
    public int getLength(Point p) {
        return Math.abs(x-p.x) + Math.abs(y-p.y);
    }
}

