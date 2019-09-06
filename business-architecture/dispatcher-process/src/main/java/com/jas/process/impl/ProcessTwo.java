/*
 * Copyright (C) 2009-2019 Hangzhou FanDianEr Technology Co., Ltd. All rights reserved
 */
package com.jas.process.impl;

import com.jas.process.AbstractProcess;
import com.jas.query.BaseQuery;
import com.jas.result.ResultBean;
import com.jas.type.BusinessEnum;
import org.springframework.stereotype.Component;

/**
 * ProcessTwo
 *
 * @author lanxiang
 * @since 2019-06-29
 */
@Component
public class ProcessTwo extends AbstractProcess {
    @Override
    public String type() {
        return BusinessEnum.BUSINESS_TWO.getKeyWord();
    }

    @Override
    public ResultBean handle(BaseQuery baseQuery) {
        return new ResultBean("处理器 2 返回的结果");
    }
}
