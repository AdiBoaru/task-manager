package com.togbo.taskmanager.controller;

import com.togbo.taskmanager.dto.TeamDto;
import com.togbo.taskmanager.dto.mapper.TeamMapper;
import com.togbo.taskmanager.model.Team;
import com.togbo.taskmanager.services.TeamService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/team")
public class TeamController {

    private final TeamService teamService;

    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    @GetMapping
    public ResponseEntity<List<Team>> findAll(){
        List<Team> teams = teamService.findAll();

        if(teams.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(teams, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Team> createTeam(@RequestBody TeamDto teamDto){
        Team team = teamService.findByName(teamDto.getName());

        if (team == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        team = TeamMapper.mapToTeam(teamDto);

        teamService.createTeam(team);

        return new ResponseEntity<>(team, HttpStatus.CREATED);
    }
}
