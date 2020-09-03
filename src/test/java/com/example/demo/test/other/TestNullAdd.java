package com.example.demo.test.other;

import java.util.ArrayList;
import java.util.List;

public class TestNullAdd {

    public static void main(String[] args) {

        TestNullAdd add = null;
        List<TestNullAdd> lst = new ArrayList<>();
        lst.add(add);
        //null
        System.out.println(add);
        //1
        System.out.println(lst.size());

    }

}
