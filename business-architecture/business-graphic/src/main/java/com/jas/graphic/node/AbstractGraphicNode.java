package com.jas.graphic.node;

import com.jas.graphic.context.GraphicNodeContext;

/**
 * AbstractGraphicNode
 *
 * @author lanxiang
 * @since 2019-09-29
 */
public abstract class AbstractGraphicNode implements GraphicNode{

    @Override
    public GraphicNodeContext apply(GraphicNodeContext context) {
        if (null == context) {
            throw new RuntimeException();
        }
        return _apply(context);
    }

    protected abstract GraphicNodeContext _apply(GraphicNodeContext context);
}
