package com.example.demo.test.sw;

public enum ToolEnum {
    /*
     *   维度
     * */
    DIM_VENDER_ID("dim_vender_id","商家ID"),
    DIM_TOOL_NAME("dim_tool_name", "工具名称"),
    /*
    *   交易指标
    * */
    INDEX_SHOP_ACT_COUNT("index_shop_act_count", "工具生效活动数指标"),
    INDEX_CATE_TOOL_DEAL_AMOUNT("index_category_tool_deal_amount", "工具成交金额指标"),
    INDEX_TOOL_DEAL_AMOUNT("index_tool_deal_amount", "工具成交金额指标"),
    INDEX_TOOL_DEAL_ORDER_COUNT("index_tool_deal_order_count","工具成交子单量指标"),
    INDEX_TOOL_DEAL_ORDER_USER_COUNT("index_tool_deal_order_user_count","工具有效成交客户数指标"),
    INDEX_TOOL_PER_AMOUNT("index_tool_per_amount","工具客单价指标"),
    INDEX_TOOL_VALID_ORDER_COUNT("index_tool_valid_order_count", "工具有效子单量指标"),

    /*
    *  渗透指标
    * */
    MARKET_YEAR_SHOP_COUNT("market_year_shop_count", "营销年累计渗透店铺数"),
    MARKET_EFFECTIVE_SHOP_COUNT("market_effective_shop_count", "营销活跃渗透店铺数"),
    END_TERM_EFFECTIVE_SHOP_COUNT("end_term_effective_shop_count","期末有效状态店铺数"),
    END_TERM_MANAGEMENT_STATUS_SHOP_COUNT("end_term_management_status_shop_count","期末经营状态店铺数"),
    EFFECTIVE_STATUS_YEAR_COUNT("effective_status_year_count","有效状态年累计渗透率"),
    MANAGEMENT_STATUS_YEAR_COUNT("management_status_year_count", "经营状态年累计渗透率"),
    MANAGEMENT_STATUS_MARKET_EFFECTIVE_COUNT("management_status_market_effective_count", "经营状态营销活跃渗透率"),
    EFFECTIVE_MARKET_ACTIVE_COUNT("effective_market_active_count","有效状态营销活跃渗透率"),
    END_TERM_NO_SHOP_COUNT("end_term_no_shop_count", "期末营销未渗透经营店铺数"),
    END_TERM_NO_EFFECTIVE_SHOP_COUNT("end_term_no_effective_shop_count", "期末营销未渗透有效店铺数");
    ToolEnum(String name, String desc){
        this.name = name;
        this.desc = desc;
    }
    private String name;
    private String desc;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
    public static ToolEnum getToolEnum(String name){
        for(ToolEnum toolEnum : ToolEnum.values()){
            if (name.equals(toolEnum.getName())){
                return toolEnum;
            }
        }
        return null;
    }

}
