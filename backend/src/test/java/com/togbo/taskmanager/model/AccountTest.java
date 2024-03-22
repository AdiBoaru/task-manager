package com.togbo.taskmanager.model;

import com.togbo.taskmanager.enums.Role;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

import java.time.LocalDate;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;


class AccountTest {

    @InjectMocks
    private Account account;

    @Test
    void createAccountWith5Param() {
        //given
        String email = "test@yahoo.com";
        String password = "123456";
        Role role = Role.TESTER;
        UUID uuid = UUID.randomUUID();
        LocalDate localDate = LocalDate.now();
        Boolean isEmailVerified = false;

        //when
        Account account = new Account(email, password, localDate, role, uuid);

        //then
        assertEquals("test@yahoo.com", account.getEmail());
        assertEquals("123456", account.getPassword());
        assertEquals(localDate, account.getCreatedDate());
        assertEquals(Role.TESTER, account.getRole());
        assertEquals(uuid, account.getVerificationCode());
        assertFalse(account.isEmailVerified());
    }

    @Test
    void createAccountWith3Param() {
        //given
        String email = "email@yahoo.com";
        String password = "12345";
        Role role = Role.DEVELOPER;

        //when
        Account account = new Account(email,password,role);

        //then
        assertEquals(email, account.getEmail());
        assertEquals(password, account.getPassword());
        assertEquals(role, account.getRole());
    }

    @Test
    void testGetterAndSetterMethods(){
        Account account = new Account();

        Long id = 5L;
        account.setId(id);
        assertEquals(id, account.getId());

        String email = "test.test@yahoo.com";
        account.setEmail(email);
        assertEquals(email, account.getEmail());

        String password = "12345";
        account.setPassword(password);
        assertEquals(password, account.getPassword());

        LocalDate localDate = LocalDate.now();
        account.setCreatedDate(localDate);
        assertEquals(localDate, account.getCreatedDate());

        Role role = Role.TEAM_LEAD;
        account.setRole(role);
        assertEquals(role, account.getRole());

        UUID uuid = UUID.randomUUID();
        account.setVerificationCode(uuid);
        assertEquals(uuid, account.getVerificationCode());

        Boolean isEmailVerified = false;
        account.setEmailVerified(isEmailVerified);
        assertFalse(account.getEmailVerified());
    }

}