
drop database if exists self_service_portal;

create database self_service_portal;

use self_service_portal;

create table users(
	email varchar(100) not null,
	firstname varchar(50) not null,
	lastname varchar(50) not null,
	password varchar(20) not null,
	constraint users_ssp_email_pk primary key(email)
);

create table addresses(
	email varchar(100) not null,
	address varchar(200) not null,
	city varchar(30) not null,
	state varchar(50) not null,
	zip int(6) not null,
	country varchar(30) not null,
	constraint addresses_email_pk primary key(email),
	constraint addresses_email_fk foreign key(email) references users(email),
	constraint addresses_zip_check check(length(trim(zip)) = 6)
);
