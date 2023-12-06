package com.togbo.taskmanager.model;

import com.togbo.taskmanager.enums.Priority;
import com.togbo.taskmanager.enums.Status;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class TaskTest {
    @Test
    public void modelTaskTest(){
        File file = new File("/");
        Task task = new Task("TOP", "menta", file, LocalDate.now(),
                LocalDate.of(2023, 12, 12),
                Status.ASSIGNED, Priority.HIGH);
        Assertions.assertTrue(task.getName().equals("TOP")
                && task.getDescription().equals("menta")
                && task.getFile().equals(file)
                && task.getStartDate().equals(LocalDate.now())
                && task.getDueDate().equals(LocalDate.of(2023, 12, 12))
                && task.getStatus().equals(Status.ASSIGNED)
                && task.getPriority().equals(Priority.HIGH));
    }
}