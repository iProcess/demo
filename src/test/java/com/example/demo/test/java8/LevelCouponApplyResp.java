package com.example.demo.test.java8;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 会员券活动提报返回参数
 */
@Data
public class LevelCouponApplyResp implements Serializable {

    /**
     * 会员等级
     */
    private Integer customerLevel;
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
     * 等级券信息
     */
    private List<LevelCouponApplyDTO> couponInfos;

}
