/*
 * Copyright (C) 2009-2019 Hangzhou FanDianEr Technology Co., Ltd. All rights reserved
 */
package com.jas.service;

import com.jas.query.BaseQuery;
import com.jas.result.ResultBean;

/**
 * IProcessService
 *
 * @author lanxiang
 * @since 2019-06-29
 */
public interface IProcessService {
    /**
     * 根据请求参数获取结果
     *
     * @param baseQuery query
     * @return 结果
     */
    ResultBean getResult(BaseQuery baseQuery);
}
