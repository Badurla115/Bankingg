
package com.infy.dto;

import jakarta.validation.constraints.NotNull;

public class DigitalBankAccountDTO {

 private String digitalBankingId;

//	@NotNull(message = "{mobileNumber_not_present}")

 private UserDTO mobileNumber;

//	@NotNull(message = "{accountNumber_not_present}")

 private BankAccountDTO accountNumber;

//	@NotNull(message = "{accountType_not_present}")

 private String accountType;

 public String getDigitalBankingId() {

 return digitalBankingId;

 }

 public void setDigitalBankingId(String digitalBankingId) {

 this.digitalBankingId = digitalBankingId;

 }

 public UserDTO getMobileNumber() {

 return mobileNumber;

 }

 public void setMobileNumber(UserDTO mobileNumber) {

 this.mobileNumber = mobileNumber;

 }

 public BankAccountDTO getAccountNumber() {

 return accountNumber;

 }

 public void setAccountNumber(BankAccountDTO accountNumber) {

 this.accountNumber = accountNumber;

 }

 public String getAccountType() {

 return accountType;

 }

 public void setAccountType(String accountType) {

 this.accountType = accountType;

 }

 @Override

 public String toString() {

 return "DigitalBankAccountDTO [digitalBankingId=" + digitalBankingId + ", mobileNumber=" + mobileNumber

 + ", accountNumber=" + accountNumber + ", accountType=" + accountType + "]";

 }

}