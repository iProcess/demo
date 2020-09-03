package com.example.demo.test.java8;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 会员券与活动提报数据异构信息
 */
@Data
public class LevelCouponApply {
    /**
     * 主键
     */
    private Long id;
    /**
     * 会员券活动id
     */
    private Long marketingId;
    /**
     * 会员券活动名称
     */
    private String marketingName;
    /**
     * 会员券活动开始时间
     */
    private Date startTime;
    /**
     * 会员券活动结束时间
     */
    private Date endTime;
    /**
     * 会员券发券状态
     */
    private Integer status;
    /**
     * 店铺会员级别
     */
    private Integer customerLevel;
    /**
     * 优惠券类型 0-POP东券 1-自营东券
     */
    private Integer selfCoupon;
    /**
     * 会员券id
     */
    private Long couponId;
    /**
     * 会员券名称
     */
    private String couponTitle;
    /**
     * 商家id
     */
    private Long venderId;
    /**
     * 店铺id
     */
    private Long shopId;
    /**
     * 店铺名称
     */
    private String shopName;
    /**
     * 会员券批次key
     */
    private String batchKey;
    /**
     * 会员券类型(1-POP东券 2-自营东券)
     */
    private Integer couponType;
    /**
     * 面额(满100减50 值为50)
     */
    private BigDecimal discount;
    /**
     * 门槛(如上值为 100)
     */
    private BigDecimal quota;
    /**
     * 活动提报报名id
     */
    private Long applyId;
    /**
     * 活动提报原报名id（用于 报名换品审核通过时 更新原数据）
     */
    private Long originalApplyId;
    /**
     * 活动提报活动id
     */
    private Long applyActivityId;
    /**
     * 活动提报会员券图片地址
     */
    private String applyCouponImage;
    /**
     * 活动提报报名人
     */
    private String applyPin;
    /**
     * 创建时间
     */
    private Date created;
    /**
     * 修改时间
     */
    private Date modified;

}
