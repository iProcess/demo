package com.example.demo.test.xm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://blog.csdn.net/weixin_38450840/article/details/80650674
 * 全排列 ：
 * 从n个不同元素中任取m（m≤n）个元素，按照一定的顺序排列起来，叫做从n个不同元素中取出m个元素的一个排列。当m=n时所有的排列情况叫全排列。
 * 例如：
 * 1 、2 、3三个元素的全排列为：
 * {1，2，3}，{1，3，2}，{2，1，3}，{2，3，1}，{3，1，2}，{3，2，1}。
 *
 * 解法1（递归）
 * 递归的话就很简单了，以{1,2,3}为例，它的排列是：
 * 以1开头，后面接着{2,3}的全排列，
 * 以2开头，后面接着{1,3}的全排列，
 * 以3开头，后面接着{1,2}的全排列。
 */
public class TestMain1 {

    public void permute(Integer[] arr, int start, List<Integer[]> list){
        if(arr == null || arr.length == 0 ){
            return;
        }
        //如果已经到了数组的最后一个元素，前面的元素已经排好，输出。
        if(start == arr.length - 1){
            list.add(arr);
        }
        for(int i = start; i <= arr.length - 1; i++ ){
            //把第一个元素分别与后面的元素进行交换，递归的调用其子数组进行排序
            swap(arr, i, start);
            permute(arr, start + 1, list);
            swap(arr, i, start);
            //子数组排序返回后要将第一个元素交换回来。
            //如果不交换回来会出错，比如说第一次1、2交换，第一个位置为2，子数组排序返回后如果不将1、2
            //交换回来第二次交换的时候就会将2、3交换，因此必须将1、2交换使1还是在第一个位置
        }
    }

    public void print(Integer[] arr){
        for (Integer i : arr){
            System.out.print(i);
        }
        System.out.println();
    }

    public void swap(Integer[] arr, int i, int j){
        int temp;
        temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        List<Integer[]> list = new ArrayList<>();
        Integer[] arr = new Integer[]{1, 2, 3};
        TestMain1 main = new TestMain1();
        main.permute(arr, 0, list);

        for(Integer[] arrs : list){
            System.out.println(Arrays.toString(arrs));
        }
        /**
         * [1, 2, 3]
         * [1, 3, 2]
         * [2, 1, 3]
         * [2, 3, 1]
         * [3, 2, 1]
         * [3, 1, 2]
         */

    }


}
