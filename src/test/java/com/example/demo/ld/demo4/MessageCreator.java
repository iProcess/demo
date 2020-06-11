package com.example.demo.ld.demo4;

import com.example.demo.ld.Orange;

import java.io.Serializable;
import java.util.List;

public interface MessageCreator<R, T> extends Serializable {

    List<Message> encaseMsg(R content, T title, Orange orange);

}
