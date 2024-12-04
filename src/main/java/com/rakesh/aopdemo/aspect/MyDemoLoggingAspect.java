package com.rakesh.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
    // this is where we add all of our related advices for logging
    // let's start with a @Before advice
    @Before("execution(public void add*())") //calling specific class
    public void beforeAddAccountAdvice(){
        System.out.println("\n======>>>> Executing @Before advice on addAccount()");
    }
}
