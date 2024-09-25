package com.infy.utility;

import org.apache.logging.log4j.LogManager;

import org.apache.logging.log4j.Logger;

import org.springframework.stereotype.Component;

import com.infy.service.UserServiceImpl;

@Component

public class OTPUtility {

 private static final Logger logger = LogManager.getLogger(UserServiceImpl.class);

 private Integer otp;

 public Integer getOtp() {

 return otp;

 }

 public void setOtp(Integer otp) {

 this.otp = otp;

 }

 public Integer sendOTP() {

 logger.info("Inside sendOTP() method of {}",

 this.getClass());

 return 123456;

 }

}