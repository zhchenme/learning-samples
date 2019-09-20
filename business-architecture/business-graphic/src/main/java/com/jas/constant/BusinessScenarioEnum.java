package com.jas.constant;

import java.util.Arrays;

/**
 * BusinessScenarioEnum
 *
 * @author lanxiang
 * @since 2019-09-10
 */
public enum BusinessScenarioEnum {

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
