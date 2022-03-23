INSERT INTO `account`(`account_id`,`encrypt_pw`,`token`,`user_name`,`is_enable`,`verification_code`,`email`) VALUES 
(1,'$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu',NULL,'admin',_binary '',NULL,'khoa4755@gmail.com'),
(10,'$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu',NULL,'minhkhoa',_binary '','','khoa4755@gmail.com'),
(11,'$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu',NULL,'trankhoa',_binary '','','trankhoadev06@gmail.com'),
(12,'$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu',NULL,'user',_binary '',NULL,'trankhoadev06@gmail.com');

INSERT INTO `role`(`role_id`,`name`) VALUES 
(1,'ROLE_USER'),
(2,'ROLE_ADMIN');

INSERT INTO `account_role`(`account_role_id`,`account_id`,`role_id`) VALUES
(1,1,2),
(10,10,2),
(11,11,2),
(12,12,1);

INSERT INTO position
VALUES ("1", "Hành Chính"),
("2", "Sale - Marketing"),
("3", "Quản Lý"),
("4", "Giám đốc") ;

INSERT INTO building 
VALUES ('1', 'Lotte', '854363854', '0368596545', 'sd324s', 'lotte@gmail.com', 'Đà Nẵng');

INSERT INTO floor
VALUES ('1','50' ,'40',b'1', 'KFC', 'Vip','ok',  '1'),
('2','30', '20',b'1', 'Jollibee', 'Normal','ok',  '1'),
('3', '80' ,'70', b'1', 'Texas','Vip', 'ok',  '1');

INSERT INTO ground
VALUES ('4', '2222', b'1', 'Normal','https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.agiusa.com%2Fhow-to-test-for-land-subsidence-before-breaking-ground&psig=AOvVaw1Y54PIx8yoUsaxPjao-7IG&ust=1647396516755000&source=images&cd=vfe&ved=0CAsQjRxqFwoTCKCUqbqEx_YCFQAAAAAdAAAAABAU', '1111', 'note', '1111', 'stutas', '1', '1'),
       ('1', '100', b'1', 'Normal', 'https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.agiusa.com%2Fhow-to-test-for-land-subsidence-before-breaking-ground&psig=AOvVaw1Y54PIx8yoUsaxPjao-7IG&ust=1647396516755000&source=images&cd=vfe&ved=0CAsQjRxqFwoTCKCUqbqEx_YCFQAAAAAdAAAAABAU', '1000','note', '1000','stutas', '1', '1'),
       ('2', '200', b'1', 'Vip','https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.agiusa.com%2Fhow-to-test-for-land-subsidence-before-breaking-ground&psig=AOvVaw1Y54PIx8yoUsaxPjao-7IG&ust=1647396516755000&source=images&cd=vfe&ved=0CAsQjRxqFwoTCKCUqbqEx_YCFQAAAAAdAAAAABAU', '2222','note','2222', 'stutas','1', '2'),
	   ('3', '200', b'1', 'Vip', 'https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.agiusa.com%2Fhow-to-test-for-land-subsidence-before-breaking-ground&psig=AOvVaw1Y54PIx8yoUsaxPjao-7IG&ust=1647396516755000&source=images&cd=vfe&ved=0CAsQjRxqFwoTCKCUqbqEx_YCFQAAAAAdAAAAABAU', '3333','note', '3333','stutas','1', '3');


INSERT INTO employee
VALUES 
("E001",b'1',"Quảng Nam","2000-05-06", b'1',"nthaihoc@gmail.com", "236568986","Nguyễn Thái Học", "0365635686", "1500",'1','2'),
("E006",b'1',"Quảng Bình","2001-09-10", b'0',"tbingan@gmail.com", "232348986","Trần Bỉ Ngạn","0365456686", "2000",  '10','4'),
('E007',b'1', 'Hà Nội','1993-05-06', b'1','nquochoi@gmail.com', '203656865',  'Nguyễn Quốc Hội', '0368546464', '1000', '12', '1');

INSERT INTO customer
VALUES ("C001", "Quảng Nam", "2000-05-06", "Codegym", "nthaihoc@gmail.com", "236568986", "Nguyễn Thái Học","0365635686", 1, "Đang thuê"),
("C002", "Đà Nẵng", "1995-04-02", "VinGroup", "chaly@gmail.com", "232348986", "Cao Hạ Ly","0365456686", 0, "Đang thuê"),
("C003", "Quảng Trị", "1999-07-19", "SunGroup", "vtiendung@gmail.com", "203656354", "Võ Tiến Dũng","0365987564", 1, "Đang thuê"),
("C004", "Huế", "1992-12-08", "FPT", "dthetoan@gmail.com", "232348986", "Đinh Thế Toàn","0365456686", 0, "Đang thuê"),
("C005", "Quy Nhơn", "2004-02-02", "Lotte", "nxuanmanh@gmail.com", "232348986", "Ngô Xuân Mạnh","0365456686", 0, "Đang thuê"),
("C006", "Quảng Bình", "2001-09-10", "KFC", "tbingan@gmail.com", "232348986", "Trần Bỉ Ngạn","0365456686", 0, "Đang thuê")
;

INSERT INTO contract 
VALUES ('CT001',  'Hợp đồng', '2022-03-02', b'1', '2022-03-30', '1000', '2022-03-03','1200',  'C001', 'E001','1'),
	   ('CT002','Hợp đồng', '2022-06-02',  b'1',   '2022-07-30','1000', '2022-06-03', '1200', 'C002', 'E006', '2'),
	   ('CT003', 'Hợp đồng', '2022-09-30',  b'1',  '2022-12-01', '1000',  '2022-10-01', '1200',  'C003', 'E007','3'),
	   ('CT004', 'Hợp đồng',  '2022-11-30',  b'1',  '2023-12-01', '1000', '2022-12-01', '1200',  'C004', 'E006','2'),
	   ('CT005', 'Hợp đồng', '2022-05-04', b'1',  '2022-06-05',  '1000', '2022-05-05', '1200',   'C005', 'E007','3');