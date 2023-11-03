package com.togbo.taskmanager.services;

import com.togbo.taskmanager.model.Account;
import com.togbo.taskmanager.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AccountService {
    @Autowired
    private AccountRepository accountRepository;

    private void addAccount(Account account){
        accountRepository.save(account);
    }

    public void deleteAccount(Account account){
        accountRepository.delete(account);
    }

    public void updateAccount(UUID id, Account account) {
        Optional<Account> foundAccount = accountRepository.findById(id);
        if (foundAccount.isPresent()) {
            accountRepository.save(account);
        }
    }

    public List<Account> findAll(){
        return accountRepository.findAll();
    }
}
