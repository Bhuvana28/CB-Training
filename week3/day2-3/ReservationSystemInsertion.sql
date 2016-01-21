-- insert into `users` values (1,'bhuvana','bhuvana'),(2,'vinothini','vinothini'),(3,'siva','siva'),(4,'hari','hari'),(5,'satya','satya');

-- insert into `trains` values (1,'cheran'),(2,'charminar'),(3,'chennai express'),(4,'rajdhani'),(5,'nilgiris'),(6,'satabdi');

-- insert into `stations` values (1,'MAS'),(2,'SC'),(3,'CBE'),(4,'SBE');

-- insert into `routes` values (1,2,3,1024), (2,1,2,700), (3,4,1,400), (4,1,1,600),(5,3,1,600),(6,1,3,600);

-- insert into `coaches` values ('General Coach',30),('H',100),('A1',80),('A2',80),('B1',70),('B2',70),('S1',50),('S2',50),('S3',50),('S4',50),('S5',50),('S6',50),('S7',50),('S8',50),('Chair',35);

-- insert into `trainCoaches` values (1,'General Coach',50),(1,'H',70),(1,'A1',60),(1,'A2',60),(1,'B1',60),(1,'B2',60),(1,'S1',58),(1,'S2',58),(1,'S3',58),(1,'S4',58),(2,'General Coach',100),(2,'H',80),(2,'A1',70),(2,'A2',70),(2,'B1',70),(2,'B2',70),(2,'S1',54),(2,'S2',54),(2,'S3',54),(2,'S4',54),(2,'S5',54),(2,'S6',54),(5,'General Coach',80),(5,'H',80),(5,'A1',80),(5,'A2',80),(5,'B1',80),(5,'B2',80),(5,'S1',64),(5,'S2',64),(5,'S3',64),(5,'S4',64),(5,'S5',64),(5,'S6',64),(5,'S7',64),(4,'General Coach',120),(4,'H',70),(4,'A1',70),(4,'A2',70),(4,'B1',70),(4,'B2',70);

-- insert into `trainRouteMaps` values (6,1,"21:30:00","06:00:00",TIME_TO_SEC(TIMEDIFF("21:30:00","06:00:00"))/60) , (6,5,"20:30:00","05:00:00",TIME_TO_SEC(TIMEDIFF("20:30:00","05:00:00"))/60) , (2,2,"18:05:00","06:30:00",TIME_TO_SEC(TIMEDIFF("18:05:00","06:30:00"))/60);

-- insert into `bookings` values (1,6,1,'S4',str_to_date('14-01-2016','%d-%m-%Y'),str_to_date('02-12-2015','%d-%m-%Y'),1), (2,2,2,'B1',str_to_date('13-02-2016','%d-%m-%Y'),str_to_date('02-01-2016','%d-%m-%Y'),4);

-- insert into bookings(routeid,trainno,coachcode,dateofjourney,dateofbooking,nooftickets) values (6,1,'S5',str_to_date('22-12-2015','%d-%m-%Y'),str_to_date('17-01-2016','%d-%m-%Y'),1);



