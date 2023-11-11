package com.togbo.taskmanager.services;

import com.togbo.taskmanager.model.Task;
import com.togbo.taskmanager.repository.TaskRepository;
import jakarta.persistence.Access;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;

    public void addTask(Task task){
        taskRepository.save(task);
    }

    public void deleteTask(Task task){
        taskRepository.delete(task);
    }

    public void updateTask(UUID id, Task task){
        Optional<Task> foundTask = taskRepository.findById(id);
        if(foundTask.isPresent()){
            taskRepository.save(task);
        }
    }

    public List<Task> findAll(){
        return taskRepository.findAll();
    }

    public Task findById(UUID id){
        Optional<Task> foundTask = taskRepository.findById(id);

        return foundTask.orElse(null);
    }

    public void deleteById(UUID id){
        taskRepository.deleteById(id);
    }
}
