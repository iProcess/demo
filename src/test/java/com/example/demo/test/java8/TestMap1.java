package com.example.demo.test.java8;

import com.alibaba.fastjson.JSON;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TestMap1 {

    public static void main(String[] args) {
        List<NewProductDTO> dtos = new ArrayList<>();

        NewProductDTO dto1 = new NewProductDTO();
        dto1.setDate("2020-11-16");
        dto1.setShopId("16");
        dto1.setShelvesGoodsNum("1600");

        NewProductDTO dto2 = new NewProductDTO();
        dto2.setDate("2020-11-17");
        dto2.setShopId("17");
        dto2.setShelvesGoodsNum("1700");

        NewProductDTO dto3 = new NewProductDTO();
        dto3.setDate("2020-11-17");
        dto3.setShopId("18");
        dto3.setShelvesGoodsNum("1800");

        NewProductDTO dto4 = new NewProductDTO();
        dto4.setDate("2020-11-21");
        dto4.setShopId("21");
        dto4.setShelvesGoodsNum("2100");

        NewProductDTO dto5 = new NewProductDTO();
        dto5.setDate("2020-11-16");
        dto5.setShopId("20");
        dto5.setShelvesGoodsNum("2000");

        dtos.add(dto1);
        dtos.add(dto2);
        dtos.add(dto3);
        dtos.add(dto4);
        dtos.add(dto5);

        Map<String, NewProductDTO> pdMap = dtos.stream().filter(pd -> StringUtils.isNotBlank(pd.getDate())).collect(Collectors.toMap(NewProductDTO::getDate, Function.identity(), (k1, k2) -> k2, ConcurrentHashMap::new));
        System.out.println(JSON.toJSONString(pdMap));
        /**
         * {
         *     "2020-11-17": {
         *         "date": "2020-11-17",
         *         "shelvesGoodsNum": "1800",
         *         "shopId": "18"
         *     },
         *     "2020-11-16": {
         *         "date": "2020-11-16",
         *         "shelvesGoodsNum": "2000",
         *         "shopId": "20"
         *     },
         *     "2020-11-21": {
         *         "date": "2020-11-21",
         *         "shelvesGoodsNum": "2100",
         *         "shopId": "21"
         *     }
         * }
         */

    }
}
