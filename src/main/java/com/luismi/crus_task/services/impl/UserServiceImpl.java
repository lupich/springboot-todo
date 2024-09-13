package com.luismi.crus_task.services.impl;

import com.luismi.crus_task.mappers.TaskMapper;
import com.luismi.crus_task.mappers.UserMapper;
import com.luismi.crus_task.models.dto.TaskDto;
import com.luismi.crus_task.models.dto.UserDto;
import com.luismi.crus_task.models.dto.UserSinPassDto;
import com.luismi.crus_task.models.entities.Task;
import com.luismi.crus_task.models.entities.User;
import com.luismi.crus_task.repositories.UserRepository;
import com.luismi.crus_task.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
  @Autowired
  private UserRepository userRepository;

  @Autowired
  private UserMapper userMapper;

  @Autowired
  private TaskMapper taskMapper;

  @Transactional(readOnly = true)
  @Override
  public List<UserSinPassDto> findAll() {
    List<User> listTask=(List<User>) userRepository.findAll();
    return listTask.stream().map(userMapper::toUserSinPassDto).collect(Collectors.toList());
  }
  @Transactional(readOnly = true)
  @Override
  public Optional<UserSinPassDto> findId(Integer id) {
    Optional<User> user=userRepository.findById(id);
    return user.map(userMapper::toUserSinPassDto);
  }

  @Transactional
  @Override
  public UserSinPassDto save(UserDto userDto) {
    User user =userMapper.toUser(userDto);
    user=userRepository.save(user);
    return userMapper.toUserSinPassDto(user);
  }

  @Transactional
  @Override
  public Optional<UserSinPassDto> update(Integer id, UserDto userDto) {

    Optional<User> userId=userRepository.findById(id);

    if(userId.isPresent()){
      User userDb=userId.orElseThrow()  ;
      userDb.setPassword(userDto.getEmail());
      userDb.setEmail(userDto.getPassward());
      userDb=userRepository.save(userDb);
      return Optional.ofNullable(userMapper.toUserSinPassDto(userDb));
    }
    return Optional.empty();
  }

  @Transactional
  @Override
  public Optional<User> delete(Integer id) {
    Optional<User> userId=userRepository.findById(id);
    //userId.ifPresent(userDb-> userRepository.delete(userDb));
    userId.ifPresent(userRepository::delete);
    return Optional.empty();
  }

  @Override
  public Optional<UserSinPassDto> assignToTask(TaskDto taskDto, Integer id) {
    Optional <User> user=userRepository.findById(id);
    if(user.isPresent()){
      User userDb=user.orElseThrow();
      Task task =taskMapper.toTask(taskDto);
      userDb.getListTasks().add(task);
      userDb=userRepository.save(userDb);
      return Optional.ofNullable(userMapper.toUserSinPassDto(userDb));

    };
    return Optional.empty();
  }
}
