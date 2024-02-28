drop database if exists demo_1;
create database if not exists demo_1;

use demo_1;

create table products(
id int auto_increment primary key,
product_code varchar(50),
product_name varchar(50),
product_price bigint,
product_amount int,
product_description text,
product_status varchar(50)
);

insert into products(id, product_code, product_name, product_price, product_amount, product_description, product_status)
values  (1,'P001', 'XH1', 200, 2, 'small', 'on'),
		(2,'P002', 'XH2', 500, 1, 'tiny', 'on'),
		(3,'P003', 'XH3', 400, 6, 'big', 'off'),
        (4,'P004', 'XH4', 800, 10, 'huge', 'on');
        
-- Trước khi thêm index        
explain select * from products where product_code = 'P003';

create unique index index_product_code on  products( product_code);
create unique index composite_index_product on  products( product_name, product_price);

-- Sau khi thêm index  
explain select * from products where product_code = 'P003';

-- Tạo view
create view view_products as
select products.product_code, products.product_name, products.product_price, products.product_status
from products;

-- Cập nhật view
create or replace view view_products as
select products.product_code, products.product_name, products.product_price
from products;

-- Xóa view
drop view view_products;

-- tạo store procedure

DELIMITER //

create procedure find_all()
begin
select * from products;
end //

create procedure add_product(
in product_code varchar(50),
in product_name varchar(50),
in product_price bigint,
in product_amount int,
in product_description text,
in product_status varchar(50)
)
begin
insert into  products(product_code, product_name, product_price, product_amount, product_description, product_status)
value (product_code, product_name, product_price, product_amount, product_description, product_status);
end //

create procedure set_product(
in id_product int,
in product_code varchar(50),
in product_name varchar(50),
in product_price bigint,
in product_amount int,
in product_description text,
in product_status varchar(50)
)
begin
update products
set products.product_code = product_code,
	products.product_name = product_name,
    products.product_price = product_price,
    products.product_amount = product_amount,
    products.product_description = product_description,
    products.product_status = product_status
where products.id = id_product;
end //

create procedure remove_product(in id int)
begin
delete from products where products.id = id;
end //

DELIMITER ;

