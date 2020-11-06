package com.example.demo.test.file;

import com.alibaba.fastjson.JSON;
import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://blog.csdn.net/thebigdipperbdx/article/details/83010009
 */
@Slf4j
public class CSVUtil1 {
    public static char separator = ',';

//    public static void main(String[] args) throws Exception {
//        // 测试导出
//        String filePath = "D:/scoreInfo.csv";
//        List<String[]> dataList = new ArrayList<String[]>();
//        //添加标题
//        dataList.add(new String[]{"学号", "姓名", "分数"});
//        for (int i = 0; i < 10; i++) {
//            dataList.add(new String[]{"2010000" + i, "张三" + i, "8" + i});
//        }
//        createCSV(dataList, filePath);
//
//        // 读取CSV文件
//        readCSV(filePath);
//    }

    public static void main(String[] args) throws Exception {
        String table = "ecopromo.app_ecodd_tool_effect_c_light_di_order_pop_v2";
        String filePath = "/Users/shijincheng/Downloads/app_ecodd_tool_effect_c_light_di_order_pop_v2_mom.csv";
        List<String> insertSql = createTableSql(table, filePath);
        for(String sql : insertSql){
            System.out.println(sql);
        }
    }

    public static List<String> createTableSql(String table, String filePath) throws Exception {
        List<String> rows = readCSV(filePath);
        log.info("rows size:{}", rows.size());
        String sql = "insert into " + table + " values()";
        List<String> insertSql = new ArrayList<>();
        for(String row : rows){
            insertSql.add("insert into " + table + " values(" + row + ");");
        }
        return insertSql;
    }

    /**
     * 读取CSV文件
     * @param filePath:全路径名
     */
    public static List<String> readCSV(String filePath) throws Exception {
        CsvReader reader = null;
        List<String> dataList = new ArrayList<String>();
        try {
            //如果生产文件乱码，windows下用gbk，linux用UTF-8
            reader = new CsvReader(filePath, separator, Charset.forName("UTF-8"));
            // 读取表头
            reader.readHeaders();
            //String[] headArray = reader.getHeaders();//获取标题
            //System.out.println(headArray[0] + headArray[1] + headArray[2]);

            //dataList.add(headArray);
            // 逐条读取记录，直至读完
            while (reader.readRecord()) {
                // 读一整行
                //System.out.println(reader.getRawRecord());
                String[] lines = reader.getRawRecord().split(",");
                String[] rows = new String[lines.length];
                for(int i = 0; i < lines.length; i++){
                    String row = lines[i];
                    if(StringUtils.isBlank(row)){
                        row = "''";
                    }else if(!NumberUtil.isNumber(row)){
                        row = "'" + row + "'";
                    }
                    rows[i] = row;
                }
                String line = String.join(",", rows);
                dataList.add(line);
                // 读这行的第一列
                //System.out.println(reader.get("学号"));
                // 读这行的第二列
                //System.out.println(reader.get(1));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (null != reader) {
                reader.close();
            }
        }

        return dataList;
    }

    /**
     * 生成CSV文件
     * @param dataList:数据集
     * @param filePath:全路径名
     */
    public static boolean createCSV(List<String[]> dataList, String filePath) throws Exception {
        boolean isSuccess = false;
        CsvWriter writer = null;
        FileOutputStream out = null;
        try {
            out = new FileOutputStream(filePath, true);
            //如果生产文件乱码，windows下用gbk，linux用UTF-8
            writer = new CsvWriter(out, separator, Charset.forName("GBK"));
            for (String[] strs : dataList) {
                writer.writeRecord(strs);
            }
            isSuccess = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (null != writer) {
                writer.close();
            }
            if (null != out) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return isSuccess;
    }
}


