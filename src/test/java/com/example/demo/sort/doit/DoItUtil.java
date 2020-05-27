package com.example.demo.sort.doit;

import java.util.Random;

public class DoItUtil {

    public static void printArray(int[] array){
        for(int i : array){
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static int[] createArray(){
        Random random = new Random();
        int[] array = new int[10];
        for(int i = 0; i < 10; i++){
            array[i] = random.nextInt(100) - random.nextInt(100);
        }
        System.out.println("============原始序列============");
        printArray(array);
        return array;
    }

    /**
     * 交互数据
     * @param data
     * @param x
     * @param y
     */
    public static void swap(int[] data, int x, int y){
        int temp = data[x];
        data[x] = data[y];
        data[y] = temp;
    }
}
