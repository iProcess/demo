package com.example.demo.sort.doit.select;

import com.example.demo.sort.doit.DoItUtil;

/**
 * 3、选择排序
 */
public class SelectSort {

    public void selectSort(int[] array){
        //比较的轮次
        for(int i = 1; i < array.length; i++){
            int index = 0;
            for(int j = 1; j <= array.length - i; j++){
                if(array[j] > array[index]){
                    index = j;
                }
            }
            DoItUtil.swap(array, array.length - i, index);
        }
        DoItUtil.printArray(array);
    }

    public static void main(String[] args) {
        SelectSort selectSort = new SelectSort();
        selectSort.selectSort(DoItUtil.createArray());
    }
}
