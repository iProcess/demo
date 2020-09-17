package com.example.demo.test.java8.fun.practise;

import java.util.function.BiFunction;

public abstract class AbstractProxy {

    public abstract MovieCodeRes proxy(MovieCodeReq req, BiFunction<MovieCodeServiceImpl, MovieCodeReq, MovieCodeRes> biFunction);

    public abstract <T, U, R> R getDataProxy(BiFunction<T, U, R> mapper, T service, U req, Class<R> clazz, Object ...args);

}
