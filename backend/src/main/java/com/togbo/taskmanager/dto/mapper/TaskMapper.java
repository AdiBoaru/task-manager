package com.togbo.taskmanager.dto.mapper;

import com.togbo.taskmanager.dto.TaskDto;
import com.togbo.taskmanager.model.Task;

public class TaskMapper {

    public static Task mapperToTask(TaskDto taskDto){
        return new Task(taskDto.getName(),
                taskDto.getDescription(),
                taskDto.getDueDate(),
                taskDto.getStatus(),
                taskDto.getPriority());
    }
}
