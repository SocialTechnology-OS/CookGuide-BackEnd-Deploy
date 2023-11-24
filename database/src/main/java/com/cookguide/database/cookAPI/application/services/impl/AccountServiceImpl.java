package com.cookguide.database.cookAPI.application.services.impl;

import com.cookguide.database.cookAPI.application.dto.request.AccountRequestDTO;
import com.cookguide.database.cookAPI.application.dto.response.AccountResponseDTO;
import com.cookguide.database.cookAPI.application.services.AccountService;
import com.cookguide.database.cookAPI.domain.entities.Account;
import com.cookguide.database.cookAPI.infraestructure.repositories.AccountRepository;
import com.cookguide.database.shared.model.dto.response.ApiResponse;
import com.cookguide.database.shared.model.enums.Estatus;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;
    private final ModelMapper modelMapper;

    public AccountServiceImpl(AccountRepository accountRepository, ModelMapper modelMapper) {
        this.accountRepository = accountRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ApiResponse<List<AccountResponseDTO>> getAllAccounts() {
        List<Account> accountList = (List<Account>) accountRepository.findAll();
        List<AccountResponseDTO> accountDTOList = accountList.stream()
                .map(entity -> modelMapper.map(entity, AccountResponseDTO.class))
                .collect(Collectors.toList());

        return new ApiResponse<>("All accounts fetched successfully", Estatus.SUCCESS, accountDTOList);
    }

    @Override
    public ApiResponse<AccountResponseDTO> createAccount(AccountRequestDTO accountRequestDTO) {
        var account = modelMapper.map(accountRequestDTO, Account.class);
        accountRepository.save(account);

        var response = modelMapper.map(account, AccountResponseDTO.class);

        return new ApiResponse<>("Account created successfully", Estatus.SUCCESS, response);
    }

    @Override
    public ApiResponse<AccountResponseDTO> updateAccount(int id, AccountRequestDTO accountRequestDTO) {
        Optional<Account> accountOptional = accountRepository.findById((int) id);
        if (accountOptional.isPresent()) {
            Account accountToUpdate = accountOptional.get();
            modelMapper.map(accountRequestDTO, accountToUpdate);
            accountRepository.save(accountToUpdate);
            AccountResponseDTO responseDTO = modelMapper.map(accountToUpdate, AccountResponseDTO.class);
            return new ApiResponse<>("Account updated successfully", Estatus.SUCCESS, responseDTO);
        } else {
            return new ApiResponse<>("Account not found", Estatus.ERROR, null);
        }
    }

    @Override
    public ApiResponse<Void> deleteAccount(int id) {
        if (accountRepository.existsById(id)) {
            accountRepository.deleteById(id);
            return new ApiResponse<>("Account deleted successfully", Estatus.SUCCESS, null);
        } else {
            return new ApiResponse<>("Account not found", Estatus.ERROR, null);
        }
    }

}