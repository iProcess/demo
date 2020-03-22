package com.example.demo.other;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.List;

public class Utils {

    public static String queryMonitorData(String restfulURL, String params, String token) {
        RestTemplate restTemplate = new RestTemplate();//这个对象可以在Spring中定义一个bean，而不必每次都new一个
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add("token", token);
        HttpEntity<String> entity = new HttpEntity<String>(params, headers);
        final ResponseEntity<String> result = restTemplate.postForEntity(restfulURL, entity, String.class);
        System.out.println("返回结果：" + result.getBody());
        System.out.println("返回状态码：" + result.getStatusCode());
        return result.getBody();
    }

    public static void writeFile(List<String> txtLst, String filename){

        try {
            String path = "d:\\ump";
            File myFile = new File(path, filename);
            BufferedWriter bw = new BufferedWriter(new FileWriter(myFile,true));
            for(String line : txtLst){
                bw.write(line);
                bw.write("\r\n");
                bw.flush();
            }
            bw.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
