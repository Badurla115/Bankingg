package com.infy.entity;

import java.util.Objects;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.CascadeType;

import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;

import jakarta.persistence.Id;

import jakarta.persistence.JoinColumn;

import jakarta.persistence.ManyToOne;

import jakarta.persistence.OneToOne;

@Entity

public class DigitalBankAccount {

 @Id

 private String digitalBankingId;

 @ManyToOne(cascade = CascadeType.ALL)

 @JoinColumn(name = "mobile_number")

 private User user;

 @OneToOne(cascade = CascadeType.ALL)

 @JoinColumn(name = "account_number")

 private BankAccount accountNumber;

 private String accountType;

 public String getDigitalBankingId() {

 return digitalBankingId;

 }

 public void setDigitalBankingId(String digitalBankingId) {

 this.digitalBankingId = digitalBankingId;

 }

 public User getUser() {

 return user;

 }

 public void setUser(User user) {

 this.user = user;

 }

 public BankAccount getAccountNumber() {

 return accountNumber;

 }

 public void setAccountNumber(BankAccount accountNumber) {

 this.accountNumber = accountNumber;

 }

 public String getAccountType() {

 return accountType;

 }

 public void setAccountType(String accountType) {

 this.accountType = accountType;

 }

 @Override

 public int hashCode() {

 return Objects.hash(accountNumber, accountType, digitalBankingId, user);

 }

 @Override

 public boolean equals(Object obj) {

 if (this == obj)

 return true;

 if (obj == null)

 return false;

 if (getClass() != obj.getClass())

 return false;

 DigitalBankAccount other = (DigitalBankAccount) obj;

 return Objects.equals(accountNumber, other.accountNumber)

 && Objects.equals(accountType, other.accountType)

 && Objects.equals(digitalBankingId, other.digitalBankingId)

 && Objects.equals(user, other.user);

 }

}