package com.example.demo.sort.bubble;

import com.example.demo.sort.util.SortUtils;

/**
 * 冒泡排序
 */
public class BubbleSort {

    /**
     * 冒泡排序----交换排序的一种
     * 方法：相邻两元素进行比较，如有需要则进行交换，每完成一次循环就将最大元素排在最后（如从小到大排序），下一次循环是将其他的数进行类似操作。
     * 性能：比较次数O(n^2),n^2/2；交换次数O(n^2),n^2/4
     *
     * @param data 要排序的数组
     * @param sortType 排序类型
     * @return
     */
    public void bubbleSort(int[] data, String sortType) {
        if (sortType.equals("asc")) { //正排序，从小排到大
            //比较的轮数
            for (int i = 1; i < data.length; i++) {
                //将相邻两个数进行比较，较大的数往后冒泡
                for (int j = 0; j < data.length - i; j++) {
                    if (data[j] > data[j + 1]) {
                        //交换相邻两个数
                        SortUtils.swap(data, j, j + 1);
                    }
                }
            }
        } else if (sortType.equals("desc")) { //倒排序，从大排到小
            //比较的轮数
            for (int i = 1; i < data.length; i++) {
                //将相邻两个数进行比较，较大的数往后冒泡
                for (int j = 0; j < data.length - i; j++) {
                    if (data[j] < data[j + 1]) {
                        //交换相邻两个数
                        SortUtils.swap(data, j, j + 1);
                    }
                }
            }
        } else {
            System.out.println("您输入的排序类型错误！");
        }
        SortUtils.printArray(data);//输出冒泡排序后的数组值
    }

    public static void main(String[] args) {
        BubbleSort sort = new BubbleSort();
        sort.bubbleSort(SortUtils.createArray(), "asc");
    }
}
