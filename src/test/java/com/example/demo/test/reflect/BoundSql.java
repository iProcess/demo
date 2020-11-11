package com.example.demo.test.reflect;



public class BoundSql {

    private final String sql;

    public BoundSql(String sql) {
        this.sql = sql;
    }

    public String getSql() {
        return sql;
    }

}
