package com.example.demo.test.ld.demo1;

import java.io.Serializable;
import java.util.List;

public interface MessageCreator<T> extends Serializable {
//    List<Message> create(String var1, T var2);

    List<Message> encaseMsg(String var1, T var2, Integer i);
}
