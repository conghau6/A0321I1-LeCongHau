-- Tham số loại in
delimiter //
create procedure getCusById (in cusNum int(11))
begin
select * from customers where customerNumber = cusNum;
end //
delimiter ;
call getCusById(175);
drop procedure getCusById;

-- Tham số loại out
delimiter //
create procedure GetCustomerCountByCity (in in_city varchar(50), out total int)
begin
select count(customerNumber) into total from customers where city = in_city;
end //
delimiter ;
call GetCustomerCountByCity ('Lyon',@total);
select @total;
drop procedure GetCustomerCountByCity;

-- Tham số loại inout
delimiter //
create procedure selectCounter(inout counter int, in inc int)
begin
set counter = counter + inc;
end //
delimiter ;
set @counter = 1;
call selectCounter(@counter,2);
select @counter;
drop procedure selectCounter;