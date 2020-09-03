package com.example.demo.test.leetcode.repeat;

public class TestMain {

    public static void main(String[] args) {
        int[] nums = {1,3,4,2,2};
        Repeat repeat = new Repeat();
        /**
         * 适用于数组中最大元素的值小于数组大小的情况
         * 如 {10,3,4,2,2}  {1,30,4,2,2} 等等情况就不适合了
         */
        int rep = repeat.findDuplicate(nums);
        System.out.println(rep);
    }

}
