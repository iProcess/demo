package com.example.demo.test.self.sort;

public class AllSort {

    public static void swap(int[] array, int i, int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void print(int[] array){
        for(int i : array){
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void bubbleSort(int[] array){
        for(int i = 1; i < array.length; i++){
            for(int j = 0; j < array.length - i; j++){
                if(array[j] > array[j + 1]){
                    swap(array, j, j + 1);
                }
            }
        }
    }

    public static void insertSort(int[] array){
        for(int i = 1; i < array.length; i++){
            for(int j = 0; j < i; j++){
                if(array[j] > array[i]){
                    swap(array, j, i);
                }
            }
        }
    }

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
    }

    public static void quickSort(int[] array, int start, int end){
        if(start < end){
            int i = start;
            int j = end;
            int x = array[i];
            while (i < j){
                while (i < j & array[j] > x){
                    j--;
                }
                if(i < j){
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

    public static void main(String[] args) {
        int[] array1 = new int[]{5, 3, 9, 1, 4};
        int[] array2 = new int[]{5, 3, 9, 1, 4};
        int[] array3 = new int[]{5, 3, 9, 1, 4};
        int[] array4 = new int[]{5, 3, 9, 1, 4};

        bubbleSort(array1);
        print(array1);

        insertSort(array2);
        print(array2);

        selectSort(array3);
        print(array3);

        quickSort(array4, 0, array4.length - 1);
        print(array4);

    }

}
