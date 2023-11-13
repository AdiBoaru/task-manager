package com.togbo.taskmanager.repository;

import com.togbo.taskmanager.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface TaskRepository extends JpaRepository<Task, UUID> {
    @Query(value = "select * from tasks where priority = 'CRITICAL';", nativeQuery = true)
    List<Task> findTaskByPriorityCritical();
    @Query(value = "select * from tasks where priority = 'HIGH';", nativeQuery = true)
    List<Task> findTaskByPriorityHigh();
    @Query(value = "select * from tasks where priority = 'MEDIUM';", nativeQuery = true)
    List<Task> findTaskByPriorityMedium();
    @Query(value = "select * from tasks where priority = 'LOW';", nativeQuery = true)
    List<Task> findTaskByPriorityLow();
}
