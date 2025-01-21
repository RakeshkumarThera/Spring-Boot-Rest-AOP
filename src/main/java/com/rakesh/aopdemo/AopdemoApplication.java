package com.rakesh.aopdemo;

import com.rakesh.aopdemo.dao.AccountDAO;
import com.rakesh.aopdemo.dao.MembershipDAO;
import com.rakesh.aopdemo.service.TrafficFortuneService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class AopdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopdemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AccountDAO theAccountDAO,
											   MembershipDAO theMembershipDAO,
											   TrafficFortuneService theTrafficFortuneService)  {
		return runner -> {
//			demoTheBeforeAdvice(theAccountDAO, theMembershipDAO);
//			demoTheAfterReturningAdvice(theAccountDAO);
//			demoTheAfterThrowingAdvice(theAccountDAO);
//			demoTheAfterAdvice(theAccountDAO);

//			demoTheAroundService(theTrafficFortuneService);

//			demoTheAroundServiceHandleException(theTrafficFortuneService);
			demoTheAroundServiceRethrowException(theTrafficFortuneService);


		};
	}

	private void demoTheAroundServiceRethrowException(TrafficFortuneService theTrafficFortuneService) {
		System.out.println("\n Main Program: demoTheAroundServiceRethrowException");
		System.out.println("Calling getFortune()");

		boolean tripWire = true;

		String data = theTrafficFortuneService.getFortune(tripWire);
		System.out.println("\n My Fortune is: " + data);
		System.out.println("Finished");
	}

	private void demoTheAroundServiceHandleException(TrafficFortuneService theTrafficFortuneService) {
		System.out.println("\n Main Program: demoTheAroundServiceHandleException");
		System.out.println("Calling getFortune()");

		boolean tripWire = true;

		String data = theTrafficFortuneService.getFortune(tripWire);
		System.out.println("\n My Fortune is: " + data);
		System.out.println("Finished");
	}

	private void demoTheAroundService(TrafficFortuneService theTrafficFortuneService) {
		System.out.println("\n Main Program: demoTheAroundAdvice");
		System.out.println("Calling getFortune()");
		String data = theTrafficFortuneService.getFortune();
		System.out.println("\n My Fortune is: " + data);
		System.out.println("Finished");
	}

	private void demoTheAfterAdvice(AccountDAO theAccountDAO) {
		List<Account> theAccounts = null;

		try {
			// add a boolean flag to simulate exceptions
			boolean tripWire = false;
			theAccounts = theAccountDAO.findAccounts(tripWire);
		} catch (Exception exc){
			System.out.println("\n\n Main Program: ... Caught Exception: " + exc);
		}

		//display the accounts
		System.out.println("\n\n Main Program : demoTheAfterThrowingAdvice");
		System.out.println("----");
		System.out.println(theAccounts);
		System.out.println("\n");
	}

	private void demoTheAfterThrowingAdvice(AccountDAO theAccountDAO) {
		List<Account> theAccounts = null;

		try {
			// add a boolean flag to simulate exceptions
			boolean tripWire = true;
			theAccounts = theAccountDAO.findAccounts(tripWire);
		} catch (Exception exc){
			System.out.println("\n\n Main Program: ... Caught Exception: " + exc);
		}

		//display the accounts
		System.out.println("\n\n Main Program : demoTheAfterThrowingAdvice");
		System.out.println("----");
		System.out.println(theAccounts);
		System.out.println("\n");
	}

	private void demoTheAfterReturningAdvice(AccountDAO theAccountDAO) {
		// call method to find the accounts
		List<Account> theAccounts = theAccountDAO.findAccounts();

		//display the accounts
		System.out.println("\n\n Main Program : demoTheAfterReturningAdvice");
		System.out.println("----");
		System.out.println(theAccounts);
		System.out.println("\n");
	}

	private void demoTheBeforeAdvice(AccountDAO theAccountDAO, MembershipDAO theMembershipDAO) {
		Account myAccount = new Account();
		myAccount.setName("Rakesh");
		myAccount.setLevel("Platinum");

		//call the business method;
		theAccountDAO.addAccount(myAccount, true);
		theAccountDAO.doWork();

		//call the accountDAO getter/setter methods
		theAccountDAO.setName("rakesh");
		theAccountDAO.setServiceCode("Diamond");

		String name = theAccountDAO.getName();
		String code = theAccountDAO.getServiceCode();

		//call the Membership business method;
		theMembershipDAO.addAccount();
		theMembershipDAO.goToSleep();
	}
}
