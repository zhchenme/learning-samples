package com.jas.facade.service;

import com.jas.facade.ICustomFacade;
import com.jas.graphic.core.BusinessGraphic;
import com.jas.graphic.context.GraphicNodeContext;
import com.jas.graphic.core.GraphicExecuteEngine;
import com.jas.request.CommonRequest;
import com.jas.vo.ComplexVO;
import com.jas.vo.CustomVO;
import org.springframework.stereotype.Service;

/**
 * CustomService
 *
 * @author lanxiang
 * @since 2019-09-10
 */
@Service
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

    @Override
    public boolean insertTest(CommonRequest commonRequest) {
        if (null == commonRequest) {
            throw new RuntimeException();
        }
        boolean result;
        try {
            GraphicNodeContext context = super.initContext(commonRequest);
            context = GraphicExecuteEngine.execute(context, BusinessGraphic.Operation.INSERT);
            result = context.getOperationResult();
        } catch (Exception e) {
            throw new RuntimeException();
        }
        return result;
    }

    @Override
    public ComplexVO complexTest(CommonRequest commonRequest) {
        if (null == commonRequest) {
            throw new RuntimeException();
        }
        ComplexVO complexVO = new ComplexVO();
        try {
            GraphicNodeContext context = super.initContext(commonRequest);
            context = GraphicExecuteEngine.execute(context, BusinessGraphic.Operation.COMPLEX);
            complexVO.setCustomVO(context.getCustomVO());
            complexVO.setOperationResult(context.getOperationResult());
        } catch (Exception e) {
            throw new RuntimeException();
        }
        return complexVO;
    }
}
