package com.example.demo.jdk8.map.fm;

import lombok.Data;

@Data
public class CustomerScaleDataVO {
    /**
     * 活跃会员数量
     */
    private Integer activeCustCount;

    /**
     * 统计日期
     */
    private String createDate;

    /**
     * 会员成交人数
     */
    private Integer custCount;

    /**
     * 新增会员数量
     */
    private Integer newCustCount;

    /**
     * 已购会员总数
     */
    private Integer ordCustCount;

    /**
     * 根据统计日期进行排序
     */
    private Long orderDate;

    /**
     * 更新时间
     */
    private String updateTime;
}
