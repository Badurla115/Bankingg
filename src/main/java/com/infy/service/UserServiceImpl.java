package com.infy.service;

import java.util.ArrayList;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.infy.dto.LoginDTO;

import com.infy.dto.UserDTO;

import com.infy.entity.User;

import com.infy.exception.InfyMeMobileException;

import com.infy.repository.UserRepository;

@Service

public class UserServiceImpl implements UserService {

//	private static final Logger logger = LogManager.getLogger(UserServiceImpl.class);

 @Autowired

 UserRepository userRepository;

 @Override

 public String createUser(UserDTO userDTO) throws InfyMeMobileException {

 Optional<User> optional = userRepository.findById(userDTO.getMobileNumber());

 if(optional.isPresent()) {

 throw new InfyMeMobileException("USER_ALREADY_PRESENT");

 }

 User user = new User();

 user.setAccountHolderName(userDTO.getAccountHolderName());

 user.setCommunicationAddress(userDTO.getCommunicationAddress());

 user.setDateOfBirth(userDTO.getDateOfBirth());

 user.setEmail(userDTO.getEmail());

 user.setGender(userDTO.getGender());

 user.setMobileNumber(userDTO.getMobileNumber());

 user.setPAN(userDTO.getPAN());

 user.setPassword(userDTO.getPassword());

 user.setUserId(userDTO.getUserId());

 userRepository.save(user);

 return user.getMobileNumber().toString();

 }

 @Override

 public Boolean loginUser(LoginDTO loginDTO) throws InfyMeMobileException {

 boolean flag = Boolean.FALSE;

 Optional<User> optional = userRepository.findById(loginDTO.getMobileNumber());

 User user = optional.orElseThrow(()->new InfyMeMobileException("NO_USER_FOUND"));

 if(user.getPassword().equals(loginDTO.getPassword())) {

 flag = Boolean.TRUE;

 }

 else {

 flag = Boolean.FALSE;

 }

 return flag;

 }

 @Override

 public UserDTO getUserProfile(String userId) throws InfyMeMobileException {

 Optional<User> optional = userRepository.findByUserId(userId);

 User user = optional.orElseThrow(()-> new InfyMeMobileException("NO_USER_FOUND"));

 UserDTO userDTO = new UserDTO();

 userDTO.setAccountHolderName(user.getAccountHolderName());

 userDTO.setCommunicationAddress(user.getCommunicationAddress());

 userDTO.setDateOfBirth(user.getDateOfBirth());

 userDTO.setEmail(user.getEmail());

 userDTO.setGender(user.getGender());

 userDTO.setMobileNumber(user.getMobileNumber());

 userDTO.setPAN(user.getPAN());

 userDTO.setPassword(user.getPassword());

 userDTO.setUserId(user.getUserId());

 return userDTO;

 }

 @Override

 public List<UserDTO> showAllUsers() {

 Iterable<User> user = userRepository.findAll();

 List<UserDTO> userDTOs = new ArrayList<>();

 user.forEach(u -> {

 UserDTO userDTO = new UserDTO();

 userDTO.setAccountHolderName(u.getAccountHolderName());

 userDTO.setCommunicationAddress(u.getCommunicationAddress());

 userDTO.setDateOfBirth(u.getDateOfBirth());

 userDTO.setEmail(u.getEmail());

 userDTO.setGender(u.getGender());

 userDTO.setMobileNumber(u.getMobileNumber());

 userDTO.setPAN(u.getPAN());

 userDTO.setPassword(u.getPassword());

 userDTO.setUserId(u.getUserId());

 userDTOs.add(userDTO);

 });

 return userDTOs;

 }

 @Override

 public UserDTO getUser(Long mobileNumber) throws InfyMeMobileException {

 Optional<User> optional = userRepository.findById(mobileNumber);

 User user = optional.orElseThrow(()-> new InfyMeMobileException("NO_USER_FOUND"));

 UserDTO userDTO = new UserDTO();

 userDTO.setAccountHolderName(user.getAccountHolderName());

 userDTO.setCommunicationAddress(user.getCommunicationAddress());

 userDTO.setDateOfBirth(user.getDateOfBirth());

 userDTO.setEmail(user.getEmail());

 userDTO.setGender(user.getGender());

 userDTO.setMobileNumber(user.getMobileNumber());

 userDTO.setPAN(user.getPAN());

 userDTO.setPassword(user.getPassword());

 userDTO.setUserId(user.getUserId());

 return userDTO;

 }

 @Override

 public String updateUserAddress(Long mobileNumber, String communicationAddress) throws InfyMeMobileException {

 Optional<User> optional = userRepository.findById(mobileNumber);

 User user = optional.orElseThrow(()-> new InfyMeMobileException("NO_USER_FOUND"));

 user.setCommunicationAddress(communicationAddress);

 return "ADDRESS_SUCCESSFULLY_CHANGED";

 }

 @Override

 public String updateUserPassword(Long mobileNumber, String password) throws InfyMeMobileException {

 Optional<User> optional = userRepository.findById(mobileNumber);

 User user = optional.orElseThrow(()-> new InfyMeMobileException("NO_USER_FOUND"));

 user.setPassword(password);

 return "PASSWORD_SUCCESSFULLY_CHANGED";

 }

}