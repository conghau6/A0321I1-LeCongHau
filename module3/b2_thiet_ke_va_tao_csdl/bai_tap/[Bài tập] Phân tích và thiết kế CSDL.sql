create database ql_oto;
use ql_oto;
create table productlines (
	productLine varchar(50) not null,
    textDescription text not null,
    image text not null,
    primary key(productLine)
);
create table offices (
	officeCode varchar(10) not null,
    city varchar(50) not null,
    phone varchar(50) not null,
    addressLine1 varchar(50) not null,
    addressLine2 varchar(50),
    state varchar(50),
    country varchar(50) not null,
    postalCode varchar(15) not null,
    primary key(officeCode)
);
create table employees (
	employeeNumber int not null,
    officeCode varchar(10),
    lastName varchar(50) not null,
    firstName varchar(50) not null,
    email varchar(100) not null,
    jobTitle varchar(50) not null,
    reportTo int,
    primary key(employeeNumber),
    foreign key(officeCode) references offices(officeCode),
    foreign key(reportTo) references employees(employeeNumber)
);
create table customers (
	customerNumber int not null,
    salesRepEmployeeNumber int,
    customerName varchar(50) not null,
    contactLastName varchar(50) not null,
    contactFirstName varchar(50) not null,
    phone varchar(50) not null,
    addressLine1 varchar(50) not null,
    addressLine2 varchar(50),
    city varchar(50) not null,
    state varchar(50) not null,
    postalCode varchar(15) not null,
    country varchar(50) not null,
    creditLimit float(2),
    primary key(customerNumber),
    foreign key(salesRepEmployeeNumber) references employees(employeeNumber)
);
create table orders(
	orderNumber int not null,
    customerNumber int,
    orderDate date not null,
    requiredDate date not null,
    shippedDate date,
    status varchar(15) not null,
    comments text,
    quantityOrdered int not null,
    priceEach float(2) not null,
	primary key (orderNumber),
    foreign key(customerNumber) references customers (customerNumber)
);
create table payments (
	customerNumber int,
    checkNumber varchar(50) not null,
    paymentDate date not null,
    amount float(2) not null,
    primary key(checkNumber),
    foreign key (customerNumber) references customers(customerNumber)
);
create table products (
	productCode varchar(15) not null,
    productLine varchar(50),
    productName varchar(70) not null,
    productScale varchar(10) not null,
    productVendor varchar(50) not null,
    productDescription text not null,
    quantityInStock int not null,
    buyPrice float(2) not null,
    MSRP float(2) not null,
    primary key(productCode),
    foreign key(productLine) references productlines(productLine)
);
create table orderDetails (
	orderNumber int,
    productCode varchar(15),
    primary key(ordernumber, productcode),
    foreign key(ordernumber) references orders(ordernumber),
    foreign key(productCode) references products(productCode)
); 