package com.example.demo.test;

import java.util.Scanner;

/**
 * https://blog.csdn.net/qq_41258836/article/details/81983468?utm_medium=distribute.pc_relevant_t0.none-task-blog-2%7Edefault%7EBlogCommendFromMachineLearnPai2%7Edefault-1.control&depth_1-utm_source=distribute.pc_relevant_t0.none-task-blog-2%7Edefault%7EBlogCommendFromMachineLearnPai2%7Edefault-1.control
 * 题目一：找出数组中重复的数字
 *
 * 在一个长度为n的数组里的所有数字都在0-n-1的范围内，数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次 。
 * 请找出数组中任意一个重复的数字。
 *
 */
public class DuplicateNum {

    public static void duplicate(int[] array){
        int[] temp = new int[array.length];
        for(int i = 0; i < array.length; i++){
            if(temp[array[i]] == 1){
                System.out.println(array[i] + " ");
            }else {
                temp[array[i]] = 1;
            }
        }
    }


    public static void main( String[] args){
        int[] array = new int[]{2, 4, 5, 6, 7, 8, 9, 3, 4, 5, 5};
        duplicate(array);

//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//        int a[] = new int[n] ;
//        int b[] = new int[n] ;
//        for( int i = 0 ; i < a.length ; i++){
//            a[i] = scanner.nextInt();
//        }
//        for( int i = 0 ; i<a.length ; i ++){
//            if(b[a[i]] == 1 ){
//                System.out.print(a[i]+" ");
//            }
//            else{
//                b[a[i]] =  1 ;
//            }
//        }
    }


}
