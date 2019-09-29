package com.jas.graphic.core;

import com.jas.graphic.context.GraphicNodeContext;
import com.jas.graphic.node.GraphicNode;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * GraphicExecuteEngine
 *
 * @author lanxiang
 * @since 2019-09-10
 */
@Component
public class GraphicExecuteEngine implements ApplicationListener<ContextRefreshedEvent> {

    private static Map<String, GraphicNode> graphicNodeHolder = null;

    private static List<String> findGraphic(int industry, int scenario, BusinessGraphic.Operation operation) {
        return BusinessGraphic.findGraphic(industry, scenario, operation);
    }

    public static GraphicNodeContext execute(GraphicNodeContext context, BusinessGraphic.Operation operation) {
        int industry = context.getIndustry();
        int scenario = context.getScenario();
        context.setOperation(operation);
        List<String> graphicList = findGraphic(industry, scenario, operation);
        for (String graphic: graphicList) {
            GraphicNode graphicNode = graphicNodeHolder.getOrDefault(graphic, null);
            if (null == graphic) {
                throw new RuntimeException();
            }
            context = graphicNode.apply(context);
        }
        return context;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        if (null == event.getApplicationContext().getParent()) {
            GraphicExecuteEngine.graphicNodeHolder = event.getApplicationContext().getBeansOfType(GraphicNode.class);
        }
    }
}
