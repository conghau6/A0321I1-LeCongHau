create database th_demo;
use th_demo;
create table users(
	id int(11) not null auto_increment,
    name varchar(50) not null,
    email varchar(50) not null,
    country varchar(50),
    primary key(id)
);

create table permision(
	id int(11) not null auto_increment,
    name varchar(50),
    primary key(id)
);

create table user_permision(
	user_id int(11),
	permision_id int(11),
    foreign key (user_id) references users(id) on update cascade on delete cascade,
    foreign key(permision_id) references permision(id) on update cascade on delete cascade
);
insert into users(name,email,country) values('Minh','minh@codegym.vn','Viet Nam');
insert into users(name, email, country) values('Kante','kante@che.uk','Kenia');
insert into permision(name) values('add');
insert into permision(name) values('edit');
insert into permision(name) values('delete');
insert into permision(name) values('view');

delimiter $$
create procedure get_user_by_id(in user_id int)
begin
	select users.name, users.email, users.country from users
    where users.id = user_id;
end $$
delimiter $$

delimiter $$
create procedure insert_user(
in user_name varchar(50),
in user_email varchar(50),
in user_country varchar(50)
)
begin
	insert into users(name,email,country) values (user_name,user_email,user_country);
end $$
delimiter $$

-- Gọi Stored Procedures từ JDBC sử dụng CallableStatement cho chức năng hiển thị danh sách users
-- Gọi Stored Procedures từ JDBC sử dụng CallableStatement cho chức năng sửa thông tin user
-- Gọi Stored Procedures từ JDBC sử dụng CallableStatement cho chức năng xoá user

delimiter $$
create procedure find_all_users()
begin
select * from users;
end $$ 
delimiter $$

delimiter $$
create procedure update_user(in id int(11), in name varchar(50), in email varchar(50), in country varchar(50))
begin
update users set users.name = name, users.email = email, users.country = country
where users.id = id;
end $$
delimiter $$

delimiter $$
create procedure delete_user(in id int(11))
begin
delete from users where users.id = id;
end $$
delimiter $$customerscustomers