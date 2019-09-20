package com.jas.graphic.core;

import com.jas.graphic.context.GraphicNodeContext;

/**
 * GraphicNode
 *
 * @author lanxiang
 * @since 2019-09-10
 */
public interface GraphicNode {

    GraphicNodeContext apply(GraphicNodeContext context);
}
