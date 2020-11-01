package com.example.demo.test.sort.doit.insert;

import com.example.demo.test.sort.doit.DoItUtil;

/**
 * 2、插入排序
 * 最佳情况：T(n) = O(n) 最坏情况：T(n) = O(n2) 平均情况：T(n) = O(n2)
 */
public class InsertSort {

    public void insertSort(int[] array){

        //比较的轮次
        for(int i = 1; i < array.length; i++){
            for(int j = 0; j < i; j++){
                if(array[j] > array[i]){
                    DoItUtil.swap(array, i, j);
                }
            }
        }
        DoItUtil.printArray(array);

    }

    public static void main(String[] args) {
        InsertSort insertSort = new InsertSort();
        insertSort.insertSort(DoItUtil.createArray());
    }

}
