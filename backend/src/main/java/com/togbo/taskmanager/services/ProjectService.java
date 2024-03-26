package com.togbo.taskmanager.services;

import com.togbo.taskmanager.dto.ProjectDto;
import com.togbo.taskmanager.dto.mapper.ProjectMapper;
import com.togbo.taskmanager.exceptions.InvalidArgumentException2;
import com.togbo.taskmanager.exceptions.ResourceNotFoundException;
import com.togbo.taskmanager.model.Account;
import com.togbo.taskmanager.model.Employee;
import com.togbo.taskmanager.model.Project;
import com.togbo.taskmanager.model.Team;
import com.togbo.taskmanager.repository.EmployeeRepository;
import com.togbo.taskmanager.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

@Service
public class ProjectService {
    @Autowired
    private ProjectRepository projectRepository;
    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private TeamService teamService;

    public boolean createProject(ProjectDto projectDto) throws InvalidArgumentException2 {
        Optional<Project> projectOptional = findByTitle(projectDto.getName());

        if (projectOptional.isPresent()) {
            throw new InvalidArgumentException2("An account with " + projectDto.getName() + " already exists");
        }else{
            if(isTeamAssigned(projectDto.getTeam())){
                throw new InvalidArgumentException2("This Team " + projectDto.getTeam().getName() + " is already assigned to a different project");
            }else {
                Project project = ProjectMapper.mapToProject(projectDto);
                projectRepository.save(project);
                return true;
            }
        }
    }

    /**
     * Check if Team is already assigned or not
     * @param team represent teamName
     */
    private boolean isTeamAssigned(Team team){
        Optional<Project> projectWithTeamId = projectRepository.findByTeamId(team.getId());
        return projectWithTeamId.isPresent();
    }

    public void updateProject(Long id, ProjectDto projectDto) {
        Optional<Project> currentProject = projectRepository.findById(id);
        if (currentProject.isPresent()) {
            Project project = currentProject.get();
            checkForNullState(projectDto.getName(), project::setName);
            checkForNullState(projectDto.getDescription(), project::setDescription);
            checkForNullState(projectDto.getDueDate(), project::setDueDate);
            checkForNullState(projectDto.getTeam(), project::setTeam);

            projectRepository.save(currentProject.get());
        }
    }

    private <T> void checkForNullState(T projectDto, Consumer<T> state) {
        if (projectDto != null) {
            state.accept(projectDto);
        }
    }
    public void deleteProject(Long id) throws ResourceNotFoundException{
        Optional<Project> foundProject = projectRepository.findById(id);

        if(foundProject.isPresent()){
            projectRepository.delete(foundProject.get());
        }else
            throw new ResourceNotFoundException("Project with id = " + id + " doesn`t exits");
    }

    public List<Project> findAll(){
        return projectRepository.findAll();
    }

    public Optional<Project> findById(Long id){
        return projectRepository.findById(id);
    }

    public void deleteById(Long id){
        projectRepository.deleteById(id);
    }

    public List<Project> findByEmployee(Employee employee){
        return projectRepository.findByEmployee(employee.getId());
    }
    public Optional<Project> findByTitle(String title){
        return projectRepository.findByName(title);
    }
    public Employee findEmployee(Account account){
        return employeeRepository.findEmployeeByAccount(account.getId());
    }

    public List<Project> findAllSorted(Sort sort){
        return projectRepository.findAll(sort);
    }
}
