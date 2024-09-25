package com.infy.service;

import java.util.List;

import com.infy.dto.LoginDTO;

import com.infy.dto.UserDTO;

import com.infy.exception.InfyMeMobileException;

public interface UserService {

 String createUser(UserDTO userDTO) throws InfyMeMobileException;

 Boolean loginUser(LoginDTO loginDTO) throws InfyMeMobileException;

 UserDTO getUserProfile(String userId) throws InfyMeMobileException;

 List<UserDTO> showAllUsers() throws InfyMeMobileException;

 UserDTO getUser(Long mobileNumber) throws InfyMeMobileException;

 String updateUserAddress(Long mobileNumber, String communicationAddress) throws InfyMeMobileException;

 String updateUserPassword(Long mobileNumber, String password) throws InfyMeMobileException;

}