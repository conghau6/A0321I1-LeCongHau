delimiter //
create procedure findAllCustomer()
begin
select * from customers where customerNumber = 175;
end //
delimiter ;

call findAllCustomer();

drop procedure findAllCustomer;