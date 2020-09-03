package com.example.demo.test.java8;

import com.alibaba.fastjson.JSON;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TestGroup {

    public static void main(String[] args) {

        List<LevelCouponApply> applyList = new ArrayList<>();
        for(int i = 1; i <= 5; i++){
            for(int j = 1; j <= 3; j++){
                LevelCouponApply apply = new LevelCouponApply();
                apply.setCustomerLevel(i);
                apply.setVenderId(Long.valueOf(i));
                apply.setShopId(Long.valueOf(i));
                apply.setShopName(i + "_ShopName");
                apply.setBatchKey(i + "_BatchKey");
                apply.setDiscount(new BigDecimal(i));
                apply.setQuota(new BigDecimal(i));
                apply.setCouponType(1);
                apply.setApplyCouponImage("https://test_" + i);
                applyList.add(apply);
            }
        }
        System.out.println(JSON.toJSONString(applyList));

        List<LevelCouponApplyResp> respList =
                applyList.parallelStream()
                        .collect(Collectors.groupingBy(LevelCouponApply::getVenderId, Collectors.toList()))
                        .entrySet()
                        .parallelStream()
                        .map(m -> {
                            List<LevelCouponApply> applies = m.getValue();

                            LevelCouponApply apply = applies.get(0);

                            LevelCouponApplyResp applyResp = new LevelCouponApplyResp();
                            applyResp.setCustomerLevel(apply.getCustomerLevel());
                            applyResp.setVenderId(apply.getVenderId());
                            applyResp.setShopId(apply.getShopId());
                            applyResp.setShopName(apply.getShopName());

                            List<LevelCouponApplyDTO> couponInfos =
                                    applies.parallelStream()
                                            .map(am -> {
                                                LevelCouponApplyDTO dto = new LevelCouponApplyDTO();
                                                dto.setBatchKey(am.getBatchKey());
                                                dto.setDiscount(am.getDiscount());
                                                dto.setQuota(am.getQuota());
                                                dto.setType(am.getCouponType());
                                                dto.setCouponImage(am.getApplyCouponImage());
                                                return dto;
                                            })
                                            .collect(Collectors.toList());

                            applyResp.setCouponInfos(couponInfos);
                            return applyResp;
                        })
                        .collect(Collectors.toList());

        System.out.println(JSON.toJSONString(respList));


    }

}
