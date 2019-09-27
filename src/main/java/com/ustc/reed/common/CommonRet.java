package com.ustc.reed.common;

public class CommonRet {
    private String status;
    private String msg;
    public final static String SUCCESS = "A00000";
    public final static String SUCCESS_MSG = "success";
    public final static String ERROR = "A00001";
    public final static String ERROR_MSG = "general internal error";

    public CommonRet() {
        this(SUCCESS, SUCCESS_MSG);
    }

    public CommonRet(String status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
