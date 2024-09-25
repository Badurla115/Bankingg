package com.infy.repository;

import java.util.List;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;

import org.springframework.data.repository.CrudRepository;

import com.infy.entity.DigitalBankAccount;

public interface DigitalBankAccountRepository extends CrudRepository<DigitalBankAccount, String>{

 @Query("select d from DigitalBankAccount d where d.accountNumber.accountNumber = :accountNumber")

 Optional<DigitalBankAccount> findByBankAccount(Long accountNumber);

 @Query("select d from DigitalBankAccount d where d.user.mobileNumber = :mobileNumber")

 List<DigitalBankAccount> findByMobileNumber(Long mobileNumber);

}