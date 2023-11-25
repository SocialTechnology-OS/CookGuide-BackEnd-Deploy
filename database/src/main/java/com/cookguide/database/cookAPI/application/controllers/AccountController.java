package com.cookguide.database.cookAPI.application.controllers;


import com.cookguide.database.cookAPI.application.dto.request.AccountRequestDTO;
import com.cookguide.database.cookAPI.application.dto.response.AccountResponseDTO;
import com.cookguide.database.cookAPI.application.services.AccountService;
import com.cookguide.database.shared.model.dto.response.ApiResponse;
import com.cookguide.database.shared.model.enums.Estatus;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Account", description = "Account API")
@RestController
@RequestMapping("/api/v1/cookguide")
public class AccountController {

    private AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @Operation(summary = "Get all accounts")
    @GetMapping("/accounts")
    public ResponseEntity<ApiResponse<List<AccountResponseDTO>>> getAllAccounts() {
        var res = accountService.getAllAccounts();
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @Operation(summary = "Get an account by ID")
    @GetMapping("/accounts/{id}")
    public ResponseEntity<ApiResponse<AccountResponseDTO>> getAccountById(@PathVariable("id") int id) {
        ApiResponse<AccountResponseDTO> response = accountService.getAccountById(id);
        return new ResponseEntity<>(response, response.getStatus() == Estatus.SUCCESS ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }

    @Operation(summary = "Create a new account")
    @PostMapping("/accounts")
    public ResponseEntity<ApiResponse<AccountResponseDTO>> createAccount(@RequestBody AccountRequestDTO accountRequestDTO) {
        var res = accountService.createAccount(accountRequestDTO);
        return new ResponseEntity<>(res, HttpStatus.CREATED);
    }

    @Operation(summary = "Update an existing account")
    @PutMapping("/accounts/{id}")
    public ResponseEntity<ApiResponse<AccountResponseDTO>> updateAccount(@PathVariable int id, @RequestBody AccountRequestDTO accountRequestDTO) {
        var res = accountService.updateAccount(id, accountRequestDTO);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @Operation(summary = "Delete an account")
    @DeleteMapping("/accounts/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteAccount(@PathVariable int id) {
        var res = accountService.deleteAccount(id);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

}
