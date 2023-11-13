package com.togbo.taskmanager.controller;

import com.togbo.taskmanager.model.Account;
import com.togbo.taskmanager.model.Employee;
import com.togbo.taskmanager.model.Project;
import com.togbo.taskmanager.model.Task;
import com.togbo.taskmanager.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/task")
public class TaskController {
    private TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService){
        this.taskService = taskService;
    }

    @GetMapping
    public List<Task> findAll(){
        return taskService.findAll();
    }

    @GetMapping("/assign")
    public List<Task> findTaskByPriority(){
        return taskService.findTasksByPriority();
    }

    @GetMapping("/{id}")
    public Task findTaskById(@PathVariable UUID id){
        return taskService.findById(id);
    }

    @GetMapping("/tasksByProjects")
    public List<Task> findTasksByProjects(@RequestBody Project project){
        return taskService.findTasksByProject(project);
    }

    @GetMapping("/tasksByEmployee")
    public List<Task> findTasksByEmployee(@RequestBody Account account){
        Employee employee = taskService.findEmployee(account);

        return taskService.findTasksByEmployee(employee);
    }

    @PostMapping("/save")
    public ResponseEntity<Task> saveProject(@RequestBody Task task){
        taskService.addTask(task);

        return new ResponseEntity<>(task, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Task> updateProject(@PathVariable UUID id, @RequestBody Task task){
        taskService.updateTask(id, task);

        return new ResponseEntity<>(task, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Task> deleteProject(@PathVariable UUID id){
        taskService.deleteById(id);

        return  new ResponseEntity<>(null, HttpStatus.OK);
    }
}
