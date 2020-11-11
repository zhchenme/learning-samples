package com.zhchen.im.protocol;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author <a href="mailto:chen.zhang@yunhuyj.com">lanxiang</a>
 * @since 2020/11/11
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Session {

    private String userId;

    private String userName;

}
