package com.example.demo.test.ali.findstr;

import java.util.HashMap;
import java.util.Map;

/**
 * https://blog.csdn.net/cyuyanenen/article/details/51749903
 * https://blog.csdn.net/wickedvalley/article/details/77745163?utm_source=blogxgwz6
 */
public class FindStr3 {

    public static void main(String[] args) {
        //String array[] = {"1", "2", "3", "2", "5", "2", "2", "6", "2", "2", "2"};
        //String array[] = {"1", "2", "3", "2", "5", "2", "6", "2", "3", "2", "4"};//-1 2
        String array[] = {"1", "2", "1", "2", "1", "2", "1", "2", "1", "2", "3"};//-1 2
        //String array[] = {"1", "1", "2", "2"};//1 2
        //String array[] = {"4", "3", "4", "2", "4", "4", "2", "4"};
        //String array[] = {"4", "3", "4", "2", "4", "4", "2", "4"};
        //String array[] = {"3", "3", "4", "2", "4", "4", "2", "4"};
        //String array[] = {"3", "3", "4", "2", "4", "4", "2", "4"};

        System.out.println(findMoreThanHalf(array));
        System.out.println(findMoreThanHalfMap(array));
    }

    public static String findMoreThanHalf(String[] array) {
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

        int times = 0;
        for (int i = 0; i < array.length; i++) {
            if(findStr.equals(array[i])){
                times++;
            }
        }
        if(times >= array.length / 2){
            return findStr;
        }

        return "-1";

    }

//    public static boolean checkMoreThanHalf(String[] array, String s){
//        int times = 0;
//        for (int i = 0; i < array.length; i++) {
//            if(s.equals(array[i])){
//                times++;
//            }
//        }
//        if(times >= array.length / 2){
//            return true;
//        }
//        return false;
//    }

    public static String findMoreThanHalfMap(String[] array) {
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




}
