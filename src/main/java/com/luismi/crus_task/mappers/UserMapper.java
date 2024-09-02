package com.luismi.crus_task.mappers;

import com.luismi.crus_task.models.dto.UserDto;
import com.luismi.crus_task.models.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {
  @Mapping(target = "password" ,ignore = true)
  UserDto toUserDto(User user);

}
