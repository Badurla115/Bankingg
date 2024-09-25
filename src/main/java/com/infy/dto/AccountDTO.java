package com.infy.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.Min;

import jakarta.validation.constraints.NotNull;

import jakarta.validation.constraints.Past;

import jakarta.validation.constraints.Size;

public class AccountDTO {

 @NotNull(message = "{bankName_not_present}")

 @Size(min = 5, max = 15,message = "{invalid_bankName}")

 private String bankName;

 @Min(value =0, message = "{invalid_balance}")

 private Double balance;

 @NotNull(message = "{accountType_not_present}")

 @Size(min = 1, max = 10,message = "{invalid_accountType}")

 private String accountType;

 @NotNull(message = "{ifscCode_not_present}")

 @Size(min = 1, max = 15, message = "{invalid_ifscCode}")

 private String ifscCode;

 @Past(message = "{openingDate_inPast}")

 private LocalDate openingDate;

 @NotNull(message = "{mobileNumber_not_present}")

 private UserDTO userDTO;

 public String getBankName() {

 return bankName;

 }

 public void setBankName(String bankName) {

 this.bankName = bankName;

 }

 public Double getBalance() {

 return balance;

 }

 public void setBalance(Double balance) {

 this.balance = balance;

 }

 public String getAccountType() {

 return accountType;

 }

 public void setAccountType(String accountType) {

 this.accountType = accountType;

 }

 public String getIfscCode() {

 return ifscCode;

 }

 public void setIfscCode(String ifscCode) {

 this.ifscCode = ifscCode;

 }

 public LocalDate getOpeningDate() {

 return openingDate;

 }

 public void setOpeningDate(LocalDate openingDate) {

 this.openingDate = openingDate;

 }

 public UserDTO getUserDTO() {

 return userDTO;

 }

 public void setUserDTO(UserDTO userDTO) {

 this.userDTO = userDTO;

 }

 @Override

 public String toString() {

 return "AccountDTO [bankName=" + bankName + ", balance=" + balance + ", accountType=" + accountType

 + ", ifscCode=" + ifscCode + ", openingDate=" + openingDate + ", userDTO=" + userDTO + "]";

 }

}