package com.example.demo.test.java8.fun.demo;

import lombok.Data;
import lombok.ToString;

/**
 * Qcr查询参数基类
 * @author jiangjian
 * @date 2020/9/7 16:29
 */
@ToString
@Data
public class QcrQueryVO {

    /**
     * 事业群ID
     */
    private String buId;

    /**
     * 一级部门ID
     */
    private String deptId1;

    /**
     * 二级部门ID
     */
    private String deptId2;

    /**
     * 三级部门ID
     */
    private String deptId3;

    /**
     * 四级部门ID
     */
    private String deptId4;

    /**
     * 采销erp 用户类型为采销时传此值
     */
    private String salerId;

    /**
     * 日期类型 day week month
     */
    private String dateType;

    /**
     * 日期
     */
    private String date;

    /**
     * 开始时间
     */
    private String startDate;

    /**
     * 结束时间
     */
    private String endDate;

    /**
     * 经营模式，1-pop，2-自营
     */
    private String shopType;

    /**
     * 一级类目id
     */
    private String firstIndId;

    /**
     * 二级类目id
     */
    private String secondIndId;

    /**
     * 三级类目id
     */
    private String thirdIndId;

    /**
     * 四级类目id
     */
    private String fourthIndId;

    /**
     * 是否全球购0-否 1-是
     */
    private String isOverSea;

    /**
     * 是否计算环比0-否 1-是
     */
    private String isCalculateMom = "0";

    /**
     * 当前页码
     */
    private Integer currentPage = 1;
    /**
     * 每页条数
     */
    private Integer pageSize = 10;
    /**
     * 需要排序的字段
     */
    private String sortField;
    /**
     * 排序顺序 (asc, desc)
     */
    private String sortOrder;

}
