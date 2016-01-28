create database phone_directory;

use phone_directory;

drop table if exists persons;
create table persons(
	id int(11) auto_increment,
	name varchar(20) not null,
	address varchar(150),
	constraint persons_id_pk primary key(id),
	constraint persons_name_address_unique unique(name,address)
);

drop table if exists contacts;
create table contacts(
	person_id int(11) auto_increment,
	type varchar(10) not null,
	phone varchar(10) not null,
	constraint contact_id_phone_ck primary key(person_id,phone),
	constraint contact_id_fk foreign key(person_id) references persons(id) 
);