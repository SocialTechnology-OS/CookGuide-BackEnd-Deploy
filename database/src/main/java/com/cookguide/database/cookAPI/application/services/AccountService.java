package com.cookguide.database.cookAPI.application.services;

import com.cookguide.database.cookAPI.application.dto.request.AccountRequestDTO;
import com.cookguide.database.cookAPI.application.dto.response.AccountResponseDTO;
import com.cookguide.database.cookAPI.domain.entities.Account;
import com.cookguide.database.shared.model.dto.response.ApiResponse;

import java.time.LocalDate;
import java.util.List;

public interface AccountService {
    ApiResponse<List<AccountResponseDTO>> getAllAccounts();
    ApiResponse<AccountResponseDTO> getAccountById(int id);
    ApiResponse<AccountResponseDTO> createAccount(AccountRequestDTO accountRequestDTO);
    ApiResponse<AccountResponseDTO> updateAccount(int id, AccountRequestDTO accountRequestDTO);
    ApiResponse<Void> deleteAccount(int id);

    boolean isDniUnique(Long dni);
    boolean isEmailUnique(String email);
    boolean isAdult(LocalDate birthday);
    boolean isPasswordStrong(String password);
    boolean isPhoneNumberValid(String phone);

}
