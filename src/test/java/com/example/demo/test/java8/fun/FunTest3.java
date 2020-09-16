package com.example.demo.test.java8.fun;

import cn.hutool.core.bean.BeanUtil;
import com.alibaba.fastjson.JSON;
import org.apache.commons.lang3.StringUtils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * https://blog.csdn.net/u010191034/article/details/87623030
 * https://www.jianshu.com/p/8dc46a2dc21d
 */
public class FunTest3 {

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

    private List<QualityIndexDeptVO> combineDept(List<QualityIndexDeptVO> currDeptList, List<QualityIndexDeptVO> contrastDeptList){
        log.info("QualityIndexDeptServiceImpl->combineDept, currDeptList:{}, contrastDeptList:{}", JSON.toJSONString(currDeptList), JSON.toJSONString(contrastDeptList));
        //当前部门以deptId分组
        Map<String, QualityIndexDeptVO> currDeptMap = currDeptList.stream()
                .collect(Collectors.toMap(QualityIndexDeptVO::getDeptId,Function.identity(),(k1, k2) -> k2, ConcurrentHashMap::new));
        //前一日部门以deptId分组
        Map<String, QualityIndexDeptVO> contrastDeptMap = contrastDeptList.stream()
                .collect(Collectors.toMap(QualityIndexDeptVO::getDeptId,Function.identity(),(k1, k2) -> k2, ConcurrentHashMap::new));
        //计算环比
        currDeptMap.keySet().forEach(key -> {
            QualityIndexUtils.setMomCount(currDeptMap.get(key), contrastDeptMap.getOrDefault(key, new QualityIndexDeptVO()));
        });
        log.info("QualityIndexDeptServiceImpl->combineDept, currDeptList:{}", JSON.toJSONString(currDeptList));
        return currDeptList;
    }

    public <T, R> R display(Function<T, R> mapper, T ){
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
        FunTest3 test = new FunTest3();
        test.handle();
    }

}
