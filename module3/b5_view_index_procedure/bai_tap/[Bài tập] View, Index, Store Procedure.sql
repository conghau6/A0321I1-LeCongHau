create database demo;
use demo;
create table products (
id int,
product_code varchar(45),
product_name varchar(45),
product_price int,
product_amount int,
product_desc varchar(45),
product_status varchar(45),
primary key (id)
);
insert into products values
(1,'A0534','iPhone5',2000,10,'Hàng mới','fgjyfyj'),
(2,'A0Re4','iPhone6',3000,11,'Hàng cũ','fgjyyyj'),
(3,'A05f4','iPhone7',4000,12,'Hàng mới','foofyj'),
(4,'A0cy4','iPhone8',5000,13,'Hàng cũ','fgoofyj'),
(5,'B0534','iPhone9',6000,14,'Hàng mới','fqqqfyj'),
(6,'Uf534','iPhone10',7000,15,'Hàng cũ','fgpppyj'),
(7,'E0534','iPhone11',8000,167,'Hàng mới','flllfyj'),
(8,'I0534','iPhone12',9000,17,'Hàng cũ','fgfewyj');

-- Tạo chỉ mục
alter table products add unique index product_index(product_code);
explain select * from products where product_code = 'Uf534';
alter table products add index composite_index(product_name, product_price);
explain select * from products where product_name = 'iPhone12' and product_price = 9000;

-- Tạo view
create view product_views as
select product_code, product_name, product_price, product_status from products;
select * from product_views;

-- Sửa view
create or replace view product_views as
select product_code, product_name, product_price from products;

delimiter //
create procedure getInfo ()
begin
select * from products;
end //
delimiter ;
call getInfo;

-- Thêm sản phẩm
delimiter //
create procedure addProduct (in id int, in `code` varchar(45), in `name` varchar(45),in price int, in amount int, in `desc` varchar(45),in `status` varchar(45))
begin
insert into products values(id,`code`,`name`,price,amount,`desc`,`status`);
end //
delimiter ;
call addProduct(9,'Pkrte0','Iphone13',10020,20,'Hàng siêu mới','rogjreogjr');

-- Sủa sản phẩm
delimiter //
create procedure updateProduct (in idx int, in `code` varchar(45), in `name` varchar(45),in price int, in amount int, in `desc` varchar(45),in `status` varchar(45))
begin
update products set
product_code = `code`,
product_name = `name`,
product_price = price,
product_amount = amount,
product_desc = `desc`,
product_status = `status`
where idx = id;
end //
delimiter ;
drop procedure updateProduct;
call updateProduct(1,'Phtyt0','Iphone4',10020,20,'Hàng siêu mới','rogjreogjr');


-- Xoá sản phẩm
delimiter //
create procedure removeProduct(in idx int)
begin
delete from products where id = idx;
end //
delimiter ;
call removeProduct(9);