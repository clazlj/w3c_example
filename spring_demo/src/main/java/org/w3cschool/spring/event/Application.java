package org.w3cschool.spring.event;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class Application {
    public static void main(String[] args) {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("Beans.xml");

        RestEventPublish eventPublish = context.getBean(RestEventPublish.class);
        RestEventPublishApplication eventPublishApplication = context.getBean(RestEventPublishApplication.class);

        AtomicInteger i = new AtomicInteger();
        new Thread(() -> {
            while (true) {
                try {
                    TimeUnit.SECONDS.sleep(2);

                    eventPublish.publishEvent(new RestEvent(new RestEventParam("ApplicationEventPublisher通知休息", "累了" + (i.incrementAndGet()))));
                    eventPublishApplication.publishEvent(new RestEvent(new RestEventParam("ApplicationContext通知休息", "累了" + (i.incrementAndGet()))));
                    System.out.println("--------------------");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
