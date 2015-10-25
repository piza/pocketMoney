package com.piza.enums;

/**
 * Created by Peter on 15/3/31.
 */
public enum NormalStatusEnum {

    NORMAL(1),DELETED(2);

    private Integer value;

    NormalStatusEnum(Integer value) {
        this.value=value;
    }

    public Integer getValue(){
        return this.value;
    }
}
