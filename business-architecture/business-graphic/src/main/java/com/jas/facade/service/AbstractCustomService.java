package com.jas.facade.service;

import com.jas.graphic.context.GraphicNodeContext;
import com.jas.request.CommonRequest;

/**
 * AbstractCustomService
 *
 * @author lanxiang
 * @since 2019-09-25
 */
public abstract class AbstractCustomService {

    protected GraphicNodeContext initContext(CommonRequest commonRequest) {
        GraphicNodeContext context = new GraphicNodeContext();
        context.setCustomerId(commonRequest.getCustomerId());
        context.setIndustry(commonRequest.getIndustry());
        context.setScenario(commonRequest.getBusinessScenario());
        return context;
    }

}
