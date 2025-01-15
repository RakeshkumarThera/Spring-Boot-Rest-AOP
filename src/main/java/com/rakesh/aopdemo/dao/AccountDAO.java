package com.rakesh.aopdemo.dao;

import com.rakesh.aopdemo.Account;

import java.util.List;

public interface AccountDAO {

    List<Account> findAccounts(boolean tripWire);

    List<Account> findAccounts();

    void addAccount(Account theAccount, boolean vipFlag);

    boolean doWork();

    public String getName();

    public void setName(String name);

    public String getServiceCode();

    public void setServiceCode(String serviceCode);

}
