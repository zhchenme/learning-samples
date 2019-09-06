/*
 * Copyright (C) 2009-2019 Hangzhou FanDianEr Technology Co., Ltd. All rights reserved
 */
package com.jas.result;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * ResultBean
 *
 * @author lanxiang
 * @since 2019-06-27
 */
@Data
@AllArgsConstructor
public class ResultBean implements Serializable {
    private static final long serialVersionUID = -7879921781420837483L;
    /**
     * 结果
     */
    private String result;
}
