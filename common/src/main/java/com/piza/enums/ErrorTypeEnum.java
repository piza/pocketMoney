package com.piza.enums;

/**
 * Created by Peter on 15/3/31.
 */
public enum ErrorTypeEnum {
    SERVER_ERROR(1),
    VALIDATE_ERROR(2),
    NEED_LOGIN(3)
    ;

    private Integer value;

    ErrorTypeEnum(Integer value) {
        this.value=value;
    }

    public Integer getValue(){
        return this.value;
    }
}
