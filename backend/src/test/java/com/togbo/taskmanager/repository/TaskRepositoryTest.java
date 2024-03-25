package com.togbo.taskmanager.repository;

import com.togbo.taskmanager.enums.Priority;
import com.togbo.taskmanager.enums.Status;
import com.togbo.taskmanager.model.Task;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@DataJpaTest
class TaskRepositoryTest {
    @Autowired
    private TaskRepository taskRepository;
    Task task;

    @BeforeEach
    void setUp() {
  //      task = new Task("Task1", "Tested Task", null, LocalDate.now(), LocalDate.now(), Status.ASSIGNED ,Priority.HIGH);
  //      taskRepository.save(task);
    }

    @AfterEach
    void tearDown() {
        task = null;
        taskRepository.deleteAll();
    }

    @Test
    @Disabled
    void findTasksByProject() {

    }

    @Test
    @Disabled
    void findTasksByEmployee() {
    }

    @Test
    void findTaskByPriority() {
        Priority priority = Priority.HIGH;
        List<Task> taskByPriorities = taskRepository.findTaskByPriority(priority);

        assertThat(taskByPriorities.get(0).getPriority()).isEqualTo(priority);
    }

    @Test
    void testFindTaskByStatusWhereStatusIsAssigned() {
        Status status = Status.ASSIGNED;
        List<Task> taskByStatus = taskRepository.findTaskByStatus(status);

        assertThat(taskByStatus.get(0).getStatus()).isEqualTo(status);

    }
}