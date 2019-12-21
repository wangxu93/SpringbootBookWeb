package com.wangxu.bootweb.domain;

import java.io.Serializable;

public class Result<T> implements Serializable {
    public static final int SUCCESS = 1;
    public static final int ERROR = 0;
    private int result;
    private String msg;
    private T data;

    public Result(int result, String msg, T data) {
        this.result = result;
        this.msg = msg;
        this.data = data;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
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
}
