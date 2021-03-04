package org.w3cschool.spring.event;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class RestEventListener implements ApplicationListener<RestEvent> {
    @Override
    public void onApplicationEvent(RestEvent event) {
        RestEventParam eventParam = (RestEventParam) event.getSource();
        System.out.println(eventParam.getReason().concat(",").concat(eventParam.getMsg()));
    }
}
