/*
 * Copyright (C) 2009-2019 Hangzhou FanDianEr Technology Co., Ltd. All rights reserved
 */
package com.jas.service.impl;

import com.jas.dispatcher.ProcessDispatcher;
import com.jas.process.IProcess;
import com.jas.query.BaseQuery;
import com.jas.result.ResultBean;
import com.jas.service.IProcessService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * ProcessServiceImpl
 *
 * @author lanxiang
 * @since 2019-06-29
 */
@Service
public class ProcessServiceImpl implements IProcessService {
    @Resource
    private ProcessDispatcher processDispatcher;

    @Override
    public ResultBean getResult(BaseQuery baseQuery) {
        // 根据业务类型获取对应的处理器
        IProcess process = processDispatcher.type(baseQuery.getBusinessType());
        // 处理器处理结果
        return process.handle(baseQuery);
    }
}
