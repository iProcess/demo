package com.example.demo.test.ali.findstr;

/**
 * https://blog.csdn.net/cyuyanenen/article/details/51749903
 * https://blog.csdn.net/wickedvalley/article/details/77745163?utm_source=blogxgwz6
 */
public class FindStr {

    public static int findMostData(int[] array, int length) {
        int findNum = 0; // 出现次数超过一半的数；
        int count = 0; // 只要最终count > 0，那么对应的findNum就是出现次数超过一半的数；

        // 循环过程中，i每增加一次，就相当于把i之前的所有元素（除了满足“findNum == arr[i]”条件的arr[i]，这些对应元素用“count++”来标记）都抛弃了，但是之后每当执行一次“ count-- ”时，又会从前面这些已保留的且等于findNum的元素中删除一项，直到count == 0，再重选findNum；
        for (int i = 0; i < length; i++) {
            if (count == 0) { // count为0时，表示当前的findNum需要重选；
                findNum = array[i];
                count = 1;
            } else {
                if (findNum == array[i])
                    count++;
                else
                    count--;
            }
        }

        return findNum;
    }

    public static void main(String[] args) {
        int array[] = {1, 2, 3, 2, 5, 2, 2, 6, 2, 2, 2};
        System.out.println(findMostData(array, array.length));
    }

}
