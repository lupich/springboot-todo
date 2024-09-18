package com.luismi.crus_task.services;

import com.luismi.crus_task.models.entities.Task;

import java.util.List;
import java.util.Optional;

public interface TaskService {
  List<Task> findAll();
  Optional<Task> findId(Integer id);
  //TaskDto save(TaskDto task, Integer userId);
  Optional<Task> update(Integer id, Task task);
  Optional<Task> delete(Integer id);
}
