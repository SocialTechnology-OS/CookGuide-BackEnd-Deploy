package com.cookguide.database.cookAPI.application.services.impl;

import com.cookguide.database.cookAPI.application.services.AccountService;
import com.cookguide.database.cookAPI.domain.entities.Account;
import com.cookguide.database.cookAPI.infraestructure.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public Account createAccount(Account account){
        return accountRepository.save(account);
    }
    @Override
    public  Account updateAccount(Account account){
        return accountRepository.save(account);
    }
    @Override
    public  Account getAccountById(Long id){
        return accountRepository.findById(id).get();
    }
    @Override
    public List<Account> getAllAccounts(){
        return (List<Account>) accountRepository.findAll();
    }
    @Override
    public  void deleteAccount(Long id){
        accountRepository.deleteById(id);
    }
    @Override
    public  boolean isAccountExist(Long id){
        return accountRepository.existsById(id);
    }

}