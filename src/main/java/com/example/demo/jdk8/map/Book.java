package com.example.demo.jdk8.map;

import lombok.Data;

/**
 * @author shijincheng
 * @version V1.0
 * date 2020/1/1 12:19
 * Description: TODO
 */
@Data
public class Book {

    private String name;
    private int releaseYear;
    private String isbn;

    public Book(String name, int releaseYear, String isbn){
        this.name = name;
        this.releaseYear = releaseYear;
        this.isbn = isbn;
    }

}
