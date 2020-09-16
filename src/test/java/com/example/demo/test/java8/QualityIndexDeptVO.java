package com.example.demo.test.java8;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 部门分析VO
 * @author jiangjian
 * @date 2020/9/7 17:26
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class QualityIndexDeptVO extends QualityIndexVO {

    /**
     * 部门id
     */
    private String deptId;

    /**
     * 部门名称
     */
    private String deptName;

}
