package com.example.demo.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class FileTest {

    public static void main(String[] args) {

        File file = new File("E:\\2020\\春节后\\商详配置\\商详配置.csv");
        FileInputStream is = null;
        InputStreamReader isr = null;
        BufferedReader reader = null;
        try {
            is = new FileInputStream(file);
            isr = new InputStreamReader(is);
            reader = new BufferedReader(isr);
            int row = 0;
            String line = null;
            while ((line = reader.readLine()) != null){
                if(row == 0){
                    row++;
                    continue;
                }
                System.out.println(line);
                String[] lines = line.split(",");
                for(String str : lines){
                    System.out.println(str);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                if(reader != null){
                    reader.close();
                }
                if(isr != null){
                    isr.close();
                }
                if(is != null){
                    is.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

}
