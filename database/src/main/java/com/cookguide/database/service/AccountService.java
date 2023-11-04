package com.cookguide.database.service;

import com.cookguide.database.model.Account;

import java.util.List;

public interface AccountService {
    public abstract Account createAccount(Account account);

    public abstract Account updateAccount(Account account);
    public abstract Account getAccountById(int id);
    public abstract List<Account> getAllAccounts();
    public abstract void deleteAccount(int id);
    public abstract boolean isAccountExist(int id);
}
