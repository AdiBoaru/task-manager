package com.togbo.taskmanager.services;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import static org.junit.jupiter.api.Assertions.*;

class NotificationServiceTest {

    @Test
    void testNotification() {
        //given
        LocalDate localDateCurrent = LocalDate.now();
        LocalDate localDate = LocalDate.of(2024,3,28);
        //when
        long d =  ChronoUnit.DAYS.between(localDateCurrent, localDate);
        //then
        if(d <= 3){
            System.out.println("timp ramas " + d);
        }
        System.out.println(d);
    }
}