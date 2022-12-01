create schema if not exists productmanagement collate utf8mb4_0900_ai_ci;

create table if not exists customer
(
	id int auto_increment
		primary key,
	firstname varchar(45) null,
	lastname varchar(45) null,
	gender bit null,
	date_of_birth date null
);

create table if not exists address
(
	customer_id int not null
		primary key,
	city varchar(45) null,
	zipcode varchar(45) null,
	street varchar(100) null,
	constraint customer_pk
		foreign key (customer_id) references customer (id)
			on update cascade on delete cascade
);

create table if not exists `order`
(
	order_id int auto_increment
		primary key,
	customer_id int not null,
	orderDate date null,
	price double not null,
	constraint custome_fk
		foreign key (order_id) references customer (id)
			on update cascade on delete cascade
);

create table if not exists product
(
	product_id int auto_increment,
	name varchar(128) not null,
	description varchar(255) not null,
	price float not null,
	constraint name_UNIQUE
		unique (name),
	constraint product_id_UNIQUE
		unique (product_id)
)
charset=latin1;

alter table product
	add primary key (product_id);

