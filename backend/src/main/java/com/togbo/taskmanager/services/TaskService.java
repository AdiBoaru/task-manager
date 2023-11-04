package com.togbo.taskmanager.services;

import com.togbo.taskmanager.model.Task;
import com.togbo.taskmanager.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.awt.image.Kernel;
import java.time.LocalDate;
import java.util.*;
import java.util.function.Predicate;

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

    /**
     * filter and search tasks
     * filter task by status, due date, priority
    **/

    public List<Task> filterTasks(Predicate<Task> filter){
        List<Task> filteredTasks = new LinkedList<>();
        for(Task task : taskRepository.findAll()){
            if(filter.test(task)){
                filteredTasks.add(task);
            }
        }
        return filteredTasks;
    }
    public List<Task> filterTaskByStatus(String status){
        Predicate<Task> taskPredicate = task -> task.getStatus().name().equals(status.toUpperCase(Locale.ROOT));
        return filterTasks(taskPredicate);
    }
    //filter the data up to a certain date
    public List<Task> filterTaskByDueDate(LocalDate date){
        Predicate<Task> taskPredicate = task -> task.getDueDate().isBefore(date);
        return filterTasks(taskPredicate);
    }
    public List<Task> filterTaskByPriority(String priority){
        Predicate<Task> taskPredicate = task -> task.getPriority().name().equals(priority.toUpperCase(Locale.ROOT));
        return filterTasks(taskPredicate);
    }
}
