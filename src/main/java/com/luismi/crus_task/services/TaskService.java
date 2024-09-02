package com.luismi.crus_task.services;

import com.luismi.crus_task.models.entities.Task;

import java.util.List;
import java.util.Optional;

public interface TaskService {
  List<Task> findAll();
  Optional<Task> findId(Integer id);
  Task save(Task task);
  Optional<Task> update(Integer id, Task task);
  Optional<Task> delete(Integer id);
}
