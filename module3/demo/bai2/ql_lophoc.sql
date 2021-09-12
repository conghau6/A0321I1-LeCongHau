create database ql_lophoc;
use ql_lophoc;
create table accounts(
username varchar(50),
   pasword varchar(50),
   primary key (username)
);
create table class(
id_class int auto_increment,
name_class varchar(50),
primary key(id_class)
);
create table student(
id_student int auto_increment,
name_student varchar(50),
date_of_birth date,
id_class int,
username varchar(50) unique,
primary key(id_student),
foreign key (id_class) references class(id_class),
foreign key (username) references accounts(username)
);
create table address(
id_address int auto_increment,
province varchar(50),
town varchar(50),
primary key(id_address)
);
create table teacher(
id_teacher int auto_increment,
name_teacher varchar(50),
id_address int,
primary key(id_teacher),
foreign key(id_address) references address(id_address)
);
create table teacher_class(
id_teacher int,
id_class int,
primary key(id_teacher,id_class),
foreign key(id_teacher) references teacher(id_teacher),
foreign key(id_class) references class(id_class)
-- vừa là khoá chính vừa là khoá ngoại
);