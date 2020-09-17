package com.example.demo.test.java8.fun.demo;

import lombok.Data;

/**
 * 质量高风险数据展示模型
 */
@Data
public class QualityRiskDeptVO extends QualityRiskVO {
    /**
     * 部门id
     */
    private String deptId;

    /**
     * 部门名称
     */
    private String deptName;

}
