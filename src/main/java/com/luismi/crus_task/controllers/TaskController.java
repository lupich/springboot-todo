package com.luismi.crus_task.controllers;

import com.luismi.crus_task.models.dto.TaskDto;
import com.luismi.crus_task.models.entities.Task;
import com.luismi.crus_task.models.entities.User;
import com.luismi.crus_task.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class TaskController {
  @Autowired
  private TaskService taskService;

  @GetMapping("/task")
  public ResponseEntity<?> listTask(){
    List<TaskDto> listTask=taskService.findAll();
    if (listTask.isEmpty()){
      return ResponseEntity.notFound().build();
    }
    return ResponseEntity.ok().body(listTask);
  }

 @GetMapping("/task/{id}")
  public ResponseEntity<?> findById(@PathVariable Integer id){
   Optional<TaskDto> taskDto=taskService.findId(id);
    if(taskDto.isPresent()){
      return ResponseEntity.ok().body(taskDto);
    }
    return ResponseEntity.notFound().build();
  }

  @PutMapping("/task/{id}")
  public ResponseEntity<?> update(@PathVariable Integer id,@RequestBody TaskDto taskDto){
    Optional<TaskDto> taskDtoOptional=taskService.update(id,taskDto);
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
