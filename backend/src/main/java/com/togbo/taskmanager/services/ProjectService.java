package com.togbo.taskmanager.services;

import com.togbo.taskmanager.model.Account;
import com.togbo.taskmanager.model.Employee;
import com.togbo.taskmanager.model.Project;
import com.togbo.taskmanager.repository.EmployeeRepository;
import com.togbo.taskmanager.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProjectService {
    @Autowired
    private ProjectRepository projectRepository;
    @Autowired
    private EmployeeRepository employeeRepository;

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

    public List<Project> findByEmployee(Employee employee){
        return projectRepository.findByEmployee(employee.getId());
    }
    public Optional<Project> findByTitle(String title){
        return projectRepository.findByTitle(title);
    }
    public Employee findEmployee(Account account){
        return employeeRepository.findEmployeeByAccount(account.getId());
    }

    public List<Project> findAllSorted(Sort sort){
        return projectRepository.findAll(sort);
    }
}
