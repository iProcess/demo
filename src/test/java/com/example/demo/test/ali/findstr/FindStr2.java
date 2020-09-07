package com.example.demo.test.ali.findstr;

import java.util.HashMap;
import java.util.Map;

/**
 * https://blog.csdn.net/cyuyanenen/article/details/51749903
 * https://blog.csdn.net/wickedvalley/article/details/77745163?utm_source=blogxgwz6
 */
public class FindStr2 {

    public static void main(String[] args) {
        //int array[] = {1, 2, 3, 2, 5, 2, 2, 6, 2, 2, 2};
        //int array[] = {1, 2, 3, 2, 5, 2, 6, 2, 3, 2, 4}; //-1
        //int array[] = {1, 1, 2, 2}; //-1


        //String array[] = {"4", "3", "4", "2", "4", "4", "2", "4"};
        String array[] = {"3", "3", "4", "2", "4", "4", "2", "4"};

        //int array1[] = {3, 3, 4, 2, 4, 4, 2, 4};//-1

        System.out.println(findAppearMoreThanHalf2(array));

        System.out.println(findAppearMoreThanHalf3(array));

        //System.out.println(moreThanHalfNum(array1));
    }

    public static String findAppearMoreThanHalf2(String[] array) {
        String findStr = ""; // 出现次数超过一半的数；
        int counter = 0; // 只要最终count > 0，那么对应的findNum就是出现次数超过一半的数；

        // 循环过程中，i每增加一次，就相当于把i之前的所有元素（除了满足“findStr == arr[i]”条件的arr[i]，这些对应元素用“counter++”来标记）都抛弃了，但是之后每当执行一次“ counter-- ”时，又会从前面这些已保留的且等于findStr的元素中删除一项，直到counter == 0，再重选findStr；
        for (int i = 0; i < array.length; i++) {
            if (counter == 0) { // counter为0时，表示当前的findStr需要重选；
                findStr = array[i];
                counter = 1;
            } else {
                if (findStr.equals(array[i])) {
                    counter++;
                }else {
                    counter--;
                }
            }
        }

        if(counter >= array.length / 2){
            return findStr;
        }else {
            return "-1";
        }

    }

    public static String findAppearMoreThanHalf3(String[] array) {
        String findStr = "-1"; // 出现次数超过一半的数；
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            if (!map.keySet().contains(array[i])) {
                map.put(array[i], 1);
            } else {
                int n = map.get(array[i]);
                n++;
                map.put(array[i], n);
                if (n >= array.length / 2) {
                    findStr = array[i];
                }
            }
        }
        return findStr;
    }





    public static boolean CheckMoreThanHalf(int[] array, int length, int number){
        int times = 0;
        for (int i = 0; i < length; i++) {
            if(array[i] == number){
                times++;
            }
        }
        boolean isMoreThanHalf = true;
        if(times * 2 <= length){
            //arrayInvalid = true;
            isMoreThanHalf = false;
        }
        return isMoreThanHalf;
    }

    public static Integer moreThanHalfNum(int[] array) {
        if (array == null)
            return null;
        Integer number = null;
        int count = 0;
        Integer resultInteger = null;
        for (int i = 0; i < array.length; i++) {
            if (number == null) {
                number = array[i];
                count++;
            } else {
                if (array[i] != number)
                    if (count == 0) {
                        number = array[i];
                        count = 1;
                    } else
                        count--;
                else
                    count++;
            }
            if (count == 1)
                resultInteger = number;
        }
        if (CheckMoreThanHalf(array, array.length, resultInteger))
            return resultInteger;
        else
            return null;
    }

}
