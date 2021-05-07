package com.example.demo.test.self.search;

import com.example.demo.test.self.sort.AllSort;

public class BinarySearch {

    public static int binarySearch(int[] array, int data, int beginIndex, int endIndex){
        if(beginIndex > endIndex || data < array[beginIndex] || data > array[endIndex]){
            return -1;
        }
        int middleIndex = (beginIndex + endIndex) >>> 1;
        if(data < array[middleIndex]){
            return binarySearch(array, data, beginIndex, middleIndex - 1);
        }else if(data > array[middleIndex]){
            return binarySearch(array, data, middleIndex + 1, endIndex);
        }else {
            return middleIndex;
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{5, 3, 9, 1, 4};
        AllSort.quickSort(array, 0, array.length - 1);
        AllSort.print(array);
        int index = binarySearch(array, 4, 0, array.length - 1);
        System.out.println("index: " + index);
        System.out.println("array[" + index + "] = " + array[index]);
    }

}
