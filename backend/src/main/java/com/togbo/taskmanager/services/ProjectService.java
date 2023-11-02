package main.java.com.togbo.taskmanager.services;

import main.java.com.togbo.taskmanager.model.Project;
import main.java.com.togbo.taskmanager.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProjectService {
    @Autowired
    private ProjectRepository projectRepository;

    private void addProject(Project project){
        projectRepository.save(project);
    }

    private void deleteProject(Project project){
        projectRepository.delete(project);
    }

    private void updateProject(UUID id, Project project){
        Optional<Project> foundProject = projectRepository.findById(id);
        if(foundProject.isPresent()){
            projectRepository.save(project);
        }
    }

    private List<Project> findAll(){
        return projectRepository.findAll();
    }
}
