package com.luismi.crus_task.mappers;

import com.luismi.crus_task.models.dto.TaskDto;
import com.luismi.crus_task.models.entities.Task;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper(componentModel = "spring")
public interface TaskMapper {
  TaskDto toTaskDto(Task task);
  Task toTask(TaskDto taskDto);


}
