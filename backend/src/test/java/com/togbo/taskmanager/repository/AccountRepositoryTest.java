package com.togbo.taskmanager.repository;

import com.togbo.taskmanager.enums.Role;
import com.togbo.taskmanager.model.Account;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
class AccountRepositoryTest {

    @Autowired
    AccountRepository accountRepository;

    @Test
    @Transactional
    void checkIfAccountFindByEmailExists(){
        //given
        String email = "test@yahoo.com";
        Account account = new Account(email, "12345", Role.TESTER);
        accountRepository.save(account);
        //when
        Account expect = accountRepository.findByEmail(email);
        //then
        Assertions.assertNotNull(expect);
    }
}
