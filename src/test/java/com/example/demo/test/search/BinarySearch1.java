package com.example.demo.test.search;

/**
 * 二分查找
 */
public class BinarySearch1 {
    /**
     *二分查找特定整数在整型数组中的位置(递归)
     *查找线性表必须是有序列表
     *@paramdataset
     *@paramdata
     *@parambeginIndex
     *@paramendIndex
     *@returnindex
     */
    public int binarySearch(int[] dataset, int data, int beginIndex, int endIndex) {
        int midIndex = (beginIndex + endIndex) >>> 1; //相当于mid = (low + high) / 2，但是效率会高些
        if (data < dataset[beginIndex] || data > dataset[endIndex] || beginIndex > endIndex){
            return -1;
        }
        if (data < dataset[midIndex]) {
            return binarySearch(dataset, data, beginIndex, midIndex - 1);
        } else if (data > dataset[midIndex]) {
            return binarySearch(dataset, data, midIndex + 1, endIndex);
        } else {
            return midIndex;
        }
    }

    public static void main(String[] args) {
        int dataset[] = new int[]{3,4,6,7,8,10,11,15,44,92};
        BinarySearch1 search = new BinarySearch1();
        int position = search.binarySearch(dataset, 6, 0, dataset.length - 1);
        System.out.println(position);
    }

}
