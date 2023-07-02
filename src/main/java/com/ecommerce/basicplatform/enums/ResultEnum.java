package com.ecommerce.basicplatform.enums;

/**
 * 返回值枚举
 */
public enum ResultEnum {
    SUCCESS("00", Boolean.TRUE, "处理成功"),
    FAIL("-99", Boolean.FALSE, "处理失败");
    private String code;
    private Boolean result;
    private String msg;

    ResultEnum(String code, Boolean result, String msg) {
        this.code = code;
        this.result = result;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Boolean getResult() {
        return result;
    }

    public void setResult(Boolean result) {
        this.result = result;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}


