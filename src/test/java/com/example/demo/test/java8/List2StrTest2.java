package com.example.demo.test.java8;

import cn.hutool.core.bean.BeanUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class List2StrTest2 {

    public static void main(String[] args) {
        List<QualityIndexDeptVO> currDeptVo = new ArrayList<>();
        List<Map<String, Object>> listMap = new ArrayList<>();

        Map<String, Object> map1 = new HashMap<>();
        map1.put("deptId", "1");
        map1.put("deptName", "test1");
        map1.put("aaGradeCount", 1L);
        map1.put("aGradeCount", 2L);
        map1.put("bGradeCount", 3L);
        map1.put("cGradeCount", 4L);
        map1.put("dGradeCount", 5L);
        map1.put("spuTotal", 100L);

        Map<String, Object> map2 = new HashMap<>();
        map2.put("deptId", "2");
        map2.put("deptName", "test2");
        map2.put("aaGradeCount", 1L);
        map2.put("aGradeCount", 2L);
        map2.put("bGradeCount", 3L);
        map2.put("cGradeCount", 4L);
        map2.put("dGradeCount", 5L);
        map2.put("spuTotal", 100L);

        listMap.add(map1);
        listMap.add(map2);

        currDeptVo = listMap.stream()
                .map(originMap -> BeanUtil.mapToBean(originMap, QualityIndexDeptVO.class, true))
                .collect(Collectors.toList());

        String deptIds = currDeptVo.parallelStream().map(QualityIndexDeptVO::getDeptId).collect(Collectors.joining(","));
        System.out.println(deptIds);
    }
}
