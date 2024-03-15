package com.togbo.taskmanager.controller;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.togbo.taskmanager.dto.TeamEmployeeDto;
import com.togbo.taskmanager.dto.mapper.TeamEmployeeMapper;
import com.togbo.taskmanager.model.Employee;
import com.togbo.taskmanager.model.Team;
import com.togbo.taskmanager.services.EmployeeService;
import com.togbo.taskmanager.services.TeamService;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/team")
public class TeamController {

    private final TeamService teamService;
    private final EmployeeService employeeService;

    public TeamController(TeamService teamService, EmployeeService employeeService) {
        this.teamService = teamService;
        this.employeeService = employeeService;
    }

    @GetMapping
    public ResponseEntity<List<Team>> findAll(){
        List<Team> teams = teamService.findAll();

        if(teams.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(teams, HttpStatus.OK);
    }
    @GetMapping("/sort")
    public List<Team> findAllSorted(@RequestParam String value, @RequestParam(defaultValue = "ASC") String direction){
        Sort.Direction sortedDirection = Sort.Direction.fromString(direction);
        Sort sort = Sort.by(sortedDirection, value);
        return teamService.findAllSorted(sort);
    }
    @PostMapping
    public ResponseEntity<Team> createTeam(@RequestBody TeamEmployeeDto teamEmployeeDto){
        Team team = teamService.findByName(teamEmployeeDto.getName());

        if (team != null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        team = TeamEmployeeMapper.mapToTeam(teamEmployeeDto);

        Set<Employee> employees = teamEmployeeDto.getEmployees();

        if (employees != null && !employees.isEmpty()) {
            for (Employee employee : employees) {
                employeeService.updateEmployeeTeamId(employee.getId(), team);
            }
        }
        teamService.createTeam(team);

        return new ResponseEntity<>(team, HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public void updateTeam(@PathVariable Long id, @RequestBody Team team){
        if(teamService.findById(id).isPresent()){
            teamService.updateTeam(team);
        }
    }
    @DeleteMapping("/{id}")
    public void deleteTeam(@PathVariable Long id){
        teamService.deleteById(id);
    }


}
