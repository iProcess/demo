package com.example.demo.test.sort.quick;

import com.example.demo.test.sort.util.SortUtils;

/**
 * 快速排序
 * https://blog.csdn.net/zzzgd_666/article/details/87634775
 * 选择待排数列的首部第一个元素为基准元素，设置两指针，分别指向数列首尾部位置，假设两指针分别设为i和j。
 * 每次遍历的过程是这样的，首先遍历指针j所指向的元素，直到j指向的元素值小于基准元素时，停止遍历，将其与
 * 指针i所指向的元素进行交换，因为当前指针所指位置就是用于插入较基准元素小的元素，然后再将指针i加一。接
 * 着轮到指针i遍历,直到i所指向的元素值大于基准元素时，停止遍历，将其与指针j所指向的元素进行交换，之所以
 * 可以交换，是因为指针j所指向的元素刚刚已经交换到前半部分呢，故可以直接选择覆盖就行，这样就将大于基准
 * 元素的元素放于后半部分。依此类推，直到指针i与指针相等或者大于时，停止外部循环。最后直接将基准元素直
 * 接放置于指针i所指向的位置即可，完成分区操作。
 *
 */
public class QuickSort {
    /**
     * 快速排序
     * 快速排序使用分治法（Divide and conquer）策略来把一个序列（list）分为两个子序列（sub-lists）。
     * 步骤为：
     * 1. 从数列中挑出一个元素，称为 "基准"（pivot），
     * 2. 重新排序数列，所有元素比基准值小的摆放在基准前面，所有元素比基准值大的摆在基准的后面（相同的数可以到任一边）。在这个分割之后，该基准是它的最后位置。这个称为分割（partition）操作。
     * 3. 递归地（recursive）把小于基准值元素的子数列和大于基准值元素的子数列排序。
     * 递回的最底部情形，是数列的大小是零或一，也就是永远都已经被排序好了。虽然一直递回下去，但是这个算法总会结束，因为在每次的迭代（iteration）中，它至少会把一个元素摆到它最后的位置去。
     * @param data 待排序的数组
     * @param sortType
     */
    public void quickSort(int[] data, String sortType) {
        if (sortType.equals("asc")) { //正排序，从小排到大
            qsortAsc(data, 0, data.length - 1);
        } else if (sortType.equals("desc")) { //倒排序，从大排到小
            qsortDesc(data, 0, data.length - 1);
        } else {
            System.out.println("您输入的排序类型错误！");
        }
    }

    /**
     * 快速排序的具体实现，正排序
     * @param data
     * @param start
     * @param end
     */
    private void qsortAsc(int data[], int start, int end) {
        int i, j, x;
        if (start < end) { //这个条件用来结束递归
            i = start;
            j = end;
            x = data[i];
            while (i < j) {
                while (i < j && data[j] > x) {
                    j--; //从右向左找第一个小于x的数
                }
                if (i < j) {
                    data[i] = data[j];
                    i++;
                }
                while (i < j && data[i] < x) {
                    i++; //从左向右找第一个大于x的数
                }
                if (i < j) {
                    data[j] = data[i];
                    j--;
                }
            }
            data[i] = x;
            qsortAsc(data, start, i - 1);
            qsortAsc(data, i + 1, end);
        }
    }

    /**
     * 快速排序的具体实现，倒排序
     * @param data
     * @param low
     * @param high
     */
    private void qsortDesc(int data[], int low, int high) {
        int i, j, x;
        if (low < high) { //这个条件用来结束递归
            i = low;
            j = high;
            x = data[i];
            while (i < j) {
                while (i < j && data[j] < x) {
                    j--; //从右向左找第一个小于x的数
                }
                if (i < j) {
                    data[i] = data[j];
                    i++;
                }
                while (i < j && data[i] > x) {
                    i++; //从左向右找第一个大于x的数
                }
                if (i < j) {
                    data[j] = data[i];
                    j--;
                }
            }
            data[i] = x;
            qsortDesc(data, low, i - 1);
            qsortDesc(data, i + 1, high);
        }
    }

    public static void main(String[] args) {
        QuickSort sort = new QuickSort();
        int[] array = SortUtils.createArray();
        sort.quickSort(array, "asc");
        SortUtils.printArray(array);
    }

}
