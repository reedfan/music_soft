package com.ustc.reed.common;



public class CommonRet {
    private String status;
    private int code;
    private Object data;
    public final static String SUCCESS = "success";
    public final static Integer SUCCESS_Code = 200;
    public final static String ERROR = "general internal error";
    public final static String ERROR_MSG = "500";

    public CommonRet() {
        this(SUCCESS, SUCCESS_Code);
    }

    public CommonRet(String status, Integer code) {
        this.status = status;
        this.code = code;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }


}
