package com.example.demo.jdk8.io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author shijincheng
 * @version V1.0
 * date 2020/1/18 13:32
 * Description: TODO
 */
public class TestReadLine {

    public static void main(String[] args){
        BufferedReader br = null;
        BufferedReader br2 = null;
        try {
            br = new BufferedReader(new FileReader("C:\\Users\\91911\\Desktop\\test.txt"));
            // 第一种读取文件方式
            System.out.println("Reading the file using readLine() method: ");
            String contentLine ;
            List<String> arr1 = new ArrayList<>();
            while ((contentLine = br.readLine()) != null) {
//            contentLine = br.readLine();
                //读取每一行，并输出
                System.out.println(contentLine);
                //将每一行追加到arr1
                arr1.add(contentLine);
            }
            //输出数组
            System.out.println(arr1);
            // 第二种读取文件方式
            br2 = new BufferedReader(new FileReader("C:\\Users\\91911\\Desktop\\test.txt"));
            System.out.println("Reading the file using read() method: ");
            int num = 0;
            char ch;
            while ((num = br2.read()) != -1) {
                ch = (char) num;
                System.out.print(ch);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
                if (br2 != null) {
                    br2.close();
                }
            } catch (IOException e) {
                System.out.println("Error in closing the BufferedReader");
            }
        }
    }
}
