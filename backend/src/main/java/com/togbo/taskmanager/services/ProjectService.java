package com.togbo.taskmanager.services;

import com.togbo.taskmanager.model.Project;
import com.togbo.taskmanager.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProjectService {
    @Autowired
    private ProjectRepository projectRepository;

    public void addProject(Project project){
        projectRepository.save(project);
    }

    public void deleteProject(UUID id, Project project){
        Optional<Project> foundProject = projectRepository.findById(id);

        if(foundProject.isPresent()){
            projectRepository.delete(project);
        }
    }

    public void updateProject(UUID id, Project project){
        Optional<Project> foundProject = projectRepository.findById(id);
        if(foundProject.isPresent()){
            projectRepository.save(project);
        }
    }

    public List<Project> findAll(){
        return projectRepository.findAll();
    }

    public Project findById(UUID id){
        Optional<Project> foundProject = projectRepository.findById(id);

        return foundProject.orElse(null);
    }

    public void deleteById(UUID id){
        projectRepository.deleteById(id);
    }
}
