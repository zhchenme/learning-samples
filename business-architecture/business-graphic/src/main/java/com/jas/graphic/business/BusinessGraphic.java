package com.jas.graphic.business;

import com.jas.constant.BusinessScenarioEnum;
import com.jas.constant.IndustryEnum;
import org.springframework.util.CollectionUtils;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * BusinessGraphic
 *
 * @author lanxiang
 * @since 2019-09-10
 */
public class BusinessGraphic {

    public interface GraphicNodeBeanName {

        String INSERT_TEST = "insertTestGraphicNode";

        String GET_TEST = "getTestGraphicNode";
    }

    public enum Operation {
        INSERT(1, "insert", "插入数据"),
        GET(2, "get", "获取数据");

        private Integer code;
        private String name;
        private String cnName;

        Operation(int code, String name, String cnName) {
            this.code = code;
            this.name = name;
            this.cnName = cnName;
        }

        public int getCode() {
            return code;
        }

        public String getName() {
            return name;
        }

        public String getCnName() {
            return cnName;
        }
    }

    enum ScenarioWithOperation {
        /**
         * 测试一
         */
        GET_DEMO(null, null, Operation.GET, Collections.singletonList(GraphicNodeBeanName.GET_TEST)),

        /**
         * 测试二
         */
        INSERT_DEMO(null, null, Operation.INSERT, Collections.singletonList(GraphicNodeBeanName.INSERT_TEST));


        private IndustryEnum industry;

        private BusinessScenarioEnum scenario;

        private Operation operation;

        private List<String> graphicList;

        ScenarioWithOperation(IndustryEnum industry, BusinessScenarioEnum scenario, Operation operation, List<String> graphicList) {
            this.industry = industry;
            this.scenario = scenario;
            this.operation = operation;
            this.graphicList = graphicList;
        }

        public IndustryEnum getIndustry() {
            return industry;
        }

        public BusinessScenarioEnum getScenario() {
            return scenario;
        }

        public Operation getOperation() {
            return operation;
        }

        public List<String> getGraphicList() {
            return graphicList;
        }
    }

    public static List<String> findGraphic(int industry, int scenario, Operation operation) {
        // 参数校验、行业处理、业务场景处理

        // 根据具体操作过滤 ScenarioWithOperation
        List<ScenarioWithOperation> scenarioWithOperationList = Arrays.stream(ScenarioWithOperation.values()).filter(a -> a.getOperation().equals(operation)).collect(Collectors.toList());
        KeyGenerator<String, String, String> keyGenerator = (arg1, arg2) -> (null == arg1 ? "" : arg1) + "_" + (null == arg2 ? "" : arg2) ;
        // 将过滤的 ScenarioWithOperation 集合按照"行业_场景"封装成 map
        Map<String, ScenarioWithOperation> scenarioWithOperationMap = scenarioWithOperationList.stream().collect(Collectors.toMap(scenarioWithOperation -> {
            IndustryEnum industryEnum = scenarioWithOperation.getIndustry();
            BusinessScenarioEnum businessScenarioEnum = scenarioWithOperation.getScenario();
            return keyGenerator.getKey(null == industryEnum ? "" : industryEnum.getType() + "", null == businessScenarioEnum ? "" : businessScenarioEnum.getType() + "");
        }, scenarioWithOperation -> scenarioWithOperation));
        ScenarioWithOperation scenarioWithOperation = scenarioWithOperationMap.getOrDefault(keyGenerator.getKey(industry + "", scenario + ""), null);
        /*if(null == scenarioWithOperation) {
            // 行业不为空，场景为空，空与非空可自定义
            scenarioWithOperation = scenarioWithOperationMap.getOrDefault(keyGenerator.getKey(industry + "", null), null);
        }*/
        List<String> graphicList = null == scenarioWithOperation ? null : scenarioWithOperation.getGraphicList();
        if(CollectionUtils.isEmpty(graphicList)) {
            throw new RuntimeException();
        }
        return graphicList;
    }

    private interface KeyGenerator<A1, A2, R> {
        R getKey(A1 arg1, A2 arg2);
    }
}
