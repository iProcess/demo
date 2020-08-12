package com.example.demo.java8;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MapFilterTest {

    public static List<ToolActivity> combineToolAnaly(List<ToolActivity> toolActivities){
        //工具生效活动数
        toolActivities = CollectionUtils.isEmpty(toolActivities) ? Lists.newArrayList(new ToolActivity()) : toolActivities;
        Map<String, ToolActivity> toolActivityMap = toolActivities.parallelStream()
                .filter(activity -> StringUtils.isNotBlank(activity.getToolName()))
                .collect(Collectors.toMap(ToolActivity::getToolName, Function.identity(), (k1, k2) -> k2, ConcurrentHashMap::new));
        //工具生效活动数
        ToolActivity toolActivity = toolActivityMap.get("会员券") != null ? toolActivityMap.get("会员券") : new ToolActivity();

        return Lists.newArrayList(toolActivity);
    }

    public static void main(String[] args) {
        System.out.println(combineToolAnaly(null));
    }

}


