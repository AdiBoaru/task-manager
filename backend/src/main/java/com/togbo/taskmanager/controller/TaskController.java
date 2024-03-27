package com.togbo.taskmanager.controller;

import com.togbo.taskmanager.dto.TaskDto;
import com.togbo.taskmanager.exceptions.InvalidArgumentException;
import com.togbo.taskmanager.model.Task;
import com.togbo.taskmanager.repository.TaskRepository;
import com.togbo.taskmanager.services.TaskService;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/task")
public class TaskController {
    private final TaskService taskService;
    private final TaskRepository taskRepository;

    public TaskController(TaskService taskService, TaskRepository taskRepository) {
        this.taskService = taskService;
        this.taskRepository = taskRepository;
    }

    @GetMapping
    public ResponseEntity<List<Task>> findAllTasks() {
        List<Task> tasks = taskService.findAll();
        if (tasks.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(tasks);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Task> findTaskById(@PathVariable Long id) {
        Optional<Task> task = taskRepository.findById(id);

        if (task.isPresent()) {
            return new ResponseEntity<>(task.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/sort")
    public List<Task> sortedTask(@RequestParam String value, @RequestParam(defaultValue = "ASC") String direction) {
        Sort.Direction sortedDirection = Sort.Direction.fromString(direction);
        Sort sort = Sort.by(sortedDirection, value);
        return taskService.findAllSorted(sort);
    }

    @PostMapping
    public ResponseEntity<Task> createTask(@RequestBody TaskDto taskDto){
        try {
            taskService.createTask(taskDto);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch (InvalidArgumentException e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Task> updateProject(@PathVariable Long id, @RequestBody TaskDto taskDto) {
        taskService.updateTask(id, taskDto);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Task> deleteTaskById(@PathVariable Long id) {
        if (taskService.deleteById(id)) {
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
