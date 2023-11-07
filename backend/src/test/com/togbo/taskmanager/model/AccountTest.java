package com.togbo.taskmanager.model;

import net.bytebuddy.asm.Advice;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;


class AccountTest {
    @Test
    public void modelAccountTest(){
        Account account = new Account("dragos@t.com", "123", LocalDate.now());
        Assertions.assertTrue(account.getEmail().equals("dragos@t.com")
                && account.getPassword().equals("123") && account.getCreatedDate().equals(LocalDate.now()));
    }
}