package com.jas.ioc.beans;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * PropertyValues
 *
 * @author lanxiang
 * @since 2019-07-18
 */
public class PropertyValues {

    private final List<PropertyValue> propertyValueSet = Lists.newArrayList();

    public void addPropertyValue(PropertyValue propertyValue) {
        this.propertyValueSet.add(propertyValue);
    }

    public List<PropertyValue> getPropertyValues() {
        return propertyValueSet;
    }
}
