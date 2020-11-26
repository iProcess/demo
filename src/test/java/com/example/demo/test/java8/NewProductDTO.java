package com.example.demo.test.java8;

import lombok.Data;

@Data
public class NewProductDTO {
    /**
     * 上架商品数
     */
    private String shelvesGoodsNum = "0";
    /**
     * 日期
     */
    private String date;
    /**
     * 店铺id
     */
    private String shopId;
}
