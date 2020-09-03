package com.example.demo.test.ld.demo3;

import com.example.demo.test.ld.Apple;

import java.io.Serializable;
import java.util.List;

public interface MessageCreator extends Serializable {

    List<Message> encaseMsg(String content, String title, Apple apple);

}
