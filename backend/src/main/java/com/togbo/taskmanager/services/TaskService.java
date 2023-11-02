package main.java.com.togbo.taskmanager.services;

import main.java.com.togbo.taskmanager.model.Task;
import main.java.com.togbo.taskmanager.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TaskService {
    private TaskRepository taskRepository;

    private void addTask(Task task){
        taskRepository.save(task);
    }

    private void deleteTask(Task task){
        taskRepository.delete(task);
    }

    private void updateTask(UUID id, Task task){
        Optional<Task> foundTask = taskRepository.findById(id);
        if(foundTask.isPresent()){
            taskRepository.save(task);
        }
    }

    private List<Task> findAll(){
        return taskRepository.findAll();
    }
}
