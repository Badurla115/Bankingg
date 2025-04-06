package com.infy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.infy.dto.LoginDTO;

import com.infy.dto.UserDTO;

import com.infy.exception.InfyMeMobileException;

import com.infy.service.UserServiceImpl;

import jakarta.validation.Valid;

@RestController

@RequestMapping(value = "/infyme")

public class UserAPI {

 @Autowired

 UserServiceImpl userServiceImpl;

 @PostMapping(value = "/users")

 public ResponseEntity<String> createUser(@Valid @RequestBody UserDTO userDTO) throws InfyMeMobileException{

 String msg = "Account Successfully Created for : " + userServiceImpl.createUser(userDTO) ;

 return new ResponseEntity<>(msg,HttpStatus.CREATED);

 }

 @PostMapping(value = "/users/login")

 public ResponseEntity<Boolean> loginUser(@RequestBody LoginDTO loginDTO) throws InfyMeMobileException{

 boolean flag = userServiceImpl.loginUser(loginDTO);

 return new ResponseEntity<>(flag,HttpStatus.CREATED);

 }

 @GetMapping(value = "/users/{userId}")

 public ResponseEntity<UserDTO> getUserProfile(@PathVariable String userId) throws InfyMeMobileException{

 UserDTO userDTO = userServiceImpl.getUserProfile(userId);

 return new ResponseEntity<>(userDTO, HttpStatus.OK);

 }

 @GetMapping(value = "/users/all")

 public ResponseEntity<List<UserDTO>> showAllUsers(){

 List<UserDTO> userDTOs = userServiceImpl.showAllUsers();

 return new ResponseEntity<>(userDTOs, HttpStatus.OK);

 }

}
#new codee