package com.jas.mess.event;

import org.springframework.context.ApplicationEvent;

/**
 * @author <a href="mailto:chen.zhang@yunhuyj.com">lanxiang</a>
 * @since 2020/03/13
 */
public class EventDemo extends ApplicationEvent {

    private static final long serialVersionUID = -8363050754445002832L;

    private String message;

    public EventDemo(Object source, String message) {
        super(source);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
