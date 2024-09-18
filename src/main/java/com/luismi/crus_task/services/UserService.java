package com.luismi.crus_task.services;

import com.luismi.crus_task.models.dto.UserSinPassDto;
import com.luismi.crus_task.models.entities.Task;
import com.luismi.crus_task.models.entities.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
  List<UserSinPassDto> findAll();
  Optional<UserSinPassDto> findId(Integer id);
  UserSinPassDto save(User user);
  Optional<UserSinPassDto> update(Integer id, User user);
  Optional<User> delete(Integer id);

  Optional<UserSinPassDto> assignToTask(Task task, Integer id);


}
