package com.infy.dto;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotNull;

public class TransactionDTO {

 private Integer transactionId;

 @NotNull(message = "{modeOfTransaction_not_present}")

 private String modeOfTransaction;

 @NotNull(message = "{paidTo_not_present}")

 private Long paidTo;

 @NotNull(message = "{receiverAccountNumber_not_present}")

 private Long receiverAccountNumber;

 @NotNull(message = "{amount_not_present}")

 private Double amount;

 @NotNull(message = "{transactionDateTime_not_present}")

 private LocalDateTime transactionDateTime;

 @NotNull(message = "{remarks_not_present}")

 private String remarks;

 @NotNull(message = "{paidFrom_not_present}")

 private Long paidFrom;

 @NotNull(message = "{senderAccountNumber_not_present}")

 private Long senderAccountNumber;

 public Integer getTransactionId() {

 return transactionId;

 }

 public void setTransactionId(Integer transactionId) {

 this.transactionId = transactionId;

 }

 public String getModeOfTransaction() {

 return modeOfTransaction;

 }

 public void setModeOfTransaction(String modeOfTransaction) {

 this.modeOfTransaction = modeOfTransaction;

 }

 public Long getPaidTo() {

 return paidTo;

 }

 public void setPaidTo(Long paidTo) {

 this.paidTo = paidTo;

 }

 public Long getReceiverAccountNumber() {

 return receiverAccountNumber;

 }

 public void setReceiverAccountNumber(Long receiverAccountNumber) {

 this.receiverAccountNumber = receiverAccountNumber;

 }

 public Double getAmount() {

 return amount;

 }

 public void setAmount(Double amount) {

 this.amount = amount;

 }

 public LocalDateTime getTransactionDateTime() {

 return transactionDateTime;

 }

 public void setTransactionDateTime(LocalDateTime transactionDateTime) {

 this.transactionDateTime = transactionDateTime;

 }

 public String getRemarks() {

 return remarks;

 }

 public void setRemarks(String remarks) {

 this.remarks = remarks;

 }

 public Long getPaidFrom() {

 return paidFrom;

 }

 public void setPaidFrom(Long paidFrom) {

 this.paidFrom = paidFrom;

 }

 public Long getSenderAccountNumber() {

 return senderAccountNumber;

 }

 public void setSenderAccountNumber(Long senderAccountNumber) {

 this.senderAccountNumber = senderAccountNumber;

 }

 @Override

 public String toString() {

 return "TransactionDTO [transactionId=" + transactionId + ", modeOfTransaction=" + modeOfTransaction

 + ", paidTo=" + paidTo + ", receiverAccountNumber=" + receiverAccountNumber + ", amount=" + amount

 + ", transactionDateTime=" + transactionDateTime + ", remarks=" + remarks + ", paidFrom=" + paidFrom

 + ", senderAccountNumber=" + senderAccountNumber + "]";

 }

}