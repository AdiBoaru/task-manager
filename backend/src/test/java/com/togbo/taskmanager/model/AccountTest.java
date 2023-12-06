package com.togbo.taskmanager.model;

import com.togbo.taskmanager.enums.Role;
import net.bytebuddy.asm.Advice;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;


class AccountTest {


    @InjectMocks
    private Account account;
  /*  @Test
    public void modelAccountTest(){
        Account account = new Account("dragos@t.com", "123", LocalDate.now());
        Assertions.assertTrue(account.getEmail().equals("dragos@t.com")
                && account.getPassword().equals("123") && account.getCreatedDate().equals(LocalDate.now()));
    }

   */

    @Test
    void createAccountWith3Param(){
        Account account = new Account("email@yahoo.com", "12345", Role.DEVELOPER);
        assertEquals(Role.DEVELOPER,account.getRole());
        assertEquals("email@yahoo.com", account.getEmail());
        assertEquals("12345", account.getPassword());

        assertNotEquals("abcd", account.getPassword());
    }

    @Test
    void testId(){
        Account account = new Account();

    }

}