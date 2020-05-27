package com.example.demo.sort.doit.bubble;

import com.example.demo.sort.doit.DoItUtil;

public class BubbleSort {

    /**
     * 升序排列
     * @param array
     */
    public void bubbleSort(int[] array){
        if(array == null || array.length == 0){
            System.out.println("array is illegal!");
            return;
        }
        //比较的轮数
        for(int i = 1; i < array.length; i++){
            //将相邻两个数进行比较，较大的数往后冒泡
            for(int j = 0; j < array.length - i; j++){
                if(array[j] > array[j + 1]){
                    DoItUtil.swap(array, j, j + 1);
                }
            }
        }
        DoItUtil.printArray(array);

    }

    public static void main(String[] args) {
        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.bubbleSort(DoItUtil.createArray());
    }
}
