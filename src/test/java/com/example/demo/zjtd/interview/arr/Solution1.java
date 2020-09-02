package com.example.demo.zjtd.interview.arr;

/**
 * https://blog.csdn.net/u012243115/article/details/41923667
 */
public class Solution1 {

    public static int findMin(int[] array){
        if(array == null || array.length == 0){
            return 0;
        }
        int prev = 0;//前下标
        int next = array.length - 1;//后下标
        //循环结束条件是prev == next
        while (prev < next){
            int mid = (prev + next) / 2;//中间下标，如果有奇数个元素，则mid位于正中间，如果有偶数个元素，则mid是最中间两个元素中靠前的那个
            //判断中间值和最后值哪个大
            if(array[mid] > array[next]){//如果中间值较大，则最小值位于后半段，且不包括当前mid（因为mid已经比next大了），因此prev = mid + 1
                prev = mid + 1;
            }else {//如果中间值较小，则最小值位于前半段，有可能包括mid，因为mid现在较小，比如3 1 2，因此next = mid，而不能用mid-1
                next = mid;
            }
        }
        return array[prev];//返回最小值
    }

    public static void main(String[] args) {
        int[] array = {5, 6, 0, 1, 2, 3, 4};
        int min = findMin(array);
        System.out.println(min);
    }
}
