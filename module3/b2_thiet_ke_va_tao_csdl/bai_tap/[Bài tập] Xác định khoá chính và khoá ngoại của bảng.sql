create database the_bank;
use the_bank;
create table customers (
	customer_number varchar(5),
    full_name varchar(20),
    address varchar(30),
    email varchar(15) unique,
    phone varchar(10) unique,
    primary key (customer_number)
);
create table accounts (
	account_number varchar(10),
    customer_number varchar(5),
    account_type varchar(10),
	date date,
    balance int,
    primary key (account_number),
    foreign key (customer_number) references customers (customer_number)
);
create table transactions (
	tran_number varchar(10),
    account_number varchar(10),
    customer_number varchar(5),
    date date,
    amount int,
    description varchar(20),
    primary key (tran_number),
    foreign key (customer_number) references accounts (customer_number)
);