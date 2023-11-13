package com.togbo.taskmanager.controller;

import com.togbo.taskmanager.dto.ProjectDTO;
import com.togbo.taskmanager.exceptions.ResourceNotFoundException;
import com.togbo.taskmanager.model.Account;
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
@CrossOrigin(origins = "http://localhost:5173/home")
@RequestMapping("/project")
public class ProjectController {
    private ProjectService projectService;

    @Autowired
    public ProjectController (ProjectService projectService){
        this.projectService = projectService;
    }

    @GetMapping
    public ResponseEntity<List<Project>> findAll(){
        List<Project> projects = projectService.findAll();

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
    public void createProject(@RequestBody ProjectDTO projectDTO) throws Exception {
        Optional<Project> projectOptional = projectService.findByTitle(projectDTO.getTitle());

        if(projectOptional.isPresent()){

            System.out.println("here");
            throw new ResourceNotFoundException("Project with this title is already created " + projectDTO.getTitle());
        }

        Project project = new Project();
        project.setTitle(projectDTO.getTitle());
        project.setDueDate(projectDTO.getDueDate());
        project.setDescription(projectDTO.getDescription());
        project.setTeamSize(projectDTO.getTeamSize());
        System.out.println(project);

        projectService.createProject(project);
        System.out.println("2" + project);

        //return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Project> updateProject(@PathVariable Long id, @RequestBody Project project) throws ResourceNotFoundException {
        for(Project projectExist : projectService.findAll()){
            if(projectExist.getId() != id){
                throw new ResourceNotFoundException("Project with this ID does`t exists " +id);
            }
        }
        projectService.updateProject(id, project);

        return new ResponseEntity<>(project, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Project> deleteProject(@PathVariable Long id) throws ResourceNotFoundException {
        for(Project projectExist : projectService.findAll()){
            if(projectExist.getId() != id){
                throw new ResourceNotFoundException("Project with this ID does`t exists " +id);
            }
        }
        projectService.deleteById(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
