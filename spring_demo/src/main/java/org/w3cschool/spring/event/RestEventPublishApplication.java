package org.w3cschool.spring.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class RestEventPublishApplication {
    //继承ApplicationEventPublisher
    @Autowired
    private ApplicationContext applicationContext;

    public void publishEvent(RestEvent event) {
        applicationContext.publishEvent(event);
    }
}
