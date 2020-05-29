package com.example.demo.sort.doit.merge;

import com.example.demo.sort.doit.DoItUtil;
import com.example.demo.sort.doit.quick.QuickSort;

/**
 * 归并排序（Merge Sort）
 *
 *
 * 和选择排序一样，归并排序的性能不受输入数据的影响，但表现比选择排序好的多，因为始终都是O(n log n）的时间复杂度。代价是需要额外的内存空间。
 *
 * 归并排序是建立在归并操作上的一种有效的排序算法。该算法是采用分治法（Divide and Conquer）的一个非常典型的应用。归并排序是一种稳定的排序方法。
 * 将已有序的子序列合并，得到完全有序的序列；即先使每个子序列有序，再使子序列段间有序。若将两个有序表合并成一个有序表，称为2-路归并。
 *
 * 把长度为n的输入序列分成两个长度为n/2的子序列；
 * 对这两个子序列分别采用归并排序；
 * 将两个排序好的子序列合并成一个最终的排序序列。
 *
 */
public class MergeSort {

    /**
     * 升序
     * @param left
     * @param right
     * @return
     */
    public int[] mergeSort(int[] left, int[] right){
        int[] merge = new int[left.length + right.length];
        for(int index = 0, i = 0, j = 0; index < merge.length; index++){
            if(i >= left.length){
                merge[index] = right[j++];
            }else if( j >= right.length){
                merge[index] = left[i++];
            }else if(left[i] > right[j]){
                merge[index] = right[j++];
            }else{
                merge[index] = left[i++];
            }
        }
        return merge;
    }

    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();

        int[] left = DoItUtil.createArray();
        quickSort.quickSort(left, 0, left.length - 1);
        DoItUtil.printArray(left);

        int[] right = DoItUtil.createArray();
        quickSort.quickSort(right, 0, right.length - 1);
        DoItUtil.printArray(right);

        MergeSort mergeSort = new MergeSort();
        int[] merge = mergeSort.mergeSort(left, right);
        DoItUtil.printArray(merge);
    }
}
