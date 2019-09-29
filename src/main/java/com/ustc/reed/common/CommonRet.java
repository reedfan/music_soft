package com.ustc.reed.common;

public class CommonRet {
    private String status;
    private String code;
    private Object data;
    public final static String SUCCESS = "A00000";
    public final static String SUCCESS_MSG = "success";
    public final static String ERROR = "A00001";
    public final static String ERROR_MSG = "general internal error";

    public CommonRet() {
        this(SUCCESS, SUCCESS_MSG);
    }

    public CommonRet(String status, String code) {
        this.status = status;
        this.code = code;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }


}
