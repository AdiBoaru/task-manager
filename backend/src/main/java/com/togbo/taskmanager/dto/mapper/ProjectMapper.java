package com.togbo.taskmanager.dto.mapper;

import com.togbo.taskmanager.dto.ProjectDto;
import com.togbo.taskmanager.model.Project;

public class ProjectMapper {

    public static Project mapToProject(ProjectDto projectDto){
        return new Project(
                projectDto.getTitle(),
                projectDto.getDescription(),
                projectDto.getTeamSize(),
                projectDto.getDueDate()
        );
    }
    public static void mapToUpdateProject(ProjectDto projectDto, Project project){
        project.setTitle(projectDto.getTitle());
        project.setDescription(projectDto.getDescription());
        project.setTeamSize(projectDto.getTeamSize());
        project.setDueDate(projectDto.getDueDate());

    }
}
