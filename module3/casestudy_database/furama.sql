create database furama;
use furama;
create table ViTri(
IDViTri int,
TenViTri varchar(45),
primary key (IDViTri)
);
create table TrinhDo(
IDTrinhDo int,
TrinhDo varchar(45),
primary key(IDTrinhDo)
);
create table BoPhan(
IDBoPhan int,
TenBoPhan varchar(45),
primary key(IDBoPhan)
);
create table NhanVien(
IDNhanVien int,
HoTen varchar(45),
IDViTri int,
IDTrinhDo int,
IDBoPhan int,
NgaySinh date,
SoCMND varchar(45),
Luong varchar(45),
SDT varchar(45),
Email varchar(45),
DiaChi varchar(45),
primary key(IDNhanVien),
foreign key(IDViTri) references ViTri(IDViTri),
foreign key(IDTrinhDo) references TrinhDo(IDTrinhDo),
foreign key(IDBoPhan) references BoPhan(IDBoPhan)
);
create table DichVuDiKem(
IDDichVuDiKem int,
TenDichVuDiKem varchar(45),
Gia int,
DonVi varchar(45),
TrangThaiKhaDung varchar(45),
primary key(IDDichVuDiKem)
);
create table LoaiKhach(
IDLoaiKhach int,
TenLoaiKhach varchar(45),
primary key(IDLoaiKhach)
);
create table KhachHang(
IDKhachHang int,
IDLoaiKhach int,
HoTen varchar(45),
NgaySinh date,
SoCMND varchar(45),
SDT varchar(45),
Email varchar(45),
DiaChi varchar(45),
primary key(IDKhachHang),
foreign key(IDLoaiKhach) references LoaiKhach(IDLoaiKhach)
);
create table KieuThue(
IDKieuThue int,
TenKieuThue varchar(45),
Gia int,
primary key(IDKieuThue)
);
create table LoaiDichVu(
IDLoaiDichVu int,
TenLoaiDichVu varchar(45),
primary key(IDLoaiDichVu)
);
create table DichVu(
IDDichVu int,
TenDichVu varchar(45),
DienTich int,
SoTang int,
SoNguoiToiDa varchar(45),
ChiPhiThue varchar(45),
IDKieuThue int,
IDLoaiDichVu int,
TrangThai varchar(45),
primary key(IDDichVu),
foreign key(IDKieuThue) references KieuThue(IDKieuThue),
foreign key(IDLoaiDichVu) references LoaiDichVu(IDLoaiDichVu)
);
create table HopDong(
IDHopDong int,
IDNhanVien int,
IDKhachHang int,
IDDichVu int,
NgayLamHopDong date,
NgayKetThuc date,
TienDatCoc int,
TongTien int,
primary key(IDHopDong),
foreign key(IDNhanVien) references NhanVien(IDNhanVien),
foreign key(IDKhachHang) references KhachHang(IDKhachHang),
foreign key(IDDichVu) references DichVu(IDDichVu)
);
create table HopDongChiTiet(
IDHopDongChiTiet int,
IDHopDong int,
IDDichVuDiKem int,
SoLuong int,
primary key(IDHopDongChiTiet),
foreign key(IDDichVuDiKem) references DichVuDiKem(IDDichVuDiKem),
foreign key(IDHopDong) references HopDong(IDHopDong)
);

-- 1.	Thêm mới thông tin cho tất cả các bảng có trong CSDL để có thể thõa mãn các yêu cầu bên dưới. 
insert into ViTri values
(1, 'Lễ Tân'),
(2, 'Phục Vụ'),
(3, 'Chuyên Viên'),
(4, 'Giám Sát'),
(5, 'Quản Lý'),
(6, 'Giám Đốc');
insert into TrinhDo values
(1,'Trung Cấp'),
(2,'Cao Đẳng'),
(3,'Đại Học'),
(4,'Sau Đại Học');
insert into BoPhan values
(1,'Sale – Marketing'),
(2,'Hành Chính'),
(3,'Phục vụ'),
(4,'Quản lý');
insert into NhanVien values
(1,'Lê Công Hậu',1,3,1,'2001-10-31','024876654','1000000','088856254','hau@gmail.com','Quảng Nam'),
(2,'Hoàng Thanh Tùng',5,4,1,'1995-9-2','066647654','2000000','085766654','tung@gmail.com','Đà Nẵng'),
(3,'Lê Văn Toàn',3,4,2,'1996-2-2','004847777','3000000','085756333','toan@gmail.com','Quảng Nam'),
(4,'Nguyễn Văn Dũng',6,1,2,'1999-4-4','004833354','7000000','085333254','dung@gmail.com','Quảng Trị'),
(5,'Bùi Thị Ly',2,2,3,'2002-5-5','007777654','4000000','085758884','ly@gmail.com','Huế'),
(6,'Hồ Khánh Huyền',4,2,1,'2000-7-7','067847654','2000000','083456254','huyen@gmail.com','Hà Nội'),
(7,'Trần Thanh Nam',4,1,4,'1999-1-1','008887654','8000000','085759994','nam@gmail.com','Hải Phòng'),
(8,'Võ Thị Ánh',1,3,3,'2001-10-10','004899954','5000000','085750004','anh@gmail.com','Cần Thơ'),
(9,'K Thị Thảo',1,3,3,'1998-7-6','004222654','6000000','085711154','thao@gmail.com','Thanh Hoá');
insert into LoaiKhach values
(1,'Diamond'),
(2,'Platinium'),
(3,'Gold'),
(4,'Silver'),
(5,'Member');
insert into KieuThue values
(1,'Theo Giờ',150),
(2, 'Theo Ngày',500),
(3,'Theo Tháng',10000),
(4,'Theo Năm',90000);
insert into LoaiDichVu values
(1,'Villa'),
(2,'Room'),
(3,'House');
insert into DichVu values
(1,'Villa 1',100,3,14,200,3,1,'Khả Dụng'),
(2,'Villa 2',200,4,14,300,2,1,'Khả Dụng'),
(3,'Room 1',50,5,5,200,4,2,'Khả Dụng'),
(4,'Room 2',40,4,7,250,1,2,'Không Khả Dụng'),
(5,'Room 3',80,6,8,280,3,2,'Khả Dụng'),
(6,'House 1',40,1,3,120,2,3,'Khả Dụng'),
(7,'House 2',50,2,5,150,2,3,'Không Khả Dụng');
insert into DichVuDiKem values
(1,'massage',50,'VND','Khả dụng'),
(2,'karaoke',40,'VND','Khả dụng'),
(3,'thức ăn',60,'VND','Khả dụng'),
(4,'nước uống',10,'VND','Khả dụng'),
(5,'thuê xe di chuyển tham quan resort',150,'VND','Khả dụng');
insert into KhachHang values
(1,2,'Nguyễn Văn Mạnh','2002-10-10','565554535','088787767','manh@gmail.com','Quảng Nam'),
(2,5,'Lê Thị Vân','1999-10-10','565646665','086667767','van@gmail.com', 'Quảng Bình'),
(3,4,'Ngô Văn Cường','1990-10-10','567774535','088787888','cuong@gmail.com','Quảng Ngãi'),
(4,3,'Đỗ Văn Huy','1998-10-10','565648895','088782227','huy@gmail.com','Đà Nẵng'),
(5,2,'Trần Duy Sơn','1997-10-10','565777535','088111767','son@gmail.com','Lào Cai'),
(6,1,'Lý Thanh Long','1999-10-10','564444535','084557767','long@gmail.com','Cao Bằng'),
(7,4,'Huỳnh Thị Thu Trang','200-10-10','511144535','086667767','trang@gmail.com','Quảng Trị'),
(8,3,'Cao Văn Tú','2002-10-10','565642225','088789997','tu@gmail.com','Huế');
insert into HopDong values
(1,1,2,7,'2020-10-10','2021-3-3',500,1200),
(2,6,3,1,'2020-10-11','2021-3-4',400,1600),
(3,7,4,2,'2020-10-12','2021-3-5',500,1300),
(4,8,5,3,'2020-10-13','2021-3-6',600,1500),
(5,9,6,4,'2020-10-14','2021-3-7',800,1700),
(6,3,7,6,'2020-10-15','2021-3-8',700,2000),
(7,2,8,5,'2020-10-16','2021-3-9',400,1100),
(8,5,1,2,'2020-10-17','2021-3-10',100,1400);
insert into HopDongChiTiet values
(1,8,5,3),
(2,7,5,2),
(3,6,3,4),
(4,5,2,5),
(5,4,1,1),
(6,3,2,5),
(7,2,3,2),
(8,1,4,2);
-- 2.	Hiển thị thông tin của tất cả nhân viên có trong hệ thống có tên bắt đầu là một trong các ký tự “H”, “T” hoặc “K” và có tối đa 15 ký tự.
select NhanVien.*, ViTri.TenViTri, TrinhDo.TrinhDo, BoPhan.TenBoPhan from NhanVien
inner join ViTri on NhanVien.IDViTri = ViTri.IDViTri
inner join TrinhDo on NhanVien.IDTrinhDo = TrinhDo.IDTrinhDo
inner join BoPhan on NhanVien.IDBoPhan = BoPhan.IDBoPhan
where ((HoTen like 'H%') or (HoTen like 'K%') or (HoTen like 'T%')) and length(HoTen) <= 15;
 
-- 3.	Hiển thị thông tin của tất cả khách hàng có độ tuổi từ 18 đến 50 tuổi và có địa chỉ ở “Đà Nẵng” hoặc “Quảng Trị”.
select NhanVien.* from NhanVien where curdate()-NgaySinh>=(18*30*365) and curdate()-NgaySinh>=(50*30*365) and DiaChi in ('Đà Nẵng','Quảng Trị');

-- 4.	Đếm xem tương ứng với mỗi khách hàng đã từng đặt phòng bao nhiêu lần.
-- Kết quả hiển thị được sắp xếp tăng dần theo số lần đặt phòng của khách hàng 
-- Chỉ đếm những khách hàng nào có Tên loại khách hàng là “Diamond”.
select khachhang.HoTen, hopdongchitiet.SoLuong from khachhang
inner join loaikhach on khachhang.IDLoaiKhach = loaikhach.IDLoaiKhach
inner join hopdong on  khachhang.IDKhachHang = hopdong.IDHopDong
inner join hopdongchitiet on hopdong.IDHopDong = hopdongchitiet.IDHopDong
where loaikhach.TenLoaiKhach like 'Diamond'
order by hopdongchitiet.SoLuong desc;

-- 5. 5.	Hiển thị IDKhachHang, HoTen, TenLoaiKhach, IDHopDong, TenDichVu, NgayLamHopDong, NgayKetThuc,
-- TongTien (Với TongTien được tính theo công thức như sau: ChiPhiThue + SoLuong*Gia
-- với SoLuong và Giá là từ bảng DichVuDiKem) cho tất cả các Khách hàng đã từng đặt phỏng.
-- (Những Khách hàng nào chưa từng đặt phòng cũng phải hiển thị ra).
select khachhang.IDKhachHang, khachhang.HoTen, loaikhach.TenLoaiKhach, hopdong.IDHopDong, dichvu.TenDichVu, hopdong.NgayLamHopDong, hopdong.NgayKetThuc,
(dichvu.ChiPhiThue + hopdongchitiet.SoLuong * kieuthue.Gia) as 'TongTien' from khachhang
left join hopdong on khachhang.IDKhachHang = hopdong.IDKhachHang
left join dichvu on hopdong.IDDichVu = dichvu.IDDichVu
left join kieuthue on dichvu.IDKieuThue = kieuthue.IDKieuThue
left join hopdongchitiet on hopdong.IDHopDong = hopdongchitiet.IDHopDong
left join loaikhach on khachhang.IDLoaiKhach =  loaikhach.IDLoaiKhach;

-- 6.	Hiển thị IDDichVu, TenDichVu, DienTich, ChiPhiThue, TenLoaiDichVu của tất cả các loại Dịch vụ chưa từng được Khách hàng thực hiện đặt từ quý 1 của năm 2019 (Quý 1 là tháng 1, 2, 3).
select dichvu.IDDichVu, TenDichVu, DienTich, ChiPhiThue, loaidichvu.TenLoaiDichVu from dichvu
left join hopdong on dichvu.IDDichVu = hopdong.IDHopDong
left join loaidichvu on dichvu.IDLoaiDichVu = loaidichvu.IDLoaiDichVu
where not exists (select hopdong.IDDichVu from hopdong);

-- 