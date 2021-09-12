create database tao_khoa_chinh;
use tao_khoa_chinh;
CREATE TABLE users(
   user_id INT AUTO_INCREMENT PRIMARY KEY,
   username VARCHAR(40),
   password VARCHAR(255),
   email VARCHAR(255)
);
CREATE TABLE roles(
   role_id INT AUTO_INCREMENT,
   role_name VARCHAR(50),
   PRIMARY KEY(role_id)
);
CREATE TABLE userroles(
   user_id INT NOT NULL,
   role_id INT NOT NULL,
   primary key(user_id, role_id), -- Khoá chỉnh tô hợp
   foreign key(user_id) references users(user_id),
   foreign key(role_id) references roles(role_id)
);
drop table userroles;