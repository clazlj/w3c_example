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
    /**
     * 1、execution(): 表达式主体。
     * 2、第一个*号：表示返回类型，*号表示所有的类型。
     * 3、包名：表示需要拦截的包名，后面的两个句点表示当前包和当前包的所有子包，com.sample.service.impl包、子孙包下所有类的方法。
     * 4、第二个*号：表示类名，*号表示所有的类。
     * 5、*(..):最后这个星号表示方法名，*号表示所有的方法，后面括弧里面表示方法的参数，两个句点表示任何参数。
     */
    @Pointcut("execution(* org.w3cschool.spring.aspect.*.*(..))")
    private void selectAll() {
    }

    @Before("selectAll()")
    public void beforeAdvice() {
        System.out.println("Going to setup student profile.");
    }

    /**
     * args传递参数
     * @param age
     */
    @Before("selectAll() && args(age))")
    public void beforeAdvicePassParameter(Integer age) {
        System.out.println("Going to setup student profile.age:" + age);
    }

    @After("selectAll()")
    public void afterAdvice() {
        System.out.println("Student profile has been setup.");
    }

    @AfterReturning(pointcut = "selectAll()", returning = "retVal")
    public void afterReturningAdvice(Object retVal) {
        //void方法返回null
        System.out.println("Returning:" + (retVal == null ? null : retVal.toString()));
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
        //void方法返回null
        Object retVal = pjp.proceed();
        //stop stopwatch
        sw.stop();
        long totalTimeMillis = sw.getTotalTimeMillis();
        System.out.println(String.format("Total running time:%sms", totalTimeMillis));
        return retVal;
    }
}
