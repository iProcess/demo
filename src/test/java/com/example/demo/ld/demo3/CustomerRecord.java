package com.example.demo.ld.demo3;

import lombok.Data;

import java.io.Serializable;

@Data
public class CustomerRecord implements Serializable {
    private String recordId;
    private String cardNo;

}
