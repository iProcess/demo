package com.example.demo.test.java8.fun;

import lombok.Data;

/**
 * 质量高风险数据展示模型
 */
@Data
public class QualityRiskVO {
    /**
     * 预警数量
     */
    private Long warnCount;

    /**
     * 降权/停采数量
     */
    private Long weightDownCount;

    /**
     * 屏蔽/下架数量
     */
    private Long blockCount;

    /**
     * 预警spu近30天妥投订单量
     */
    private Long warnOrderCount;

    /**
     * 降权spu近30天妥投订单量
     */
    private Long weightDownOrderCount;

    /**
     * 屏蔽spu近30天妥投订单量
     */
    private Long blockOrderCount;

    /**
     * 预警数量环比
     */
    private String warnCountMom = "--";

    /**
     * 降权/停采数量环比
     */
    private String blockCountMom = "--";

    /**
     * 屏蔽/下架数量环比
     */
    private String weightDownCountMom = "--";
}
