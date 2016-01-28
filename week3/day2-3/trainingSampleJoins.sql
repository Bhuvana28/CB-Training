create database training_sample;

use training_sample;

source /Users/cb-bhuvana/Documents/CB-Training-JAVA/CB-Training/week3/day2-3/sample-sql-data.sql;

--Queries
select name from students;

select name from students where name like 'H%';

select name from students where name like '%a%';

select name from students order by name asc;

select name from students order by name limit 2;

select name from students order by name limit 2,2;

--Queries with marks table
select name,subject_id "Subject Id",quarterly 'Quarterly',half_yearly 'Half yearly',annual 'Annual',year,grade from marks inner join students on students.id=marks.student_id where annual is NULL;

select name,subject_id,year from marks inner join students on students.id = marks.student_id where year = 2005 and annual is NULL;

select name,subject_id,year from marks inner join students on students.id = marks.student_id where quarterly is NOT NULL or  half_yearly is NOT NULL or  annual is NOT NULL;

select name, subject_id, year, quarterly, half_yearly, annual from marks inner join students on students.id = marks.student_id where quarterly > 90 and half_yearly > 90 and annual > 90;

select name, subject_id, (IFNULL(quarterly,0) + IFNULL(half_yearly,0) + IFNULL(annual,0))/3 'average', year from marks inner join students on students.id = marks.student_id;

select name, subject_id, (IFNULL(quarterly,0) + IFNULL(half_yearly,0) + IFNULL(annual,0))/3 average, year from marks inner join students on students.id = marks.student_id where year in (2003,2004);
