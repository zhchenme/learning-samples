/*
 * Copyright (C) 2009-2019 Hangzhou FanDianEr Technology Co., Ltd. All rights reserved
 */
package com.jas.query;

import com.jas.type.BusinessEnum;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * BaseQuery
 *
 * @author lanxiang
 * @since 2019-06-27
 */
@Data
@AllArgsConstructor
public class BaseQuery implements Serializable {
    private static final long serialVersionUID = -618487741244359473L;
    /**
     * 业务类型 {@link BusinessEnum}
     */
    private String businessType;
}
