#select marks.id,name,subject_id,quarterly,half_yearly,annual,year,grade from marks INNER JOIN students on marks.student_id = students.id;

#1)
#select name from marks inner join students on marks.student_id = students.id where quarterly is null and half_yearly is null and annual is null;

#2)
#select name,sum(COALESCE(annual,0)) marks,year from marks inner join students on students.id = marks.student_id group by student_id,year;

#3)
#select name,sum(COALESCE(quarterly,0)) marks,grade from marks inner join students on students.id = marks.student_id where year = 2003 group by student_id,grade;

#4)
#select name,grade,count(medal_won) no_of_medals from medals inner join students on students.id = medals.student_id group by student_id,grade having grade in (9,10) and no_of_medals > 3 ;

#5)
#select name,grade,count(medal_won) no_of_medals from students left join medals on students.id = medals.student_id group by name,grade having no_of_medals < 2;

#6)
#select name,year from students inner join marks on marks.student_id = students.id where annual > 90 group by name,year having count(student_id) = 5 and name in (select name from students left join medals on students.id = medals.student_id group by name having count(medal_won) = 0);
##select m.student_id,s.name,m.year from students s inner join marks m on m.student_id = s.id where m.annual >= 40 group by m.student_id,m.year having count(m.student_id) = 5 and 0 = (select count(medal_won) from medals where student_id = m.student_id and year = m.year) ;
# - To check student annual marks in a year select student_id,annual from marks where student_id=100001 and year = 2006;

#7)
#select name, game_id, medal_won, year, grade from medals inner join students on students.id = medals.student_id where student_id in (select student_id from medals group by student_id having count(medal_won) >= 3 );
# - to check students who won medals >= 3  select student_id from medals group by student_id having count(medal_won) >=3;

#8)
select distinct s.name,(count(me.medal_won)/5) medals,round((sum(COALESCE(ma.quarterly,0))/500)*100,2) quarterly_per, round((sum(COALESCE(ma.half_yearly,0))/500)*100,2) half_yearly_per, round((sum(COALESCE(ma.annual,0))/500)*100,2) annual_per, ma.year, ma.grade from marks ma inner join students s on s.id=ma.student_id left join medals me on me.student_id=ma.student_id and me.year = ma.year group by ma.student_id,ma.year,ma.grade,me.medal_won; 

select * from marks ma inner join students s on s.id=ma.student_id left join medals me on me.student_id=ma.student_id and me.year = ma.year;

select distinct s.name,count(me.medal_won) medals,round((sum(COALESCE(ma.quarterly,0))/500)*100,2) quarterly_per, round((sum(COALESCE(ma.half_yearly,0))/500)*100,2) half_yearly_per, round((sum(COALESCE(ma.annual,0))/500)*100,2) annual_per, ma.year, ma.grade from marks ma inner join students s on s.id=ma.student_id left join medals me on me.student_id=ma.student_id and me.year = ma.year group by ma.student_id,ma.year,ma.grade; 

#9)
DELIMITER $$
CREATE FUNCTION AssignRating(total INT) RETURNS CHAR
	BEGIN 
		DECLARE range CHAR;
		SET range = 'H';
		RETURN (range);
	END;
	$$
	DELIMITER;

	IF (total >= 450 AND total <= 500) THEN
			SET range = 'S';
		ELSEIF(total >= 400 AND total <= 449) THEN
			SET range = 'A';
		ELSEIF(total >= 350 AND total <= 399) THEN
			SET range = 'B';
		ELSEIF(total >= 300 AND total <= 349) THEN
			SET range = 'C';
		ELSEIF(total >= 250 AND total <= 299) THEN
			SET range = 'D';
		ELSEIF(total >= 200 AND total <= 249) THEN
			SET range = 'E';
		ELSEIF(total < 200) THEN
			SET range = 'F';
		END IF;



select name, quarterly_rating, half_yearly_rating, annual_rating, year, grade