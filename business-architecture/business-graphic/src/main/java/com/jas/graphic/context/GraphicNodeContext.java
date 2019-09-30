package com.jas.graphic.context;

import com.jas.graphic.core.BusinessGraphic;
import com.jas.vo.CustomVO;
import lombok.Data;

/**
 * GraphicNodeContext
 *
 * @author lanxiang
 * @since 2019-09-10
 */
@Data
public class GraphicNodeContext {

    /*--------------------------- 请求参数区 --------------------------------*/

    /**
     * 用户 ID
     */
    private String customerId;

    /**
     * 行业
     *
     * @see com.jas.constant.IndustryEnum
     */
    private Integer industry;

    /**
     * 业务场景
     *
     * @see com.jas.constant.BusinessScenarioEnum
     */
    private Integer scenario;

    /*--------------------------- 业务划分参数 --------------------------------*/

    /**
     * 业务操作
     */
    private BusinessGraphic.Operation operation;

    /*--------------------------- 返回参数区 --------------------------------*/

    /**
     * 返参
     */
    private CustomVO customVO;

    /**
     * 操作是否成功
     */
    private Boolean operationResult;
}
