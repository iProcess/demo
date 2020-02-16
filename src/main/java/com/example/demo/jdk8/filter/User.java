package com.example.demo.jdk8.filter;

import lombok.Data;

import java.io.Serializable;

/**
 * @author shijincheng
 * @version V1.0
 * date 2020/1/20 15:04
 * Description: TODO
 */
@Data
public class User implements Serializable {
    private String userName;
    private Integer age;
}
