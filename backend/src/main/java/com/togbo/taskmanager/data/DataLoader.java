package com.togbo.taskmanager.data;

import com.togbo.taskmanager.enums.Role;
import com.togbo.taskmanager.model.Account;
import com.togbo.taskmanager.model.Employee;
import com.togbo.taskmanager.repository.AccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.UUID;

@Component
public class DataLoader implements CommandLineRunner {

    private final AccountRepository accountRepository;

    public DataLoader(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        for(int i = 0; i < 5; i++){
            Account account = new Account();
            account.setId(UUID.randomUUID());
            account.setPassword("1234");
            account.setCreatedDate(LocalDate.now());
            account.setRole(Role.DEVELOPER);

            accountRepository.save(accountRepository.save(account));
        }

        for(int i = 0; i < 5; i++){
            Employee employee = new Employee();
         /*   employee.setId(UUID.randomUUID());
            employee.setPassword("1234");
            employee.setCreatedDate(LocalDate.now());
            employee.setRole(Role.DEVELOPER);

            accountRepository.save(accountRepository.save(account));
       */
        }
    }


}
