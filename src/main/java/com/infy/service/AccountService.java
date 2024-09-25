package com.infy.service;

import java.util.List;

import com.infy.dto.AccountDTO;

import com.infy.dto.BankAccountDTO;

import com.infy.dto.TransactionDTO;

import com.infy.exception.InfyMeMobileException;

public interface AccountService {

 String createAccount(AccountDTO accountDTO) throws InfyMeMobileException;

 List<BankAccountDTO> listAccounts(Long mobileNo) throws InfyMeMobileException;

 String linkAccount(Long mobileNumber, Long accountNo) throws InfyMeMobileException;

 String linkAccount(Long mobileNo, Long accountNo, Integer OTP) throws InfyMeMobileException;

 Double checkBalance(Long mobileNumber, Long accountNo) throws InfyMeMobileException;

 String fundTransfer(TransactionDTO transactionDTO) throws InfyMeMobileException;

 List<TransactionDTO> accountStatement(Long mobileNumber) throws InfyMeMobileException;

}