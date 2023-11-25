package com.cookguide.database.cookAPI.application.services.impl;

import com.cookguide.database.cookAPI.application.dto.request.AccountRequestDTO;
import com.cookguide.database.cookAPI.application.dto.response.AccountResponseDTO;
import com.cookguide.database.cookAPI.application.services.AccountService;
import com.cookguide.database.cookAPI.domain.entities.Account;
import com.cookguide.database.cookAPI.infraestructure.repositories.AccountRepository;
import com.cookguide.database.shared.exception.ValidationException;
import com.cookguide.database.shared.model.dto.response.ApiResponse;
import com.cookguide.database.shared.model.enums.Estatus;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
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
    public ApiResponse<AccountResponseDTO> getAccountById(int id) {
        Optional<Account> accountOptional = accountRepository.findById(id);
        if (accountOptional.isPresent()) {
            Account account = accountOptional.get();
            AccountResponseDTO responseDTO = modelMapper.map(account, AccountResponseDTO.class);
            return new ApiResponse<>("Account fetched successfully", Estatus.SUCCESS, responseDTO);
        } else {
            return new ApiResponse<>("Account not found", Estatus.ERROR, null);
        }
    }
    @Override
    public ApiResponse<AccountResponseDTO> createAccount(AccountRequestDTO accountRequestDTO) {
        validateEmail(accountRequestDTO.getEmail());
        validateDNI(accountRequestDTO.getDNI());
        validateAge(accountRequestDTO.getBirthday());
        validatePassword(accountRequestDTO.getPassword());
        validatePhoneNumber(accountRequestDTO.getPhone());
        validateEmailDomain(accountRequestDTO.getEmail());
        validateAccountType(accountRequestDTO.getType());
        validateGender(accountRequestDTO.getGender());
        validateDiet(accountRequestDTO.getDiet());

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

    private void validateEmail(String email) {
        if (!isEmailUnique(email)) {
            throw new ValidationException("Email is already in use");
        }
    }

    private void validateDNI(Long dni) {
        if (!isDniUnique(dni)) {
            throw new ValidationException("DNI must be unique");
        }
    }

    private void validateAge(LocalDate birthday) {
        if (!isAdult(birthday)) {
            throw new ValidationException("User must be at least 18 years old");
        }
    }

    private void validatePassword(String password) {
        if (!isPasswordStrong(password)) {
            throw new ValidationException("Password does not meet the strength requirements");
        }
    }

    private void validatePhoneNumber(String phone) {
        if (!isPhoneNumberValid(phone)) {
            throw new ValidationException("Phone number is invalid");
        }
    }

    private void validateEmailDomain(String email) {
        if (ALLOWED_EMAIL_DOMAINS.stream().noneMatch(email::endsWith)) {
            throw new ValidationException("Email domain is not allowed.");
        }
    }

    private void validateAccountType(String type) {
        if (!ALLOWED_ACCOUNT_TYPES.contains(type.toLowerCase())) {
            throw new ValidationException("Account type is invalid.");
        }
    }

    private void validateGender(String gender) {
        if (!ALLOWED_GENDERS.contains(gender.toLowerCase())) {
            throw new ValidationException("Gender is invalid.");
        }
    }

    private void validateDiet(String diet) {
        if (!ALLOWED_DIETS.contains(diet.toLowerCase())) {
            throw new ValidationException("Diet is invalid.");
        }
    }

    @Override
    public boolean isDniUnique(Long dni) {
        return !accountRepository.existsByDNI(dni);
    }

    @Override
    public boolean isEmailUnique(String email) {
        return !accountRepository.existsByEmail(email);
    }

    @Override
    public boolean isAdult(LocalDate birthday) {
        return Period.between(birthday, LocalDate.now()).getYears() >= 18;
    }

    @Override
    public boolean isPasswordStrong(String password) {
        String passwordRegex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$";
        return password.matches(passwordRegex);
    }

    @Override
    public boolean isPhoneNumberValid(String phone) {
        // This is a very basic example and will vary greatly depending on country and format
        String phoneRegex = "^\\+(?:[0-9] ?){6,14}[0-9]$";
        return phone.matches(phoneRegex);
    }

    private static final List<String> ALLOWED_EMAIL_DOMAINS = List.of(
            "@gmail.com", "@outlook.es", "@outlook.com", "@hotmail.com", "@yahoo.com"
    );

    private static final List<String> ALLOWED_ACCOUNT_TYPES = List.of("cocinero", "estudiante");

    private static final List<String> ALLOWED_GENDERS = List.of("femenino", "masculino");

    private static final List<String> ALLOWED_DIETS = List.of("omnivoro", "carnivoro", "herbivoro");


}