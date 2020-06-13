package com.example.demo.sort.doit.quick;

import com.example.demo.sort.doit.DoItUtil;

/**
 * 3、快速排序
 */
public class QuickSort {

    public void quickSort(int[] array, int start, int end){
//        int i = start;
//        int j = end;
//        int x = array[i];//因多次递归，会有数据越界问题
        if(start < end){//这个条件用来结束递归
            int i = start;
            int j = end;
            int x = array[i];
            while (i < j){
                while (i < j && array[j] > x){
                    j--;//从右向左找第一个小于x的数
                }
                if(i < j){
                    array[i] = array[j];
                    i++;
                }
                while (i < j && array[i] < x){
                    i++;//从左向右找第一个大于x的数
                }
                if(i < j){
                    array[j] = array[i];
                    j--;
                }
            }
            array[i] = x;
            quickSort(array, start, i - 1);
            quickSort(array, i + 1, end);
        }
    }

    public static void main(String[] args) {
        int[] array = DoItUtil.createArray();
//        int[] array = new int[]{-50, 3, 80, -17, -68, -30, -23, 5, 4, -41};
        QuickSort quickSort = new QuickSort();
        quickSort.quickSort(array, 0, array.length - 1);
        DoItUtil.printArray(array);
    }

}
