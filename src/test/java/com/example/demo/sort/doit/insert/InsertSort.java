package com.example.demo.sort.doit.insert;

import com.example.demo.sort.doit.DoItUtil;

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
