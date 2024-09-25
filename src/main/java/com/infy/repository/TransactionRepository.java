package com.infy.repository;

import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

import com.infy.entity.Transaction;

@Repository

public interface TransactionRepository extends CrudRepository<Transaction, Integer> {

}