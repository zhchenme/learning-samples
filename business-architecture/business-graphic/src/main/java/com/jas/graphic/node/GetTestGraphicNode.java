package com.jas.graphic.node;

import com.jas.graphic.core.BusinessGraphic;
import com.jas.graphic.context.GraphicNodeContext;
import com.jas.vo.CustomVO;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * GetTestGraphicNode
 *
 * @author lanxiang
 * @since 2019-09-29
 */
@Component(BusinessGraphic.GraphicNodeBeanName.GET_TEST)
public class GetTestGraphicNode extends AbstractGraphicNode {

    @Override
    protected GraphicNodeContext _apply(GraphicNodeContext context) {
        CustomVO customVO = new CustomVO();
        customVO.setList(Arrays.asList("hello", "world"));
        context.setCustomVO(customVO);
        return context;
    }
}
