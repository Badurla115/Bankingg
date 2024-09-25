package com.infy.repository;

import java.util.List;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;

import org.springframework.data.repository.CrudRepository;

import org.springframework.data.repository.query.Param;

import org.springframework.stereotype.Repository;

import com.infy.dto.BankAccountDTO;

import com.infy.entity.BankAccount;

@Repository

public interface AccountRepository extends CrudRepository<BankAccount, Long>{

 BankAccount findByAccountTypeAndBankName(String accountName, String bankName);

 @Query("select b from BankAccount b where b.user.mobileNumber = :mobileNumber")

 List<BankAccount> findBankAccountsByMobileNumber(@Param("mobileNumber") Long mobileNumber);

 @Query("select b from BankAccount b where b.accountNumber = :accountNumber")

 Optional<BankAccount> findByAccountNumber(long accountNumber);

}