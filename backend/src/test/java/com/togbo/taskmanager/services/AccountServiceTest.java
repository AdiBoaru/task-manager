package com.togbo.taskmanager.services;

import com.togbo.taskmanager.dto.AccountEmployeeDto;
import com.togbo.taskmanager.enums.Role;
import com.togbo.taskmanager.exceptions.ResourceNotFoundException;
import com.togbo.taskmanager.model.Account;
import com.togbo.taskmanager.repository.AccountRepository;
import com.togbo.taskmanager.repository.EmployeeRepository;
import org.junit.jupiter.api.*;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


class AccountServiceTest {
    @Mock
    private AccountService accountServiceTest;
    @Mock
    private AccountRepository accountRepositoryTest;
    AutoCloseable autoCloseable;
    @Mock
    Account account;

    @BeforeEach
    void setUp(){
        autoCloseable = MockitoAnnotations.openMocks(this);
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    @DisplayName("Extract data from a DTO Object and call the repository to save it into DB ")
    void saveAccount() throws ResourceNotFoundException {
        mock(Account.class);
        mock(AccountRepository.class);

        when(accountRepositoryTest.save(account)).thenReturn(account);

        assertThat(accountServiceTest.isAccountPresent(account.getEmail())).isTrue();
    }

    @Test
    @DisplayName("Delete the object from the DB")
    void deleteAccount() {
        //given
        mock(Account.class);
        mock(AccountRepository.class, Mockito.CALLS_REAL_METHODS);

        //when
        //when(accountRepositoryTest.delete(account)).thenReturn(account);

        //then
        assertThat(accountRepositoryTest.findByEmail(account.getEmail())).isNull();
    }

    @Test
    void updateAccount() {
        mock(Account.class);
        mock(AccountRepository.class);
        Account newAccount = new Account("newEmail@yahoo.com","123456", Role.DEVELOPER);

        Optional<Account> testedAccount = accountRepositoryTest.findById(1L);
        accountRepositoryTest.save(newAccount);

        assertThat(accountRepositoryTest.findByEmail("newEmail@yahoo.com"));
    }

    @Test
    void findAll() {
    }

    @Test
    @Disabled
    void findById() {
    }

    @Test
    @Disabled
    void deleteAccountById() {
    }

    @Test
    @Disabled
    void isAccountPresent() {
    }
}