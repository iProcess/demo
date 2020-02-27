package com.example.demo.jdk8.lst;

import com.alibaba.fastjson.JSON;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author shijincheng
 * @version V1.0
 * date 2020/2/27 12:31
 * Description: TODO
 */
public class TestList {

    /** 中台查询sku的最大个数 */
    public static final Integer SKU_MAX_NUM = 10;

    public static void main(String[] args) {

        int j = 1000;
        while (j > 0){
            List<Long> skuList = new ArrayList<>();
            for(Long i = 0L; i < 19L; i++){
                skuList.add(i);
            }
            TestList list = new TestList();
            list.getCustomerDoublePrice(skuList, "test");
            skuList.clear();
            j--;
        }

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
//            List<String> subSkuList = new ArrayList<>();
//            Vector<String> subSkuList = new Vector<>();
//            List<String> subSkuList = Collections.synchronizedList(new ArrayList<>());
            List<String> subSkuList = new CopyOnWriteArrayList();

            if (i == pageCount) {
                skuList.subList((i - 1) * TestList.SKU_MAX_NUM, totalCount).parallelStream()
                        .forEach(x -> {subSkuList.add(String.valueOf(x));});
            } else {
                skuList.subList((i - 1) * TestList.SKU_MAX_NUM, TestList.SKU_MAX_NUM * i).parallelStream()
                        .forEach(x -> {subSkuList.add(String.valueOf(x));});;
            }
            System.out.println(JSON.toJSONString(subSkuList));
            if(subSkuList == null || subSkuList.size() <= 8 || subSkuList.contains(null)){
                System.out.println(JSON.toJSONString(subSkuList));
                throw new RuntimeException("出错啦!");
            }

        }
        return totalMap;
    }

}
