/*
 * Copyright (C) 2009-2019 Hangzhou FanDianEr Technology Co., Ltd. All rights reserved
 */
package com.jas.service;

import com.jas.BaseApplicationTests;
import com.jas.query.BaseQuery;
import com.jas.result.ResultBean;
import org.junit.Test;

import javax.annotation.Resource;

/**
 * IProcessServiceTest
 *
 * @author lanxiang
 * @since 2019-06-29
 */
public class IProcessServiceTest extends BaseApplicationTests {
    @Resource
    private IProcessService processService;

    @Test
    public void processTest() {
        BaseQuery baseQuery1 = new BaseQuery("business_one");
        ResultBean result1 = processService.getResult(baseQuery1);
        System.out.println(result1.getResult());

        BaseQuery baseQuery2 = new BaseQuery("business_two");
        ResultBean result2 = processService.getResult(baseQuery2);
        System.out.println(result2.getResult());
    }
}
