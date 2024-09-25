drop database if exists infyMeMobile_db;

create database infyMeMobile_db;

use infyMeMobile_db;

CREATE TABLE user (

 mobile_number BIGINT PRIMARY KEY,

 user_id varchar(30) NOT NULL,

 account_holder_name VARCHAR(100) NOT NULL,

 gender VARCHAR(30) NOT NULL,

 date_of_birth DATE NOT NULL,

 password VARCHAR(30) NOT NULL,

 email VARCHAR(30) NOT NULL,

 communication_address VARCHAR(200) NOT NULL,

 PAN VARCHAR(100) NOT NULL

);

CREATE TABLE bank_account (

 account_number BIGINT PRIMARY KEY auto_increment,

 bank_name varchar(40) NOT NULL,

 balance int NOT NULL,

 account_type VARCHAR(30) NOT NULL,

 ifsc_code VARCHAR(100) NOT NULL,

 opening_date DATE NOT NULL,

 mobile_number BIGINT NOT NULL,

 CONSTRAINT fk_user_abc FOREIGN KEY (mobile_number) REFERENCES user(mobile_number)

);

CREATE TABLE digital_bank_account (

 digital_banking_id VARCHAR(50) PRIMARY KEY,

 mobile_number BIGINT NOT NULL,

 account_number BIGINT NOT NULL,

 account_type VARCHAR(30) NOT NULL,

 CONSTRAINT fk_user_1 FOREIGN KEY (mobile_number) REFERENCES user(mobile_number),

 CONSTRAINT fk_bank_account_2 FOREIGN KEY (account_number) REFERENCES bank_account(account_number)

);

CREATE TABLE transaction (

 transaction_id INT(30) PRIMARY KEY auto_increment,

 mode_of_transaction varchar(50) NOT NULL,

 paid_to BIGINT NOT NULL,

 receiver_account_number BIGINT NOT NULL,

 amount int NOT NULL,

 transaction_date_time DATETIME NOT NULL,

 remarks VARCHAR(30) NOT NULL,

 paid_from BIGINT NOT NULL,

 sender_account_number BIGINT NOT NULL

);

insert into user(mobile_number, user_id,account_holder_name,gender,date_of_birth,password,email,communication_address,PAN) values (1234567890,"U1001", "Jonny","Male", '2020-05-22', "ABCD", "jonny@mail.com", "376/33 Vijay Nagar", "DQLKJM123456");

insert into bank_account(account_number,bank_name, balance, account_type, ifsc_code, opening_date, mobile_number) values (111111,"ICICI", 120000, "Savings" , "ICICI12341231", '2022-07-30', 1234567890);

insert into bank_account(account_number,bank_name, balance, account_type, ifsc_code, opening_date, mobile_number) values (111112,"AXIS", 190000, "Salary" , "AXIS12341231", '2020-07-30', 1234567890);

insert into digital_bank_account(digital_banking_id,mobile_number,account_number,account_type) values ("DBA-1", 1234567890, 111111, "Savings");

insert into transaction(transaction_id,mode_of_transaction,paid_to,receiver_account_number,amount,transaction_date_time,remarks,paid_from,sender_account_number) values (1001, "Fund Transfer", 70221251234, 55810643722, 12890, '2022-05-25 19:30:00',"Payment for Grocries",1234567890, 55810643722);

select * from user;

select * from bank_account;

select * from digital_bank_account;

select * from transaction;



