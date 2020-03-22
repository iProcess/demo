package com.example.demo.sort.insert;

import com.example.demo.sort.util.SortUtils;

/**
 * 插入排序
 */
public class InsertSort {
    /**
     * 插入排序
     * 方法：将一个记录插入到已排好序的有序表（有可能是空表）中,从而得到一个新的记录数增1的有序表。
     * 性能：比较次数O(n^2),n^2/4
     *       复制次数O(n),n^2/4
     *       比较次数是前两者的一般，而复制所需的CPU时间较交换少，所以性能上比冒泡排序提高一倍多，而比选择排序也要快。
     *
     * @param data 要排序的数组
     * @param sortType 排序类型
     */
    public void insertSort(int[] data, String sortType) {
        if (sortType.equals("asc")) { //正排序，从小排到大
            //比较的轮数
            for (int i = 1; i < data.length; i++) {
                //保证前i+1个数排好序
                for (int j = 0; j < i; j++) {
                    if (data[j] > data[i]) {
                        //交换在位置j和i两个数
                        SortUtils.swap(data, i, j);
                    }
                }
            }
        } else if (sortType.equals("desc")) { //倒排序，从大排到小
            //比较的轮数
            for (int i = 1; i < data.length; i++) {
                //保证前i+1个数排好序
                for (int j = 0; j < i; j++) {
                    if (data[j] < data[i]) {
                        //交换在位置j和i两个数
                        SortUtils.swap(data, i, j);
                    }
                }
            }
        } else {
            System.out.println("您输入的排序类型错误！");
        }
        SortUtils.printArray(data);//输出插入排序后的数组值
    }

    public static void main(String[] args) {
        InsertSort sort = new InsertSort();
        int[] array = SortUtils.createArray();
        sort.insertSort(array, "asc");
        SortUtils.reverse(array);

    }
}
