drop database if exists database_2;
create database if not exists database_2;
use database_2;

create table phieu_xuat(
so_phieu_xuat varchar(7) primary key,
ngay_xuat date not null
);

create table vat_tu(
ma_vat_tu varchar(7) primary key,
ten_vat_tu varchar(50) not null
);

create table chi_tiet_phieu_xuat(
ma_vat_tu varchar(7),
so_phieu_xuat varchar(7) not null,
don_gia_xuat bigint default 0, 
so_luong_xuat int default 0,
primary key(ma_vat_tu, so_phieu_xuat),
foreign key(ma_vat_tu) references vat_tu(ma_vat_tu),
foreign key(so_phieu_xuat) references phieu_xuat(so_phieu_xuat),
constraint dieu_kien_1 check(don_gia_xuat >= 0 and so_luong_xuat >= 0)
);

create table phieu_nhap(
so_phieu_nhap varchar(7) primary key,
ngay_nhap date not null
);

create table chi_tiet_phieu_nhap(
ma_vat_tu varchar(7),
so_phieu_nhap varchar(7),
don_gia_nhap bigint default 0,
so_luong_nhap int default 0,
primary key(ma_vat_tu, so_phieu_nhap),
foreign key(ma_vat_tu) references vat_tu(ma_vat_tu),
foreign key(so_phieu_nhap) references phieu_nhap(so_phieu_nhap),
constraint dieu_kien_2 check(don_gia_nhap >= 0 and so_luong_nhap >= 0)
);

create table nha_cung_cap(
ma_nha_cc varchar(7) primary key,
ten_nha_cc varchar(45) not null,
dia_chi varchar(50) not null
);

create table don_dat_hang(
so_don_hang varchar(7),
ma_nha_cc varchar(7),
primary key(so_don_hang, ma_nha_cc),
foreign key (ma_nha_cc) references nha_cung_cap(ma_nha_cc),
ngay_dat_hang date not null
);

create table chi_tiet_don_dat_hang(
ma_vat_tu varchar(7),
so_don_hang varchar(7),
noi_dung text,
primary key(ma_vat_tu, so_don_hang),
foreign key(ma_vat_tu) references vat_tu(ma_vat_tu),
foreign key(so_don_hang) references don_dat_hang(so_don_hang)
);

create table sdt_nha_cc(
so_dien_thoai varchar(10),
ma_nha_cc varchar(7),
primary key(so_dien_thoai, ma_nha_cc),
foreign key(ma_nha_cc) references nha_cung_cap(ma_nha_cc)
);








