package com.joyspring.demo.controller;

import com.joyspring.demo.domain.entity.Account;
import com.joyspring.demo.service.AccountQueryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/account")
public class AccountQueryController {

    private final AccountQueryService accountQueryService;

    public AccountQueryController(AccountQueryService accountQueryService) {
        this.accountQueryService = accountQueryService;
    }

    @GetMapping("/test")
    public String test() {
        return "hello";
    }

    @GetMapping("/{accountId}")
    public ResponseEntity<Account> getAccountById(@PathVariable(value = "accountId") Long accountId) {
        Optional<Account> accountOpt = accountQueryService.getAccountById(accountId);
        return accountOpt.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/list")
    public Account createItem(@RequestBody Account account) {
        return accountQueryService.postAccount(account);
    }

    @GetMapping("/list")
    public List<Account> getAccounts() {
        return accountQueryService.getAccounts();
    }

    @DeleteMapping("/{accountId}")
    public ResponseEntity<String> deleteItem(@PathVariable(value = "accountId") Long accountId) {
        Optional<Account> accountOpt = accountQueryService.getAccountById(accountId);
        if (accountOpt.isPresent()) {
            accountQueryService.deleteAccount(accountId);
            return ResponseEntity.ok().body("Entity with ID " + accountId + " was successfully deleted");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Entity with ID " + accountId + " not found");
        }
    }

}