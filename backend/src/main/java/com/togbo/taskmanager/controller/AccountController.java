package com.togbo.taskmanager.controller;

import com.togbo.taskmanager.model.Account;
import com.togbo.taskmanager.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/account")
public class AccountController {
    private final AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService){
        this.accountService = accountService;
    }

    @GetMapping
    public List<Account> findAllAccounts(){
        return this.accountService.findAll();
    }

    @GetMapping("/{id}")
    public Account findById(@PathVariable UUID id){
//        Optional<Account> foundAccount = Optional.ofNullable(accountService.findById(id));
//        return foundAccount.map(account -> new ResponseEntity<>(account, HttpStatus.FOUND))
//                .orElseGet(() -> new ResponseEntity<>(null, HttpStatus.NOT_FOUND));

        return accountService.findById(id);
    }

    @PostMapping("/save")
    public ResponseEntity<Account> saveAccount(@RequestBody Account account){
        accountService.addAccount(account);

        return new ResponseEntity<>(account, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Account> updateAccount(@PathVariable UUID id, @RequestBody Account account){
        accountService.updateAccount(id, account);

        return new ResponseEntity<>(account, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Account> deleteAccount(@PathVariable UUID id){
        accountService.deleteAccountById(id);

        return new ResponseEntity<>(null, HttpStatus.OK);
    }


}
