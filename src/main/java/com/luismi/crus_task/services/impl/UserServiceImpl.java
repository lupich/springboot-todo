package com.luismi.crus_task.services.impl;

import com.luismi.crus_task.models.entities.User;
import com.luismi.crus_task.repositories.UserRepository;
import com.luismi.crus_task.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
  @Autowired
  private UserRepository userRepository;
  @Transactional(readOnly = true)
  @Override
  public List<User> findAll() {
    return (List<User>) userRepository.findAll();
  }
  @Transactional(readOnly = true)
  @Override
  public Optional<User> findId(Integer id) {
    return userRepository.findById(id);
  }

  @Transactional
  @Override
  public User save(User user) {
    return userRepository.save(user);
  }

  @Transactional
  @Override
  public Optional<User> update(Integer id, User user) {

    Optional<User> userId=userRepository.findById(id);
    if(userId.isPresent()){
      User userDb=userId.orElseThrow()  ;
      userDb.setPassword(user.getPassword());
      userDb.setEmail(user.getEmail());
      return Optional.of(userRepository.save(userDb));
    }
    return userId;
  }

  @Transactional
  @Override
  public Optional<User> delete(Integer id) {
    Optional<User> userId=userRepository.findById(id);
    userId.ifPresent(userDb-> userRepository.delete(userDb));
    return userId;
  }
}
