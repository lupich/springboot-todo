package com.luismi.crus_task.controllers;
import com.luismi.crus_task.mappers.UserMapper;
import com.luismi.crus_task.models.dto.UserDto;
import com.luismi.crus_task.models.dto.UserSinPassDto;
import com.luismi.crus_task.models.entities.User;
import com.luismi.crus_task.repositories.UserRepository;
import com.luismi.crus_task.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1")
public class UserController {
  @Autowired
  private UserService userService;

  @GetMapping("/user")
  public ResponseEntity<?> listAll(){
    List<UserSinPassDto>  userList=userService.findAll();
    if(userList.isEmpty()){
      return ResponseEntity.notFound().build();
    }
    return ResponseEntity.ok().body(userList);

  }

  @GetMapping("/user/{id}")
  public ResponseEntity<?> findById(@PathVariable Integer id){
    Optional<UserSinPassDto> userDto=userService.findId(id);
    if(userDto.isPresent()){
      return ResponseEntity.ok(userDto);
    }
    return ResponseEntity.notFound().build();
  }

  @PostMapping("/user")
  public ResponseEntity<UserSinPassDto> createUser(@RequestBody UserDto userDto){
    UserSinPassDto userSinPassDto= userService.save(userDto);
    return ResponseEntity.ok().body(userSinPassDto);
  }

  @PutMapping("/user/{id}")
  public ResponseEntity<?> update(@PathVariable Integer id ,@RequestBody UserDto userDto){
    Optional<UserSinPassDto> user=userService.update(id,userDto);
    if(user.isPresent()){
      return ResponseEntity.ok().body(user);
    }
    return ResponseEntity.notFound().build();
  }

  @DeleteMapping("/user/{id}")
  public ResponseEntity <?> delete(@PathVariable Integer id){
    Optional <User> user=userService.delete(id);
    if(user.isPresent()){
      return ResponseEntity.noContent().build();

    }
    return ResponseEntity.badRequest().build();
  }



}
