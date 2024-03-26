package com.togbo.taskmanager.model;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.Description;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class ProjectTest {
    @Test
    @Description("Create Project with 5 params")
    void createProjectWith5Params() {
        //given
        String title = "Project 1";
        String description = "Project 1 description";
        LocalDate creationDate = LocalDate.now();
        Integer teamSize = 5;
        LocalDate dueDate = LocalDate.of(2024, 12, 23);
        Set<Employee> employees = new HashSet<>();
        Set<Task> tasks = new HashSet<>();

        //when
        Project project = new Project(title, description, teamSize, dueDate);

        //then
        assertEquals(title, project.getName());
        assertEquals(description, project.getDescription());
        assertEquals(creationDate, project.getCreationDate());
        assertEquals(teamSize, project.getTeamSize());
    }
}