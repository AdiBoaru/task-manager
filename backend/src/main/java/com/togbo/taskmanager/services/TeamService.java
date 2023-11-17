package com.togbo.taskmanager.services;

import com.togbo.taskmanager.model.Project;
import com.togbo.taskmanager.model.Team;
import com.togbo.taskmanager.repository.TeamRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamService {

    private final TeamRepository teamRepository;

    public TeamService(TeamRepository teamRepository){
        this.teamRepository = teamRepository;
    }


    public void createTeam(Team team){
        teamRepository.save(team);
    }

    public Team findByName(String name){
        return teamRepository.findByName(name);
    }

    public List<Team> findAll(){
        return teamRepository.findAll();
    }

}
