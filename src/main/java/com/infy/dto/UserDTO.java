package com.infy.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.Max;

import jakarta.validation.constraints.Min;

import jakarta.validation.constraints.NotNull;

import jakarta.validation.constraints.Past;

import jakarta.validation.constraints.Pattern;

import jakarta.validation.constraints.Size;

public class UserDTO {

 @NotNull(message = "{mobileNumber_not_present}")

 @Min(value = 1000000000L, message = "{invalid_mobileNumber}")

 @Max(value = 9999999999L, message = "{invalid_mobileNumber}")

 private Long mobileNumber;

 @Pattern(regexp = "U[0-9]+" ,message = "{invalid_userId}")

 private String userId;

 @NotNull(message = "{accountHolderName_is_not_present}")

 @Size(min = 3,max = 50,message = "{invalid_accountHolderName}")

 private String accountHolderName;

 @Pattern(regexp = "Male|Female", message = "{invalid_gender}")

 private String gender;

 @Past(message = "{invalid_dateOfBirth}")

 private LocalDate dateOfBirth;

 @NotNull(message = "{password_is_not_present}")

 @Size(min = 5, max = 10 ,message = "{invalid_passwordSize}")

 @Pattern(regexp = "[a-zA-Z0-9]+",message = "{invalid_password}")

 private String password;

 @Pattern(regexp = "^[A-Za-z0-9._]+@[A-Za-z0-9._]+\\.[A-Za-z]+" ,message = "{invalid_email}")

 private String email;

 @NotNull(message = "{communicationAddress_is_not_present}")

 @Size(min = 3,max = 50,message = "{invalid_address}")

 private String communicationAddress;

 @NotNull(message = "{PAN_is_not_present}")

 @Size(min = 10,message = "{invalid_PANsize}")

 @Pattern(regexp = "[A-Z]{5}[0-9]{4}[A-Z]{1}",message = "{invalid_PAN}")

 private String PAN;

 public String getUserId() {

 return userId;

 }

 public void setUserId(String userId) {

 this.userId = userId;

 }

 public Long getMobileNumber() {

 return mobileNumber;

 }

 public void setMobileNumber(Long mobileNumber) {

 this.mobileNumber = mobileNumber;

 }

 public String getAccountHolderName() {

 return accountHolderName;

 }

 public void setAccountHolderName(String accountHolderName) {

 this.accountHolderName = accountHolderName;

 }

 public String getGender() {

 return gender;

 }

 public void setGender(String gender) {

 this.gender = gender;

 }

 public LocalDate getDateOfBirth() {

 return dateOfBirth;

 }

 public void setDateOfBirth(LocalDate dateOfBirth) {

 this.dateOfBirth = dateOfBirth;

 }

 public String getPassword() {

 return password;

 }

 public void setPassword(String password) {

 this.password = password;

 }

 public String getEmail() {

 return email;

 }

 public void setEmail(String email) {

 this.email = email;

 }

 public String getCommunicationAddress() {

 return communicationAddress;

 }

 public void setCommunicationAddress(String communicationAddress) {

 this.communicationAddress = communicationAddress;

 }

 public String getPAN() {

 return PAN;

 }

 public void setPAN(String pAN) {

 PAN = pAN;

 }

 @Override

 public String toString() {

 return "UserDTO [userId=" + userId + ", mobileNumber=" + mobileNumber + ", accountHolderName="

 + accountHolderName + ", gender=" + gender + ", dateOfBirth=" + dateOfBirth + ", password=" + password

 + ", email=" + email + ", communicationAddress=" + communicationAddress + ", PAN=" + PAN + "]";

 }

}