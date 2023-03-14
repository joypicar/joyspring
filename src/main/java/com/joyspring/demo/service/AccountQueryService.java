package com.joyspring.demo.service;

import com.joyspring.demo.domain.entity.Account;
import com.joyspring.demo.domain.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountQueryService {

    @Autowired
    private AccountRepository accountRepository;

    public Optional<Account> getAccountById(Long accountId) {
        return  accountRepository.findById(accountId);
    }

    public List<Account> getAccounts() {
        return accountRepository.findAll();
    }

    public Account postAccount(Account account) {
        Optional<Account> existingAccount = accountRepository.findByName((account.getName()));
        if (existingAccount.isPresent()) {
            throw new IllegalArgumentException("Item already exists");
        }
        return accountRepository.save(account);
    }

    public void deleteAccount(Long accountId) {
        Optional<Account> existingAccount = accountRepository.findById(accountId);
        if (!existingAccount.isPresent()) {
            throw new IllegalArgumentException("Item didn't exist");
        }
        accountRepository.deleteById(accountId);
    }
}