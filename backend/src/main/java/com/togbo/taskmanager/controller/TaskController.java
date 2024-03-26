package com.togbo.taskmanager.controller;

import com.togbo.taskmanager.model.Account;
import com.togbo.taskmanager.model.Employee;
import com.togbo.taskmanager.model.Project;
import com.togbo.taskmanager.model.Task;
import com.togbo.taskmanager.repository.TaskRepository;
import com.togbo.taskmanager.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/task")
public class TaskController {
    private final TaskService taskService;
    private final TaskRepository taskRepository;

    public TaskController(TaskService taskService, TaskRepository taskRepository){
        this.taskService = taskService;
        this.taskRepository = taskRepository;
    }

    @GetMapping
    public ResponseEntity<List<Task>> findAllTasks(){
        List<Task> tasks = taskService.findAll();
        if(tasks.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(tasks);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Task> findTaskById(@PathVariable Long id){
        Optional<Task> task = taskRepository.findById(id);

        if(task.isPresent()){
            return new ResponseEntity<>(task.get(),HttpStatus.FOUND);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
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
    @GetMapping("/sort")
    public List<Task> sortedTask(@RequestParam String value, @RequestParam(defaultValue = "ASC") String direction){
        Sort.Direction sortedDirection = Sort.Direction.fromString(direction);
        Sort sort = Sort.by(sortedDirection, value);
        return taskService.findAllSorted(sort);
    }

    @PostMapping("/save")
    public ResponseEntity<Task> saveProject(@RequestBody Task task){
        taskService.addTask(task);

        return new ResponseEntity<>(task, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Task> updateProject(@PathVariable Long id, @RequestBody Task task){
        taskService.updateTask(id, task);

        return new ResponseEntity<>(task, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Task> deleteProject(@PathVariable Long id){
        taskService.deleteById(id);

        return  new ResponseEntity<>(null, HttpStatus.OK);
    }
}
