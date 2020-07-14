package com.example.demo.jdk8.map.fm;

import lombok.Data;

/**
 * 1-5星会员成交总人数、订单总数量、订单总金额
 *
 * @author wl
 * @date 2020/05/01
 */
@Data
public class CustomerOrderRangeDataVO {
    /**
     * 会员总成交数
     */
    private Integer custCount;

    /**
     * 会员总成交订单量
     */
    private Integer custOrdCount;

    /**
     * 会员总成交订单金额
     */
    private Double custOrdAmount;

    /**
     * 统计日期
     */
    private String createDate;

    /**
     * 更新时间
     */
    private String updateTime;
}
