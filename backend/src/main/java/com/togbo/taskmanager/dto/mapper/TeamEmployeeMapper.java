package com.togbo.taskmanager.dto.mapper;

import com.togbo.taskmanager.dto.TeamEmployeeDto;
import com.togbo.taskmanager.model.Employee;
import com.togbo.taskmanager.model.Team;

public class TeamEmployeeMapper {

    public static Team mapToTeam(TeamEmployeeDto teamDto) {
        return new Team(
                teamDto.getName(),
                teamDto.getEmployees()
        );
    }
/*    public static void mapToEmployeeTeamId(TeamEmployeeDto teamEmployeeDto, Employee employee){
        employee.setTeam(teamEmployeeDto.getEmployees());
    }

 */
}
