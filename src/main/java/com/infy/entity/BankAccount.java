package com.infy.entity;

import java.time.LocalDate;

import java.util.Objects;

import jakarta.persistence.CascadeType;

import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;

import jakarta.persistence.GenerationType;

import jakarta.persistence.Id;

import jakarta.persistence.JoinColumn;

import jakarta.persistence.ManyToOne;

@Entity

public class BankAccount {

 @Id

 @GeneratedValue(strategy = GenerationType.IDENTITY)

 private Long accountNumber;

 private String bankName;

 private Double balance;

 private String accountType;

 private String ifscCode;

 private LocalDate openingDate;

 @ManyToOne(cascade = CascadeType.ALL)

 @JoinColumn(name = "mobile_number")

 private User user;

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

 public User getUser() {

 return user;

 }

 public void setUser(User user) {

 this.user = user;

 }

 @Override

 public int hashCode() {

 return Objects.hash(accountNumber, accountType, balance, bankName, ifscCode, openingDate, user);

 }

 @Override

 public boolean equals(Object obj) {

 if (this == obj)

 return true;

 if (obj == null)

 return false;

 if (getClass() != obj.getClass())

 return false;

 BankAccount other = (BankAccount) obj;

 return Objects.equals(accountNumber, other.accountNumber) && Objects.equals(accountType, other.accountType)

 && Objects.equals(balance, other.balance) && Objects.equals(bankName, other.bankName)

 && Objects.equals(ifscCode, other.ifscCode) && Objects.equals(openingDate, other.openingDate)

 && Objects.equals(user, other.user);

 }

}