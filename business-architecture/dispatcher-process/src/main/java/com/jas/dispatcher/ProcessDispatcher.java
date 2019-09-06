/*
 * Copyright (C) 2009-2019 Hangzhou FanDianEr Technology Co., Ltd. All rights reserved
 */
package com.jas.dispatcher;

import com.google.common.collect.Maps;
import com.jas.manager.BeanProcessManager;
import com.jas.process.IProcess;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.MapUtils;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * ProcessDispatcher
 *
 * @author lanxiang
 * @since 2019-06-27
 */
@Component
public class ProcessDispatcher implements InitializingBean {
    @Resource
    private BeanProcessManager beanProcessManager;

    private Map<String, IProcess> processMap = Maps.newHashMap();

    /**
     * Spring IoC 容器在装载完所有 bean 的时候会调用该方法
     */
    @Override
    public void afterPropertiesSet() {
        List<IProcess> processList = beanProcessManager.getBeanList(IProcess.class);
        if (CollectionUtils.isNotEmpty(processList)) {
            for (IProcess process : processList) {
                processMap.put(process.type(), process);
            }
        }
        if (MapUtils.isEmpty(processMap)) {
            throw new IllegalArgumentException("至少设置一个处理器");
        }
    }

    public IProcess type(String type) {
        return processMap.get(type);
    }
}
