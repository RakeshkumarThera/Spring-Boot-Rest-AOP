package com.rakesh.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {
    // this is where we add all of our related advices for logging
    // let's start with a @Before advice
    //    @Before("execution(public void add*())") //calling any class that starts with add

    @Before("com.rakesh.aopdemo.aspect.AopExpressions.forDAOPackageNoGetterSetter()")// Match on any class, method or arguments in specified package
    public void beforeAddAccountAdvice(){
        System.out.println("\n======>>>> Executing @Before advice on addAccount()");
    }

}
