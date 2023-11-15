package com.togbo.taskmanager.controller;

import com.togbo.taskmanager.dto.ProjectDto;
import com.togbo.taskmanager.dto.mapper.ProjectMapper;
import com.togbo.taskmanager.exceptions.ResourceNotFoundException;
import com.togbo.taskmanager.model.Account;
import com.togbo.taskmanager.model.Project;
import com.togbo.taskmanager.services.ProjectService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:5173/home")
@RequestMapping("/project")
public class ProjectController {
    private final ProjectService projectService;


    public ProjectController (ProjectService projectService){
        this.projectService = projectService;
    }

    @GetMapping
    public ResponseEntity<List<Project>> findAll(){
        List<Project> projects = projectService.findAll();
        //sout
        if(projects.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(projects, HttpStatus.OK);
    }

    @GetMapping("/findProjectsByEmployee")
    public List<Project> findProjectByEmployee(@RequestBody Account account){
        return projectService.findByEmployee(projectService.findEmployee(account));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Project> findById(@PathVariable Long id) throws ResourceNotFoundException {
        Project project = projectService.findById(id);
        if(project == null){
            throw new ResourceNotFoundException("Project not found by this id " + id);
        }
        return new ResponseEntity<>(projectService.findById(id), HttpStatus.FOUND);
    }

    @PostMapping("/create")
    public ResponseEntity<Project> createProject(@RequestBody ProjectDto projectDto) {
        Optional<Project> projectOptional = projectService.findByTitle(projectDto.getTitle());

        if(projectOptional.isPresent()){
            //handle bad request if a project with same name already exits
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Project project = ProjectMapper.mapToProject(projectDto);
        projectService.createProject(project);

        return new ResponseEntity<>(project, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Project> updateProject(@PathVariable Long id, @RequestBody ProjectDto projectDto) throws ResourceNotFoundException {
        Project project = projectService.findById(id);
        if(project == null){
            //de verificat
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        ProjectMapper.mapToUpdateProject(projectDto, project);

        projectService.updateProject(id, project);

        return new ResponseEntity<>(project, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProject(@PathVariable Long id) {
        Project project = projectService.findById(id);

        if(project == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        projectService.deleteById(id);

        return new ResponseEntity<>("Project deleted successfully",HttpStatus.OK);
    }
}
