package org.w3cschool.spring.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

/**
 * 注解配置
 */
@Aspect
@Component
public class Logging {
    @Pointcut("execution(* org.w3cschool.spring.aspect.*.*(..))")
    private void selectAll() {
    }

    @Before("selectAll()")
    public void beforeAdvice() {
        System.out.println("Going to setup student profile.");
    }

    @After("selectAll()")
    public void afterAdvice() {
        System.out.println("Student profile has been setup.");
    }

    @AfterReturning(pointcut = "selectAll()", returning = "retVal")
    public void afterReturningAdvice(Object retVal) {
        System.out.println("Returning:" + retVal.toString());
    }

    @AfterThrowing(pointcut = "selectAll()", throwing = "ex")
    public void afterThrowingAdvice(IllegalArgumentException ex) {
        System.out.println("There has been an exception: " + ex.toString());
    }

    @Around("selectAll()")
    public Object aroundAdvice(ProceedingJoinPoint pjp) throws Throwable {
        //start stopwatch
        StopWatch sw = new StopWatch();
        sw.start();
        Object retVal = pjp.proceed();
        //stop stopwatch
        sw.stop();
        long totalTimeMillis = sw.getTotalTimeMillis();
        return retVal;
    }
}
