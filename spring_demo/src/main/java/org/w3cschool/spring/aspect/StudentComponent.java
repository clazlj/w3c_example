package org.w3cschool.spring.aspect;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class StudentComponent
//        implements InitializingBean
{
    private Integer age;
    private String name;
    public void setAge(Integer age) {
        this.age = age;
    }
    public Integer getAge() {
        System.out.println("Age : " + age );
        return age;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        System.out.println("Name : " + name );
        return name;
    }
    public void printThrowException(){
        System.out.println("Exception raised");
        throw new IllegalArgumentException();
    }

    @PostConstruct
    public void init() {
        this.name = "Zara";
        this.age = 11;
    }

//    @Override
//    public void afterPropertiesSet() throws Exception {
//        this.name = "Zara";
//        this.age = 11;
//    }
}
