package com.example.demo.test.search;

/**
 * 二分查找
 * 二分查找又称折半查找，优点是比较次数少，查找速度快，平均性能好；其缺点是要求待查表为有序表，且插入删除困难。
 * 因此，折半查找方法适用于不经常变动而查找频繁的有序列表。
 * 首先，假设表中元素是按升序排列，将表中间位置记录的关键字与查找关键字比较，如果两者相等，则查找成功；
 * 否则利用中间位置记录将表分成前、后两个子表，如果中间位置记录的关键字大于查找关键字（即查找的关键字小于中间位置记录），则进一步查找前一子表，否则进一步查找后一子表。
 * 重复以上过程，直到找到满足条件的记录，使查找成功，或直到子表不存在为止，此时查找不成功。
 * T(n) = O(logn)
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
