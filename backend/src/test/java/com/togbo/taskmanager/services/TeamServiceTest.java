package com.togbo.taskmanager.services;

import com.togbo.taskmanager.enums.TeamSize;
import com.togbo.taskmanager.model.Employee;
import com.togbo.taskmanager.model.Team;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

public class TeamServiceTest {

    private TeamService teamService;
    @Test
    public void shouldCreateTeam(){
      //  Team team = new Team("")
    }

    static boolean checkIfNameContainsNumberUsingRegex(String name){
        return name.matches(".*\\d.*");
    }
    @Test
    void teamNameShouldContainsOnlyLetters(){
        String nameWithOnlyLetters = "Team Name";
        String nameWithLettersAndNumbers = "12Team Name 2";
        String emptyName = "";

        Assertions.assertFalse(checkIfNameContainsNumberUsingRegex(nameWithOnlyLetters));
        Assertions.assertTrue(checkIfNameContainsNumberUsingRegex(nameWithLettersAndNumbers));
        Assertions.assertFalse(checkIfNameContainsNumberUsingRegex(emptyName));
    }

    @Test
    void teamSizeShouldBeOneOF_3_5_10(){

       // Assertions.assertEquals(TeamSize.SMALL, teamService.createTeam());
    }
}
