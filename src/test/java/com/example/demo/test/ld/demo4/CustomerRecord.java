package com.example.demo.test.ld.demo4;

import lombok.Data;

import java.io.Serializable;

@Data
public class CustomerRecord implements Serializable {
    private String recordId;
    private String cardNo;

}
