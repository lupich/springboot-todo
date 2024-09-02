package com.luismi.crus_task.mappers;

import com.luismi.crus_task.models.dto.TaskDto;
import com.luismi.crus_task.models.dto.UserDto;
import com.luismi.crus_task.models.entities.Task;
import com.luismi.crus_task.models.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring",uses = {TaskMapper.class})
public interface UserMapper {
  //@Mapping(target = "password", ignore = true)
  //@Mapping(source = "listTasks", target = "listTasks")
  UserDto toUserDto(User user);



}
