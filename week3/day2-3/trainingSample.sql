create database training_sample;

use training_sample;

source /Users/cb-bhuvana/Documents/CB-Training-JAVA/CB-Training/week3/day2-3/sample-sql-data.sql;

--Queries
select * from students;

select * from students where name like 'H%';

select * from students where name like '%a%';

select * from students order by name asc;

select * from students order by name limit 2;

select * from students order by name limit 2,2;

--Queries with marks table
select * from marks where annual is NULL;

select student_id,subject_id,year from marks where year = 2005 and annual is NULL;

select student_id,subject_id,year from marks where quarterly is NOT NULL or  half_yearly is NOT NULL or  annual is NOT NULL;

select student_id, subject_id, year, quarterly, half_yearly, annual from marks where quarterly > 90 and half_yearly > 90 and annual > 90;

select student_id, subject_id, (IFNULL(quarterly,0) + IFNULL(half_yearly,0) + IFNULL(annual,0))/3 'average', year from marks;

select student_id, subject_id, (IFNULL(quarterly,0) + IFNULL(half_yearly,0) + IFNULL(annual,0))/3 average, year from marks where year in (2003,2004);
