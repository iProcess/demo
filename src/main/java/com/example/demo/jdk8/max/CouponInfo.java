package com.example.demo.jdk8.max;

import lombok.Data;

import java.math.BigDecimal;

/**
 * CouponInfo
 * 券信息
 * @author shijincheng
 * @date 2019/12/25
 */
@Data
public class CouponInfo {
    /**
     * 优惠券key
     */
    private String batchKey;
    /**
     * 面额 满100减50 值为50
     */
    private BigDecimal discount;
    /**
     * 门槛 如上值为 100
     */
    private BigDecimal condition;
    /**
     * 优惠券类型 0：自营券 1：POP券
     */
    private Integer type;


}
