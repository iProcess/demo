package com.example.demo.test.other;

import java.util.HashSet;
import java.util.Set;

public class TestSet {

    public static void main(String[] args) {
        Set<Long> skuIdSet = new HashSet<>();
        System.out.println(skuIdSet.contains(893142));
        skuIdSet.add(10608791270L);
        skuIdSet.add(893142L);
        skuIdSet.add(893143L);

        System.out.println(skuIdSet.contains(893142));
        System.out.println(skuIdSet.contains(893142L));
        System.out.println(skuIdSet.contains(getId()));
    }

    public static Long getId(){
        return 10608791270L;
    }
}
