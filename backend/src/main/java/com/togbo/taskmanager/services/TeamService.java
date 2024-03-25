package com.togbo.taskmanager.services;

import com.togbo.taskmanager.dto.TeamEmployeeDto;
import com.togbo.taskmanager.dto.mapper.TeamEmployeeMapper;
import com.togbo.taskmanager.enums.TeamSize;
import com.togbo.taskmanager.exceptions.InvalidTeamException;
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

    public TeamService(TeamRepository teamRepository, EmployeeService employeeService) {
        this.teamRepository = teamRepository;
        this.employeeService = employeeService;
    }

    public boolean createTeam(TeamEmployeeDto teamEmployeeDto) throws InvalidTeamException {
        if(!isTeamNameValid(teamEmployeeDto.getName())) {
            Team team = teamRepository.findByName(teamEmployeeDto.getName());
            if (!isTeamPresent(team)) {
                team = TeamEmployeeMapper.mapToTeam(teamEmployeeDto);
                System.out.println(team);

                int teamSize = checkTeamSize(teamEmployeeDto.getSize());
                int employeeSize = teamEmployeeDto.getEmployees().size();

                if (teamSize < employeeSize) {
                    throw new InvalidTeamException("Too many employees for current team size");
                }
                updateEmployeeID(team.getEmployees(), team);
                teamRepository.save(team);
                return true;
            }
        }else
            throw new InvalidTeamException("Team name should not contain any digit");
        return false;
    }

    /**
     * Team Name should not contain any digit
     *
     * @param name is a string, representing team name
     * @return a boolean value, true if the string contains any digit, false if doesn`t
     */
    private boolean isTeamNameValid(String name){
        return name.matches(".*\\d.*");
    }
    private void updateEmployeeID(Set<Employee> employeeSet, Team team) {
        for (Employee employee : employeeSet) {
            employeeService.updateEmployeeTeamId(employee.getId(), team);
        }
    }

    private int checkTeamSize(int size) throws InvalidTeamException {
        switch (size) {
            case 3:
                return TeamSize.SMALL;
            case 5:
                return TeamSize.MEDIUM;
            case 10:
                return TeamSize.LARGE;
            default:
                throw new InvalidTeamException("Team size is invalid");
        }
    }

    private boolean isTeamPresent(Team team) {
        return team != null;
    }

    public void updateTeam(Team currentTeam, Team team) {
        checkForNullState(team.getName(), currentTeam::setName);
        checkForNullState(team.getSize(), currentTeam::setSize);
        checkForNullState(team.getEmployees(), currentTeam::setEmployees);

        teamRepository.save(currentTeam);
    }

    private <T> void checkForNullState(T team, Consumer<T> state) {
        if (team != null) {
            state.accept(team);
        }
    }

    public Team findByName(String name) {
        return teamRepository.findByName(name);
    }

    public Optional<Team> findById(Long id) {
        return teamRepository.findById(id);
    }

    public List<Team> findAll() {
        return teamRepository.findAll();
    }

    public List<Team> findAllSorted(Sort sort) {
        return teamRepository.findAll(sort);
    }

    public void deleteById(Long id) {
        teamRepository.deleteById(id);
    }
}
