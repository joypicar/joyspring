package com.joyspring.demo.service;

import com.joyspring.demo.domain.entity.Account;
import com.joyspring.demo.domain.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class MockAccountGenerateService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private AccountIdGenerationService accountIdGenerationService;

    public void generateAccounts() {
        Account account1=  Account.builder()
                .balance(new BigDecimal(100))
                .name("Joy Lab")
                .build();
        accountRepository.save(account1);

        Account account2=  Account.builder()
                .balance(new BigDecimal(200))
                .name("Noreen Laz")
                .build();

        accountRepository.save(account2);

        Account account3=  Account.builder()
                .balance(new BigDecimal(10000))
                .name("Bo Castil")
                .build();

        accountRepository.save(account3);
    }
}