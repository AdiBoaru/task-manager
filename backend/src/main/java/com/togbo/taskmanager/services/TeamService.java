package com.togbo.taskmanager.services;

import com.togbo.taskmanager.model.Project;
import com.togbo.taskmanager.model.Team;
import com.togbo.taskmanager.repository.TeamRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeamService {

    private final TeamRepository teamRepository;

    public TeamService(TeamRepository teamRepository){
        this.teamRepository = teamRepository;
    }


    public void createTeam(Team team){
        teamRepository.save(team);
    }

    public void updateTeam(Team team){
        teamRepository.save(team);
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
