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

    public void createProject(Project project){
        projectRepository.save(project);
    }

    public void deleteProject(Long id, Project project){
        Optional<Project> foundProject = projectRepository.findById(id);

        if(foundProject.isPresent()){
            projectRepository.delete(project);
        }
    }

    public void updateProject(Long id, Project project){
        Optional<Project> foundProject = projectRepository.findById(id);
        if(foundProject.isPresent()){
            projectRepository.save(project);
        }
    }

    public List<Project> findAll(){
        return projectRepository.findAll();
    }

    public Project findById(Long id){
        Optional<Project> foundProject = projectRepository.findById(id);

        return foundProject.orElse(null);
    }

    public void deleteById(Long id){
        projectRepository.deleteById(id);
    }
}
