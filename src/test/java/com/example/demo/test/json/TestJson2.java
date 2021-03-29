package com.example.demo.test.json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;

public class TestJson2 {

    public static void main(String[] args) {
        String json = "{\n" +
                "    \"list\": [\n" +
                "        {\n" +
                "            \"buId\": 1727, \n" +
                "            \"closeTm\": \"\", \n" +
                "            \"deptId1\": 33, \n" +
                "            \"deptId2\": 48, \n" +
                "            \"deptId3\": 1048, \n" +
                "            \"deptId4\": 1058, \n" +
                "            \"deptName1\": \"消费品事业部\", \n" +
                "            \"deptName2\": \"母婴采销部\", \n" +
                "            \"deptName3\": \"洗护用品\", \n" +
                "            \"deptName4\": \"洗护用品岗\", \n" +
                "            \"majorSuppBrevityCode\": \"\", \n" +
                "            \"openTm\": \"2012-09-29 02:00:27.0\", \n" +
                "            \"productFlag\": 0, \n" +
                "            \"purchaserErpAcct\": \"\", \n" +
                "            \"salerOperErpAcct\": \"duning1\", \n" +
                "            \"shopId\": 10146, \n" +
                "            \"shopName\": \"POKO母婴护理旗舰店\", \n" +
                "            \"skuNum\": 105, \n" +
                "            \"spuNum\": 76, \n" +
                "            \"toolDealAmount\": \"0.00\", \n" +
                "            \"toolDealAmountMom\": \"--\", \n" +
                "            \"toolDealAmountYoy\": \"--\", \n" +
                "            \"toolDealOrderCount\": \"0\", \n" +
                "            \"toolDealOrderCountMom\": \"--\", \n" +
                "            \"toolDealOrderCountYoy\": \"--\", \n" +
                "            \"toolDealOrderUserCount\": \"0\", \n" +
                "            \"toolDealOrderUserCountMom\": \"--\", \n" +
                "            \"toolDealOrderUserCountYoy\": \"--\", \n" +
                "            \"toolName\": \"\", \n" +
                "            \"toolPerAmount\": \"0.00\", \n" +
                "            \"toolPerAmountMom\": \"--\", \n" +
                "            \"toolPerAmountYoy\": \"--\", \n" +
                "            \"toolValidOrderCount\": \"0\", \n" +
                "            \"toolValidOrderCountMom\": \"--\", \n" +
                "            \"toolValidOrderCountYoy\": \"--\", \n" +
                "            \"venderId\": 10118\n" +
                "        }, \n" +
                "        {\n" +
                "            \"buId\": 1727, \n" +
                "            \"closeTm\": \"\", \n" +
                "            \"deptId1\": 33, \n" +
                "            \"deptId2\": 425, \n" +
                "            \"deptId3\": 1618, \n" +
                "            \"deptId4\": 1619, \n" +
                "            \"deptName1\": \"消费品事业部\", \n" +
                "            \"deptName2\": \"酒类采销部\", \n" +
                "            \"deptName3\": \"洋酒组\", \n" +
                "            \"deptName4\": \"洋酒组\", \n" +
                "            \"majorSuppBrevityCode\": \"\", \n" +
                "            \"openTm\": \"2012-11-19 02:00:04.0\", \n" +
                "            \"productFlag\": 0, \n" +
                "            \"purchaserErpAcct\": \"\", \n" +
                "            \"salerOperErpAcct\": \"huozhenzhen3\", \n" +
                "            \"shopId\": 10191, \n" +
                "            \"shopName\": \"诚善堂酒类专营店\", \n" +
                "            \"skuNum\": 6, \n" +
                "            \"spuNum\": 6, \n" +
                "            \"toolDealAmount\": \"0.00\", \n" +
                "            \"toolDealAmountMom\": \"--\", \n" +
                "            \"toolDealAmountYoy\": \"--\", \n" +
                "            \"toolDealOrderCount\": \"0\", \n" +
                "            \"toolDealOrderCountMom\": \"--\", \n" +
                "            \"toolDealOrderCountYoy\": \"--\", \n" +
                "            \"toolDealOrderUserCount\": \"0\", \n" +
                "            \"toolDealOrderUserCountMom\": \"--\", \n" +
                "            \"toolDealOrderUserCountYoy\": \"--\", \n" +
                "            \"toolName\": \"\", \n" +
                "            \"toolPerAmount\": \"0.00\", \n" +
                "            \"toolPerAmountMom\": \"--\", \n" +
                "            \"toolPerAmountYoy\": \"--\", \n" +
                "            \"toolValidOrderCount\": \"0\", \n" +
                "            \"toolValidOrderCountMom\": \"--\", \n" +
                "            \"toolValidOrderCountYoy\": \"--\", \n" +
                "            \"venderId\": 10166\n" +
                "        }\n" +
                "    ], \n" +
                "    \"pageCount\": 188, \n" +
                "    \"pageNumber\": 1, \n" +
                "    \"pageSize\": 2, \n" +
                "    \"totalCount\": 376\n" +
                "}";

        PageInfo<ShopToolDetails> pageInfo = JSON.parseObject(json, new TypeReference<PageInfo<ShopToolDetails>>(){});
        //需要全参数的构造函数
        System.out.println(JSON.toJSONString(pageInfo));

        PageInfo<ShopToolDetailsResponse> resultPageInfo = JSON.parseObject(JSON.toJSONString(pageInfo), new TypeReference<PageInfo<ShopToolDetailsResponse>>(){});
        //需要全参数的构造函数
        System.out.println(JSON.toJSONString(resultPageInfo));
    }
}
