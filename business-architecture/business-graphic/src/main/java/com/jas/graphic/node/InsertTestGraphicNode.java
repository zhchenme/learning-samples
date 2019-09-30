package com.jas.graphic.node;

import com.jas.graphic.context.GraphicNodeContext;
import com.jas.graphic.core.BusinessGraphic;
import org.springframework.stereotype.Component;

/**
 * GraphicNode
 *
 * @author lanxiang
 * @since 2019-09-10
 */
@Component(BusinessGraphic.GraphicNodeBeanName.INSERT_TEST)
public class InsertTestGraphicNode extends AbstractGraphicNode {

    @Override
    protected GraphicNodeContext _apply(GraphicNodeContext context) {
        context.setOperationResult(true);
        return context;
    }
}
