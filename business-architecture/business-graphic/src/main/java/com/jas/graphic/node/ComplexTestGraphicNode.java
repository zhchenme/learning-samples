package com.jas.graphic.node;

import com.jas.graphic.context.GraphicNodeContext;
import com.jas.graphic.core.BusinessGraphic;
import org.springframework.stereotype.Component;

/**
 * ComplexTestGraphicNode
 *
 * @author lanxiang
 * @since 2019-09-30
 */
@Component(BusinessGraphic.GraphicNodeBeanName.COMPLEX_TEST)
public class ComplexTestGraphicNode extends AbstractGraphicNode{

    @Override
    protected GraphicNodeContext _apply(GraphicNodeContext context) {
        System.out.println(context.getCustomVO());
        System.out.println(context.getOperationResult());
        return context;
    }
}
