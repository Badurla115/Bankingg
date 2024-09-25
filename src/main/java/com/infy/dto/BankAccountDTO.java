package com.infy.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.Min;

import jakarta.validation.constraints.NotNull;

import jakarta.validation.constraints.Past;

import jakarta.validation.constraints.Size;

public class BankAccountDTO {

 @NotNull(message = "{accountNumber_not_present}")

 @Min(value = 100000L ,message = "{invalid_accountNumber}")

 private Long accountNumber;

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

//	@Min(value = 1000000000L, message = "{invalid_mobileNumber}")

 private UserDTO userDTO;

 private Integer otp;

 public Integer getOtp() {

 return otp;

 }

 public void setOtp(Integer otp) {

 this.otp = otp;

 }

 public Long getAccountNumber() {

 return accountNumber;

 }

 public void setAccountNumber(Long accountNumber) {

 this.accountNumber = accountNumber;

 }

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

 return "BankAccountDTO [accountNumber=" + accountNumber + ", bankName=" + bankName + ", balance=" + balance

 + ", accountType=" + accountType + ", ifscCode=" + ifscCode + ", openingDate=" + openingDate

 + ", userDTO=" + userDTO + "]";

 }

}