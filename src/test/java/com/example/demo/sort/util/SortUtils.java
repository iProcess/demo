package com.example.demo.sort.util;

import lombok.extern.slf4j.Slf4j;

import java.util.Random;

@Slf4j
public class SortUtils {

    /**
     * 打印数组中的元素到控制台
     * @param data
     */
    public static void printArray(int[] data) {
        for (int i : data) {
//            log.info(i + " ");
            System.out.print(i + " ");
        }
        System.out.println();
    }

    /**
     * 初始化测试数组的方法
     * @return 一个初始化好的数组
     */
    public static int[] createArray() {
        Random random = new Random();
        int[] array = new int[10];
        for (int i = 0; i < 10; i++) {
            array[i] = random.nextInt(100) - random.nextInt(100);//生成两个随机数相减，保证生成的数中有负数
        }
//        log.info("==========原始序列==========");
        System.out.println("==========原始序列==========");
        printArray(array);
        return array;
    }

    /**
     * 交换数组中指定的两元素的位置
     * @param data
     * @param x
     * @param y
     */
    public static void swap(int[] data, int x, int y) {
        int temp = data[x];
        data[x] = data[y];
        data[y] = temp;
    }

    /**
     * 反转数组的方法
     * @param data 源数组
     */
    public static void reverse(int[] data) {

        int length = data.length;
        int temp = 0;//临时变量

        for (int i = 0; i < length / 2; i++) {
            temp = data[i];
            data[i] = data[length - 1 - i];
            data[length - 1 - i] = temp;
        }
        printArray(data);//输出到转后数组的值
    }


}
