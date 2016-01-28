alter table marks add column created_at datetime default now();
alter table marks modify column updated_at datetime default now() on update now();

alter table students add column created_at datetime default now();
alter table students modify column updated_at datetime default now() on update now();

alter table medals add column created_at datetime default now();
alter table medals modify column updated_at datetime default now() on update now();


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

insert into students_summary(student_id,student_name,year,percentage,no_of_medals_received) select s.id,s.name,ma.year,round((sum(IFNULL(ma.annual,0))/5),2),COALESCE(me.medal_won,0) from marks ma right join students s on s.id=ma.student_id left join (select student_id,count(medal_won) 'medal_won',year from medals group by student_id,year) me on me.student_id=ma.student_id and me.year = ma.year group by s.id,s.name,ma.year,me.medal_won;
	
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

drop trigger if exists setMedalWonToMedalReceived;
delimiter $$
create trigger setMedalWonToMedalReceived before insert on medals for each row
	begin 
	if new.medal_received is not null THEN
		set new.medal_won = new.medal_received;
	elseif new.medal_won is not null THEN
		set new.medal_received = new.medal_won;
	end if;
	end
	$$
	delimiter ;

drop trigger if exists updateMedalReceived;
delimiter $$
create trigger updateMedalReceived before update on medals for each row
	begin
	if new.medal_received<>old.medal_received THEN
		set new.medal_won = new.medal_received;
	elseif new.medal_won <> old.medal_won THEN
		set new.medal_received = new.medal_won;
	end if;
	end
	$$
	delimiter ;

update medals set medal_received = medal_won;

alter table medals drop column medals_received;




