package com.example.demo.test.ld.demo2;

import java.io.Serializable;
import java.util.List;

public interface MessageCreator extends Serializable {

    List<Message> encaseMsg(String content, String title, Integer order);

}
