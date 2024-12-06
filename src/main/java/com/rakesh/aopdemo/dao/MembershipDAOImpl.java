package com.rakesh.aopdemo.dao;

import org.springframework.stereotype.Repository;

@Repository
public class MembershipDAOImpl implements MembershipDAO {

    @Override
    public void addAccount() {
        System.out.println(getClass() + "DOING MY DB WORK: ADDING AN MEMBERSHIP ACCOUNT");
    }

    @Override
    public void goToSleep() {
        System.out.println(getClass() + "I am going to sleep now... zzZZ");
    }
}
