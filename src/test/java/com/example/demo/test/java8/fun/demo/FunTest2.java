package com.example.demo.test.java8.fun.demo;

import cn.hutool.core.bean.BeanUtil;
import org.apache.commons.lang3.StringUtils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FunTest2 {

    public String getYesterday(String date){
        LocalDate today = LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        LocalDate yesterday = today.minusDays(1);
        return yesterday.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }

    /**
     * 判断是否选中多个事业群
     * @param qcrQueryVO
     * @return true-是；false-否
     */
    private boolean isMultiBuId(QcrQueryVO qcrQueryVO){
        if(StringUtils.isNotBlank(qcrQueryVO.getBuId())){
            String[] buIds = qcrQueryVO.getBuId().split(",");
            return buIds.length > 1 ? true : false;
        }
        return false;
    }

    /**
     * 构建环比查询部门id
     * @param qcrQueryVO
     * @param deptIds
     */
    private void buildDeptIds(QcrQueryVO qcrQueryVO, String deptIds){
        //判断选中哪级部门，注：判断有先后顺序
        //选中三级部门，展示三级部门
        if(StringUtils.isNotBlank(qcrQueryVO.getDeptId3())){
            qcrQueryVO.setDeptId3(deptIds);
            return;
        }
        //选中二级部门，展示三级部门
        if(StringUtils.isNotBlank(qcrQueryVO.getDeptId2())){
            qcrQueryVO.setDeptId3(deptIds);
            return;
        }
        //选中一级部门，展示二级部门
        if(StringUtils.isNotBlank(qcrQueryVO.getDeptId1())){
            qcrQueryVO.setDeptId2(deptIds);
            return;
        }
        //未选中部门，只选中事业群，判断是否选中多个事业群，如只选中一个事业群，则展示的该事业群下的一级部门
        if(!isMultiBuId(qcrQueryVO)){
            qcrQueryVO.setDeptId1(deptIds);
            return;
        }
        qcrQueryVO.setBuId(deptIds);
    }


    private Map<String, Object> encaseContrastVO(List<QualityIndexDeptVO> currDeptVo, QcrQueryVO qcrQueryVO){
        QcrQueryVO contrastVO = new QcrQueryVO();
        BeanUtil.copyProperties(qcrQueryVO, contrastVO);
        contrastVO.setIsCalculateMom("1");
        contrastVO.setDate(getYesterday(qcrQueryVO.getDate()));
        String deptIds = currDeptVo.parallelStream().map(QualityIndexDeptVO::getDeptId).collect(Collectors.joining(","));
        buildDeptIds(contrastVO, deptIds);
        Map<String, Object> param = BeanUtil.beanToMap(contrastVO);
        param.put("multiBuId", isMultiBuId(qcrQueryVO) ? 2 : 1);
        return param;
    }

    private Map<String, Object> encaseContrastVO(String deptIds, QcrQueryVO qcrQueryVO){
        QcrQueryVO contrastVO = new QcrQueryVO();
        BeanUtil.copyProperties(qcrQueryVO, contrastVO);
        contrastVO.setIsCalculateMom("1");
        contrastVO.setDate(getYesterday(qcrQueryVO.getDate()));
        buildDeptIds(contrastVO, deptIds);
        Map<String, Object> param = BeanUtil.beanToMap(contrastVO);
        param.put("multiBuId", isMultiBuId(qcrQueryVO) ? 2 : 1);
        return param;
    }


    public Map<String, Object> display(String buId, Function<QcrQueryVO, Map<String, Object>> function){
        QcrQueryVO qcrQueryVO = new QcrQueryVO();
        qcrQueryVO.setBuId(buId);
        return function.apply(qcrQueryVO);
    }

    public Map<String, Object> encaseName(QcrQueryVO qcrQueryVO){
        Map<String, Object> map = new HashMap<>();
        map.put("buId", qcrQueryVO.getBuId());
        return map;
    }

    public void handle(){
        System.out.println(display("1001", (qcrQueryVO) -> encaseName(qcrQueryVO)));
    }


    public static void main(String[] args) {
        FunTest2 test = new FunTest2();
        test.handle();
    }

}
