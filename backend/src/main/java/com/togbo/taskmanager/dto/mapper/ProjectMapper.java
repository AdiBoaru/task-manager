package com.togbo.taskmanager.dto.mapper;

import com.togbo.taskmanager.dto.ProjectDto;
import com.togbo.taskmanager.model.Project;

public class ProjectMapper {

    public static Project mapToProject(ProjectDto projectDto){
        return new Project(
                projectDto.getName(),
                projectDto.getDescription(),
                projectDto.getDueDate(),
                projectDto.getTeam()
        );
    }
    public static void mapToUpdateProject(ProjectDto projectDto, Project project){
        project.setName(projectDto.getName());
        project.setDescription(projectDto.getDescription());
        project.setTeam(projectDto.getTeam());
        project.setDueDate(projectDto.getDueDate());

    }
}
