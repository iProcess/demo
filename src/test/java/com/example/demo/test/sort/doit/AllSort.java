package com.example.demo.test.sort.doit;

import java.util.Random;

/**
 * 按升序
 */
public class AllSort {
    public static void main(String[] args) {
        int[] array = createArray(10);

        int[] bubbleSort = new int[array.length];
        copyArray(array, bubbleSort);
        bubbleSort(bubbleSort);

        int[] selectArray = new int[array.length];
        copyArray(array, selectArray);
        selectSort(selectArray);

        int[] insertArray = new int[array.length];
        copyArray(array, insertArray);
        insertSort(insertArray);

        print("原数组：", array);
    }

    //1、冒泡排序
    public static void bubbleSort(int[] array){
        for(int i = 1; i < array.length; i++){
            for(int j = 0; j < array.length - i; j++){
                if(array[j] > array[j + 1]){
                    swap(array, j, j + 1);
                }
            }
        }
        print("冒泡排序：", array);
    }

    //2、插入排序
    public static void insertSort(int[] array){
        for(int i = 1; i < array.length; i++){
            for(int j = 0; j < i; j++){
                if(array[j] > array[i]){
                    swap(array, j, i);
                }
            }
        }
        print("插入排序：", array);
    }

    //3、选择排序
    public static void selectSort(int[] array){
        for(int i = 1; i < array.length; i++){
            int index = 0;
            for(int j = 1; j <= array.length - i; j++){
                if(array[j] > array[index]){
                    index = j;
                }
            }
            swap(array, array.length - i, index);
        }
        print("选择排序：", array);
    }

    //4、快速排序

    public static int[] createArray(int size){
        Random random = new Random();
        int[] array = new int[size];
        for(int i = 0; i < size; i++){
            array[i] = random.nextInt(100) - random.nextInt(100);
        }
        System.out.println();
        print("原数组：", array);
        return array;
    }

    public static void print(String sortName, int[] array){
        System.out.print(sortName + " ");
        for(int i : array){
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void swap(int[] array, int i, int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void copyArray(int[] source, int[] target){
        for(int i = 0; i < source.length; i++){
            target[i] = source[i];
        }
    }

}
