package com.jas.facade.service;

import com.jas.facade.ICustomFacade;
import com.jas.graphic.business.BusinessGraphic;
import com.jas.graphic.context.GraphicNodeContext;
import com.jas.graphic.core.GraphicExecuteEngine;
import com.jas.request.CommonRequest;
import com.jas.vo.CustomVO;

/**
 * CustomService
 *
 * @author lanxiang
 * @since 2019-09-10
 */
public class CustomService extends AbstractCustomService implements ICustomFacade {

    @Override
    public CustomVO getTest(CommonRequest commonRequest) {
        if (null == commonRequest) {
            throw new RuntimeException();
        }
        CustomVO customVO;
        try {
            GraphicNodeContext context = super.initContext(commonRequest);
            context = GraphicExecuteEngine.execute(context, BusinessGraphic.Operation.GET);
            customVO = context.getCustomVO();
        } catch (Exception e) {
            throw new RuntimeException();
        }
        return customVO;
    }
}
