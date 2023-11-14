package com.togbo.taskmanager.dto.mapper;

import com.togbo.taskmanager.dto.ProjectDto;
import com.togbo.taskmanager.model.Project;

public class ProjectMapper {

    public static Project mapToProject(ProjectDto projectDto){
        return new Project(
                projectDto.getTitle(),
                projectDto.getDescription(),
                projectDto.getTitle(),
                projectDto.getDueDate()
        );
    }
}
