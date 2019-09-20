package com.jas.constant;

import java.util.Arrays;

/**
 * IndustryEnum
 *
 * @author lanxiang
 * @since 2019-09-10
 */
public enum IndustryEnum {

    ;

    private int type;
    private String name;

    IndustryEnum(int type, String name) {
        this.type = type;
        this.name = name;
    }

    public static IndustryEnum findByType(int type) {
        return Arrays.stream(IndustryEnum.values()).filter(a -> a.type == type).findFirst().orElse(null);
    }

    public Integer getType() {
        return type;
    }

    public String getName() {
        return name;
    }
}
