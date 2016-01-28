create database sample_review;

use database smaple_review;

create table students(id int(2) primary key, name varchar(20));
create table teachers(id int(2) primary key, name varchar(20));
create table staffs(id int(2) primary key, name varchar(20));

delimiter ;;
create trigger insertStudent before insert on students for each row
	insert into persons values(new.id);
	;;
	delimiter ;

delimiter ;;
create trigger insertTeacher before insert on teachers for each row
	insert into persons values(new.id);
	;;
	delimiter ;

delimiter ;;
create trigger insertStaff before insert on staffs for each row
	insert into persons values(new.id);
	;;
	delimiter ;

create table persons(id int(2));



