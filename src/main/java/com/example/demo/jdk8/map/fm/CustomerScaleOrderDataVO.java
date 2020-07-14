package com.example.demo.jdk8.map.fm;

import lombok.Data;

@Data
public class CustomerScaleOrderDataVO {

    /**
     * 会员总量
     */
    private Integer totalCustCount;
    /**
     * 已购会员总数
     */
    private Integer ordCustCount;
    /**
     * 活跃会员数量
     */
    private Integer activeCustCount;
    /**
     * 新增会员数量
     */
    private Integer newCustCount;
    /**
     * 会员成交人数
     */
    private Integer custCount;
    /**
     * 会员成交订单量
     */
    private Integer custOrdCount;
    /**
     * 会员成交金额
     */
    private Double custOrdAmount;
    /**
     * 统计日期
     */
    private String createDate;

}
