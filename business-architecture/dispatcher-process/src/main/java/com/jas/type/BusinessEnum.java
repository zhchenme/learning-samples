/*
 * Copyright (C) 2009-2019 Hangzhou FanDianEr Technology Co., Ltd. All rights reserved
 */
package com.jas.type;
/**
 * BusinessEnum
 *
 * @author lanxiang
 * @since 2019-06-27
 */
public enum BusinessEnum {

    BUSINESS_ONE("business_one", "业务类型1"),
    BUSINESS_TWO("business_two", "业务类型2");

    /**
     * 关键词
     */
    private String keyWord;
    /**
     * 备注
     */
    private String remarks;

    BusinessEnum(String keyWord, String remarks) {
        this.keyWord = keyWord;
        this.remarks = remarks;
    }

    public String getKeyWord() {
        return keyWord;
    }

    public String getRemarks() {
        return remarks;
    }
}
