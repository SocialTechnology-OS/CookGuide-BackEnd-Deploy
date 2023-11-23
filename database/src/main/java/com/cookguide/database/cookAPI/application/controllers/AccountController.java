package com.cookguide.database.cookAPI.application.controllers;

import com.cookguide.database.shared.exception.ValidationException;
import com.cookguide.database.cookAPI.domain.entities.Account;
import com.cookguide.database.cookAPI.infraestructure.repositories.AccountRepository;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.Optional;


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
    @GetMapping("/accounts/{id}")
    public ResponseEntity<Account> getAccountById(@PathVariable int id) {
        Optional<Account> account = accountRepository.findById(id);
        return account.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/accounts/{id}")
    public ResponseEntity<Void> deleteAccount(@PathVariable int id) {
        if (accountRepository.existsById(id)) {
            accountRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @PutMapping("/accounts/{id}")
    public ResponseEntity<Account> updateAccount(@PathVariable int id, @RequestBody Account updatedAccount) {
        Optional<Account> existingAccount = accountRepository.findById(id);
        if (existingAccount.isPresent()) {
            // Cambio de Nombres, Dieta, Fecha de Cumpleaños y Numero
            Account account = existingAccount.get();
            account.setFirstName(updatedAccount.getFirstName());
            account.setLastName(updatedAccount.getLastName());
            account.setDiet(updatedAccount.getDiet());
            account.setBirthday(updatedAccount.getBirthday());
            account.setPhone(updatedAccount.getPhone());

            // Ejemplo: account.setNombre(updatedAccount.getNombre());


            Account savedAccount = accountRepository.save(account);
            return ResponseEntity.ok(savedAccount);
        } else {
            return ResponseEntity.notFound().build();
        }
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
