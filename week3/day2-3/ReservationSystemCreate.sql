drop database if exists `reservation_system`;

create database `reservation_system`;

use `reservation_system`;

#drop table if exists `users`;
create table if not exists `users`(
	`UserId` int(3) auto_increment,
	`LoginId` varchar(15),
	`LPassword` varchar(20),
	constraint `users_userId_pk` primary key(`UserId`)
)auto_increment=1;

#drop table if exists `trains`;
create table if not exists `trains`(
	`TrainNo` int(3) auto_increment,
	`TrainName` varchar(30),
	constraint `trains_trainNo_pk` primary key(`TrainNo`)
)auto_increment=1;

#drop table if exists `stations`;
create table if not exists `stations`(
	`StationId` int(3) auto_increment,
	`StationCode` varchar(10),
	constraint `stations_stationId_pk` primary key(`StationId`)
)auto_increment=1;

#drop table if exists `routes`;
create table if not exists `routes`(
	`RouteId` int(3) auto_increment,
	`OriginStationId` int(3),
	`DestinationStationId` int(3),
	`DistanceInKms` int(4),
	constraint `routes_routeId_pk` primary key(`RouteId`),
	constraint `routes_originStationId_fk` foreign key(`OriginStationId`) references `stations`(`StationId`),
	constraint `routes_destinationStationId_fk` foreign key(`DestinationStationId`) references `stations`(`StationId`)
)auto_increment=1;

#drop table if exists `coaches`;
create table if not exists `coachs`(
	`CoachCode` varchar(20),
	`CostPerkm` int(3),
	constraint `coaches_coachCode_pk` primary key(`CoachCode`)
);

#drop table if exists `trainCoaches`;
create table if not exists `trainCoachs`(
	`TrainNo` int(3),
	`CoachCode` varchar(20),
	`NoOfSeats` int(3),
	constraint `trainCoaches_trainNo_fk` foreign key(`TrainNo`) references `trains`(`TrainNo`), 
	constraint `trainCoaches_coachCode_fk` foreign key(`CoachCode`) references `coachs`(`CoachCode`)
);

#drop table if exists `trainRouteMaps`;
create table if not exists `trainRouteMaps`(
	`RouteId` int(3),
	`TrainNo` int(3),
	`ArrivalTime` time,
	`DepartureTime` time,
	`DurationInMins` float(6,2),
	constraint `trainRouteMaps_ck` primary key(`RouteId`,`TrainNo`),
	constraint `trainRouteMaps_routeId_fk` foreign key (`RouteId`) references `routes`(`RouteId`),
	constraint `trainRouteMaps_trainNo_fk` foreign key (`TrainNo`) references `trains`(`TrainNo`)
);

#drop table if exists `bookings`;
create table if not exists `bookings`(
	`BookingRefNo` int(5) auto_increment,
	`RouteId` int(3),
	`TrainNo` int(3),
	`CoachCode` varchar(15),
	`DateOfJourney` date,
	`DateOfBooking` date,
	`NoOfTickets` int(1),
	constraint `bookings_bookingRefNo_pk` primary key(`BookingRefNo`),
	constraint `bookings_routeId_fk` foreign key(`RouteId`) references `trainRouteMaps`(`RouteId`), 
	constraint `bookings_trainNo_fk` foreign key(`TrainNo`) references `trainRouteMaps`(`TrainNo`),
	constraint `bookings_coachCode_fk` foreign key(`CoachCode`) references `coaches`(`CoachCode`)
)auto_increment=1;

-- delimiter $$
-- create trigger setDurationInMins on trainRouteMaps instead of insert as
-- begin
-- insert into trainRouteMaps values (new.RouteId,new.TrainNo,new.ArrivalTime,new.DepartureTime,TIME_TO_SEC(TIMEDIFF(new.ArrivalTime,new.DepartureTime))/60);
-- 	end;
-- 	$$
-- 	delimiter;



