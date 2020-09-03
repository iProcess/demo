package com.example.demo.test.ali.inte;

import java.util.ArrayList;
import java.util.List;

public class ArrayListTest {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(9);
        list.add(10);

        List<Integer> subList = list.subList(5, 10);
        System.out.println(subList.size());

        //不能转换，subList返回的是SubList类型
        //ArrayList<Integer> subList1 = list.subList(5, 10);
    }
}
