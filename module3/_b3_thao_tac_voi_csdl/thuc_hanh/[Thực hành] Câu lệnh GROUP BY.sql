select status from orders group by status;
select status, count(status) as 'So luong status' from orders group by status;
select status, sum(quantityOrdered * priceEach) as 'mount' from orders inner join orderdetails on orders.orderNumber = orderdetails.orderNumber group by status;