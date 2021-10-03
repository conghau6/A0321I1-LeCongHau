create database ql_oto;
use ql_oto;
create table product_lines (
	product_line varchar(50) not null,
    text_description text not null,
    image text not null,
    primary key(product_line)
);
create table offices (
	office_code varchar(10) not null,
    city varchar(50) not null,
    phone varchar(50) not null,
    address_line1 varchar(50) not null,
    address_line2 varchar(50),
    state varchar(50),
    country varchar(50) not null,
    postal_code varchar(15) not null,
    primary key(office_code)
);
create table employees (
	employee_number int not null,
    office_code varchar(10),
    last_name varchar(50) not null,
    first_name varchar(50) not null,
    email varchar(100) not null,
    job_title varchar(50) not null,
    report_to int,
    primary key(employee_number),
    foreign key(office_code) references offices(office_code),
    foreign key(report_to) references employees(employee_number)
);
create table customers (
	customer_number int not null,
    salesRepemployee_number int,
    customerName varchar(50) not null,
    contact_last_name varchar(50) not null,
    contact_first_name varchar(50) not null,
    phone varchar(50) not null,
    address_line1 varchar(50) not null,
    address_line2 varchar(50),
    city varchar(50) not null,
    state varchar(50) not null,
    postal_code varchar(15) not null,
    country varchar(50) not null,
    credit_limit float(2),
    primary key(customer_number),
    foreign key(salesRepemployee_number) references employees(employee_number)
);
create table orders(
	order_number int not null,
    customer_number int,
    order_date date not null,
    required_date date not null,
    shipped_date date,
    status varchar(15) not null,
    comments text,
    quantity_ordered int not null,
    price_each float(2) not null,
	primary key (order_number),
    foreign key(customer_number) references customers (customer_number)
);
create table payments (
	customer_number int,
    check_number varchar(50) not null,
    payment_date date not null,
    amount float(2) not null,
    primary key(check_number),
    foreign key (customer_number) references customers(customer_number)
);
create table products (
	product_code varchar(15) not null,
    product_line varchar(50),
    product_name varchar(70) not null,
    product_scale varchar(10) not null,
    product_vendor varchar(50) not null,
    product_description text not null,
    quantityIn_stock int not null,
    buy_price float(2) not null,
    MSRP float(2) not null,
    primary key(product_code),
    foreign key(product_line) references product_lines(product_line)
);
create table orderDetails (
	order_number int,
    product_code varchar(15),
    primary key(order_number, product_code),
    foreign key(order_number) references orders(order_number),
    foreign key(product_code) references products(product_code)
); 