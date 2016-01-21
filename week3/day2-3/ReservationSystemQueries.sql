#1) To get the list of all trains
select `trainname` from `trains`;

#2) To get the list of all train routes in the database
-- drop function if exists getStationCode;

-- delimiter $$
-- create function getStationCode(station_id int) returns varchar(10)
-- 	begin
-- 	declare code varchar(10);
-- 	select stationcode into @code from stations where stationid=station_id;
-- 	return @code;
-- 	end$$
-- 	delimiter ;

select getStationCode(originstationid), getStationCode(destinationstationid) from routes;

#3) Total number of seats in the each train.
select trainname 'Train',sum(noofseats) 'No of Seats' from traincoaches inner join trains on trains.trainno = traincoaches.trainno group by trainname;

#4) List of all routes goes to Bangalore
select getStationCode(originstationid), getStationCode(destinationstationid) from routes where getStationCode(destinationstationid) = 'SBE';

#5) List of all routes starting from bangalore, calcutta and chennai
select getStationCode(originstationid), getStationCode(destinationstationid) from routes where getStationCode(originstationid) in ('SBE','MAS','CAL');

#6) List of all the bookings booked between 1st Jan 2005 and 31st Dec 2005
#select * from bookings where dateofbooking between str_to_date('1st Jan 2005','%dst %b %Y') and str_to_date('31st Jan 2005','%dst %b %Y');
select bookingrefno,getStationCode(originstationid),getStationCode(destinationstationid),dateofjourney,dateofbooking,nooftickets from bookings inner join trains on trains.trainno = bookings.trainno inner join routes on routes.routeid = bookings.routeid where dateofbooking between str_to_date('1st Dec 2015','%dst %b %Y') and str_to_date('31st Dec 2015','%dst %b %Y') ;

#7) List of all trains whose name begins with B
#select trainname from trains where trainname like 'B%';
select trainname from trains where trainname like 'c%';

#8) List of all bookings where DOB is not null
select bookingrefno,getStationCode(originstationid),getStationCode(destinationstationid),dateofjourney,dateofbooking,nooftickets from bookings inner join trains on trains.trainno = bookings.trainno inner join routes on routes.routeid = bookings.routeid where dateofbooking is not null;

#9) List of all bookings for the booked in 2006, DOJ in 2007
select bookingrefno,getStationCode(originstationid),getStationCode(destinationstationid),dateofjourney,dateofbooking,nooftickets from bookings inner join trains on trains.trainno = bookings.trainno inner join routes on routes.routeid = bookings.routeid where year(dateofbooking) = '2006' and year(dateofjourney) = '2007';

#10) Total number of coaches in the all the trains
select trainname 'Train' ,count(coachcode) 'No of coaches' from traincoaches inner join trains on trains.trainno = traincoaches.trainno group by trainname;

#11) Total number of bookings in the database for the train no 16198
select trainname 'Train' ,count(bookingrefno) 'No of bookings' from bookings inner join trains on trains.trainno = bookings.trainno where bookings.trainno = 1 group by bookings.trainno;

#12) Total no of tickets column 'total' , booked for train no. 14198
select trainname 'Train' ,sum(nooftickets) 'No of tickets booked' from bookings inner join trains on trains.trainno = bookings.trainno where bookings.trainno = 1 group by bookings.trainno;

#13) Minimum distance route
select getStationCode(originstationid) 'Origin', getStationCode(destinationstationid) 'Destination' , distanceinkms 'Distance' from routes where distanceinkms = (select min(distanceinkms) from routes);

#14) Total number of tickets booked for each train in the database
select trainname 'Train' ,sum(coalesce(nooftickets,0)) 'No of tickets booked' from bookings right join trains on trains.trainno = bookings.trainno group by trains.trainname;

#15) cost for 50 kms for each coach.
select coachcode 'Coach', costperkm*50 'Cost for 50km' from coachs;

#16) List the train name and departure time for the trains starting from Bangalore.
select trainname,departuretime from trainroutemaps inner join trains on trains.trainno = trainroutemaps.trainno where routeid in (select routeid from routes where getStationCode(originstationid) = 'SC');

#17) List the trains for which the total no of tickets booked is greater than 500
select trainname 'Train' ,sum(nooftickets) 'No of tickets booked' from bookings inner join trains on trains.trainno = bookings.trainno group by bookings.trainno having sum(nooftickets) > 500;

#18) List the trains for which the total no of tickets booked is lesser than 50
select trainname 'Train' ,sum(coalesce(nooftickets,0)) 'No of tickets booked' from bookings right join trains on trains.trainno = bookings.trainno group by trains.trainname having sum(coalesce(nooftickets,0)) < 50;

#19) List the bookings along with train name, origin station, destination station and coach code after the date of journey ’25th Feb 2015’
select bookingrefno,trainname,getStationCode(originstationid),getStationCode(destinationstationid),coachcode,dateofjourney,nooftickets from bookings inner join trains on trains.trainno = bookings.trainno inner join routes on routes.routeid = bookings.routeid where dateofjourney >= str_to_date('25th Feb 2015','%dth %b %Y');

#20) List the trains via the route Mysore - Chennai

#21) List the trains for which are booked till now.
select distinct trainname 'Trains for which tickets are booked' from trains inner join bookings on trains.trainno=bookings.trainno;






