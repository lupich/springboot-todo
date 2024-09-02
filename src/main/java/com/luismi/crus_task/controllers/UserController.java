package com.luismi.crus_task.controllers;
import com.luismi.crus_task.models.entities.User;
import com.luismi.crus_task.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class UserController {
  @Autowired
  private UserService userService;



  @GetMapping("/user")
  public ResponseEntity<?> listAll(){
    List<User>  userList=userService.findAll();
    if(userList.isEmpty()){

      return ResponseEntity.notFound().build();
    }
    /*List<UserDto> listUserDto=userList.stream().map(userMapper::toUserDto).collect(Collectors.toList());
    return ResponseEntity.ok().body(listUserDto);*/
    return ResponseEntity.ok().body(userList);

  }



}
