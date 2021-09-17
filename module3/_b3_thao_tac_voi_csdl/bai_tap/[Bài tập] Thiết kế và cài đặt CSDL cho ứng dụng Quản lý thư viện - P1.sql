create database ql_thuvien;
use ql_thuvien;
create table student (
	student_number varchar(15),
    borrowOrder_id int,
    student_name varchar(50),
    address varchar(500),
    email varchar(50),
    image binary,
    primary key(student_number),
    foreign key(borrowOrder_id) references borrowOrder (borrowOrder_id)
);
create table book (
	book_number varchar(15),
    category_id varchar(15),
    borrowOrder_id int,
    `name` varchar(15),
    `desc` varchar(30),
    primary key(book_number),
    foreign key (category_id) references category(category_id),
    foreign key (borrowOrder_id) references borrowOrder(borrowOrder_id)
);
create table category(
	category_id varchar(15),
	`name` varchar(10),
    `desc` varchar(15),
    primary key(category_id)
);
create table borrowOrder (
	borrowOrder_id int,
    dateStart date,
    dateEnd date,
    primary key(borrowOrder_id)
);
insert into category values (1, 'Hài Hước', 'sdss');
insert into category values(2,'Kinh dị','ỵytjy');