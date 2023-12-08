package com.togbo.taskmanager.services;

import com.togbo.taskmanager.dto.AccountEmployeeDto;
import com.togbo.taskmanager.exceptions.ResourceNotFoundException;
import com.togbo.taskmanager.model.Account;
import com.togbo.taskmanager.repository.AccountRepository;
import com.togbo.taskmanager.repository.EmployeeRepository;
import org.junit.jupiter.api.*;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


class AccountServiceTest {
    @Mock
    private AccountService accountServiceTest;
    @Mock
    private AccountRepository accountRepositoryTest;
    @Mock
    private EmployeeRepository employeeRepositoryTest;
    @Mock
    private PasswordEncoder passwordEncoder;
    @Mock
    private EmailService emailService;
    AutoCloseable autoCloseable;
    @Mock
    AccountEmployeeDto accountEmployeeDto;
    @Mock
    Account account;

    @BeforeEach
    void setUp(){
        autoCloseable = MockitoAnnotations.openMocks(this);
        accountServiceTest = new AccountService(
                accountRepositoryTest,
                passwordEncoder,
                emailService,
                employeeRepositoryTest);
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
    @Disabled
    void deleteAccount() {
    }

    @Test
    @Disabled
    void updateAccount() {
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