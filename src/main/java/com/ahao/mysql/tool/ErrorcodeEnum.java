package com.ahao.mysql.tool;

public enum ErrorcodeEnum {

    SUCCESS(200, "成功"),
    PARAMS_ERROR(400, "参数错误"),
    SERVER_ERROR(500, "服务器错误"),
    
    ;
    
    private Integer errorcode;
    
    private String describe;
    
    private ErrorcodeEnum(Integer errorcode, String describe) {
        this.errorcode = errorcode;
        this.describe = describe;
    }

    public Integer getErrorcode() {
        return errorcode;
    }

    public void setErrorcode(Integer errorcode) {
        this.errorcode = errorcode;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    };
    
}
