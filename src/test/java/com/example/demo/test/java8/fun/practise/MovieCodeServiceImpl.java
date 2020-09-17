package com.example.demo.test.java8.fun.practise;

import cn.hutool.core.bean.BeanUtil;

public class MovieCodeServiceImpl implements MovieCodeService {

    @Override
    public MovieCodeRes getMyMovieId(MovieCodeReq req) {
        MovieCodeRes res = new MovieCodeRes();
        BeanUtil.copyProperties(req, res);
        res.setCode("200");
        res.setMsg("成功!");
        System.out.println("处理成功!");
        return res;
    }

    @Override
    public MovieCodeRes getMyMovieName(MovieCodeReq req) {
        MovieCodeRes res = new MovieCodeRes();
        BeanUtil.copyProperties(req, res);
        res.setCode("200");
        res.setMsg("成功!");
        System.out.println("处理成功!");
        return res;
    }

}
