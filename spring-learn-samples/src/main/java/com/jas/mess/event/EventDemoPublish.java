package com.jas.mess.event;

import org.springframework.context.ApplicationEventPublisher;

/**
 * @author <a href="mailto:chen.zhang@yunhuyj.com">lanxiang</a>
 * @since 2020/03/13
 */
public class EventDemoPublish {

    public void publish(ApplicationEventPublisher applicationEventPublisher, String message) {
        EventDemo eventDemo = new EventDemo(this, message);
        applicationEventPublisher.publishEvent(eventDemo);
    }

}
