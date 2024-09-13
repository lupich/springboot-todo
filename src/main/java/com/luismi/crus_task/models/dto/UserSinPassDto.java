package com.luismi.crus_task.models.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class UserSinPassDto {
  private  Integer id;
  private String username;
  private String email;
  private List<TaskDto> listTasks;
}
