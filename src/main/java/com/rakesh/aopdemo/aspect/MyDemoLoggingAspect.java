package com.rakesh.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
    // this is where we add all of our related advices for logging
    // let's start with a @Before advice
//    @Before("execution(public void add*())") //calling any class that starts with add

    @Before("execution(* add*(com.rakesh.aopdemo.Account))")// Match on any return type instead of void only
    public void beforeAddAccountAdvice(){
        System.out.println("\n======>>>> Executing @Before advice on addAccount()");
    }
}
