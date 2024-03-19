package com.togbo.taskmanager.services;

import com.togbo.taskmanager.dto.TeamEmployeeDto;
import com.togbo.taskmanager.dto.mapper.TeamEmployeeMapper;
import com.togbo.taskmanager.model.Employee;
import com.togbo.taskmanager.model.Team;
import com.togbo.taskmanager.repository.TeamRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.function.Consumer;

@Service
public class TeamService {

    private final TeamRepository teamRepository;
    private final EmployeeService employeeService;

    public TeamService(TeamRepository teamRepository, EmployeeService employeeService){
        this.teamRepository = teamRepository;
        this.employeeService = employeeService;
    }

    //check if team exists
    //save only if team doesn`t exits
    //check if employee have a team or not

    public boolean createTeam(TeamEmployeeDto teamEmployeeDto){
        Team team = teamRepository.findByName(teamEmployeeDto.getName());
        if(isTeamAbsent(team)){
            team = TeamEmployeeMapper.mapToTeam(teamEmployeeDto);
            updateEmployeeID(team.getEmployees(), team);
            teamRepository.save(team);
            return true;
        }
        return false;
    }

    private void updateEmployeeID(Set<Employee> employeeSet, Team team){
        for(Employee employee : employeeSet){
            employeeService.updateEmployeeTeamId(employee.getId(),team);
        }
    }
    private boolean isTeamAbsent(Team team){
        return team == null;
    }
    /**
     * Update only non-null values of the object Team
     */
    public void updateTeam(Team currentTeam, Team team){
        checkForNullState(team.getName(),currentTeam::setName);
        checkForNullState(team.getSize(), currentTeam::setSize);
        checkForNullState(team.getEmployees(),currentTeam::setEmployees);

        teamRepository.save(currentTeam);
    }
    private <T> void checkForNullState(T team, Consumer<T> state){
        if(team != null){
            state.accept(team);
        }
    }

    public Team findByName(String name){
        return teamRepository.findByName(name);
    }

    public Optional<Team> findById(Long id){
        return teamRepository.findById(id);
    }
    public List<Team> findAll(){
        return teamRepository.findAll();
    }

    public List<Team> findAllSorted(Sort sort){
        return teamRepository.findAll(sort);
    }

    public void deleteById(Long id){
        teamRepository.deleteById(id);
    }
}
