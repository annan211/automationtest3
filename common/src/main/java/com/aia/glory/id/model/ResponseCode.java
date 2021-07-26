package com.aia.glory.id.model;

public enum ResponseCode {

    FATAL_ERROR("016"),

    ERROR("008"),

    WARNING("004"),

    NORMAL("000");

    private String code;


    public String getCode() {
        return code;
    }

    private ResponseCode(String code){
        this.code=code;
    }
}
