package com.jas.ioc.beans;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * PropertyValue
 *
 * @author lanxiang
 * @since 2019-07-18
 */
@Data
@AllArgsConstructor
public class PropertyValue {

    private final String name;

    private final Object value;
}
