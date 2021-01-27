package com.example.demo.test.json;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShopGiftDetail implements Serializable {

    @ColumnWidth(24)
    @ExcelProperty(value = "日期", index = 0)
    private String time;

    @ColumnWidth(24)
    @ExcelProperty(value = "领取礼包客户数", index = 1)
    private Long drawPins;

    @ColumnWidth(24)
    @ExcelProperty(value = "引入粉丝数", index = 2)
    private Long leadFollowers;

    @ColumnWidth(24)
    @ExcelProperty(value = "领取京豆人数", index = 3)
    private Long drawJingdouPins;

    @ColumnWidth(24)
    @ExcelProperty(value = "领取积分人数", index = 4)
    private Long drawPointsPins;

    @ColumnWidth(24)
    @ExcelProperty(value = "领取京券人数", index = 5)
    private Long drawJcouponPins;

    @ColumnWidth(24)
    @ExcelProperty(value = "领取东券人数", index = 6)
    private Long drawDcouponPins;

    @ColumnWidth(24)
    @ExcelProperty(value = "使用京券人数", index = 7)
    private Long useJcouponPins;

    @ColumnWidth(24)
    @ExcelProperty(value = "使用东券人数", index = 8)
    private Long useDcouponPins;

    @ColumnWidth(24)
    @ExcelProperty(value = "券引入订单数", index = 9)
    private Long dealOrdnum;

    @ColumnWidth(24)
    @ExcelProperty(value = "券引入订单金额", index = 10)
    private Double dealAmount;

    public void setLeadFollowers(Long leadFollowers) {
        this.leadFollowers = leadFollowers == null ? 0 : leadFollowers;
    }

    //    public void setTime(String time) {
//        this.time = DateUtil.format(time, DateUtil.YYYYMMDD, DateUtil.YYYY_MM_DD);
//    }
//
//    public void setDealAmount(Double dealAmount) {
//        this.dealAmount = CalcUtil.doubleFormat2(dealAmount);
//    }
}
