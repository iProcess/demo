package com.example.demo.test.reflect;

import com.alibaba.fastjson.JSON;

import java.lang.reflect.Field;

public class TestBoundSql {

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        BoundSql boundSql = new BoundSql("select * from table1 where id = ? order by 'id' 'desc' limit 0, 10");
        System.out.println(JSON.toJSONString(boundSql));
        //获取到原始sql语句
        String sql = boundSql.getSql();

        int index = sql.indexOf("order by");
        String mSql = "";
        if(index != -1){
            String orderBy = sql.substring(index).replaceAll("'", "");
            mSql = sql.substring(0, index) + orderBy;
        }
        //通过反射修改sql语句
        Field field = boundSql.getClass().getDeclaredField("sql");
        field.setAccessible(true);
        field.set(boundSql, mSql);
        System.out.println(JSON.toJSONString(boundSql));
    }



}
