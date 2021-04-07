package com.example.demo.test.json;

import lombok.Data;

@Data
public class ShopToolDetails {

    /** 店铺id */
    private Integer shopId;
    /** 店铺名称 */
    private String shopName;
    /** 主供应商简码 */
    private String majorSuppBrevityCode;
    /** pop-运营erp、自营-销售erp */
    private String salerOperErpAcct;
    /** 采购员erp帐号 */
    private String purchaserErpAcct;
    /** 事业部id */
    private Integer buId;
    /** 一级部门id */
    private Integer deptId1;
    /** 一级部门名称 */
    private String deptName1;
    /** 二级部门id */
    private Integer deptId2;
    /** 二级部门名称 */
    private String deptName2;
    /** 三级部门id */
    private Integer deptId3;
    /** 三级部门名称 */
    private String deptName3;
    /** 四级部门id */
    private Integer deptId4;
    /** 四级部门名称 */
    private String deptName4;
    /** sku数 */
    private Integer skuNum;
    /** spu数 */
    private Integer spuNum;
    /** 是否绑定产品线 */
    private Integer productFlag;
    /** 开店时间 */
    private String openTm;
    /** 关店时间 */
    private String closeTm;
    /** 商家id */
    private Integer venderId;
    /** 工具名称 */
    private String toolName = "--";
    /** 工具有效子单量 */
    private String toolValidOrderCount = "0";
    /** 工具有效子单量环比 */
    private String toolValidOrderCountMom = "--";
    /** 工具有效子单量同比 */
    private String toolValidOrderCountYoy = "--";
    /** 工具成交子单量 */
    private String toolDealOrderCount = "0";
    /** 工具成交子单量环比 */
    private String toolDealOrderCountMom = "--";
    /** 工具成交子单量同比 */
    private String toolDealOrderCountYoy = "--";
    /** 工具成交金额 */
    private String toolDealAmount = "0";
    /** 工具成交金额环比 */
    private String toolDealAmountMom = "--";
    /** 工具成交金额同比 */
    private String toolDealAmountYoy = "--";
    /** 工具成交客户数 */
    private String toolDealOrderUserCount = "0";
    /** 工具成交客户数环比 */
    private String toolDealOrderUserCountMom = "--";
    /** 工具成交客户数同比 */
    private String toolDealOrderUserCountYoy = "--";
    /** 工具客单价 */
    private String toolPerAmount = "0";
    /** 工具客单价环比 */
    private String toolPerAmountMom = "--";
    /** 工具客单价同比 */
    private String toolPerAmountYoy = "--";
}
