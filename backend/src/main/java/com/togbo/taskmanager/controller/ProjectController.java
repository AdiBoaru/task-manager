package com.togbo.taskmanager.controller;

import com.togbo.taskmanager.model.Project;
import com.togbo.taskmanager.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/project")
public class ProjectController {
    private ProjectService projectService;


    public ProjectController (ProjectService projectService){
        this.projectService = projectService;
    }

    @GetMapping
    public List<Project> getAll(){
        return projectService.findAll();
    }

    @GetMapping("/{id}")
    public Project findById(@PathVariable UUID id){
//        Optional<Project> foundProject = Optional.ofNullable(projectService.findById(id));
//
//        return foundProject.map(project -> new ResponseEntity<>(project, HttpStatus.FOUND))
//                .orElseGet(() -> new ResponseEntity<>(null, HttpStatus.NOT_FOUND));
        return projectService.findById(id);
    }

    @PostMapping
    public ResponseEntity<Project> saveProject(@RequestBody Project project){
        projectService.addProject(project);

        return new ResponseEntity<>(project, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Project> updateProject(@PathVariable UUID id, @RequestBody Project project){
        projectService.updateProject(id, project);

        return new ResponseEntity<>(project, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Project> deleteProject(@PathVariable UUID id){
        projectService.deleteById(id);

        return new ResponseEntity<>(null, HttpStatus.OK);
    }
}
