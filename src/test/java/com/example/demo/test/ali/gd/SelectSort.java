package com.example.demo.test.ali.gd;

/**
 * 可能有误
 * 第二层循环：
 * 1、下标应是j = 1；
 * 2、边界值j应是j <= array.length - i。
 * 这样的后果是：第一个元素会和自己做比较，即：array[0]和array[0]做比较，且最后一个元素不会参与比较大小。
 * 对于3 6 7 9 0来说，因最后一位是0，没有比较就进行了交互到第一位，所以看起来是正确的，
 * 如换成3 6 7 9 10，就不正确了
 */
public class SelectSort {

    //3 6 7 9 0
    public static void selectSort(int[] array){
        for(int i = 1; i < array.length; i++){
            int index = 0;
            //for(int j = 0; j < array.length - i; j++){
            for(int j = 1; j <= array.length - i; j++){//修改后
                if(array[j] > array[index]){
                    index = j;
                }
            }
            swap(array, array.length - i, index);
        }
    }

    public static void swap(int[] array, int i, int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        int[] array = {3, 6, 7, 9, 10};
        selectSort(array);
        for(int i : array){
            System.out.print(i + " ");
        }
        System.out.println("");

    }


}
