package com.example.demo.test.search;

/**
 * 二分查找
 */
public class BinarySearch2 {
    /**
     *二分查找特定整数在整型数组中的位置(非递归)
     *查找线性表必须是有序列表
     *@paramdataset
     *@paramdata
     *@returnindex
     */
    public int binarySearch(int[] dataset, int data) {
        int beginIndex = 0;
        int endIndex = dataset.length - 1;

        if (data < dataset[beginIndex] || data > dataset[endIndex] || beginIndex > endIndex){
            return -1;
        }
        int midIndex = -1;
        while (beginIndex <= endIndex) {
            midIndex = (beginIndex + endIndex) >>> 1; //相当于midIndex = (beginIndex + endIndex) / 2，但是效率会高些
            if (data < dataset[midIndex]) {
                endIndex = midIndex - 1;
            } else if (data > dataset[midIndex]) {
                beginIndex = midIndex + 1;
            } else {
                return midIndex;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        int dataset[] = new int[]{3,4,6,7,8,10,11,15,44,92};
        BinarySearch2 search = new BinarySearch2();
        int position = search.binarySearch(dataset, 6);
        System.out.println(position);
    }

}
