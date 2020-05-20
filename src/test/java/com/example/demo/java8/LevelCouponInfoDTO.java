package com.example.demo.java8;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 等级券信息
 */
@Data
public class LevelCouponInfoDTO implements Serializable {
    /** 优惠券key **/
    private String batchKey;
    /** 面额 满100减50 值为50 **/
    private BigDecimal discount;
    /** 门槛 如上值为 100 **/
    private BigDecimal condition;
    /** 优惠券类型 0：自营券 1：POP券 **/
    private Integer type;
    /** 优惠券对应的等级**/
    private Integer couponLevel;
}
