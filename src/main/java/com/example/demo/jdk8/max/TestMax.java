package com.example.demo.jdk8.max;

import com.alibaba.fastjson.JSON;

import java.math.BigDecimal;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author shijincheng
 * @version V1.0
 * date 2020/2/10 15:51
 * Description: TODO
 */
public class TestMax {

    public static void main(String[] args) {

        List<String> strs = Arrays.asList("d", "b", "a", "c", "a");
        Optional<String> min = strs.stream().min(Comparator.comparing(Function.identity()));
        Optional<String> max = strs.stream().max((o1, o2) -> o1.compareTo(o2));
        System.out.println(String.format("min:%s; max:%s", min.get(), max.get()));// min:a; max:d

        CouponInfo info1 = new CouponInfo();
        info1.setBatchKey("123");
        info1.setDiscount(new BigDecimal(40));
        info1.setCondition(new BigDecimal(100));
        info1.setType(0);

        CouponInfo info2 = new CouponInfo();
        info2.setBatchKey("124");
        info2.setDiscount(new BigDecimal(100));
        info2.setCondition(new BigDecimal(200));
        info2.setType(1);

        CouponInfo info3 = new CouponInfo();
        info3.setBatchKey("125");
        info3.setDiscount(new BigDecimal(110));
        info3.setCondition(new BigDecimal(300));
        info3.setType(0);

        List<CouponInfo> couponInfos = new ArrayList<>();
        couponInfos.add(info1);
        couponInfos.add(info2);
        couponInfos.add(info3);

        System.out.println("max前：" + JSON.toJSONString(couponInfos));

        List<CouponInfo> couponList = new ArrayList<>();
        if(couponInfos != null && !couponInfos.isEmpty()){
            CouponInfo couponInfo = couponInfos.stream().max((c1, c2) -> {
                BigDecimal decimal1 = c1.getDiscount().divide(c1.getCondition(),4, BigDecimal.ROUND_HALF_UP);
                BigDecimal decimal2 = c2.getDiscount().divide(c2.getCondition(),4, BigDecimal.ROUND_HALF_UP);
                return decimal1.compareTo(decimal2);
            }).get();
            System.out.println("max后：" + JSON.toJSONString(couponInfo));
            couponList.addAll(Arrays.asList(couponInfo));
            System.out.println("max list后：" + JSON.toJSONString(couponList));
        }
        /**
         * Exception in thread "main" java.lang.ArithmeticException: Non-terminating decimal expansion; no exact representable decimal result.
         * 参照：https://www.cnblogs.com/LeoBoy/p/5897754.html
         *
         *
         * java.lang.ArithmeticException: Non-terminating decimal expansion; no exact representable decimal result异常的解决方法
         * 场景描述#
         * 今天在写一个JAVA程序的时候出现了异常：java.lang.ArithmeticException: Non-terminating decimal expansion; no exact representable decimal result。
         * 发现报错的语句是：
         *
         * foo.divide(bar));
         *
         *
         * 解决方法#
         * 原来JAVA中如果用BigDecimal做除法的时候一定要在divide方法中传递第二个参数，定义精确到小数点后几位，否则在不整除的情况下，结果是无限循环小数时，就会抛出以上异常。
         *
         * foo.divide(bar, 2, BigDecimal.ROUND_HALF_UP);
         *
         */
        //BigDecimal decimal = info3.getDiscount().divide(info3.getCondition()).setScale(4, BigDecimal.ROUND_HALF_UP);
        //System.out.println(JSON.toJSONString(decimal));

        Optional<CouponInfo> optional1 = couponInfos.stream().collect(Collectors.maxBy(Comparator.comparing(CouponInfo::getType)));
        System.out.println("maxBy后：" + JSON.toJSONString(optional1));

        Optional<CouponInfo> optional2 = couponInfos.stream().max(Comparator.comparing(CouponInfo::getType));
        System.out.println("max后：" + JSON.toJSONString(optional2));
    }
}
