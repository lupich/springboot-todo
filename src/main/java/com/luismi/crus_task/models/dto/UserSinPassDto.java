package com.luismi.crus_task.models.dto;

import com.luismi.crus_task.models.entities.Task;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class UserSinPassDto {
  private  Integer id;
  private String username;
  private String email;
  private List<Task> listTasks;
}
