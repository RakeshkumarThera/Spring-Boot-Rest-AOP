package com.rakesh.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AopExpressions {
    @Pointcut("execution(* com.rakesh.aopdemo.dao.*.*(..))")
    public void forDAOPackage() {}

    // create a pointcut for getter methods
    @Pointcut("execution(* com.rakesh.aopdemo.dao.*.get*(..))")
    public void getter() {}

    // create a pointcut for setter methods
    @Pointcut("execution(* com.rakesh.aopdemo.dao.*.set*(..))")
    public void setter() {}

    // create a pointcut: include package ... exclude getter/setter
    @Pointcut("forDAOPackage() && !(getter() || setter())")
    public void forDAOPackageNoGetterSetter(){}
}
