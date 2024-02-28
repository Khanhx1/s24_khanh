drop database if exists database_2;
create database if not exists database_2;
use database_2;

create table customer(
customer_id int auto_increment primary key,
customer_name varchar(50) not null,
age int not null
);

create table order_product(
order_id int,
customer_id int,
order_date date not null,
order_total_price bigint,
primary key(order_id, customer_id),
foreign key(customer_id) references customer(customer_id)
);

create table product(
product_id int,
product_name varchar(50) not null,
product_price bigint not null,
primary key(product_id)
);

create table order_detail(
order_id int,
product_id int,
quantity int not null,
primary key(order_id, product_id),
foreign key(order_id) references order_product(order_id),
foreign key(product_id) references product(product_id)
);

insert into customer(customer_id, customer_name, age)
values	(1, 'Minh Quan', 10),
		(2, 'Ngoc Oanh', 20),
		(3, 'Hong Ha' ,50);

insert into order_product(order_id, customer_id, order_date, order_total_price)
values	(1, 1, '2006-03-21', Null),
		(2, 2, '2006-03-23', Null),
		(3, 1, '2006-03-16', Null);
        
insert into product(product_id, product_name, product_price)
values	(1, 'May Giat', 3), 
		(2, 'Tu Lanh', 5), 
		(3, 'Dieu Hoa', 7), 
		(4, 'Quat', 1), 
		(5, 'Bep Dien', 2);
        
insert into order_detail(order_id, product_id, quantity)
values	(1, 1, 3), 
		(1, 3, 7), 
		(1, 4, 2), 
		(2, 1, 1), 
		(3, 1, 8), 
		(2, 5, 4), 
		(2, 3, 3);
        
SELECT order_id, order_date, order_total_price
FROM order_product;

SELECT customer.customer_name, product.product_name
FROM customer
JOIN order_product ON customer.customer_id = order_product.customer_id
JOIN order_detail ON order_product.order_id = order_detail.order_id
JOIN product ON order_detail.product_id = product.product_id;

SELECT customer.customer_name
FROM customer
LEFT JOIN order_product ON customer.customer_id = order_product.customer_id
WHERE order_product.order_id IS NULL;

SELECT 
    order_product.order_id,
    order_product.order_date,
    SUM(product.product_price * order_detail.quantity) AS order_total_price
FROM 
    order_product 
JOIN 
    order_detail ON order_product.order_id = order_detail.order_id
JOIN 
    product ON order_detail.product_id = product.product_id
GROUP BY 
    order_product.order_id, order_product.order_date;
