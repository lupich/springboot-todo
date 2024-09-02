package com.luismi.crus_task.services;

import com.luismi.crus_task.models.entities.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
  List<User> findAll();
  Optional<User> findId(Integer id);
  User save(User user);
  Optional<User> update(Integer id, User user);
  Optional<User> delete(Integer id);

}
