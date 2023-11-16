package com.togbo.taskmanager.repository;

import com.togbo.taskmanager.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team, Long> {

    Team findByName(String name);
}
