package com.bankmanagementsystem.accounting.services;

import com.bankmanagementsystem.accounting.repositories.AccountRepository;
import org.springframework.stereotype.Service;

import com.bankmanagementsystem.accounting.models.Account;
import com.bankmanagementsystem.accounting.dtos.AcccountDTO;
import com.bankmanagementsystem.accounting.dtos.CreateAccountDTO;
import com.bankmanagementsystem.common.dtos.GenericConverter;

import java.util.Optional;

@Service
public class AccountService {

    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public AcccountDTO createAccount(CreateAccountDTO createAccount) {
        Account account = GenericConverter.convertToEntity(createAccount, Account.class);
        return accountRepository.save(account);
    }

    public Optional<AcccountDTO> getAccountById(String id) {
        Account account =  accountRepository.findById(id);
        return GenericConverter.convertToDto(account, CreateAccountDTO.class);
    }

    public Optional<AcccountDTO> updateAccountById(String id, CreateAccountDTO updateAccountDTO) {
        Account existingAccount = accountRepository.findById(id);
        existingAccount.setCurrency(updateAccountDTO.getCurrency());
        Account updatedAccount = accountRepository.save(existingAccount);
        return GenericConverter.convertToDto(updatedAccount, AcccountDTO.class);

    }

    public void deleteAccountById(String id) {
        accountRepository.deleteById(id);
    }


}