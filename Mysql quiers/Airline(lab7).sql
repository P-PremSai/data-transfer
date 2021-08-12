/*Consider the following database that keeps track of airline flight information:
FLIGHTS (flno: integer, from: string, to: string, distance: integer, departs: time, arrives: time, price: integer)
AIRCRAFT (aid: integer, aname: string, cruisingrange: integer)
CERTIFIED (eid: integer, aid: integer)
EMPLOYEE (eid: integer, ename: string, salary: integer)
Note that the Employees relation describes pilots and other kinds of employees as well; Every pilot is certified
for some aircraft, and only pilots are certified to fly.
Write each of the following queries in SQL.
i. Find the names of aircraft such that all pilots certified to operate them have salaries more than
Rs.80,000.
ii. For each pilot who is certified for more than three aircrafts, find the eid and the maximum cruising
range of the aircraft for which she or he is certified.
iii. Find the names of pilots whose salary is less than the price of the cheapest route from Bengaluru to
Frankfurt.
iv. For all aircraft with cruising range over 1000 Kms, find the name of the aircraft and the average
salary of all pilots certified for this aircraft.
v. Find the names of pilots certified for some Boeing aircraft.
vi. Find the aids of all aircraft that can be used on routes from Bengaluru to New Delhi.
vii. A customer wants to travel from Madison to New York with no more than two changes of flight. List
the choice of departure times from Madison if the customer wants to arrive in New York by 6 p.m.
viii. Print the name and salary of every non-pilot whose salary is more than the average salary for pilots.*/

create database airline;

use airline;

create table FLIGHTS
(
   flno int,
   from_place varchar(30), 
   to_place  varchar(30),
   distance int, 
   departs  time, 
   arrives  time, 
   price int,
   primary key(flno)
);
   
create table AIRCRAFT 
(
   aid int, 
   aname varchar(30), 
   cruisingrange int,
   primary key(aid)
);

create table CERTIFIED 
(
    eid int,
	aid int,
    foreign key(eid) references employee(eid) on delete cascade on update cascade,
    foreign key(aid) references aircraft(aid) on delete cascade on update cascade
);

create table EMPLOYEE 
(
     eid int, 
     ename varchar(30), 
     salary int,
     pilot boolean,
     primary key(eid)
);

show tables;

insert into FLIGHTS (flno, from_place, to_place, distance, departs, arrives, price)
values
      (1,'Bengaluru','New Delhi',900,'7:00:00','8:30:00',2500),
      (2,'Madison','New York',1200,'12:00:00','18:50:00',5000),
      (3,'Madison','Washing D C',1100,'11:00:00','16:00:00',4000),
      (4,'Washing D C','New York',200,'16:00:00','17:30:00',1000),
      (5,'Bengaluru','Frankfurt',600,'11:00:00','12:00:00',1500),
      (6,'Bengaluru','Frankfurt',600,'18:00:00','19:00:00',1300);
      
      update flights set price =125000 where price =75000;
	  update flights set price =72000 where price =1500;
      update flights set arrives="17:50:00" where arrives= "18:00:00";
            
insert into AIRCRAFT (aid, aname, cruisingrange)
values
     (101,'IndiGo',950),
     (102,'Air India',6000),
     (103,'Spice Jet',5000),
     (104,'Gotir',2000),
     (105,'Boeing',3000);
     
     update aircraft set aname ="Nosa Boeing" where aname ="Boeing";
     update aircraft set cruisingrange=890 where cruisingrange=950;
     
insert into EMPLOYEE (eid, ename, salary,pilot)
values
      (201,'Alden Cantrell',100000,1),
      (202,'Kierra Gentry',700000,1),
      (203,'Pieerre Cox',80000,1),
      (204,'Thomas Crane',110000,0),
      (205,'Miranda Shaffer',120000,1);
	
alter table employee drop column pilot;
insert into employee values (206,"Roman",55000);
insert into employee values (207,"Cisco",105000);

insert into CERTIFIED (eid, aid)
values
      (205,101),
      (205,102),
      (205,105),
      (201,101),
      (202,104),
      (203,101),
      (204,103);
      
insert into CERTIFIED values (205,104);
update  employee set salary =70000 where salary =700000;
delete from certified where eid =204;

select * from FLIGHTS ;
select * from AIRCRAFT ;
select * from EMPLOYEE ;
select * from CERTIFIED ;

                                       /*i. Find the names of aircraft such that all pilots certified to operate them have salaries more than Rs.80,000.*/

select aname from aircraft 
where aid not in 
		(select aid from certified      /*deleting the aid's which have atleast one pilot with salary<80000*/
        where eid  in (
					select eid from employee 
		            where salary<=80000)
		)
and aid in(        /*selecting all aid's*/
		select distinct aid from certified );
        
                                      /*ii. For each pilot who is certified for more than three aircrafts, find the eid and the maximum cruising  range of the aircraft for which she or he is certified.*/

select e.eid, max(a.cruisingrange) from aircraft a 
join certified c on a.aid =c.aid 
join employee e on c.eid =e.eid 
group by c.eid having count(c.eid)>3;

                                      /*iii. Find the names of pilots whose salary is less than the price of the cheapest route from Bengaluru to Frankfurt*/
                         
select e.ename from employee e 
where e.salary<
(select min(f.price) from flights f 
where f.from_place ="Bengaluru" and f.to_place ="Frankfurt");
                         
                        /* iv. For all aircraft with cruising range over 1000 Kms, find the name of the aircraft and the average salary of all pilots certified for this aircraft.*/

select a.aname,avg(salary)  from aircraft a 
join certified c on a.aid =c.aid 
join employee e on c.eid = e.eid 
where a.cruisingrange>1000 
group by a.aid;

                                   /*v. Find the names of pilots certified for some Boeing aircraft.*/
                                   
select e.ename from employee e 
join certified c on e.eid =c.eid 
join aircraft a on c.aid = a.aid 
where a.aname like "%Boeing%";
                        
                        /*vi. Find the aids of all aircraft that can be used on routes from Bengaluru to New Delhi.*/
                        
select aid from aircraft  
where cruisingrange>
(select distance from flights 
where from_place ="Bengaluru" 
and to_place="New Delhi");
                        
                        /*vii. A customer wants to travel from Madison to New York with no more than two changes of flight. 
                        List the choice of departure times from Madison if the customer wants to arrive in New York by 6 p.m.*/


select departs from flights 
where flno in( 
(select F0.flno from flights F0 
where F0.from_place = "Madison" 
and F0.to_place ="New York")

union 
(select F0.flno from flights F0,flights F1 
where F0.from_place = "Madison"  and F0.to_place<> "New York" 
and F1.from_place=F0.to_place   and F1.to_place ="New York"
and F1.departs >= F0.arrives 
and F1.arrives<"18:00:00")

union 
(select F0.flno 
from flights F0, flights F1, flights F2 
where F0.from_place ="Madison" and F0.to_place <> "New York" 
and  F1.from_place = F0.to_place and F1.to_place <>"New York" 
and F2.from_place = F1.to_place and F2.to_place ="New York" 
and F1.departs >=F0.arrives 
and F2.departs >= F1.arrives 
and F2.arrives<"18:00:00")
);

                          /*viii. Print the name and salary of every non-pilot whose salary is more than the average salary for pilots.*/
                          
select ename,salary from employee 
where eid not in 
(select distinct eid from certified )
 and 
salary > (select avg(salary) from employee 
where eid in
(select distinct eid from certified)
);

