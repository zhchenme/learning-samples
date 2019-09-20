package com.jas.request;

import lombok.Data;

/**
 * CommonRequest
 *
 * @author lanxiang
 * @since 2019-09-10
 */
@Data
public class CommonRequest extends AbstractRequest {

    /**
     * 当前操作用户
     */
    private String customerId;

    // ... 根据业务场景自定义字段

    /**
     * 所属行业
     *
     * @see com.jas.constant.IndustryEnum
     */
    private Integer industry;

    /**
     * 所在业务场景
     *
     * @see com.jas.constant.BusinessScenarioEnum
     */
    private Integer businessScenario;
}
