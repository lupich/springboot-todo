package com.luismi.crus_task.models.dto;

import lombok.Data;

@Data
public class TaskDto {
  private Integer id;
  private String title;
  private String description;
  private String status;
  private String priority;
}
