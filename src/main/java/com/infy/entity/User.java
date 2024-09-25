package com.infy.entity;

import java.time.LocalDate;

import java.util.Objects;

import jakarta.persistence.Entity;

import jakarta.persistence.Id;

@Entity

public class User {

 @Id

 private Long mobileNumber;

 private String userId;

 private String accountHolderName;

 private String gender;

 private LocalDate dateOfBirth;

 private String password;

 private String email;

 private String communicationAddress;

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

 public int hashCode() {

 return Objects.hash(gender, PAN, accountHolderName, communicationAddress, dateOfBirth, email, mobileNumber,

 password, userId);

 }

 @Override

 public boolean equals(Object obj) {

 if (this == obj)

 return true;

 if (obj == null)

 return false;

 if (getClass() != obj.getClass())

 return false;

 User other = (User) obj;

 return Objects.equals(gender, other.gender) && Objects.equals(PAN, other.PAN)

 && Objects.equals(accountHolderName, other.accountHolderName)

 && Objects.equals(communicationAddress, other.communicationAddress)

 && Objects.equals(dateOfBirth, other.dateOfBirth) && Objects.equals(email, other.email)

 && Objects.equals(mobileNumber, other.mobileNumber) && Objects.equals(password, other.password)

 && Objects.equals(userId, other.userId);

 }

}