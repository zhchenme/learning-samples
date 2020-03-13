package com.jas.mess.event;

import org.springframework.context.ApplicationListener;

/**
 * @author <a href="mailto:chen.zhang@yunhuyj.com">lanxiang</a>
 * @since 2020/03/13
 */
public class EventDemo2Listener implements ApplicationListener<EventDemo> {
    public void onApplicationEvent(EventDemo event) {
        System.out.println(this + " receiver " + event.getMessage());
    }
}
