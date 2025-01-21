package com.rakesh.aopdemo.aspect;

import com.rakesh.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

    @After("execution(* com.rakesh.aopdemo.dao.AccountDAO.findAccounts(..))")
    public void afterFinallyFindAccountsAdvice(JoinPoint theJoinPoint){

        //print out which method we are advising on
        String method = theJoinPoint.getSignature().toShortString();
        System.out.println("\n =======>>> Executing @After (finally) on method: "  + method);
    }

    // add a new advice for @AfterReturning on the findAccounts method
    @AfterThrowing(pointcut = "execution(* com.rakesh.aopdemo.dao.AccountDAO.findAccounts(..))",
                    throwing = "theExc")
    public void afterThrowingFindAccountsAdvice(JoinPoint theJoinPoint, Throwable theExc){

        //print out which method we are advising on
        String method = theJoinPoint.getSignature().toShortString();
        System.out.println("\n =======>>> Executing @AfterThrowing on method: "  + method);


        // log the exception
        System.out.println("\n =======>>> The Exception is: "  + theExc);


    }


    @AfterReturning(
            pointcut = "execution(* com.rakesh.aopdemo.dao.AccountDAO.findAccounts(..))",
            returning = "results")
    public void afterReturningFindAccountsAdvice(JoinPoint theJoinPoint, List<Account> results){
        // print out which method we are advising on
        String method = theJoinPoint.getSignature().toShortString();
        System.out.println("\n =======>>> Executing @AfterReturning on method: "  + method);

        // print out the results of the method call
        System.out.println("\n =======>>> result is: "  + results);


        // let's post-process the data ... let's modify ;)

        // convert the account names to uppercase
        converTheAccountNamesToUpperCase(results);

        System.out.println("\n =======>>> result is: "  + results);
    }

    private void converTheAccountNamesToUpperCase(List<Account> results) {
        // loop through the accounts
        for (Account tempAccount : results) {

            // get uppercase versions of name
            String theUpperName = tempAccount.getName().toUpperCase();

            // update the name on the account
            tempAccount.setName(theUpperName);
        }
    }

    @Before("com.rakesh.aopdemo.aspect.AopExpressions.forDAOPackageNoGetterSetter()")// Match on any class, method or arguments in specified package
    public void beforeAddAccountAdvice(JoinPoint theJoinPoint){
        System.out.println("\n======>>>> Executing @Before advice on addAccount()");

        // display the method signature
        MethodSignature methodSignature = (MethodSignature) theJoinPoint.getSignature();
        System.out.println("Method: " + methodSignature);

        //display method arguments

        //get args
        Object[] args = theJoinPoint.getArgs();

        //loop thru args
        for(Object tempArg: args){
            System.out.println(tempArg);

            if (tempArg instanceof Account){
                // downcast the print Account specific stuff

                Account theAccount = (Account) tempArg;
                System.out.println("Account Name: " + theAccount.getName());
                System.out.println("Account Level: " + theAccount.getLevel());
            }
        }
    }
}
