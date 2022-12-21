create database QLSV_Java3_Assignment
go
use QLSV_Java3_Assignment
go
create table GRADE(
	id int primary key not null,
	maSV nvarchar(50),
	diemTiengAnh int,
	diemTinHoc int,
	diemGDTC int,
	FOREIGN KEY (maSV) REFERENCES STUDENTS(maSV)
	
);
create table STUDENTS (
	maSV nvarchar(50) primary key,
	hoTen nvarchar(50),
	email varchar(50),
	sdt nvarchar(50),
	gioiTinh bit,
	diaChi nvarchar(50),
	hinh nvarchar(50)
)
create table USERS(
	username nvarchar(50) primary key not null,
	password nvarchar(50),
	role nvarchar(50)
)