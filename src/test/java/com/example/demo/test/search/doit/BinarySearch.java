package com.example.demo.test.search.doit;

import com.example.demo.test.sort.doit.AllSort;

import java.util.Random;

/**
 * 定义：https://blog.csdn.net/u011489043/article/details/69357726
 * 二分查找
 * 二分查找又称折半查找，优点是比较次数少，查找速度快，平均性能好；其缺点是要求待查表为有序表，且插入删除困难。
 * 因此，折半查找方法适用于不经常变动而查找频繁的有序列表。
 * 首先，假设表中元素是按升序排列，将表中间位置记录的关键字与查找关键字比较，如果两者相等，则查找成功；
 * 否则利用中间位置记录将表分成前、后两个子表，如果中间位置记录的关键字大于查找关键字（即查找的关键字小于中间位置记录），则进一步查找前一子表，否则进一步查找后一子表。
 * 重复以上过程，直到找到满足条件的记录，使查找成功，或直到子表不存在为止，此时查找不成功。
 * 时间复杂度：T(n) = O(logn)
 */
public class BinarySearch {

    public static void main(String[] args) {
        int[] array = createArray(10);
        AllSort.quickSort(array, 0, array.length - 1);
        System.out.print("快速排序后：");
        print(array);
        System.out.println("查找元素：" + array[3]);
        System.out.println("元素坐标：" + biSearch(array, array[3], 0, array.length - 1));
    }

    public static int biSearch(int[] array, int data, int beginIndex, int endIndex){
        if(data < array[beginIndex] || data > array[endIndex] || beginIndex > endIndex){
            return -1;
        }
        int middleIndex = (beginIndex + endIndex) >>> 1;//(beginIndex + endIndex)/2
        if(data < array[middleIndex]){
            return biSearch(array, data, beginIndex, middleIndex - 1);
        }else if (data > array[middleIndex]){
            return biSearch(array, data, middleIndex + 1, endIndex);
        }else {
            return middleIndex;
        }
    }


    public static int[] createArray(int size){
        Random random = new Random();
        int[] array = new int[size];
        for(int i = 0; i < size; i++){
            array[i] = random.nextInt(100) - random.nextInt(100);
        }
        System.out.print("原数组：");
        print(array);
        return array;
    }

    public static void print(int[] array){
        for(int i : array){
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
