package com.example.demo;

public class SelectSort {

    //3 6 7 9 0
    public static void selectSort(int[] array){
        for(int i = 1; i < array.length; i++){
            int index = 0;
            for(int j = 0; j < array.length - i; j++){
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
        int[] array = {3, 6, 7, 9, 0};
        selectSort(array);
        for(int i : array){
            System.out.print(i + " ");
        }
        System.out.println("");

    }


}
