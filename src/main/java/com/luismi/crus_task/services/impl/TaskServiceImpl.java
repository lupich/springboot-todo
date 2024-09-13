package com.luismi.crus_task.services.impl;

import com.luismi.crus_task.mappers.TaskMapper;
import com.luismi.crus_task.models.dto.TaskDto;
import com.luismi.crus_task.models.entities.Task;
import com.luismi.crus_task.repositories.TaskRepository;
import com.luismi.crus_task.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TaskServiceImpl implements TaskService {

  @Autowired
  private TaskRepository taskRepository;

  @Autowired
  private TaskMapper taskMapper;

  @Transactional(readOnly = true)
  @Override
  public List<TaskDto> findAll() {
    List<Task> listTask= (List<Task>) taskRepository.findAll();
    return listTask.stream().map(taskMapper::toTaskDto).collect(Collectors.toList());
  }

  @Transactional(readOnly = true)
  @Override
  public Optional<TaskDto> findId(Integer id) {
    Optional<Task> taskId=taskRepository.findById(id);

    return taskId.map(taskMapper::toTaskDto);
  }
  /*
  @Transactional
  @Override
  public TaskDto save(TaskDto taskDto, Integer userId) {
    Task task =taskMapper.toTask(taskDto);
    task.setUser();
    return taskRepository.save(task);
  }*/

  @Transactional
  @Override
  public Optional<TaskDto> update(Integer id, TaskDto taskDto) {
    Optional<Task> taskId=taskRepository.findById(id);
    if(taskId.isPresent()){
      Task taskDb=taskId.orElseThrow();
      taskDb.setTitle(taskDto.getTitle());
      taskDb.setDescription(taskDto.getDescription());
      taskDb.setStatus(taskDto.getStatus());
      taskDb.setPriority(taskDto.getPriority());
      taskDb= taskRepository.save(taskDb);
      return Optional.of(taskMapper.toTaskDto(taskDb));
    }
    return Optional.empty();
  }


  @Transactional
  @Override
  public Optional<Task> delete(Integer id) {
    Optional<Task> taskId=taskRepository.findById(id);
    taskId.ifPresent(taskRepository::delete);
    return Optional.empty();
  }
}
