package com.jas.vo;

import lombok.Data;

/**
 * ComplexVO
 *
 * @author lanxiang
 * @since 2019-09-30
 */
@Data
public class ComplexVO extends BaseVO {

    private static final long serialVersionUID = 8815860786016280876L;
    /**
     * 返参
     */
    private CustomVO customVO;

    /**
     * 操作是否成功
     */
    private Boolean operationResult;
}
