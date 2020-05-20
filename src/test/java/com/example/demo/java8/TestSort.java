package com.example.demo.java8;

import com.alibaba.fastjson.JSON;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class TestSort {

    public static void main(String[] args) {
        List<LevelCouponInfoDTO> couponInfoDtos = new ArrayList<>();

        LevelCouponInfoDTO dto1 = new LevelCouponInfoDTO();
        dto1.setBatchKey("BA_fzo6il6");
        dto1.setCondition(new BigDecimal(398.00));
        dto1.setDiscount(new BigDecimal(50.00));
        dto1.setCouponLevel(4);
        dto1.setType(0);

        LevelCouponInfoDTO dto2 = new LevelCouponInfoDTO();
        dto2.setBatchKey("BA_fow6izl");
        dto2.setCondition(new BigDecimal(348.00));
        dto2.setDiscount(new BigDecimal(40.00));
        dto2.setCouponLevel(2);
        dto2.setType(0);

        couponInfoDtos.add(dto1);
        couponInfoDtos.add(dto2);

        System.out.println(JSON.toJSONString(couponInfoDtos));

        //按等级降序
        List<LevelCouponInfoDTO> sortCouponInfos = couponInfoDtos.stream()
                .sorted(Comparator.comparing(LevelCouponInfoDTO::getCouponLevel).reversed())
                .collect(Collectors.toList());

        System.out.println(JSON.toJSONString(sortCouponInfos));

    }
}
