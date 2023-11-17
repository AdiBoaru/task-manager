package com.togbo.taskmanager.repository;

import com.togbo.taskmanager.enums.Priority;
import com.togbo.taskmanager.enums.Status;
import com.togbo.taskmanager.model.Project;
import com.togbo.taskmanager.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface TaskRepository extends JpaRepository<Task, UUID>, JpaSpecificationExecutor {
    @Query(value = "SELECT t.* FROM tasks t WHERE t.project_id = :projectId", nativeQuery = true)
    List<Task> findTasksByProject(@Param("projectId")Long projectId);
    @Query(value = "SELECT t.* FROM employee_task t where t.employee_id = :employeeId", nativeQuery = true)
    List<Task> findTasksByEmployee(@Param("employeeId")Long employeeId);

    List<Task> findTaskByPriority(Priority priority);

    List<Task> findTaskByStatus(Status status);


}
