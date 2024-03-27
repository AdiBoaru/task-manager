package com.togbo.taskmanager.controller;

import com.togbo.taskmanager.dto.ProjectDto;
import com.togbo.taskmanager.exceptions.InvalidArgumentException;
import com.togbo.taskmanager.exceptions.ResourceNotFoundException;
import com.togbo.taskmanager.model.Project;
import com.togbo.taskmanager.services.ProjectService;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/project")
public class ProjectController {
    private final ProjectService projectService;


    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping
    public ResponseEntity<List<Project>> findAll() {
        List<Project> projects = projectService.findAll();
        if (projects.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(projects, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Project> findById(@PathVariable Long id) throws ResourceNotFoundException {
        Optional<Project> project = projectService.findById(id);
        if (project.isPresent()) {
            return new ResponseEntity<>(project.get(),HttpStatus.FOUND);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/sort")
    public List<Project> sortProject(@RequestParam String key, @RequestParam(defaultValue = "ASC") String direction){
        Sort.Direction sortDirection = Sort.Direction.fromString(direction);
        Sort sort = Sort.by(sortDirection, key);
        return projectService.findAllSorted(sort);
    }

    @PostMapping()
    public ResponseEntity<Project> createProject(@RequestBody ProjectDto projectDto) throws InvalidArgumentException {
        if(projectService.createProject(projectDto)){
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Project> updateProject(@PathVariable Long id, @RequestBody ProjectDto projectDto){
        projectService.updateProject(id, projectDto);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProject(@PathVariable Long id) throws ResourceNotFoundException {
        projectService.deleteById(id);
        return new ResponseEntity<>("Project deleted successfully", HttpStatus.OK);
    }
}
