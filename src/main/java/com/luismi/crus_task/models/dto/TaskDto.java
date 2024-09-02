package com.luismi.crus_task.models.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TaskDto {
  private Integer id;
  private String title;
  private String description;
  private String status;
  private String priority;
}
