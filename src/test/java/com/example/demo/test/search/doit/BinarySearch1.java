package com.example.demo.test.search.doit;

public class BinarySearch1 {

    public int binarySearch(int[] array, int data){
        int beginIndex = 0;
        int endIndex = array.length - 1;
        if(data < array[beginIndex] || data > array[endIndex] || beginIndex > endIndex){
            return -1;
        }
        int midIndex = -1;
//        int midIndex = beginIndex + (endIndex - beginIndex) / 2;
        while (beginIndex <= endIndex){
            midIndex = (beginIndex + endIndex) / 2;
            if(data < array[midIndex]){
                endIndex = midIndex - 1;
            }else if(data > array[midIndex]){
                beginIndex = midIndex + 1;
            }else {
                return midIndex;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] array = new int[]{-68, -50, -41, -30, -23, -17, 3, 4, 5, 80};
        int data = 5;
        BinarySearch1 binarySearch = new BinarySearch1();
        int dataIndex = binarySearch.binarySearch(array, data);
        System.out.println(dataIndex);
    }

}
