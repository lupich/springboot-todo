package com.luismi.crus_task.services;

import com.luismi.crus_task.models.dto.TaskDto;
import com.luismi.crus_task.models.dto.UserDto;
import com.luismi.crus_task.models.dto.UserSinPassDto;
import com.luismi.crus_task.models.entities.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
  List<UserSinPassDto> findAll();
  Optional<UserSinPassDto> findId(Integer id);
  UserSinPassDto save(UserDto userDto);
  Optional<UserSinPassDto> update(Integer id, UserDto userDto);
  Optional<User> delete(Integer id);

  Optional<UserSinPassDto> assignToTask(TaskDto taskDto, Integer id);


}
