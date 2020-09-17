package com.example.demo.test.java8.fun.practise;

import java.util.function.BiFunction;

public class MovieCodeServiceProxy extends AbstractProxy implements MovieCodeService{

    MovieCodeServiceImpl movieCodeService = new MovieCodeServiceImpl();

    @Override
    public MovieCodeRes getMyMovieId(MovieCodeReq req) {
        System.out.println("代理-->添加缓存");
        return movieCodeService.getMyMovieId(req);
    }

    @Override
    public MovieCodeRes getMyMovieName(MovieCodeReq req) {
        System.out.println("代理-->添加缓存");
        return movieCodeService.getMyMovieName(req);
    }

    @Override
    public MovieCodeRes proxy(MovieCodeReq req, BiFunction<MovieCodeServiceImpl, MovieCodeReq, MovieCodeRes> biFunction) {

//        BiFunction<MovieCodeServiceImpl, MovieCodeReq, MovieCodeRes> biFunction;
//
//        biFunction = (t, u) -> t.getMyMovieId(u);

        return getDataProxy(biFunction, movieCodeService, req, MovieCodeRes.class, req.getMovieId());

    }

    public <T, U, R> R getDataProxy(BiFunction<T, U, R> mapper, T service, U req, Class<R> clazz, Object ...args){
        //调用前处理
        System.out.println("调用前处理...");
        R res = mapper.apply(service, req);
        //调用后处理
        System.out.println("调用后处理...");
        return res;
    }

}
