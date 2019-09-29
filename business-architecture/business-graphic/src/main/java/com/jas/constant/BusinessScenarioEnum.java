package com.jas.constant;

import java.util.Arrays;

/**
 * BusinessScenarioEnum
 *
 * @author lanxiang
 * @since 2019-09-10
 */
public enum BusinessScenarioEnum {

    BUSINESS_SCENARIO_ONE(1, "业务类型1"),
    BUSINESS_SCENARIO_TWO(2, "业务类型2")
    ;

    private int type;
    private String name;

    BusinessScenarioEnum(int type, String name) {
        this.type = type;
        this.name = name;
    }

    public static BusinessScenarioEnum findByType(int type) {
        return Arrays.stream(BusinessScenarioEnum.values()).filter(a -> a.type == type).findFirst().orElse(null);
    }

    public int getType() {
        return type;
    }

    public String getName() {
        return name;
    }
}
