package com.rakesh.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(3)
public class MyApiAnalyticsAspect {

    @Before("com.rakesh.aopdemo.aspect.AopExpressions.forDAOPackage()forDAOPackageNoGetterSetter()")
    public void performApiAnalytics(){
        System.out.println("\n======>>>> Performing API analytics");
    }

}
