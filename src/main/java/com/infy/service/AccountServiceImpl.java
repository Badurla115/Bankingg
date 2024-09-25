package com.infy.service;

import java.util.ArrayList;

import java.util.Iterator;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.infy.dto.AccountDTO;

import com.infy.dto.BankAccountDTO;

import com.infy.dto.TransactionDTO;

import com.infy.dto.UserDTO;

import com.infy.entity.BankAccount;

import com.infy.entity.DigitalBankAccount;

import com.infy.entity.Transaction;

import com.infy.entity.User;

import com.infy.exception.InfyMeMobileException;

import com.infy.repository.AccountRepository;

import com.infy.repository.DigitalBankAccountRepository;

import com.infy.repository.TransactionRepository;

import com.infy.repository.UserRepository;
import com.infy.utility.OTPUtility;


import jakarta.transaction.Transactional;

@Service

@Transactional

public class AccountServiceImpl implements AccountService {

 @Autowired

 AccountRepository accountRepository;

 @Autowired

 UserRepository userRepository;

 @Autowired

 DigitalBankAccountRepository digitalBankAccountRepository;

 @Autowired

 TransactionRepository transactionRepository;

 @Autowired

 OTPUtility oTPutiltiy;

 @Override

 public String createAccount(AccountDTO accountDTO) throws InfyMeMobileException {

 Long a = accountDTO.getUserDTO().getMobileNumber();

 Optional<User> optional = userRepository.findById(accountDTO.getUserDTO().getMobileNumber());

 User user = optional.orElseThrow(()-> new InfyMeMobileException("NO_USER_FOUND"));

 List<BankAccount> bank = accountRepository.findBankAccountsByMobileNumber(a);

// System.out.println(bank);

// BankAccount bank = accountRepository.findByAccountTypeAndBankName(accountDTO.getAccountType(), accountDTO.getBankName());

 for (BankAccount bankAccount2 : bank) {

 if(bankAccount2.getUser().getMobileNumber().equals(accountDTO.getUserDTO().getMobileNumber())){

 if(bankAccount2.getAccountType().equals(accountDTO.getAccountType())&& bankAccount2.getBankName().equals(accountDTO.getBankName())) {

  throw new InfyMeMobileException("Service.ACCOUNT_ALREADY_PRESENT");

 }

 }

 }

 BankAccount bankAccount = new BankAccount();

 bankAccount.setAccountType(accountDTO.getAccountType());

 bankAccount.setBalance(accountDTO.getBalance());

 bankAccount.setBankName(accountDTO.getBankName());

 bankAccount.setIfscCode(accountDTO.getIfscCode());

 bankAccount.setUser(user);

 bankAccount.setOpeningDate(accountDTO.getOpeningDate());

 accountRepository.save(bankAccount);

 return "SUCCESSFULLY_ADDED";

 }

 @Override

 public List<BankAccountDTO> listAccounts(Long mobileNo) throws InfyMeMobileException {

 Iterable<BankAccount> list = accountRepository.findAll();

 List<BankAccountDTO> bankAccount = new ArrayList<>();

 for (BankAccount bankAccount2 : list) {

 if(bankAccount2.getUser().getMobileNumber().equals(mobileNo)) {

 BankAccountDTO bankAccountDTO = new BankAccountDTO();

 bankAccountDTO.setAccountNumber(bankAccount2.getAccountNumber());

 bankAccountDTO.setAccountType(bankAccount2.getAccountType());

 bankAccountDTO.setBalance(bankAccount2.getBalance());

 bankAccountDTO.setBankName(bankAccount2.getBankName());

 bankAccountDTO.setIfscCode(bankAccount2.getIfscCode());

 bankAccountDTO.setOpeningDate(bankAccount2.getOpeningDate());

 UserDTO userDTO = new UserDTO();

 userDTO.setAccountHolderName(bankAccount2.getUser().getAccountHolderName());

 userDTO.setCommunicationAddress(bankAccount2.getUser().getCommunicationAddress());

 userDTO.setDateOfBirth(bankAccount2.getUser().getDateOfBirth());

 userDTO.setEmail(bankAccount2.getUser().getEmail());

 userDTO.setGender(bankAccount2.getUser().getGender());

 userDTO.setMobileNumber(bankAccount2.getUser().getMobileNumber());

 userDTO.setPAN(bankAccount2.getUser().getPAN());

 userDTO.setPassword(bankAccount2.getUser().getPassword());

 userDTO.setUserId(bankAccount2.getUser().getUserId());

 bankAccountDTO.setUserDTO(userDTO);

 bankAccount.add(bankAccountDTO);

 }

// else {

// throw new InfyMeMobileException("Service.NO_ACCOUNTS_FOUND");

// }

 }

 if(bankAccount.isEmpty()) {

 throw new InfyMeMobileException("Service.NO_ACCOUNTS_FOUND");

 }

 return bankAccount;

 }

 @Override

 public String linkAccount(Long mobileNumber, Long accountNo) throws InfyMeMobileException {

 List<BankAccount> list = accountRepository.findBankAccountsByMobileNumber(mobileNumber);

 if(list.isEmpty()) {

 throw new InfyMeMobileException("Service.NO_ACCOUNTS_FOUND");

 }

 List<DigitalBankAccount> d = (List<DigitalBankAccount>) digitalBankAccountRepository.findAll();

 Optional<DigitalBankAccount> optional = digitalBankAccountRepository.findByBankAccount(accountNo);

 if(optional.isPresent()) {

 throw new InfyMeMobileException("Service.ACCOUNT_ALREADY_PRESENT");

 }

 DigitalBankAccount digitalBankAccount = new DigitalBankAccount();

 for (BankAccount bankAccount : list) {

 if(bankAccount.getAccountNumber().equals(accountNo)) {

 digitalBankAccount.setAccountNumber(bankAccount);

 digitalBankAccount.setAccountType(bankAccount.getAccountType());

 digitalBankAccount.setUser(bankAccount.getUser());

 }

 }

 if(digitalBankAccount.getAccountNumber()==null) {

 throw new InfyMeMobileException("Service.NO_BANK_FOR_ACCOUNT");

 }

 digitalBankAccount.setDigitalBankingId("DBA-" + (d.size()+1));

 digitalBankAccountRepository.save(digitalBankAccount);

 return "LINKED_SUCCESSFULLY";

 }

 @Override

 public String linkAccount(Long mobileNo, Long accountNo, Integer OTP) throws InfyMeMobileException {

 // TODO Auto-generated method stub

  List<BankAccount> list = accountRepository.findBankAccountsByMobileNumber(mobileNo);

 if(list.isEmpty()) {

 throw new InfyMeMobileException("Service.NO_ACCOUNTS_FOUND");

 }

 List<DigitalBankAccount> d = (List<DigitalBankAccount>) digitalBankAccountRepository.findAll();

 Optional<DigitalBankAccount> optional = digitalBankAccountRepository.findByBankAccount(accountNo);

 if(optional.isPresent()) {

 throw new InfyMeMobileException("Service.ACCOUNT_ALREADY_PRESENT");

 }

 DigitalBankAccount digitalBankAccount = new DigitalBankAccount();

 for (BankAccount bankAccount : list) {

 if(bankAccount.getAccountNumber().equals(accountNo)) {

 Integer otp = oTPutiltiy.sendOTP();

 if(otp.equals(OTP)) {

 digitalBankAccount.setAccountNumber(bankAccount);

 digitalBankAccount.setAccountType(bankAccount.getAccountType());

 digitalBankAccount.setUser(bankAccount.getUser());

 }

 else {

  throw new InfyMeMobileException("OTP_DOESNOT_MATCH");

 }

 }

 }

 if(digitalBankAccount.getAccountNumber()==null) {

 throw new InfyMeMobileException("Service.NO_BANK_FOR_ACCOUNT");

 }

 digitalBankAccount.setDigitalBankingId("DBA-" + (d.size()+1));

 digitalBankAccountRepository.save(digitalBankAccount);

 return "LINKED_SUCCESSFULLY";

 }

 @Override

 public Double checkBalance(Long mobileNumber, Long accountNo) throws InfyMeMobileException {

 Double balance = null ;

 List<DigitalBankAccount> list = digitalBankAccountRepository.findByMobileNumber(mobileNumber);

 if(list.isEmpty()) {

 throw new InfyMeMobileException("Service.NO_ACCOUNT_IS_LINKED");

 }

 for (DigitalBankAccount digitalBankAccount : list) {

 if(digitalBankAccount.getAccountNumber().getAccountNumber().equals(accountNo)) {

 balance = digitalBankAccount.getAccountNumber().getBalance();

 }

 }

 if(balance == null ) {

 throw new InfyMeMobileException("Service.ACCOUNT_NUMBER_NOTFOUND");

 }

 return balance;

 }

 @Override

 public String fundTransfer(TransactionDTO transactionDTO) throws InfyMeMobileException {

 Optional<BankAccount> optional = accountRepository.findByAccountNumber(transactionDTO.getSenderAccountNumber());

 BankAccount senderBankAccount= optional.orElseThrow(()-> new InfyMeMobileException("Service.SENDER_DOESNOT_EXIST"));

 if(senderBankAccount.getBalance()<transactionDTO.getAmount()) {

 throw new InfyMeMobileException("Service.INSUFFICIENT_FUNDS");

 }

 Optional<BankAccount> optional1= accountRepository.findById(transactionDTO.getReceiverAccountNumber());

 BankAccount receiverBankAccount = optional1.orElseThrow(()-> new InfyMeMobileException("Service.RECEIVER_DOESNOT_EXIST"));

 if(senderBankAccount.getUser().getMobileNumber().equals(transactionDTO.getPaidFrom())) {

 if(receiverBankAccount.getUser().getMobileNumber().equals(transactionDTO.getPaidTo())) {

 senderBankAccount.setBalance(senderBankAccount.getBalance() - transactionDTO.getAmount());

 receiverBankAccount.setBalance(receiverBankAccount.getBalance() + transactionDTO.getAmount());

 Transaction transaction = new Transaction();

 transaction.setAmount(transactionDTO.getAmount());

 transaction.setModeOfTransaction(transactionDTO.getModeOfTransaction());

 transaction.setPaidFrom(transactionDTO.getPaidFrom());

 transaction.setPaidTo(transactionDTO.getPaidTo());

 transaction.setReceiverAccountNumber(transactionDTO.getReceiverAccountNumber());

 transaction.setRemarks(transactionDTO.getRemarks());

 transaction.setSenderAccountNumber(transactionDTO.getSenderAccountNumber());

 transaction.setTransactionDateTime(transactionDTO.getTransactionDateTime());

 transactionRepository.save(transaction);

 }

 else {

 throw new InfyMeMobileException("Service.PAIDTONUMBER_NOTFOUND");

 }

 }

 else {

 throw new InfyMeMobileException("Service.PAIDFROMNUMBER_NOTFOUND");

 }

 return "Service.TRANSACTION_SUCCESSFULL";

 }

 @Override

 public List<TransactionDTO> accountStatement(Long mobileNumber) throws InfyMeMobileException {

 List<Transaction> list = (List<Transaction>) transactionRepository.findAll();

 List<TransactionDTO> transactionDTOs = new ArrayList<>();

 for (Transaction transaction : list) {

 if(transaction.getPaidFrom().equals(mobileNumber)) {

 TransactionDTO transactionDTO = new TransactionDTO();

 transactionDTO.setAmount(transaction.getAmount());

 transactionDTO.setModeOfTransaction(transaction.getModeOfTransaction());

 transactionDTO.setPaidFrom(transaction.getPaidFrom());

 transactionDTO.setPaidTo(transaction.getPaidTo());

 transactionDTO.setReceiverAccountNumber(transaction.getReceiverAccountNumber());

 transactionDTO.setRemarks(transaction.getRemarks());

 transactionDTO.setSenderAccountNumber(transaction.getSenderAccountNumber());

 transactionDTO.setTransactionDateTime(transaction.getTransactionDateTime());

 transactionDTO.setTransactionId(transaction.getTransactionId());

 transactionDTOs.add(transactionDTO);

 }

 }

  if(transactionDTOs.isEmpty()) {

  throw new InfyMeMobileException("Service.NO_ACTIVE_TRANSACTIONS");

 }

  return transactionDTOs;

 }

}