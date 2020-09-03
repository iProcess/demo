package com.example.demo.test.fastjson;

public class Result<T> {
    private int ret;
    private String msg;
    private T data;
    // 此处省略getter和setter方法


    public int getRet() {
        return ret;
    }

    public void setRet(int ret) {
        this.ret = ret;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ret=" + ret + ", msg=" + msg + ", data={" + data + "}";
    }
}
