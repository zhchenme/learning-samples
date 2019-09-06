package com.jas.aop;

import lombok.Data;
import org.aopalliance.intercept.MethodInterceptor;

/**
 * AdvisedSupport
 *
 * @author lanxiang
 * @since 2019-07-29
 */
@Data
public class AdvisedSupport {

    private TargetSource targetSource;

    private MethodInterceptor methodInterceptor;
}
