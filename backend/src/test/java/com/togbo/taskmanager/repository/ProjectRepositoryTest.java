package com.togbo.taskmanager.repository;

import com.togbo.taskmanager.model.Project;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class ProjectRepositoryTest {
    @Autowired
    private ProjectRepository projectRepository;
    Project project;

    @BeforeEach
    void setUp(){
//        project = new Project("Project","desc", 5, LocalDate.now());
        projectRepository.save(project);
    }

    @AfterEach
    void tearDown(){
        project = null;
        projectRepository.deleteAll();
    }

    //Success case
    @Test
    void findProjectByTitle(){
        String title = "Project";
        Optional<Project> projectTest = projectRepository.findByName(title);
        assertThat(projectTest).isPresent();
        assertThat(projectTest.get().getDescription()).isEqualTo("desc");
        assertThat(projectTest.get().getTeam()).isEqualTo(5);
    }

    //Failure case
    @Test
    void failToFindProjectBySpecificTitle(){
        String title = "failTitle";
        Optional<Project> projectTest = projectRepository.findByName(title);

        assertThat(projectTest).isNotPresent();
    }
}
