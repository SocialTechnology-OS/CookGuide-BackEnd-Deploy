package com.cookguide.database.controller;

import com.cookguide.database.exception.ValidationException;
import com.cookguide.database.model.Account;
import com.cookguide.database.repository.AccountRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/login/v1")
public class AccountController {
    @Autowired
    private AccountRepository accountRepository;

    @Transactional
    @PostMapping("/accounts")
    public ResponseEntity<Account> createAccount(@RequestBody Account account)
    {
        validateAccount(account);
        Account savedAccount = accountRepository.save(account);
        return ResponseEntity.ok(savedAccount);
    }

    private void validateAccount(Account account){
        String emailRegex = "^[A-Za-z0-9_-]+@(gmail\\.com|yahoo\\.com|outlook\\.com)$";

        if (!account.getUserEmail().matches(emailRegex)) {
            throw new ValidationException("Invalid Email or domain not allowed");
        }
        if (account.getFirstName().length() > 100){
            throw new ValidationException("Maximun limit of characters");
        }

    }




}
