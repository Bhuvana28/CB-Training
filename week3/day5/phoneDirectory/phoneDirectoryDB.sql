create database phone_directory;

use phone_directory;

drop table if exists person;
create table person(
	id int(11) auto_increment,
	name varchar(20) not null,
	address text,
	constraint person_id_pk primary key(id)
);

drop table if exists contact;
create table contact(
	person_id int(11) auto_increment,
	type varchar(10) not null,
	phone varchar(10) not null,
	constraint contact_id_phone_ck primary key(person_id,phone),
	constraint contact_id_fk foreign key(person_id) references person(id) 
);