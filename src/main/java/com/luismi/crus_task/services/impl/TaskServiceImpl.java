package com.luismi.crus_task.services.impl;

import com.luismi.crus_task.models.entities.Task;
import com.luismi.crus_task.repositories.TaskRepository;
import com.luismi.crus_task.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService {

  @Autowired
  private TaskRepository taskRepository;

  @Transactional(readOnly = true)
  @Override
  public List<Task> findAll() {
    return (List<Task>) taskRepository.findAll();
  }

  @Transactional(readOnly = true)
  @Override
  public Optional<Task> findId(Integer id) {
    return taskRepository.findById(id);
  }
  @Transactional
  @Override
  public Task save(Task task) {
    return taskRepository.save(task);
  }

  @Transactional
  @Override
  public Optional<Task> update(Integer id, Task task) {
    Optional<Task> taskId=taskRepository.findById(id);
    if(taskId.isPresent()){
      Task taskDb=taskId.orElseThrow();
      taskDb.setTitle(task.getTitle());
      taskDb.setDescription(task.getDescription());
      taskDb.setStatus(task.getStatus());
      taskDb.setPriority(task.getPriority());
      return Optional.of(taskRepository.save(taskDb));
    }

    return Optional.empty();
  }


  @Transactional
  @Override
  public Optional<Task> delete(Integer id) {
    Optional<Task> taskId=taskRepository.findById(id);
    taskId.ifPresent(taskDb-> taskRepository.delete(taskDb));
    return taskId;
  }
}
