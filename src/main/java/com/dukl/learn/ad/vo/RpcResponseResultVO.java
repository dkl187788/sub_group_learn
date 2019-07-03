package com.dukl.learn.ad.vo;

/**
 * Created by dukangli on 2019/6/17 15:32
 */
public class RpcResponseResultVO<T> {
    private Integer responseCode;

    private String msg;

    private T data;

    public Integer getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(Integer responseCode) {
        this.responseCode = responseCode;
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
