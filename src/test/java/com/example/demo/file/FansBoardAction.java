package com.example.demo.file;


import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Slf4j
public class FansBoardAction {

    //private static final String FANS_COLUMN="pop.crm.shop.java.fansboardaction.fanscolumn";
    //private static final String DATA_DETAILS="pop.crm.shop.java.fansboardaction.skufanactivitydatadetails";

    private static final String FANS_COLUMN="商品id,商品名称,订单量,GMV,销量,以粉丝价下单订单量,以粉丝价下单GMV,以粉丝价下单销量";
    private static final String DATA_DETAILS="SKU粉丝活动数据明细";

    public void export(){
        //HttpServletResponse response = ServletActionContext.getResponse();
        HttpServletResponse response = null;
        String sTitle = FANS_COLUMN;
        String fName = DATA_DETAILS;
        String mapKey = "skuId,skuName,orderCount,gmv,sales,fpOrderCount,fpGmv,fpSales";
        List<Map<String,Object>> list = new ArrayList<>();
        try (final OutputStream os = response.getOutputStream()) {
            ExportUtil.responseSetProperties(fName, response);
            ExportUtil.doExport(list, sTitle, mapKey, os);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }

    }


}
