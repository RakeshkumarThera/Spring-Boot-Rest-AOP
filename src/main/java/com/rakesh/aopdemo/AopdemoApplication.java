package com.rakesh.aopdemo;

import com.rakesh.aopdemo.dao.AccountDAO;
import com.rakesh.aopdemo.dao.MembershipDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AopdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopdemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AccountDAO theAccountDAO, MembershipDAO theMembershipDAO) {
		return runner -> {
			demoTheBeforeAdvice(theAccountDAO, theMembershipDAO);
		};
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
