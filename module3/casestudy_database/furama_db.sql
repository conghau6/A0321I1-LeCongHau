create database furama_db;
use furama_db;

create table `position`(
	position_id int,
    position_name varchar(45),
    primary key(position_id)
);

create table education_degree(
	education_degree_id int,
    education_degree_name varchar(45),
    primary key(education_degree_id)
);

create table division(
	division_id int,
    division_name varchar(45),
    primary key(division_id)
);

create table customer_type(
	customer_type_id int,
    customer_type_name varchar(45),
    primary key(customer_type_id)
);

create table service_type(
	service_type_id int,
    service_type_name varchar(45),
    primary key(service_type_id)
);

create table rent_type(
	rent_type_id int,
    rent_type_name varchar(45),
    rent_type_cost double,
    primary key(rent_type_id)
);

create table attach_service(
	attach_service_id int,
    attach_service_name varchar(45),
    attach_service_cost double,
    attach_service_unit int,
    attach_service_status varchar(45),
    primary key(attach_service_id)
);

create table `role`(
	role_id int,
    role_name varchar(255),
    primary key(role_id)
);

create table `user`(
	username varchar(255),
    `password` varchar(255),
    primary key(username)
);

create table user_role(
	role_id int,
    username varchar(255),
    foreign key(role_id) references `role`(role_id) on update cascade on delete cascade,
    foreign key(username) references `user`(username) on update cascade on delete cascade
);

create table service(
	service_id int,
    service_name varchar(45),
    service_area int,
    service_cost double,
    service_max_people int,
    rent_type_id int,
    service_type_id int,
    standard_room varchar(45),
    description_other_convenience varchar(45),
    pool_area double,
    number_of_floors int,
    primary key(service_id),
    foreign key(rent_type_id) references rent_type(rent_type_id) on update cascade on delete cascade,
    foreign key(service_type_id) references service_type(service_type_id) on update cascade on delete cascade
);

create table employee(
	employee_id int,
    employee_name varchar(45),
    employee_birthday date,
    employee_id_card varchar(45) unique,
    employee_salary double,
    employee_phone varchar(45) unique,
    employee_email varchar(45) unique,
    employee_address varchar(45),
    position_id int,
    education_degree_id int,
    division_id int,
    username varchar(45) unique,
    primary key(employee_id),
    foreign key(position_id) references `position`(position_id) on update cascade on delete cascade,
    foreign key(education_degree_id) references education_degree(education_degree_id) on update cascade on delete cascade,
    foreign key(division_id) references division(division_id) on update cascade on delete cascade,
    foreign key(username) references `user`(username) on update cascade on delete cascade
);

create table customer(
	customer_id int,
    customer_type_id int,
    customer_name varchar(45),
    customer_birthday date,
    customer_gender bit(1),
    customer_id_card varchar(45) unique,
    customer_phone varchar(45) unique,
    customer_email varchar(45) unique,
    customer_address varchar(45),
    primary key(customer_id),
    foreign key(customer_type_id) references customer_type(customer_type_id) on update cascade on delete cascade
);

create table contract(
	contract_id int,
    contract_start_date datetime,
    contract_end_date datetime,
    contract_deposit double,
    contract_total_money double,
    employee_id int,
    customer_id int,
    service_id int,
    primary key(contract_id),
    foreign key(employee_id) references employee(employee_id) on update cascade on delete cascade,
    foreign key(customer_id) references customer(customer_id) on update cascade on delete cascade,
    foreign key(service_id) references service(service_id)on update cascade on delete cascade
);

create table contract_detail(
	contract_detail_id int,
    contract_id int,
    attach_service_id int,
    quantity int,
    primary key(contract_detail_id),
    foreign key(contract_id) references contract(contract_id) on update cascade on delete cascade,
    foreign key(attach_service_id) references attach_service(attach_service_id) on update cascade on delete cascade
);

delimiter $$
create procedure select_all_customer()
begin
	select customer.customer_id, customer_type.customer_type_name, customer.customer_name,customer.customer_birthday,
    customer.customer_gender, customer.customer_id_card, customer.customer_phone, customer.customer_email,
    customer.customer_email, customer.customer_address
    from customer inner join customer_type
    on customer.customer_type_id = customer_type.customer_type_id;
end $$
delimiter $$

insert into `position` values 
(1, "Lế tân"),
(2, "Phục vụ"),
(3, "Chuyên viên"),
(4, "Giám sát"),
(5, "Quản lý"),
(6,"Giám đốc");
insert into education_degree values
(1,"Trung cấp"),
(2,"Cao đẳng"),
(3,"Đại học"),
(4,"Sau đại học");
insert into division values
(1,"Sale – Marketing"),
(2,"Hành chính"),
(3,"Phục vụ"),
(4,"Quản lý");
insert into `role` values
(1, "Lế tân"),
(2, "Phục vụ"),
(3, "Chuyên viên"),
(4, "Giám đốc"),
(5, "Quản lý");
insert into `user` values
("van.anh", "vananh123"),
("nguyen.manh","nguyenmanh123"),
("anh.thu","anhthu123"),
("quang.huy","quanghuy123"),
("son.tung","sontung123"),
("nhat.nam","nhatnam123"),
("thanh.thuy","thanhthuy123"),
("duy.manh","duymanh123"),
("thanh.long","thanhlong123"),
("thanh.thao","thanhthao123"),
("duc.huy","duchuy123"),
("ngoc.huyen","ngochuyen123"),
("kha.banh","khabanh123"),
("van.duc","vanduc123"),
("huy.hoang","huyhoang123"),
("thanh.quoc","thanhquoc123");
insert into user_role values
(4,"anh.thu"),
(5,"thanh.long");
insert into employee values
(1,"Vân Anh","1998-12-2","208444756","3000000","097787656","van.anh@furama.com","Hà Nội",1,4,2,"van.anh"),
(2,"Nguyên Mạnh","1993-1-2","205555756","9000000","076888656","nguyen.manh@furama.com","Hà Nội",1,4,2,"nguyen.manh"),
(3,"Anh Thư","1995-12-2","209444756","7000000","097633656","anh.thu@furama.com","Đà Nẵng",6,4,1,"anh.thu"),
(4,"Quang Huy","1983-10-3","205599756","19000000","097678656","quang.huy@furama.com","Đà Nẵng",1,2,2,"quang.huy"),
(5,"Sơn Tùng","1993-1-4","205599996","11000000","097611656","son.tung@furama.com","Cần Thơ",3,3,2,"son.tung"),
(6,"Nhất Nam","1999-1-2","208888756","8000000","097611116","nhat.nam@furama.com","TP Hồ Chí Minh",4,4,2,"nhat.nam"),
(7,"Thanh Thuỷ","1993-1-20","205512126","14000000","091518656","thanh.thuy@furama.com","TP Hồ Chí Minh",1,4,2,"thanh.thuy"),
(8,"Duy Mạnh","1991-1-2","205555050","29000000","097645556","duy.manh@furama.com","Hà Nội",2,4,2,"duy.manh"),
(9,"Thành Long","1993-1-2","205554756","9000000","097613656","thanh.long@furama.com","Hà Nội",6,4,4,"thanh.long"),
(10,"Thanh Thảo","1993-1-20","205454756","9000000","096788656","thanh.thao@furama.com","Quảng Nam",2,4,2,"thanh.thao"),
(11,"Đức Huy","1993-12-2","205554746","9000000","097689995","duc.huy@furama.com","Quảng Nam",2,4,2,"duc.huy"),
(12,"Ngọc Huyền","1999-1-2","204666756","9000000","097070865","ngochuyen@furama.com","Quảng Nam",2,4,2,"ngoc.huyen"),
(13,"Khá Bảnh","1993-1-2","207774756","9000000","097888110","kha.banh@furama.com","Quảng Nam",2,4,2,"kha.banh"),
(14,"Văn Đức","1983-1-2","207750506","9000000","097900110","van.duc@furama.com","Quảng Nam",2,4,2,"van.duc"),
(15,"Huy Hoàng","1973-1-2","207454506","9000000","097907979","huy.hoang@furama.com","Quảng Nam",2,4,2,"huy.hoang"),
(16,"Thanh Quốc","1989-1-2","207722296","9000000","097988710","thanh.quoc@furama.com","Quảng Nam",2,4,2,"thanh.quoc");
insert into customer_type values
(1,"Diamond"),
(2,"Platinum"),
(3,"Gold"),
(4,"Silver"),
(5,"Member");
insert into customer values
(1,2,"Lê Công Hậu","2001-10-31",1,"206777999","098488847","hau@gmail.com","Quảng Nam"),
(2,1,"Võ Anh Thư","1999-7-1",0,"207777888","095564746","thu@gmail.com","Đà Nẵng"),
(3,3,"Nguyễn Văn Thành","1998-8-2",1,"209454667","0877665667","thanh@gmail.com","hà Nội"),
(4,5,"Lê Thị Vân","1882-4-4",0,"205666777","095577865","van@gmail.com","Huế"),
(5,4,"Đỗ Ngọc Anh","1992-8-1",0,"205666555","095889865","anh@gmail.com","Vinh"),
(6,4,"Trần Văn Sơn","1998-2-2",1,"205555777","090007865","son@gmail.com","Nghệ An"),
(7,5,"Lê Thanh Hùng","1998-5-2",0,"207776777","088777865","hung@gmail.com","Đà Nẵng"),
(8,5,"Bùi Quốc Huy","2001-3-4",1,"205999777","09557665","huy@gmail.com","Quảng Nam"),
(9,3,"Trần Thị Bích Hà","1998-3-5",0,"207986777","095443865","ha@gmail.com","Quảng Nam"),
(10,3,"Châu Thị Huyền","1998-2-5",0,"205888777","095555665","huyen@gmail.com","Hà Tỉnh"),
(11,3,"Đoàn Thị Linh","1995-4-3",0,"205655577","095574465","linh@gmail.com","Quảng Ngãi"),
(12,4,"Lê Thanh Trang","1995-7-1",0,"205585777","095577765","trang@gmail.com","Quảng Bình"),
(13,5,"Nguyễn Ngọc","1994-3-3",0,"205666668","095578885","ngoc@gmail.com","Quảng Trị"),
(14,5,"Hồ Thanh Hà","1992-5-6",0,"205668857","095574445","ha1@gmail.com","Cần Thơ"),
(15,5,"Lê Công Vinh","1993-5-7",1,"205633577","095522265","vinh@gmail.com","Nghệ An");
insert into rent_type values
(1,"Theo Giờ",100000),
(2,"Theo Ngày",700000),
(3,"Theo Tháng",15000000),
(4,"Theo Năm",98000000);
insert into service_type values
(1,"Villa"),
(2,"Room"),
(3,"House");
insert into service values
(1,"Villa 1",100,1000,5,3,1,"VIP I","none",200,10),
(2,"Villa 2",100,1000,7,4,1,"VIP III","none",200,10),
(3,"House 1",100,1000,5,2,3,"VIP II","none",200,10),
(4,"House 2",100,1000,5,2,3,"VIP I","none",200,10),
(5,"Room 1",100,1000,5,1,2,"VIP III","none",200,10),
(6,"Room 2",100,1000,5,3,2,"VIP I","none",200,10),
(7,"Room 3",100,1000,5,2,2,"VIP I","none",200,10);
insert into contract values
(1,"2018-2-4","2018-2-5",1400000,"2000000",4,3,5),
(2,"2018-3-4","2019-3-4",12000000,"30000000",3,4,2),
(3,"2018-2-10","2018-3-10",1400000,"1400000",5,5,6),
(4,"2018-2-9","2018-3-9",1400000,"4500000",4,9,1),
(5,"2018-9-21","2018-10-21",1500000,"3400000",10,11,2),
(6,"2018-4-22","2018-5-22",1200000,"22000000",11,14,2),
(7,"2018-2-5","2019-2-5",14400000,"5300000",4,1,1),
(8,"2018-2-22","2018-2-23",174000,"2000000",2,3,4),
(9,"2018-8-10","2018-9-10",140000,"2000000",6,3,7),
(10,"2018-12-3","2019-12-3",1200000,"12000000",3,7,5),
(11,"2018-1-31","2018-2-1",1600000,"62000000",7,7,6),
(12,"2018-6-30","2019-6-30",1400000,"32000000",5,5,3);

