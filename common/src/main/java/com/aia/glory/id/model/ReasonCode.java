package com.aia.glory.id.model;

public enum ReasonCode {
    GENERIC_SUCCESS("00000","Sucessful"),

    GENERIC_ERROR("00001","Generic Error"),

    NAME_NULL_ERROR("00002","Name cannot be empty"),

    NAME_INPUT_ERROR("00003","Name cannot be input '<','>'......"),

    COMPANY_NULL_ERROR("00004","Company cannot be empty"),

    COMPANY_INPUT_ERROR("00005","Company cannot be input '<','>'......"),

    CHANNEL_NULL_ERROR("00006","Channel cannot be empty"),

    CHANNEL_INPUT_ERROR("00007","Channel cannot be input '<','>'......"),

    EFFSD_NULL_ERROR("00008","EffectedStartDate cannot be empty"),

    EFFD_FORMAT_ERROR("00009","Date format error"),

    EFFED_NULL_ERROR("00010","EffectedEndDate cannot be empty"),

    PAYMENTFLAG_NAME_ERROR("00011","The current rule name was duplicated with a system reserved key word, please use another one or change the payment flag to YES"),

    TABLENAME_NULL_ERROR("00012","TableName cannot be empty"),

    DIMENSIONONENAME_NULL_ERROR("00013","Dimension_one name cannot be empty"),

    DIMENSIONTHREENAME_NULL_ERROR("00014","When dimension_two name is empty,dimension_three name must be empty"),

    EMAIL_FORMAT_ERROR("00015","Email format error"),

    TELEPHONE_FORMAT_ERROR("00016","Telephone format error");


    private String code;

    private String desc;

    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    private ReasonCode(String code, String desc){
        this.code=code;
        this.desc=desc;
    }
}
