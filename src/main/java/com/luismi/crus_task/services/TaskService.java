package com.luismi.crus_task.services;

import com.luismi.crus_task.models.dto.TaskDto;
import com.luismi.crus_task.models.entities.Task;

import java.util.List;
import java.util.Optional;

public interface TaskService {
  List<TaskDto> findAll();
  Optional<TaskDto> findId(Integer id);
  //TaskDto save(TaskDto task, Integer userId);
  Optional<TaskDto> update(Integer id, TaskDto taskDto);
  Optional<Task> delete(Integer id);
}
