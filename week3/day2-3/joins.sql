select marks.id,name,subject_id,quarterly,half_yearly,annual,year,grade from marks INNER JOIN students on marks.student_id = students.id;

#1)
select name from marks inner join students on marks.student_id = students.id where quarterly is null and half_yearly is null and annual is null;

#2)
select name,sum(IFNULL(annual,0)) marks,year from marks inner join students on students.id = marks.student_id group by student_id,year;

#3)
select name,sum(IFNULL(quarterly,0)) marks,grade from marks inner join students on students.id = marks.student_id where year = 2003 group by student_id,grade;

#4)
select name,grade,count(medal_won) no_of_medals from students inner join medals on students.id = medals.student_id group by student_id,grade having grade in (9,10) and no_of_medals > 3 ;

#5)
select name,grade,count(medal_won) no_of_medals from students left join medals on students.id = medals.student_id group by name,grade having no_of_medals < 2;

#6)
select m.student_id,s.name,m.year from students s left join marks m on m.student_id = s.id  left join (select student_id,year,count(medal_won) 'medal_won' from medals group by student_id,year) me on me.student_id = s.id and me.year = m.year where m.annual >= 40 and IFNULL(me.medal_won,0) = 0 group by m.student_id,m.year having count(m.student_id) = 5;
select m.student_id,s.name,m.year from students s left join (select student_id,sum(if(annual>=40,0,1)) 'annual',year from marks group by student_id,year) m on m.student_id = s.id  left join (select student_id,year,count(medal_won) 'medal_won' from medals group by student_id,year) me on me.student_id = s.id and me.year = m.year where m.annual = 0 and IFNULL(me.medal_won,0) = 0;
#select m.student_id,s.name,m.year from students s inner join marks m on m.student_id = s.id where m.annual >= 40 group by m.student_id,m.year having count(m.student_id) = 5 and 0 = (select count(medal_won) from medals where student_id = m.student_id and year = m.year) ;
# - To check student annual marks in a year - select student_id,annual from marks where student_id=100001 and year = 2006;

#7)
select name, game_id, medal_won, year, grade from medals inner join students on students.id = medals.student_id where student_id in (select student_id from medals group by student_id having count(medal_won) >= 3 );
# - to check students who won medals >= 3  select student_id from medals group by student_id having count(medal_won) >=3;

#8)

#select s.name,ma.quarterly,ma.half_yearly,ma.annual,me.medal_won,ma.year from marks ma right join students s on s.id=ma.student_id left join (select student_id,count(medal_won) medal_won,year from medals group by student_id,year) me on me.student_id=ma.student_id and me.year = ma.year;

select s.name, round(sum(IFNULL(ma.quarterly,0))/5,2) quarterly_per, round((sum(IFNULL(ma.half_yearly,0))/5),2) half_yearly_per,
round((sum(IFNULL(ma.annual,0))/5),2) annual_per,IFNULL(me.medal_won,0) 'Medals won',ma.year 
from marks ma right join students s on s.id=ma.student_id left join 
(select student_id,count(medal_won) 'medal_won',year from medals group by student_id,year) me 
on me.student_id=ma.student_id and me.year = ma.year group by s.id,s.name,ma.year,me.medal_won order by s.id;

#9)
DELIMITER $$
CREATE FUNCTION Hello() RETURNS TEXT
BEGIN
RETURN 'Hello';
END;
$$
DELIMITER;

DROP FUNCTION IF EXISTS getRating;
DELIMITER $$
CREATE FUNCTION getRating(total INT) RETURNS CHAR
BEGIN
DECLARE grade CHAR;
IF(total>=450) THEN
SET grade = 'S';
ELSEIF(total>=400) THEN
SET grade = 'A';
ELSEIF(total>=350) THEN
SET grade = 'B';
ELSEIF(total>=300) THEN
SET grade = 'C';
ELSEIF(total>=250) THEN
SET grade = 'D';
ELSEIF(total>=200) THEN
SET grade = 'E';
ELSEIF(total<200) THEN
SET grade = 'F';
END IF;
RETURN (grade);
END
$$
DELIMITER ;

select name, getRating(SUM(IFNULL(quarterly,0))) quarterly_rating,getRating(SUM(IFNULL(half_yearly,0))) half_yearly_rating,getRating(SUM(IFNULL(annual,0))) annual_rating, year, grade from marks inner join students on students.id = marks.student_id group by student_id,year,grade;