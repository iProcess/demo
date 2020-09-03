package com.example.demo.test.java8;

import lombok.Data;

@Data
public class ToolActivity {
    /**
     * 店铺Id
     */
    private String shopId;

    /**
     * 工具生效活动数
     */
    private String shopActCount;

    /**
     * 工具名称
     */
    private String toolName;

    /**
     * 环比指标
     */
    private String mom;

    /**
     * 同比指标
     */
    private String yoy;
}
