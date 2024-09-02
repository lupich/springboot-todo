package com.luismi.crus_task.models.dto;

import com.luismi.crus_task.models.entities.Task;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class UserDto {
  private  Integer id;
  private String username;
 private String password;
  private String email;
  private List<TaskDto> listTasks;
}
