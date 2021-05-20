drop database if exists infyshop_userdb;
create schema infyshop_userdb;
use infyshop_userdb;

create table buyer(
	buyer_id integer primary key AUTO_INCREMENT,
	name varchar(50) NOT NULL,
	email varchar(30) NOT NULL,
	phone_number bigint not null unique,
	password varchar(50) not null,
    is_privileged boolean default false,
    reward_points integer default 0,
    is_active boolean default false
);


create table seller(
	seller_id integer primary key AUTO_INCREMENT,
	name varchar(50) NOT NULL,
	email varchar(30) NOT NULL,
	phone_number bigint not null unique,
	password varchar(50) not null,
    is_active boolean default false
);


create table wishlist(
	buyer_id integer,
	prod_id integer, 
    primary key(buyer_id,prod_id)
);


create table cart(
	buyer_id integer,
	prod_id integer,
	quantity integer not null,
    primary key(buyer_id,prod_id)
);