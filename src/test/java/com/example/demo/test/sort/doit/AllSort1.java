package com.example.demo.test.sort.doit;

import java.util.Random;

/**
 * 按升序
 */
public class AllSort1 {


//    //1、冒泡排序
//    public static void bubbleSort(int[] array){
//        for(int i = 1; i < array.length; i++){
//            for(int j = 0; j < array.length - i; j++){
//                if(array[j] > array[j + 1]){
//                    swap(array, j, j + 1);
//                }
//            }
//        }
//        print("冒泡排序：", array);
//    }
//
//    //2、插入排序
//    public static void insertSort(int[] array){
//        for(int i = 1; i < array.length; i++){
//            for(int j = 0; j < i; j++){
//                if(array[j] > array[i]){
//                    swap(array, j, i);
//                }
//            }
//        }
//        print("插入排序：", array);
//    }
//
//    //3、选择排序
//    public static void selectSort(int[] array){
//        for(int i = 1; i < array.length; i++){
//            int index = 0;
//            for(int j = 1; j <= array.length - i; j++){
//                if(array[j] > array[index]){
//                    index = j;
//                }
//            }
//            swap(array, array.length - i, index);
//        }
//        print("选择排序：", array);
//    }
//
//    //4、快速排序
//    public static void quickSort(int[] array, int start, int end){
//        if(start < end){
//            int i = start;
//            int j = end;
//            int x = array[i];
//            while (i < j){
//                while (i < j && array[j] > x){
//                    j--;
//                }
//                if(i < j){
//                    array[i] = array[j];
//                    i++;
//                }
//                while (i < j && array[i] < x){
//                    i++;
//                }
//                if(i < j){
//                    array[j] = array[i];
//                    j--;
//                }
//            }
//            array[i] = x;
//            quickSort(array, start, i - 1);
//            quickSort(array, i + 1, end);
//        }
//    }


    public static void quickSort(int[] array, int start, int end){
        if (start < end){
            int i = start;
            int j = end;
            int x = array[i];
            while (i < j){
                while (i < j && array[j] > x){
                    j--;
                }
                if (i < j){
                    array[i] = array[j];
                    i++;
                }
                while (i < j && array[i] < x){
                    i++;
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




}
