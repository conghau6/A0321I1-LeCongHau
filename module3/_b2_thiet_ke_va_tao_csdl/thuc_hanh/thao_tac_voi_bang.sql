create database b2_th_thao_tao_voi_bang;
use b2_th_thao_tao_voi_bang;
create table contacts (
	contact_id int(11) not null auto_increment,
    last_name varchar(30) not null,
    first_name varchar(25),
    birthday date,
    constraint contact_pks primary key (contact_id)
);
drop table contacts; 

create table suppliers (
	supplier_id int(11) not null auto_increment,
    supplier_name varchar(50) not null,
    account_rep varchar(30) not null default 'TTB',
    constraint suppliers_pk primary key (supplier_id)
);

alter table contacts drop column last_name; -- Xoá cột last name --
alter table contacts add last_name varchar(40) not null after contact_id; -- Thêm lại cột lastname --
alter table contacts change column last_name last1_name varchar(25) not null; 
alter table contacts change column last_name1 last_name varchar(25) not null; -- Đổi tên cột last_name1 thành last_name

alter table contacts rename to contacts1;
alter table contacts1 rename to contact; -- đỏi tên table contacts1 thành contacts
select * from contacts;