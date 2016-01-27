alter table marks add column created_at datetime default now();
alter table marks add column updated_at datetime default now();

alter table students add column created_at datetime default now();
alter table students add column updated_at datetime default now();

alter table medals add column created_at datetime default now();
alter table medals add column updated_at datetime default now();

drop trigger if exists updatedatetimemarks;
delimiter $$
create trigger updatedatetimemarks before update on marks for each row
	begin
	set new.updated_at = now();
	end
	$$
	delimiter ;

drop trigger if exists updatedatetimestudents;
delimiter $$
create trigger updatedatetime before update on students for each row
	begin
	set new.updated_at = now();
	end
	$$
	delimiter ;


drop trigger if exists updatedatetimemedals;
delimiter $$
create trigger updatedatetimemedals before update on medals for each row
	begin
	set new.updated_at = now();
	end
	$$
	delimiter ;

update marks set quarterly = 0 where quarterly is null;
update marks set half_yearly = 0 where half_yearly is null;
update marks set annual = 0 where annual is null;

alter table marks modify annual int(11) not null default 0;
alter table marks modify half_yearly int(11) not null default 0;
alter table marks modify quarterly int(11) not null default 0;

create table if not exists students_summary(
	student_id bigint(19) NOT NULL AUTO_INCREMENT,
	student_name varchar(100) DEFAULT NULL,
	year int(11),
	percentage float(4,2),
	no_of_medals_received int(2),
	constraint students_summary_id_year_ck primary key(student_id,year),
	constraint students_summary_id_fk foreign key(student_id) references students(id)
);

drop procedure if exists setStudentSummary;
delimiter $$
create procedure setStudentSummary()
	begin
	declare stud_id bigint(19);
	declare stud_name varchar(100);
	declare stud_year int(11);
	declare stud_percentage float(4,2);
	declare no_medals int(2);
	declare finished int default 0;

	declare cur1 cursor for select s.id,s.name,ma.year,round((sum(COALESCE(ma.annual,0))/5),2),COALESCE(me.medal_won,0) from marks ma right join students s on s.id=ma.student_id left join (select student_id,count(medal_won) 'medal_won',year from medals group by student_id,year) me on me.student_id=ma.student_id and me.year = ma.year group by s.id,s.name,ma.year,me.medal_won;
	declare continue handler for not found set finished = 1;

	open cur1;

	summary: loop
		fetch cur1 into stud_id,stud_name,stud_year,stud_percentage,no_medals;
		if finished=1 then
			leave summary;
		end if;
		insert into students_summary values(stud_id,stud_name,stud_year,stud_percentage,no_medals);
	end loop summary;

	close cur1;

	end $$
delimiter ;

call setStudentSummary();

----
alter table marks add column average float(6,2) not null default 0;

delimiter $$
create trigger updateAverage before update on marks for each row
	begin
	set new.average = (new.quarterly + new.half_yearly + new.annual)/3;
	end
	$$
delimiter ;

delimiter $$
create trigger setAverage before insert on marks for each row
	begin
	set new.average = (new.quarterly + new.half_yearly + new.annual)/3;
	end
	$$
	delimiter ;


#Rename the column name from medal_won to medal_received in the table medals.

alter table medals add column medal_received varchar(10);

delimiter $$
create trigger setMedalWonToMedalReceived before insert on medals for each row
	begin 
	set new.medal_received = new.medal_won;
	end
	$$
	delimiter ;

delimiter $$
create trigger updateMedalReceived before update on medals for each row
	begin
	set new.medal_received = new.medal_won;
	end
	$$
	delimiter ;


drop procedure if exists copyMedalWonToMedalReceived;
delimiter $$
create procedure copyMedalWonToMedalReceived()
	begin
	update medals set medal_received = medal_won;
	end$$
	delimiter ;

call copyMedalWonToMedalReceived();





