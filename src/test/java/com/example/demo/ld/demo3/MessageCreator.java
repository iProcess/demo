package com.example.demo.ld.demo3;

import com.example.demo.ld.Apple;

import java.io.Serializable;
import java.util.List;

public interface MessageCreator extends Serializable {

    List<Message> encaseMsg(String content, String title, Apple apple);

}
