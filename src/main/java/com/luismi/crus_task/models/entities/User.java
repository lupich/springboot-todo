package com.luismi.crus_task.models.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private  Integer id;
  private String username;
  private String password;
  private String email;

  @OneToMany(cascade = CascadeType.ALL ,orphanRemoval = true)
  @JoinColumn(name = "user_id")
  private List<Task> listTasks;

}
