create database insurance;

use insurance;

create table person
(
 driver_id varchar(10),
 name varchar(20),
 address varchar(15),
 primary key(driver_id)
 );
 desc person;
 
create table car
(
 regno varchar(10),
 model varchar(20),
 year date,
 primary key(regno)
 );
 
create table accident
(
 report_no int,
 adate date,
 location varchar(15),
 primary key(report_no)
 );
 
create table owns 
(
 driver_id varchar(10),
 regno varchar(10),
 primary key(driver_id,regno),
 foreign key(driver_id) references person(driver_id) on delete cascade,
 foreign key(regno) references car(regno) on delete cascade
 );
 
 create table participated
 (
  driver_id varchar(10),
  regno varchar(10),
  report_no int,
  damage_amt float,
  foreign key(driver_id,regno) references owns(driver_id,regno) on delete cascade,
  foreign key(report_no) references accident(report_no) on delete cascade
  );
  
  insert into person(driver_id,name,address)
  values
        ('1111','Ramu','K.S.Layout'),
		('2222','John','Indiranagar'),
		('3333','Priya','Jayanagar'),
		('4444','Gopal','Whitefield'),
		('5555','Latha','Vijayanagar');
  
  insert into car(regno,model,year)
  values
       ('KA04Q2301','MARUTHI-DX','2000-05-30'),
       ('KA05P1000','FORDICON','2000-12-23'),
       ('KA03L1234','ZEN-VXI','1999-03-31'),
       ('KA03L9999','MARUTHI-DX','2002-04-24'),
       ('KA01P4020','INDICA-VX','2002-06-19');
       
	insert into accident(report_no,adate,location)
    values
	    (12,'2002-06-01','M G Road'),
        (200,'2002-12-10','Double Road'),
        (300,'1999-07-23','M G Road'),
        (25000,'2000-06-11','Residency Road'),
        (26500,'2001-10-16','Richmond Road');
        
    insert into owns(driver_id,regno)
    values 
         ('1111','KA04Q2301'),
         ('1111','KA05P1000'),
         ('2222','KA03L1234'),
         ('3333','KA03L9999'),
         ('4444','KA01P4020');
         
	insert into participated(driver_id,regno,report_no,damage_amt)
    values
		 (1111,'KA04Q2301',12,20000),
         (2222,'KA03L1234',200,500),
         (3333,'KA03L9999',300,10000),
         (4444,'KA01P4020',25000,2375),
         (1111,'KA05P1000',26500,70000);
         
     select * from  person;    
	 select * from car;
     select * from accident;
     select * from owns;
     select * from participated;
         
/*
a. Update the damage amount for the car with a specific Regno in the accident with report number 12 to
25000.
*/
update participated set damage_amt = 25000 where report_no = 12 and regno = 'KA04Q2301';
select * from participated;

/*
b. Add a new accident to the database
*/
insert into accident values (1001,'2008-10-10','ring road');
select * from accident;

/*
iv. Find the total number of people who owned cars that involved in accidents in 2008
*/
select count(*) from accident where year(ADATE)=2008;

/*
V. Find the number of accidents in which cars belonging to a specific model were involved
*/
SELECT COUNT(A.REPORT_NO) FROM ACCIDENT A, PARTICIPATED P, CAR C
 WHERE A.REPORT_NO=P.REPORT_NO AND
 P.REGNO=C.REGNO AND C.MODEL='MARUTHI-DX';