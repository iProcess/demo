package com.example.demo.test.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class List2StrTest1 {

    public static void main(String[] args) {
        List<QualityIndexDeptVO> currDeptVo = new ArrayList<>();

        QualityIndexDeptVO deptVO1 = new QualityIndexDeptVO();
        deptVO1.setDeptId("1");
        deptVO1.setDeptName("test1");
        deptVO1.setAaGradeCount(1L);
        deptVO1.setAGradeCount(2L);
        deptVO1.setBGradeCount(3L);
        deptVO1.setCGradeCount(4L);
        deptVO1.setDGradeCount(5L);
        deptVO1.setSpuTotal(100L);

        QualityIndexDeptVO deptVO2 = new QualityIndexDeptVO();
        deptVO2.setDeptId("2");
        deptVO2.setDeptName("test2");
        deptVO2.setAaGradeCount(1L);
        deptVO2.setAGradeCount(2L);
        deptVO2.setBGradeCount(3L);
        deptVO2.setCGradeCount(4L);
        deptVO2.setDGradeCount(5L);
        deptVO2.setSpuTotal(100L);

        currDeptVo.add(deptVO1);
        currDeptVo.add(deptVO2);

        String deptIds = currDeptVo.parallelStream().map(QualityIndexDeptVO::getDeptId).collect(Collectors.joining(","));
        System.out.println(deptIds);
    }
}
