package com.piza.enums;

/**
 * Created by Peter on 15/3/31.
 */
public enum IndexTypeEnum {

    DB_DATA(1),FILE_DATA(2);

    private Integer value;

    IndexTypeEnum(Integer value) {
        this.value=value;
    }

    public Integer getValue(){
        return this.value;
    }
}
