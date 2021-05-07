package com.example.demo.test.ali.findstr;

/**
 * 数组中出现次数超过一半的数字（数组 时间效率）
 * https://blog.csdn.net/DirBee/article/details/78457176
 */
public class FindStr4 {

    public static void main(String[] args) {
        int array[] = {1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 3, 2, 2};//-1 2
        System.out.println(solution(array));
    }

    public static int solution(int [] array) {
        if (array.length == 0) {
            return 0;
        }
        if (array.length == 1) {
            return array[0];
        }
        int res = array[0];
        int count = 1;

        for (int i = 1; i < array.length; i++) {
            if (count == 0) {
                res = array[i];
                count = 1;
            } else if (array[i] == res){
                count++;
            }else{
                count--;
            }
        }

        count = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == res) {
                count++;
            }
        }
        return count > array.length / 2 ? res : 0;
    }

}
