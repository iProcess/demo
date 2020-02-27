package com.example.demo.jdk8.lst;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author shijincheng
 * @version V1.0
 * date 2020/2/27 12:31
 * Description: TODO
 */
public class TestList {

    /** 中台查询sku的最大个数 */
    public static final Integer SKU_MAX_NUM = 6;

    public static void main(String[] args) {

        List<Long> skuList = new ArrayList<>();
        skuList.add(1L);
        skuList.add(2L);
        skuList.add(3L);
        skuList.add(4L);
        skuList.add(5L);

        TestList list = new TestList();
        list.getCustomerDoublePrice(skuList, "test");
    }

    /**
     * 有问题
     * @param skuList
     * @param pin
     * @return
     */
    public Map<Long, String> getCustomerDoublePrice(List<Long> skuList, String pin) {
        Map<Long, String> totalMap = new HashMap<>();
        int totalCount = skuList.size();
        int temp = totalCount % TestList.SKU_MAX_NUM;
        int pageCount =  temp > 0? (totalCount / TestList.SKU_MAX_NUM) + 1: totalCount / TestList.SKU_MAX_NUM;

        for (int i = 1; i <= pageCount; i++) {
            List<String> subSkuList = new ArrayList<>();
            if (i == pageCount) {
                skuList.subList((i - 1) * TestList.SKU_MAX_NUM, totalCount).parallelStream()
                        .forEach(x -> {subSkuList.add(String.valueOf(x));});
            } else {
                skuList.subList((i - 1) * TestList.SKU_MAX_NUM, TestList.SKU_MAX_NUM * i).parallelStream()
                        .forEach(x -> {subSkuList.add(String.valueOf(x));});;
            }
            System.out.println(JSON.toJSONString(subSkuList));
        }
        return totalMap;
    }

}
