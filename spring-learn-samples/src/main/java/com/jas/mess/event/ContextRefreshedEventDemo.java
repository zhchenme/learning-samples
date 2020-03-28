package com.jas.mess.event;

import com.alibaba.fastjson.JSON;
import com.jas.mess.bean.User;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

import java.util.Map;

/**
 * @author <a href="mailto:chen.zhang@yunhuyj.com">lanxiang</a>
 * @since 2020/03/13
 */
public class ContextRefreshedEventDemo implements ApplicationListener<ContextRefreshedEvent> {

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        // 加这个判断是为了防止在父容器存在的情况下将事件广播给父容器
        if (null == event.getApplicationContext().getParent()) {
            Map<String, User> beansOfType = event.getApplicationContext().getBeansOfType(User.class);
            // System.out.println(JSON.toJSON(beansOfType));
        }
    }
}
