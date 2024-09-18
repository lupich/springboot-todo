package com.luismi.crus_task.mappers;

import com.luismi.crus_task.models.dto.UserSinPassDto;
import com.luismi.crus_task.models.entities.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {



  //@Mapping(target = "password", ignore = true)
  //@Mapping(source = "listTasks", target = "listTasks")
  UserSinPassDto toUserSinPassDto(User user);
  User toUser(UserSinPassDto userSinPassDto);


}
