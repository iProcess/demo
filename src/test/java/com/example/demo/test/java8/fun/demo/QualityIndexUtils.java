package com.example.demo.test.java8.fun.demo;

import cn.hutool.core.util.NumberUtil;
import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;

public class QualityIndexUtils {

    /**
     * 计算百分比
     * @param molecule 分子
     * @param denominator 分母
     * @return
     */
    public static String percentage(Long molecule, Long denominator){
        if(denominator == null || molecule == null){
            return "0";
        }
        //除数
        BigDecimal divisor = new BigDecimal(denominator);
        if(divisor.compareTo(new BigDecimal("0")) == 0){
            return "0";
        }
        //被除数
        BigDecimal divided = new BigDecimal(molecule);
        //计算
        return divided.divide(divisor, 4, BigDecimal.ROUND_HALF_UP).toString();
    }

    /**
     * 除法计算
     * @param v1 被除数
     * @param v2 除数
     * @return 商
     */
    public static Double div(Long v1, Long v2) {
        if (v1 == null || v2 == null) {
            return 0D;
        }
        if (v2 == 0) {
            return 0D;
        }
        return NumberUtil.div(v1, v2).doubleValue();
    }

    public static String subtract(String rateDod, String beforeRateDod) {
        if(StringUtils.isBlank(rateDod) || StringUtils.isBlank(beforeRateDod)){
            return "0";
        }
        BigDecimal result = new BigDecimal(rateDod).subtract(new BigDecimal(beforeRateDod));
        return result.toString();
    }
    public static String calculateMomForNum(Long current, Long previous){
        if(previous == null || previous == 0){
            return "--";
        }
        if(current == null || current == 0){
            return "0";
        }
        BigDecimal curDecimal = new BigDecimal(current);
        BigDecimal preDecimal = new BigDecimal(previous);
        return curDecimal.subtract(preDecimal).divide(preDecimal, 4, BigDecimal.ROUND_HALF_UP).toString();
    }



    /**
     * 计算比率
     * @param indexVO
     */
    public static void setGradeCountRate(QualityIndexVO indexVO){
        indexVO.setAaGradeRate(QualityIndexUtils.percentage(indexVO.getAaGradeCount(), indexVO.getSpuTotal()));
        indexVO.setAGradeRate(QualityIndexUtils.percentage(indexVO.getAGradeCount(), indexVO.getSpuTotal()));
        indexVO.setBGradeRate(QualityIndexUtils.percentage(indexVO.getBGradeCount(), indexVO.getSpuTotal()));
        indexVO.setCGradeRate(QualityIndexUtils.percentage(indexVO.getCGradeCount(), indexVO.getSpuTotal()));
        indexVO.setDGradeRate(QualityIndexUtils.percentage(indexVO.getDGradeCount(), indexVO.getSpuTotal()));
    }

    /**
     * 计算环比值
     * @param currentVO
     * @param previousVO
     */
    public static void setMomCount(QualityIndexVO currentVO, QualityIndexVO previousVO){
        setGradeCountRate(currentVO);
        setGradeCountRate(previousVO);
        currentVO.setAaGradeCountMom(calculateMomForNum(currentVO.getAaGradeCount(), previousVO.getAaGradeCount()));
        currentVO.setAGradeCountMom(calculateMomForNum(currentVO.getAGradeCount(), previousVO.getAGradeCount()));
        currentVO.setBGradeCountMom(calculateMomForNum(currentVO.getBGradeCount(), previousVO.getBGradeCount()));
        currentVO.setCGradeCountMom(calculateMomForNum(currentVO.getCGradeCount(), previousVO.getCGradeCount()));
        currentVO.setDGradeCountMom(calculateMomForNum(currentVO.getDGradeCount(), previousVO.getDGradeCount()));
        currentVO.setAaGradeRateMom(subtract(currentVO.getAaGradeRate(), previousVO.getAaGradeRate()));
        currentVO.setAGradeRateMom(subtract(currentVO.getAGradeRate(), previousVO.getAGradeRate()));
        currentVO.setBGradeRateMom(subtract(currentVO.getBGradeRate(), previousVO.getBGradeRate()));
        currentVO.setCGradeRateMom(subtract(currentVO.getCGradeRate(), previousVO.getCGradeRate()));
        currentVO.setDGradeRateMom(subtract(currentVO.getDGradeRate(), previousVO.getDGradeRate()));
    }


    /**
     * 计算质量高风险环比值
     * @param currentVO
     * @param previousVO
     */
    public static void setRiskMom(QualityRiskVO currentVO, QualityRiskVO previousVO){
        currentVO.setWarnCountMom(calculateMomForNum(currentVO.getWarnCount(), previousVO.getWarnCount()));
        currentVO.setBlockCountMom(calculateMomForNum(currentVO.getBlockCount(), previousVO.getBlockCount()));
        currentVO.setWeightDownCountMom(calculateMomForNum(currentVO.getWeightDownCount(), previousVO.getWeightDownCount()));
    }

}
