package org.w3cschool.spring.aspect;

/**
 * xml配置
 */
public class LoggingX {
    public void beforeAdvice(){
        System.out.println("Going to setup student profile.");
    }

    public void afterAdvice(){
        System.out.println("Student profile has been setup.");
    }

    public void afterReturningAdvice(Object retVal){
        System.out.println("Returning:" + retVal.toString() );
    }

    public void afterThrowingAdvice(IllegalArgumentException ex){
        System.out.println("There has been an exception: " + ex.toString());
    }
}
