package com.jas.graphic.core;

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
        GET_DEMO(IndustryEnum.INDUSTRY_ONE, BusinessScenarioEnum.BUSINESS_SCENARIO_ONE, Operation.GET, Collections.singletonList(GraphicNodeBeanName.GET_TEST)),

        /**
         * 测试二
         */
        INSERT_DEMO(IndustryEnum.INDUSTRY_TWO, BusinessScenarioEnum.BUSINESS_SCENARIO_TWO, Operation.INSERT, Collections.singletonList(GraphicNodeBeanName.INSERT_TEST));


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
        IndustryEnum industryEnum = IndustryEnum.findByType(industry);
        if(null == industryEnum) {
            throw new RuntimeException();
        }
        BusinessScenarioEnum scenarioEnum = BusinessScenarioEnum.findByType(scenario);
        if(null == scenarioEnum) {
            throw new RuntimeException();
        }
        if(null == operation) {
            throw new RuntimeException();
        }
        List<ScenarioWithOperation> scenarioWithOperationList = Arrays.stream(ScenarioWithOperation.values()).filter(a -> a.getOperation().equals(operation)).collect(Collectors.toList());
        KeyGenerator<String, String, String> keyGenerator = (arg1, arg2) -> (null == arg1 ? "" : arg1) + "_" + (null == arg2 ? "" : arg2) ;
        // key:industry_scenario
        Map<String, ScenarioWithOperation> scenarioWithOperationMap = scenarioWithOperationList.stream().collect(Collectors.toMap(scenarioWithOperation -> {
            IndustryEnum i = scenarioWithOperation.getIndustry();
            BusinessScenarioEnum businessScenarioEnum = scenarioWithOperation.getScenario();
            return keyGenerator.getKey(null == i ? "" : i.getType() + "", null == businessScenarioEnum ? "" : businessScenarioEnum.getType() + "");
        }, scenarioWithOperation -> scenarioWithOperation));
        ScenarioWithOperation scenarioWithOperation = scenarioWithOperationMap.getOrDefault(keyGenerator.getKey(industry + "", scenario + ""), null);
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
