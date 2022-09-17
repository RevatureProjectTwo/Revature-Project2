package com.Revature.ecommerce.project2WesPSamvelA.controller;

import org.springframework.beans.BeanUtils;
// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.web.bind.annotation.*;

// import java.util.List;

import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;

import com.Revature.ecommerce.project2WesPSamvelA.entity.UserEntity;
import com.Revature.ecommerce.project2WesPSamvelA.pojo.LoginResponsePojo;
import com.Revature.ecommerce.project2WesPSamvelA.pojo.UserPojo;
import com.Revature.ecommerce.project2WesPSamvelA.service.UserService;
import com.fasterxml.jackson.databind.util.JSONPObject;

import ch.qos.logback.core.net.LoginAuthenticator;

@RestController
@RequestMapping("api/users")
public class UserController {

  @Autowired
  UserService userService;

  // Create - addBook - @PostMapping
  @PostMapping("/register")
  public ResponseEntity<UserPojo> addUser(@Valid @RequestBody UserPojo newUser) {    
    return ResponseEntity.status(HttpStatus.CREATED).body(userService.addUser(newUser));
  }
  
  @PostMapping("/login")
  public ResponseEntity<LoginResponsePojo> login(@Valid @RequestBody UserPojo user){
    String username = user.getUserUserName();
    String password = user.getUserPassword();

    if(userService.getUserByUsernameAndPassword(username, password) == null) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid combination of username and password");
    }

    String token = userService.signToken(username, password);

    return ResponseEntity.status(HttpStatus.CREATED).body(new LoginResponsePojo(token));
  }

  @GetMapping("/me")
  public UserPojo me(@RequestHeader("authorization") String token) {
    try{
      return userService.authenticate(token);
    } catch(Exception e) {
      throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Invalid authentication token");
    }
  }
}
