/*
 * Copyright (C) 2009-2019 Hangzhou FanDianEr Technology Co., Ltd. All rights reserved
 */
package com.jas.process;


import com.jas.query.BaseQuery;
import com.jas.result.ResultBean;

/**
 * IProcess
 *
 * @author lanxiang
 * @since 2019-06-27
 */
public interface IProcess {
    /**
     * 返回处理器对应的业务类型
     *
     * @return 业务类型
     */
    String type();

    /**
     * 处理器返回结果
     *
     * @param baseQuery query
     * @return 结果
     */
    ResultBean handle(BaseQuery baseQuery);
}
