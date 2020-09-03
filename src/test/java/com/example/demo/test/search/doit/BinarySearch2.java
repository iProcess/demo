package com.example.demo.test.search.doit;

public class BinarySearch2 {

    public int binarySearch(int[] array, int data, int beginIndex, int endIndex){
        if(data < array[beginIndex] || data > array[endIndex] || beginIndex > endIndex){
            return -1;
        }
        int midIndex = beginIndex + (endIndex - beginIndex) / 2;
        if(data < array[midIndex]){
            return binarySearch(array, data, beginIndex, midIndex - 1);
        }else if(data > array[midIndex]){
            return binarySearch(array, data, midIndex + 1, endIndex);
        }else {
            return midIndex;
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{-68, -50, -41, -30, -23, -17, 3, 4, 5, 80};
        int data = 5;
        BinarySearch2 binarySearch = new BinarySearch2();
        int dataIndex = binarySearch.binarySearch(array, data, 0, array.length - 1);
        System.out.println(dataIndex);
    }

}
