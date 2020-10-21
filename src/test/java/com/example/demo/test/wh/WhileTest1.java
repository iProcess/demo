package com.example.demo.test.wh;

/**
 * 判断两个数组中对应位置相等的元素，并返回下标和值
 */
public class WhileTest1 {

    public static void main(String[] args) {
        int[] array1 = {1, 2, 3, 4, 5, 6, 7, 8};
        int[] array2 = {5, 2, 3, 8, 5, 10, 7, 12, 13};

        //int[] maxArray = array1.length > array2.length ? array1 : array2;
        int[] minArray = array1.length > array2.length ? array2 : array1;

        int[] merge = new int[minArray.length];
        for(int i = 0; i < minArray.length; i++){
            if(array1[i] == array2[i]){
                merge[i] = array1[i];
            }
        }
        for(int k : merge){
            System.out.print(k + " ");
        }
        System.out.println();
        int h = 0;
        int mergeLength = merge.length;
        while (mergeLength-- > 0){
            if(merge[h] > 0){
                System.out.println(h + " " + merge[h]);
            }
            h++;
        }

    }

}
