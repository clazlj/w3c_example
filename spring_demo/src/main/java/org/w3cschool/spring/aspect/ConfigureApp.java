package org.w3cschool.spring.aspect;

import org.springframework.context.annotation.*;

@Configuration
@ComponentScans(value = {@ComponentScan(basePackages = "org.w3cschool.spring.aspect")})
@EnableAspectJAutoProxy
public class ConfigureApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConfigureApp.class);

        StudentComponent student = context.getBean(StudentComponent.class);
        student.getName();
        student.getAge();
        student.setAge(6);
        student.printThrowException();
    }
}
