package com.ustc.reed.common;



public class CommonRet {
    private boolean success;
    private int code;
    private Object data;
    private String message;

    public final static Integer SUCCESS_Code = 200;

    public final static Integer ERROR_code = 500;

    public CommonRet() {
        this(true, SUCCESS_Code);
    }

    public CommonRet(boolean status, Integer code) {
        this.success = status;
        this.code = code;
    }

    public int getCode() {
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

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
