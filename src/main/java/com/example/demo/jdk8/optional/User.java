package com.example.demo.jdk8.optional;

import lombok.Data;

/**
 * @author shijincheng
 * @version V1.0
 * date 2020/1/16 16:22
 * Description: TODO
 */
@Data
public class User {

    private String userName;
    private String province;
    private String city;
    private String county;
    private String town;

    public User(String userName, String province, String city, String county, String town){
        this.userName = userName;
        this.province = province;
        this.city = city;
        this.county = county;
        this.town = town;
    }

}
