package com.rakesh.aopdemo.dao;

import com.rakesh.aopdemo.Account;

public interface AccountDAO {
    void addAccount(Account theAccount, boolean vipFlag);

    boolean doWork();

}
