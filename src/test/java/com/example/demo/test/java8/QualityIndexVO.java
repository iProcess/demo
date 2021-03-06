package com.example.demo.test.java8;

import lombok.Data;

/**
 * 质量指数基础信息
 * @author jiangjian
 * @date 2020/9/7 17:19
 */
@Data
public class QualityIndexVO {
    /**
     * AA等级SPU数量
     */
    private Long aaGradeCount;

    /**
     * A等级SPU数量
     */
    private Long aGradeCount;

    /**
     * B等级SPU数量
     */
    private Long bGradeCount;

    /**
     * C等级SPU数量
     */
    private Long cGradeCount;

    /**
     * D等级SPU数量
     */
    private Long dGradeCount;

    /**
     * AA等级SPU占比
     */
    private String aaGradeRate;

    /**
     * A等级SPU占比
     */
    private String aGradeRate;

    /**
     * B等级SPU占比
     */
    private String bGradeRate;

    /**
     * C等级SPU占比
     */
    private String cGradeRate;

    /**
     * D等级SPU占比
     */
    private String dGradeRate;

    /**
     * AA等级SPU数量环比
     */
    private String aaGradeCountMom;
    /**
     * A等级SPU数量环比
     */
    private String aGradeCountMom;
    /**
     * B等级SPU数量环比
     */
    private String bGradeCountMom;
    /**
     * C等级SPU数量环比
     */
    private String cGradeCountMom;
    /**
     * D等级SPU数量环比
     */
    private String dGradeCountMom;
    /**
     * AA等级SPU占比环比
     */
    private String aaGradeRateMom;
    /**
     * A等级SPU占比环比
     */
    private String aGradeRateMom;
    /**
     * B等级SPU占比环比
     */
    private String bGradeRateMom;
    /**
     * C等级SPU占比环比
     */
    private String cGradeRateMom;
    /**
     * D等级SPU占比环比
     */
    private String dGradeRateMom;
    /**
     * spu总数
     */
    private Long spuTotal;
}
