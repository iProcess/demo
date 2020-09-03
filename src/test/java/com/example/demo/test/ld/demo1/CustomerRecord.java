package com.example.demo.test.ld.demo1;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@Data
public class CustomerRecord implements Serializable {
    private String recordId;  //记录唯一ID
    private String venderId = null;
    private String customerPin;
    private int level = 1;
    private int oldLevel = 1;
    private boolean customerFlag = false;  /* 是否是会员 */
    private int customerType = -1;  // 会员类型（1-绑定；2-注册完成；3-注册未完成）
    /* 附属信息 */
    private String mobile;
    private String cardNo;
    private long createTime;
    private int channel;
    /* 计算等级使用字段 */
    private String subVenderList = null;  /* 查询hbase 使用字段 */
    private String hbaseTable;      /* 查询hbase 表名 */
    private boolean calc;   /* 是否计算等级 */
    private String levelRule;
    /* 是否输出 */
    private boolean outflag = false;
    private boolean hasServices;
    private Long totalPrice;  // 店铺总消费金额
    private Long totalCount;  // 店铺总订单数
    //private String subVenderId;  //子店铺Id
    //private Long subPrice;  // 子店铺消费金额
    //private Long subCount;  // 子店铺订单数
    //private int subIndex;    // 店铺索引
    //private int venderCount;   //子店铺个数
    private long genDataTime;  //生成对象时间
    private long hbaseConsumeTime = -1;//查询hbase耗时
    //private boolean flatFlag = false; //是否展开subVenderList

    public static boolean isBrand(CustomerRecord r) {
        return r.venderId.length() == 15;
    }

    public static CustomerRecord genCustomerRecord(String json) {
        CustomerRecord record = new CustomerRecord();
        record.recordId = UUID.randomUUID().toString();

        JSONObject jsonObject = JSON.parseObject(json);
        record.venderId = jsonObject.getString("brandsId");
        if (record.venderId == null) {
            record.venderId = jsonObject.getString("venderId");
        }

        record.customerPin = jsonObject.getString("customerPin");
        record.mobile = jsonObject.getString("mobile");
        if (record.mobile == null) {
            record.mobile = jsonObject.getString("phoneNo");
        }

        /* 判断是否是会员 */
        if (jsonObject.containsKey("isCustomer")) {
            /* 订单消息带有会员标志 isCustomer */
            record.customerFlag = jsonObject.getBoolean("isCustomer");
            //record.outflag = false;
        } else if (jsonObject.containsKey("customerType")) {
            record.customerType = jsonObject.getIntValue("customerType");
            /* 新开卡 customerType 1,2 是会员 */
            if (record.customerType == 1 || record.customerType == 2) {
                record.customerFlag = true;
                //record.outflag = true;
            }
        } else {
            record.customerFlag = false;
            //record.outflag = false;
        }

        String tmpLevel = jsonObject.getString("customerLevel");
        if (tmpLevel != null) {
            record.level = Integer.parseInt(tmpLevel);
            record.oldLevel = record.level;
        }
        record.cardNo = jsonObject.getString("cardNo");
        if(jsonObject.containsKey("orderId")){ // 订单取完成时间
            record.createTime = 123L;
        }else{ //开卡去创建时间
            record.createTime = 123L;
        }
        Integer chl = jsonObject.getInteger("channel");
        if (chl != null) {
            record.channel = chl;
        }
        record.setGenDataTime(new Date().getTime());
        return record;
    }

    public static CustomerRecord createCustomerRecord(CustomerRecord r) {
        CustomerRecord record = new CustomerRecord();
        record.recordId = r.recordId;
        record.venderId = r.venderId;
        record.customerPin = r.customerPin;
        record.level = r.level;
        record.oldLevel = r.oldLevel;
        record.customerFlag = r.customerFlag;
        record.customerType = r.customerType;
        record.mobile = r.mobile;
        record.cardNo = r.cardNo;
        record.createTime = r.createTime;
        record.channel = r.channel;
        record.hbaseTable = r.hbaseTable;
        record.calc = r.calc;
        record.outflag = r.outflag;
        record.hasServices = r.hasServices;
        record.totalPrice = r.totalPrice;
        record.totalCount = r.totalCount;
        record.subVenderList = r.subVenderList;
        record.levelRule = r.levelRule;
        record.genDataTime = r.genDataTime;
        record.hbaseConsumeTime = r.hbaseConsumeTime;
        return record;
    }

    @Override
    public String toString() {
        return "CustomerRecord{" +
                "recordId='" + recordId + '\'' +
                ", venderId='" + venderId + '\'' +
                ", customerPin='" + customerPin + '\'' +
                ", level=" + level +
                ", oldLevel=" + oldLevel +
                ", customerFlag=" + customerFlag +
                ", customerType=" + customerType +
                ", mobile='" + mobile + '\'' +
                ", cardNo='" + cardNo + '\'' +
                ", createTime=" + createTime +
                ", channel=" + channel +
                ", subVenderList='" + subVenderList + '\'' +
                ", hbaseTable='" + hbaseTable + '\'' +
                ", calc=" + calc +
                ", levelRule='" + levelRule + '\'' +
                ", outflag=" + outflag +
                ", hasServices=" + hasServices +
                ", totalPrice=" + totalPrice +
                ", totalCount=" + totalCount +
                ", genDataTime=" + genDataTime +
                ", hbaseConsumeTime=" + hbaseConsumeTime +
                '}';
    }
}
