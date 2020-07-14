package com.example.demo.jdk8.map.fm;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Slf4j
public class MergeList {

    public static void main(String[] args) {
        List<CustomerScaleDataVO> scaleDataList = JSON.parseArray(getStr1(), CustomerScaleDataVO.class);
        List<CustomerOrderRangeDataVO> orderDataList = JSON.parseArray(getStr2(), CustomerOrderRangeDataVO.class);

        List<Map<String, Object>> listMap = mergeList(scaleDataList, orderDataList);

        log.info(JSON.toJSONString(listMap));

    }

    public static List<Map<String, Object>> mergeList(List<CustomerScaleDataVO> scaleDataList, List<CustomerOrderRangeDataVO> orderDataList){
        log.error("CustomerDataController->mergeList, scaleDataList:{}", JSON.toJSONString(scaleDataList));
        log.error("CustomerDataController->mergeList, orderDataList:{}", JSON.toJSONString(orderDataList));
        if(CollectionUtils.isEmpty(scaleDataList) || CollectionUtils.isEmpty(orderDataList)){
            return null;
        }

        Map<String, CustomerOrderRangeDataVO> orderDataMap = orderDataList.stream().collect(Collectors.toMap(CustomerOrderRangeDataVO::getCreateDate, Function.identity()));

        List<CustomerScaleOrderDataVO> dataVOList1 = scaleDataList.stream()
                .map(scale -> {
                    CustomerScaleOrderDataVO dataVO = new CustomerScaleOrderDataVO();
                    dataVO.setTotalCustCount(scale.getCustCount());
                    dataVO.setOrdCustCount(scale.getOrdCustCount());
                    dataVO.setActiveCustCount(scale.getActiveCustCount());
                    dataVO.setNewCustCount(scale.getNewCustCount());
                    dataVO.setCreateDate(scale.getCreateDate());

                    CustomerOrderRangeDataVO orderData = orderDataMap.get(scale.getCreateDate());
                    dataVO.setCustCount(orderData == null ? 0 : orderData.getCustCount());
                    dataVO.setCustOrdCount(orderData == null ? 0 : orderData.getCustOrdCount());
                    dataVO.setCustOrdAmount(orderData == null ? 0.00 : orderData.getCustOrdAmount());

                    return dataVO;

                }).collect(Collectors.toList());
        System.out.println(JSON.toJSONString(dataVOList1));
        System.out.println(dataVOList1.size());


        List<CustomerScaleOrderDataVO> dataVOList = scaleDataList.stream()
                .flatMap(scale -> orderDataList.stream()
                        .filter(order -> order.getCreateDate().equals(scale.getCreateDate()))
                        .map(order -> {
                            CustomerScaleOrderDataVO dataVO = new CustomerScaleOrderDataVO();
                            BeanUtils.copyProperties(scale, dataVO);
                            dataVO.setTotalCustCount(scale.getCustCount());
                            BeanUtils.copyProperties(order, dataVO);
                            return dataVO;
                        }))
                .collect(Collectors.toList());




        log.error("CustomerDataController->mergeList, dataVOList:{}", JSON.toJSONString(dataVOList));
        return JSON.parseObject(JSON.toJSONString(dataVOList), List.class);
    }


    public static String getStr2(){
        String str = "[\n" +
                "    {\n" +
                "        \"createDate\": \"2020-04-23\", \n" +
                "        \"custCount\": 2, \n" +
                "        \"custOrdAmount\": 0.03, \n" +
                "        \"custOrdCount\": 3, \n" +
                "        \"updateTime\": \"2020-07-01 20:05:05\"\n" +
                "    }, \n" +
                "    {\n" +
                "        \"createDate\": \"2020-04-27\", \n" +
                "        \"custCount\": 1, \n" +
                "        \"custOrdAmount\": 0.03, \n" +
                "        \"custOrdCount\": 3, \n" +
                "        \"updateTime\": \"2020-07-01 20:05:05\"\n" +
                "    }, \n" +
                "    {\n" +
                "        \"createDate\": \"2020-05-16\", \n" +
                "        \"custCount\": 1, \n" +
                "        \"custOrdAmount\": 0.01, \n" +
                "        \"custOrdCount\": 1, \n" +
                "        \"updateTime\": \"2020-07-01 20:05:05\"\n" +
                "    }, \n" +
                "    {\n" +
                "        \"createDate\": \"2020-07-10\", \n" +
                "        \"custCount\": 1, \n" +
                "        \"custOrdAmount\": 0.03, \n" +
                "        \"custOrdCount\": 2, \n" +
                "        \"updateTime\": \"2020-07-11 10:15:59\"\n" +
                "    }\n" +
                "]";
        return str;
    }

    public static String getStr1(){
        String str = "[\n" +
                "    {\n" +
                "        \"activeCustCount\": 11, \n" +
                "        \"createDate\": \"2020-06-01\", \n" +
                "        \"custCount\": 153, \n" +
                "        \"newCustCount\": 8, \n" +
                "        \"ordCustCount\": 16, \n" +
                "        \"orderDate\": 1590940800000, \n" +
                "        \"updateTime\": \"2020-07-06 17:30:24\"\n" +
                "    }, \n" +
                "    {\n" +
                "        \"activeCustCount\": 2, \n" +
                "        \"createDate\": \"2020-06-02\", \n" +
                "        \"custCount\": 155, \n" +
                "        \"newCustCount\": 2, \n" +
                "        \"ordCustCount\": 16, \n" +
                "        \"orderDate\": 1591027200000, \n" +
                "        \"updateTime\": \"2020-07-06 17:30:24\"\n" +
                "    }, \n" +
                "    {\n" +
                "        \"activeCustCount\": 11, \n" +
                "        \"createDate\": \"2020-06-03\", \n" +
                "        \"custCount\": 155, \n" +
                "        \"newCustCount\": 0, \n" +
                "        \"ordCustCount\": 16, \n" +
                "        \"orderDate\": 1591113600000, \n" +
                "        \"updateTime\": \"2020-07-06 17:30:24\"\n" +
                "    }, \n" +
                "    {\n" +
                "        \"activeCustCount\": 4, \n" +
                "        \"createDate\": \"2020-06-04\", \n" +
                "        \"custCount\": 155, \n" +
                "        \"newCustCount\": 0, \n" +
                "        \"ordCustCount\": 16, \n" +
                "        \"orderDate\": 1591200000000, \n" +
                "        \"updateTime\": \"2020-07-06 17:30:24\"\n" +
                "    }, \n" +
                "    {\n" +
                "        \"activeCustCount\": 3, \n" +
                "        \"createDate\": \"2020-06-05\", \n" +
                "        \"custCount\": 155, \n" +
                "        \"newCustCount\": 0, \n" +
                "        \"ordCustCount\": 16, \n" +
                "        \"orderDate\": 1591286400000, \n" +
                "        \"updateTime\": \"2020-07-06 17:30:24\"\n" +
                "    }, \n" +
                "    {\n" +
                "        \"activeCustCount\": 0, \n" +
                "        \"createDate\": \"2020-06-06\", \n" +
                "        \"custCount\": 155, \n" +
                "        \"newCustCount\": 0, \n" +
                "        \"ordCustCount\": 16, \n" +
                "        \"orderDate\": 1591372800000, \n" +
                "        \"updateTime\": \"2020-07-06 17:30:24\"\n" +
                "    }, \n" +
                "    {\n" +
                "        \"activeCustCount\": 0, \n" +
                "        \"createDate\": \"2020-06-07\", \n" +
                "        \"custCount\": 155, \n" +
                "        \"newCustCount\": 0, \n" +
                "        \"ordCustCount\": 16, \n" +
                "        \"orderDate\": 1591459200000, \n" +
                "        \"updateTime\": \"2020-07-06 17:30:24\"\n" +
                "    }, \n" +
                "    {\n" +
                "        \"activeCustCount\": 0, \n" +
                "        \"createDate\": \"2020-06-08\", \n" +
                "        \"custCount\": 155, \n" +
                "        \"newCustCount\": 0, \n" +
                "        \"ordCustCount\": 16, \n" +
                "        \"orderDate\": 1591545600000, \n" +
                "        \"updateTime\": \"2020-07-06 17:30:24\"\n" +
                "    }, \n" +
                "    {\n" +
                "        \"activeCustCount\": 2, \n" +
                "        \"createDate\": \"2020-06-09\", \n" +
                "        \"custCount\": 155, \n" +
                "        \"newCustCount\": 0, \n" +
                "        \"ordCustCount\": 16, \n" +
                "        \"orderDate\": 1591632000000, \n" +
                "        \"updateTime\": \"2020-07-06 17:30:24\"\n" +
                "    }, \n" +
                "    {\n" +
                "        \"activeCustCount\": 3, \n" +
                "        \"createDate\": \"2020-06-10\", \n" +
                "        \"custCount\": 155, \n" +
                "        \"newCustCount\": 0, \n" +
                "        \"ordCustCount\": 16, \n" +
                "        \"orderDate\": 1591718400000, \n" +
                "        \"updateTime\": \"2020-07-06 17:30:24\"\n" +
                "    }, \n" +
                "    {\n" +
                "        \"activeCustCount\": 1, \n" +
                "        \"createDate\": \"2020-06-11\", \n" +
                "        \"custCount\": 155, \n" +
                "        \"newCustCount\": 0, \n" +
                "        \"ordCustCount\": 16, \n" +
                "        \"orderDate\": 1591804800000, \n" +
                "        \"updateTime\": \"2020-07-06 17:30:24\"\n" +
                "    }, \n" +
                "    {\n" +
                "        \"activeCustCount\": 1, \n" +
                "        \"createDate\": \"2020-06-12\", \n" +
                "        \"custCount\": 155, \n" +
                "        \"newCustCount\": 0, \n" +
                "        \"ordCustCount\": 16, \n" +
                "        \"orderDate\": 1591891200000, \n" +
                "        \"updateTime\": \"2020-07-06 17:30:24\"\n" +
                "    }, \n" +
                "    {\n" +
                "        \"activeCustCount\": 0, \n" +
                "        \"createDate\": \"2020-06-13\", \n" +
                "        \"custCount\": 155, \n" +
                "        \"newCustCount\": 0, \n" +
                "        \"ordCustCount\": 16, \n" +
                "        \"orderDate\": 1591977600000, \n" +
                "        \"updateTime\": \"2020-07-06 17:30:24\"\n" +
                "    }, \n" +
                "    {\n" +
                "        \"activeCustCount\": 0, \n" +
                "        \"createDate\": \"2020-06-14\", \n" +
                "        \"custCount\": 155, \n" +
                "        \"newCustCount\": 0, \n" +
                "        \"ordCustCount\": 16, \n" +
                "        \"orderDate\": 1592064000000, \n" +
                "        \"updateTime\": \"2020-07-06 17:30:24\"\n" +
                "    }, \n" +
                "    {\n" +
                "        \"activeCustCount\": 1, \n" +
                "        \"createDate\": \"2020-06-15\", \n" +
                "        \"custCount\": 155, \n" +
                "        \"newCustCount\": 0, \n" +
                "        \"ordCustCount\": 16, \n" +
                "        \"orderDate\": 1592150400000, \n" +
                "        \"updateTime\": \"2020-07-06 17:30:24\"\n" +
                "    }, \n" +
                "    {\n" +
                "        \"activeCustCount\": 0, \n" +
                "        \"createDate\": \"2020-06-16\", \n" +
                "        \"custCount\": 155, \n" +
                "        \"newCustCount\": 0, \n" +
                "        \"ordCustCount\": 16, \n" +
                "        \"orderDate\": 1592236800000, \n" +
                "        \"updateTime\": \"2020-07-06 17:30:24\"\n" +
                "    }, \n" +
                "    {\n" +
                "        \"activeCustCount\": 0, \n" +
                "        \"createDate\": \"2020-06-17\", \n" +
                "        \"custCount\": 155, \n" +
                "        \"newCustCount\": 0, \n" +
                "        \"ordCustCount\": 16, \n" +
                "        \"orderDate\": 1592323200000, \n" +
                "        \"updateTime\": \"2020-07-06 17:30:24\"\n" +
                "    }, \n" +
                "    {\n" +
                "        \"activeCustCount\": 0, \n" +
                "        \"createDate\": \"2020-06-18\", \n" +
                "        \"custCount\": 155, \n" +
                "        \"newCustCount\": 0, \n" +
                "        \"ordCustCount\": 16, \n" +
                "        \"orderDate\": 1592409600000, \n" +
                "        \"updateTime\": \"2020-07-06 17:30:24\"\n" +
                "    }, \n" +
                "    {\n" +
                "        \"activeCustCount\": 1, \n" +
                "        \"createDate\": \"2020-06-19\", \n" +
                "        \"custCount\": 155, \n" +
                "        \"newCustCount\": 0, \n" +
                "        \"ordCustCount\": 16, \n" +
                "        \"orderDate\": 1592496000000, \n" +
                "        \"updateTime\": \"2020-07-06 17:30:24\"\n" +
                "    }, \n" +
                "    {\n" +
                "        \"activeCustCount\": 0, \n" +
                "        \"createDate\": \"2020-06-20\", \n" +
                "        \"custCount\": 155, \n" +
                "        \"newCustCount\": 0, \n" +
                "        \"ordCustCount\": 16, \n" +
                "        \"orderDate\": 1592582400000, \n" +
                "        \"updateTime\": \"2020-07-06 17:30:24\"\n" +
                "    }, \n" +
                "    {\n" +
                "        \"activeCustCount\": 1, \n" +
                "        \"createDate\": \"2020-06-21\", \n" +
                "        \"custCount\": 155, \n" +
                "        \"newCustCount\": 0, \n" +
                "        \"ordCustCount\": 16, \n" +
                "        \"orderDate\": 1592668800000, \n" +
                "        \"updateTime\": \"2020-07-06 17:30:24\"\n" +
                "    }, \n" +
                "    {\n" +
                "        \"activeCustCount\": 1, \n" +
                "        \"createDate\": \"2020-06-22\", \n" +
                "        \"custCount\": 155, \n" +
                "        \"newCustCount\": 0, \n" +
                "        \"ordCustCount\": 16, \n" +
                "        \"orderDate\": 1592755200000, \n" +
                "        \"updateTime\": \"2020-07-06 17:30:24\"\n" +
                "    }, \n" +
                "    {\n" +
                "        \"activeCustCount\": 0, \n" +
                "        \"createDate\": \"2020-06-23\", \n" +
                "        \"custCount\": 155, \n" +
                "        \"newCustCount\": 0, \n" +
                "        \"ordCustCount\": 16, \n" +
                "        \"orderDate\": 1592841600000, \n" +
                "        \"updateTime\": \"2020-07-06 17:30:24\"\n" +
                "    }, \n" +
                "    {\n" +
                "        \"activeCustCount\": 0, \n" +
                "        \"createDate\": \"2020-06-24\", \n" +
                "        \"custCount\": 155, \n" +
                "        \"newCustCount\": 0, \n" +
                "        \"ordCustCount\": 16, \n" +
                "        \"orderDate\": 1592928000000, \n" +
                "        \"updateTime\": \"2020-07-06 17:30:24\"\n" +
                "    }, \n" +
                "    {\n" +
                "        \"activeCustCount\": 0, \n" +
                "        \"createDate\": \"2020-06-25\", \n" +
                "        \"custCount\": 155, \n" +
                "        \"newCustCount\": 0, \n" +
                "        \"ordCustCount\": 16, \n" +
                "        \"orderDate\": 1593014400000, \n" +
                "        \"updateTime\": \"2020-07-06 17:30:24\"\n" +
                "    }, \n" +
                "    {\n" +
                "        \"activeCustCount\": 0, \n" +
                "        \"createDate\": \"2020-06-26\", \n" +
                "        \"custCount\": 155, \n" +
                "        \"newCustCount\": 0, \n" +
                "        \"ordCustCount\": 16, \n" +
                "        \"orderDate\": 1593100800000, \n" +
                "        \"updateTime\": \"2020-07-06 17:30:24\"\n" +
                "    }, \n" +
                "    {\n" +
                "        \"activeCustCount\": 0, \n" +
                "        \"createDate\": \"2020-06-27\", \n" +
                "        \"custCount\": 155, \n" +
                "        \"newCustCount\": 0, \n" +
                "        \"ordCustCount\": 16, \n" +
                "        \"orderDate\": 1593187200000, \n" +
                "        \"updateTime\": \"2020-07-06 17:30:24\"\n" +
                "    }, \n" +
                "    {\n" +
                "        \"activeCustCount\": 1, \n" +
                "        \"createDate\": \"2020-06-28\", \n" +
                "        \"custCount\": 155, \n" +
                "        \"newCustCount\": 0, \n" +
                "        \"ordCustCount\": 16, \n" +
                "        \"orderDate\": 1593273600000, \n" +
                "        \"updateTime\": \"2020-07-06 17:30:24\"\n" +
                "    }, \n" +
                "    {\n" +
                "        \"activeCustCount\": 1, \n" +
                "        \"createDate\": \"2020-06-29\", \n" +
                "        \"custCount\": 155, \n" +
                "        \"newCustCount\": 0, \n" +
                "        \"ordCustCount\": 16, \n" +
                "        \"orderDate\": 1593360000000, \n" +
                "        \"updateTime\": \"2020-07-06 17:30:24\"\n" +
                "    }, \n" +
                "    {\n" +
                "        \"activeCustCount\": 1, \n" +
                "        \"createDate\": \"2020-06-30\", \n" +
                "        \"custCount\": 155, \n" +
                "        \"newCustCount\": 0, \n" +
                "        \"ordCustCount\": 16, \n" +
                "        \"orderDate\": 1593446400000, \n" +
                "        \"updateTime\": \"2020-07-06 17:30:24\"\n" +
                "    }, \n" +
                "    {\n" +
                "        \"activeCustCount\": 3, \n" +
                "        \"createDate\": \"2020-07-01\", \n" +
                "        \"custCount\": 158, \n" +
                "        \"newCustCount\": 3, \n" +
                "        \"ordCustCount\": 16, \n" +
                "        \"orderDate\": 1593532800000, \n" +
                "        \"updateTime\": \"2020-07-06 17:30:24\"\n" +
                "    }, \n" +
                "    {\n" +
                "        \"activeCustCount\": 0, \n" +
                "        \"createDate\": \"2020-07-02\", \n" +
                "        \"custCount\": 158, \n" +
                "        \"newCustCount\": 0, \n" +
                "        \"ordCustCount\": 16, \n" +
                "        \"orderDate\": 1593619200000, \n" +
                "        \"updateTime\": \"2020-07-06 17:30:24\"\n" +
                "    }, \n" +
                "    {\n" +
                "        \"activeCustCount\": 0, \n" +
                "        \"createDate\": \"2020-07-03\", \n" +
                "        \"custCount\": 158, \n" +
                "        \"newCustCount\": 0, \n" +
                "        \"ordCustCount\": 16, \n" +
                "        \"orderDate\": 1593705600000, \n" +
                "        \"updateTime\": \"2020-07-06 17:30:24\"\n" +
                "    }, \n" +
                "    {\n" +
                "        \"activeCustCount\": 0, \n" +
                "        \"createDate\": \"2020-07-04\", \n" +
                "        \"custCount\": 158, \n" +
                "        \"newCustCount\": 0, \n" +
                "        \"ordCustCount\": 16, \n" +
                "        \"orderDate\": 1593792000000, \n" +
                "        \"updateTime\": \"2020-07-06 17:30:24\"\n" +
                "    }, \n" +
                "    {\n" +
                "        \"activeCustCount\": 0, \n" +
                "        \"createDate\": \"2020-07-05\", \n" +
                "        \"custCount\": 158, \n" +
                "        \"newCustCount\": 0, \n" +
                "        \"ordCustCount\": 16, \n" +
                "        \"orderDate\": 1593878400000, \n" +
                "        \"updateTime\": \"2020-07-06 17:30:24\"\n" +
                "    }, \n" +
                "    {\n" +
                "        \"activeCustCount\": 1, \n" +
                "        \"createDate\": \"2020-07-06\", \n" +
                "        \"custCount\": 158, \n" +
                "        \"newCustCount\": 0, \n" +
                "        \"ordCustCount\": 16, \n" +
                "        \"orderDate\": 1593964800000, \n" +
                "        \"updateTime\": \"2020-07-07 10:31:29\"\n" +
                "    }, \n" +
                "    {\n" +
                "        \"activeCustCount\": 6, \n" +
                "        \"createDate\": \"2020-07-07\", \n" +
                "        \"custCount\": 162, \n" +
                "        \"newCustCount\": 4, \n" +
                "        \"ordCustCount\": 16, \n" +
                "        \"orderDate\": 1594051200000, \n" +
                "        \"updateTime\": \"2020-07-08 08:44:57\"\n" +
                "    }, \n" +
                "    {\n" +
                "        \"activeCustCount\": 3, \n" +
                "        \"createDate\": \"2020-07-08\", \n" +
                "        \"custCount\": 162, \n" +
                "        \"newCustCount\": 0, \n" +
                "        \"ordCustCount\": 16, \n" +
                "        \"orderDate\": 1594137600000, \n" +
                "        \"updateTime\": \"2020-07-09 08:54:30\"\n" +
                "    }, \n" +
                "    {\n" +
                "        \"activeCustCount\": 1, \n" +
                "        \"createDate\": \"2020-07-09\", \n" +
                "        \"custCount\": 162, \n" +
                "        \"newCustCount\": 0, \n" +
                "        \"ordCustCount\": 16, \n" +
                "        \"orderDate\": 1594224000000, \n" +
                "        \"updateTime\": \"2020-07-10 08:40:27\"\n" +
                "    }, \n" +
                "    {\n" +
                "        \"activeCustCount\": 2, \n" +
                "        \"createDate\": \"2020-07-10\", \n" +
                "        \"custCount\": 162, \n" +
                "        \"newCustCount\": 0, \n" +
                "        \"ordCustCount\": 17, \n" +
                "        \"orderDate\": 1594310400000, \n" +
                "        \"updateTime\": \"2020-07-11 08:53:52\"\n" +
                "    }, \n" +
                "    {\n" +
                "        \"activeCustCount\": 1, \n" +
                "        \"createDate\": \"2020-07-11\", \n" +
                "        \"custCount\": 162, \n" +
                "        \"newCustCount\": 0, \n" +
                "        \"ordCustCount\": 17, \n" +
                "        \"orderDate\": 1594396800000, \n" +
                "        \"updateTime\": \"2020-07-12 08:45:41\"\n" +
                "    }, \n" +
                "    {\n" +
                "        \"activeCustCount\": 1, \n" +
                "        \"createDate\": \"2020-07-12\", \n" +
                "        \"custCount\": 163, \n" +
                "        \"newCustCount\": 1, \n" +
                "        \"ordCustCount\": 17, \n" +
                "        \"orderDate\": 1594483200000, \n" +
                "        \"updateTime\": \"2020-07-13 08:47:30\"\n" +
                "    }\n" +
                "]\n";
        return str;
    }

}
