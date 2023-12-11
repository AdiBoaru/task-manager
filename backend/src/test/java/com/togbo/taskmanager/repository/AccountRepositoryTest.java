package com.togbo.taskmanager.repository;

import com.togbo.taskmanager.enums.Role;
import com.togbo.taskmanager.model.Account;
import jakarta.transaction.Transactional;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@DataJpaTest //make use of in memory db
class AccountRepositoryTest {

    //GIVEN data -> WHEN there is some execution -> THEN there will be some output
    @Autowired
    private AccountRepository accountRepository;
    Account account;

    @BeforeEach
    void setUp() {
        String email = "test@yahoo.com";
        account = new Account(email, "12345", Role.TESTER);

        accountRepository.save(account);
    }

    @AfterEach
    void tearDown() {
        account = null;
        accountRepository.deleteAll();
    }

    //Test Case Success
    @Test
    void shouldFindUserByEmail(){
        //given
        Account accountExpected = accountRepository.findByEmail("test@yahoo.com");

        //when
        //then
        assertThat(account.getEmail()).isEqualTo(accountExpected.getEmail());
        assertThat(account.getRole()).isEqualTo(Role.TESTER);
        assertThat(account.getPassword()).isEqualTo("12345");

    }

    //Test Case Failure
    @Test
    void checkIfAccountNotEqualWithExpectedEmail(){
        Account accountExpected = accountRepository.findByEmail("te@yahoo.com");
        assertThat(accountExpected).isNull();
    }

}
