package com.togbo.taskmanager.dto.mapper;

import com.togbo.taskmanager.dto.TeamDto;
import com.togbo.taskmanager.model.Team;

public class TeamMapper {

    public static Team mapToTeam(TeamDto teamDto) {
        return new Team(
                teamDto.getName(),
                teamDto.getEmployeesTeam()
        );
    }
}
