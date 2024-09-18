package com.luismi.crus_task.controllers;

import com.luismi.crus_task.models.entities.Task;
import com.luismi.crus_task.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class TaskController {
  @Autowired
  private TaskService taskService;

  @GetMapping("/task")
  public ResponseEntity<?> listTask(){
    List<Task> listTask=taskService.findAll();
    if (listTask.isEmpty()){
      return ResponseEntity.notFound().build();
    }
    return ResponseEntity.ok().body(listTask);
  }

 @GetMapping("/task/{id}")
  public ResponseEntity<?> findById(@PathVariable Integer id){
   Optional<Task> taskDto=taskService.findId(id);
    if(taskDto.isPresent()){
      return ResponseEntity.ok().body(taskDto);
    }
    return ResponseEntity.notFound().build();
  }

  @PutMapping("/task/{id}")
  public ResponseEntity<?> update(@PathVariable Integer id,@RequestBody Task task){
    Optional<Task> taskDtoOptional=taskService.update(id,task);
    if(taskDtoOptional.isPresent()){
      //return ResponseEntity.status(HttpStatus.CREATED).body(taskDtoOptional);
      return ResponseEntity.ok().body(taskDtoOptional);
    }
    return ResponseEntity.notFound().build();
  }
  @DeleteMapping("/task/{id}")
  public ResponseEntity<?> delete(@PathVariable Integer id){
    Optional<Task> task=taskService.delete(id);
    if(task.isPresent()){
      return ResponseEntity.noContent().build();
    }
    return ResponseEntity.badRequest().build();
  }
}
