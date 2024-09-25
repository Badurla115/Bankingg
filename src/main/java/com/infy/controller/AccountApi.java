package com.infy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.repository.query.Param;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.PutMapping;

import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.infy.dto.AccountDTO;
import com.infy.dto.BankAccountDTO;
import com.infy.dto.TransactionDTO;
import com.infy.exception.InfyMeMobileException;
import com.infy.service.AccountServiceImpl;

import jakarta.validation.Valid;



@RestController

@CrossOrigin

@RequestMapping(value = "/infyme")

public class AccountApi {

 @Autowired

 AccountServiceImpl accountServiceImpl;

 @PostMapping(value = "/accounts")

 public ResponseEntity<String> createAccount(@Valid @RequestBody AccountDTO accountDTO) throws InfyMeMobileException{

 String msg = accountServiceImpl.createAccount(accountDTO);

 return new ResponseEntity<>(msg,HttpStatus.CREATED);

 }

 @PostMapping(value = "/accounts/{mobileNo}")

 public ResponseEntity<String> linkAccount(@RequestBody BankAccountDTO accountNo, @PathVariable Long mobileNo) throws InfyMeMobileException{

 String msg = accountServiceImpl.linkAccount(mobileNo, accountNo.getAccountNumber());

 return new ResponseEntity<>(msg,HttpStatus.CREATED);

 }

 @PostMapping(value = "/accounts/v1/{mobileNo}")

 public ResponseEntity<String> linkAccounts(@RequestBody BankAccountDTO accountNo, @PathVariable Long mobileNo) throws InfyMeMobileException{

 String msg = accountServiceImpl.linkAccount(mobileNo, accountNo.getAccountNumber(), accountNo.getOtp());

 return new ResponseEntity<>(msg,HttpStatus.CREATED);

 }

 @GetMapping(value = "/accounts/balance/{mobileNo}")

 public ResponseEntity<Double> checkBalance(@RequestBody BankAccountDTO accountNo , @PathVariable Long mobileNo) throws InfyMeMobileException{

 Double balance = accountServiceImpl.checkBalance(mobileNo, accountNo.getAccountNumber());

 return new ResponseEntity<>(balance, HttpStatus.OK);

 }

 @PutMapping(value = "/accounts/fundtransfer")

 public ResponseEntity<String> fundTransfer(@RequestBody TransactionDTO transactionDTO) throws InfyMeMobileException{

 String msg = accountServiceImpl.fundTransfer(transactionDTO);

 return new ResponseEntity<>(msg,HttpStatus.OK);

 }

 @GetMapping(value = "accounts/statement/{mobileNo}")

 public ResponseEntity<List<TransactionDTO>> accountStatement(@PathVariable Long mobileNo) throws InfyMeMobileException {

 List<TransactionDTO> transactionDTO = accountServiceImpl.accountStatement(mobileNo);

 return new ResponseEntity<>(transactionDTO, HttpStatus.OK);

 }

}