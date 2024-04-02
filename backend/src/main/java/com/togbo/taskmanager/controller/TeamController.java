package com.togbo.taskmanager.controller;

import com.togbo.taskmanager.dto.TeamEmployeeDto;
import com.togbo.taskmanager.exceptions.InvalidTeamException;
import com.togbo.taskmanager.model.Team;
import com.togbo.taskmanager.services.EmployeeService;
import com.togbo.taskmanager.services.TeamService;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**TODo
 * when create a team name should not contains any number
 */
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
    public ResponseEntity<List<Team>> findAll() {
        List<Team> teams = teamService.findAll();

        if (teams.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(teams, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public Optional<Team> findById(@PathVariable Long id) {
        return teamService.findById(id);
    }

    @GetMapping("/sort")
    public List<Team> findAllSorted(@RequestParam String value, @RequestParam(defaultValue = "ASC") String direction) {
        Sort.Direction sortedDirection = Sort.Direction.fromString(direction);
        Sort sort = Sort.by(sortedDirection, value);
        return teamService.findAllSorted(sort);
    }

    @PostMapping
    public ResponseEntity<String> createTeam(@RequestBody TeamEmployeeDto teamEmployeeDto) throws InvalidTeamException {
        if(!teamService.createTeam(teamEmployeeDto)){
            String badRequestMessage = "A team with " + teamEmployeeDto.getName() + " name, already exits";
            return ResponseEntity.badRequest().body(badRequestMessage);
        }
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public void updateTeam(@PathVariable Long id, @RequestBody Team team) {
        Optional<Team> currentTeam = teamService.findById(id);
        if (currentTeam.isPresent()) {
            teamService.updateTeam(currentTeam.get(), team);
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTeam(@PathVariable Long id) {
            Optional<Team> team = teamService.findById(id);
            if(team.isPresent()){
                teamService.deleteById(id);
                return new ResponseEntity<>("Team successfully deleted", HttpStatus.OK);
            }
            return new ResponseEntity<>("Bad request ", HttpStatus.BAD_REQUEST);
    }
}
