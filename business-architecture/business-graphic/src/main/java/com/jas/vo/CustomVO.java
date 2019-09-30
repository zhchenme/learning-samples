package com.jas.vo;

import lombok.Data;

import java.util.List;

/**
 * CustomVO
 *
 * @author lanxiang
 * @since 2019-09-25
 */
@Data
public class CustomVO extends BaseVO {

    private static final long serialVersionUID = -942835658570925105L;
    /**
     * 测试返回数据
     */
    private List<String> list;


    // 可根据业务场景定义返回字段
}
