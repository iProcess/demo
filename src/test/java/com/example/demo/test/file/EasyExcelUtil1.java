package com.example.demo.test.file;

import com.alibaba.excel.EasyExcel;

import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.List;

public class EasyExcelUtil1 {
    /**
     * web导出excel文件
     * @param response response
     * @param list 实体数据
     * @param fileName 文件名
     * @param sheetName sheet名
     * @param clazz 实体类
     * @throws Exception
     */
    public static void exprotExcel(HttpServletResponse response, List<?> list, String fileName, String sheetName, Class<?> clazz)throws Exception  {
        EasyExcel.write(getOutputStream(fileName,response), clazz)
                .sheet(sheetName)
                .doWrite(list);
    }

    /**
     * 导出文件时为Writer生成OutputStream
     * @param fileName
     * @param response
     * @return
     */
    private static OutputStream getOutputStream(String fileName, HttpServletResponse response) throws Exception {
        try {
            fileName = URLEncoder.encode(fileName, "UTF-8");
            response.setContentType("application/vnd.ms-excel");
            response.setCharacterEncoding("utf8");
            response.setHeader("Content-Disposition", "attachment; filename=" + fileName + ".xlsx");
            response.setHeader("Pragma", "public");
            response.setHeader("Cache-Control", "no-store");
            response.addHeader("Cache-Control", "max-age=0");
            return response.getOutputStream();
        } catch (Exception e) {
            throw new Exception("导出excel表格失败!", e);
        }
    }

    /**
     * 无模板写文件
     *
     * @param filePath
     * @param head     表头数据
     * @param data     表内容数据
     */
    public static void write(String filePath, List<List<String>> head, List<List<Object>> data) {
        EasyExcel.write(filePath).head(head).sheet().doWrite(data);
    }

    /**
     * 无模板写文件
     *
     * @param filePath
     * @param head      表头数据
     * @param data      表内容数据
     * @param sheetNo   sheet页号，从0开始
     * @param sheetName sheet名称
     */
    public static void write(String filePath, List<List<String>> head, List<List<Object>> data, Integer sheetNo, String sheetName) {
        EasyExcel.write(filePath).head(head).sheet(sheetNo, sheetName).doWrite(data);
    }

    public static void exprotExcel1(HttpServletResponse response, String fileName, List<List<String>> head, Integer sheetNo, String sheetName, List<List<Object>> data)throws Exception  {
        EasyExcel.write(getOutputStream(fileName,response))
                .head(head)
                .sheet(sheetNo, sheetName)
                .doWrite(data);

    }

}

