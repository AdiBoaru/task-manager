package com.togbo.taskmanager.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class ProjectTest {
    @Test
    public void modelProjectTest(){
        Project project = new Project("Maraton", "parsi", LocalDate.now(),
                LocalDate.of(2025, 10, 10));

        Assertions.assertTrue(project.getTitle().equals("Maraton")
                && project.getDescription().equals("parsi")
                && project.getCreationDate().equals(LocalDate.now())
                && project.getDueDate().equals(LocalDate.of(2025, 10, 10)));
    }
}