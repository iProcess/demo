package com.example.demo.file;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class ExcelUtil {

    /**
     * 写入excel文件
     * @return
     */
//    private boolean writeExcel(String fileName){
//        if (StringUtils.isBlank(fileName)) {
//            log.error("ExcelUtil-->writeExcel, fileName is null");
//            return false;
//        }
//
//        FileOutputStream os = null;
//        try {
//
//            // 创建Excel的工作书册 Workbook,对应到一个excel文档
//            HSSFWorkbook wb = new HSSFWorkbook();
//            // 创建Excel的工作sheet,对应到一个excel文档的tab
//            HSSFSheet sheet = wb.createSheet("商详配置");
//            // 设置excel每列宽度
////            for (int i = 0; i < Constants.COLUMN_NUMBERS; i++) {
////                sheet.setColumnWidth(i, Constants.COLUMN_WIDTH);
////            }
//
//            // 创建字体样式
//            HSSFFont font = wb.createFont();
//            font.setFontName("Verdana");
//            font.setBoldweight((short) 100);
//            font.setFontHeight((short) 300);
//            font.setColor(HSSFColor.BLACK.index);
//
//            // 创建单元格样式
//            HSSFCellStyle style = wb.createCellStyle();
//            style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
//            style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
//            style.setFillForegroundColor(HSSFColor.LIGHT_TURQUOISE.index);
//            style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
//
//            // 设置边框
//            style.setBottomBorderColor(HSSFColor.RED.index);
//            style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
//            style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
//            style.setBorderRight(HSSFCellStyle.BORDER_THIN);
//            style.setBorderTop(HSSFCellStyle.BORDER_THIN);
//
//            // 设置字体
//            style.setFont(font);
//
//            //根据数据创建excel的行
//            String[] skus = errorSkus.split(",");
//            int length = skus.length;
//            for (int j = 0; j < length; j++) {
//                if (StringUtils.isBlank(skus[j])) {
//                    continue;
//                }
//                String[] contents = skus[j].split(":");
//                String skuId = contents[0];
//                String reason = contents[1];
//
//                //
//                HSSFRow row = sheet.createRow(j);
//                // 设定行的高度
//                row.setHeight((short) 500);
//                // 创建一个Excel的单元格
//                HSSFCell cellSkuId = row.createCell(0);
//                // 给Excel的单元格设置样式和赋值
//                cellSkuId.setCellStyle(style);
//                cellSkuId.setCellValue(skuId);
//
//                HSSFCell cellReason = row.createCell(1);
//                cellReason.setCellStyle(style);
//                cellReason.setCellValue(reason);
//
//                //输出流
//                os = new FileOutputStream(fileName);
//                wb.write(os);
//            }
//
//            boolean isOk = crmShopJssHandle.upload(new File(fileName), fileName, crmShopJssHandle.SENDBUCKET);
//            if (isOk) {
//                log.info("ExcelUtil -> writeErrorSkusToExcel write skus to excel successfully!");
//                return true;
//            } else {
//                log.error("ExcelUtil -> writeErrorSkusToExcel write skus to excel failed!");
//                return false;
//            }
//
//
//        } catch (Throwable t) {
//            log.error("ExcelUtil -> writeErrorSkusToExcel write skus to excel failed!");
//            return false;
//        } finally {
//            if (os != null) {
//                try {
//                    os.close();
//                } catch (IOException e) {
//                    log.error("ExcelUtil -> writeErrorSkusToExcel close output stream failed!");
//                    return false;
//                }
//            }
//        }
//    }

    /**
     * 解析上传的文件
     * @param fileName
     * @return
     */
    public static List<MemberCardConfig> readExcel(String fileName){
        BufferedInputStream in = null;
        InputStream is = null;
        try {

            is = new FileInputStream(new File(fileName));

            //存储excel中的MemberCardConfig
            List<MemberCardConfig> configList = new ArrayList<>();
            //构建输入流读取skus
            in = new BufferedInputStream(is);
            // 打开Workbook
            Workbook wb = null;
            if (isExcel2007(fileName)) {
                wb = new XSSFWorkbook(in);
            }else {
                wb = new HSSFWorkbook(is);
            }

            //sheet
            for (int sheetIndex = 0; sheetIndex < wb.getNumberOfSheets(); sheetIndex++) {
                Sheet st =  wb.getSheetAt(sheetIndex);

                //row
                for (int rowIndex = 1; rowIndex <= st.getLastRowNum(); rowIndex++) {
                    //获取行
                    Row row = st.getRow(rowIndex);
                    if (row == null) {
                        continue;
                    }
                    MemberCardConfig config = new MemberCardConfig();
                    //获取单元格数据
                    Cell cell0 = row.getCell(0);
                    String cellValue0 = getCellValue(cell0);
                    config.setBrandsId(StringUtils.isNotBlank(cellValue0) ? Long.valueOf(StringUtils.trim(cellValue0)) : null);

                    Cell cell1 = row.getCell(1);
                    String cellValue1 = getCellValue(cell1);
                    config.setMemberTitle(StringUtils.isNotBlank(cellValue1) ? StringUtils.trim(cellValue1) : null);

                    Cell cell2 = row.getCell(2);
                    String cellValue2 = getCellValue(cell2);
                    config.setNonmemberTitle(StringUtils.isNotBlank(cellValue2) ? StringUtils.trim(cellValue2) : null);

                    Cell cell3 = row.getCell(3);
                    String cellValue3 = getCellValue(cell3);
                    config.setNewOldFlag(StringUtils.isNotBlank(cellValue3) ? Integer.valueOf(StringUtils.trim(cellValue3)) : null);

                    configList.add(config);
//                    //cell
//                    for (int columnIndex = 0; columnIndex <= row.getLastCellNum(); columnIndex++) {
////                        //第一列
////                        if (columnIndex != 0) {
////                            //此处暂留扩展
////                            continue;
////                        }
//                        //获取单元格数据
//                        Cell cell = row.getCell(columnIndex);
//                        if (cell != null) {
//                            cell.setCellType(Cell.CELL_TYPE_STRING);
//                            //存储当前的sku
//                            String sku = cell.getStringCellValue();
//                            if (StringUtils.isNotBlank(sku)) {
//                                skus.add(sku.trim());
//                            }
//                            log.info("ExcelUtil -> readBlackWaresFile sku("+sku+")");
//                        }
//                    }
                }
            }
            log.info("ExcelUtil-->readExcel, return successfully!");
            return configList;
        } catch (Throwable t) {
            log.error("ExcelUtil-->readExcel, 解析上传的文件失败!", t);
        } finally {
            try {
                //关闭输入流
                if (is != null) {
                    is.close();
                }

                if (in != null) {
                    in.close();
                }
            } catch (IOException e) {
                log.error("ExcelUtil-->readExcel, close input stream failed!", e);
            }
        }

        return new ArrayList<>();
    }

    public static boolean isExcel2007(String fileName) {
        return fileName.contains("xlsx");
    }

    public static String getCellValue(Cell cell){
        if (cell != null) {
            cell.setCellType(Cell.CELL_TYPE_STRING);
            String cellValue = cell.getStringCellValue();
            log.info("ExcelUtil-->readExcel, getCellValue cellValue:{}", cellValue);
            return cellValue;
        }
        return null;
    }


    /**
     * 配置中心key： brand_open_card_entrance_config
     * @param args
     */
    public static void main(String[] args) {
        String fileName = "/Users/shijincheng/Documents/sx/新增商详开卡入口品牌-汇总_2020_07_08_02.xlsx";
        List<MemberCardConfig> configList = ExcelUtil.readExcel(fileName);
        System.out.println(configList.size());
        String json = JSON.toJSONString(configList);
        System.out.println(json.length());
        System.out.println(json);
    }
}
