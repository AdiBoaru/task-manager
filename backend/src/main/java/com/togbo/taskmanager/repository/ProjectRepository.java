package com.togbo.taskmanager.repository;

import com.togbo.taskmanager.model.Project;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
    @Query(value = "SELECT p.* FROM employee_project p where p.employee_id = :employeeId", nativeQuery = true)
    List<Project> findByEmployee(@Param("employeeId") Long employeeId);

    Optional<Project> findByTitle(String title);

}
