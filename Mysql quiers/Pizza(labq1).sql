/*Consider the following database for a Pizza Database Information.
The Requirement is Pizza Stores are maintained and stored at a particular Price.Each Pizza
Is having a QualityRating like Good,verygood ,excellent etc.Each store can sell multiple pizzas
and each pizza can be sold by multiple stores. You can add more tuples to the table to answer queries
i) Create the above tables by properly specifying the primary keys and the foreign keys.
ii) Enter at least five tuples for each relation.
iii) Find the names of all stores that sell both veggie and cheese pizzas.
iv) Find the name and phone numbers of all stores that sell Good or excellent veggie pizza
under $100.
v) Demonstrate how you update the price of a vegcheese pizza by 10%
vi) List the stores whose average price for pizza is higher than the overall average prize.
vii) Create a View which contains(Pname,Totalprice,Avgprice) for each pizza sold .

Pizza(pid: Integer, pname:String,quality:Integer, Address:String).
Store(SID:integer,sname:string, phone:string,Qualityrating:string)
Soldby(pid:Integer,sid:Integer ,Price:float)*/

create database pizza;

use pizza;

create table pizza
(
 pid int,
 pname varchar(30),
 quality int,
 address varchar(50),
 primary key(pid)
 );
 
create table store
(
 sid  integer,
 sname varchar(30),
 phone varchar(20),
 Qualityrating varchar(20),
 primary key(SID)
 );
 
 create table soldby
 (
  pid int,
  sid  int ,
  Price float,
  foreign key(pid) references pizza(pid) on delete cascade on update cascade,
  foreign key(sid) references store(sid) on delete cascade on update cascade
  );
  
  drop table soldby;
   drop table pizza;
insert into pizza(pid,pname,quality,address)
values
	(1,'Deluxe Veggie',8,'Javanagar'),
    (2,'Veg cheese',9,'Basvangudi'),
    (3,'Nonveg cheese',9,'M G Road'),
    (4,'Peepy Paneer',8,'Indiranagar'),
    (5,'Margherita',9,'Basvangudi');
    
insert into store(SID,sname,phone,Qualityrating)
values
     (101,'Dominos','9565432151','Excellent'),
     (102,'Pizza hut','8234968545','Very Good'),
     (103,'Mojo Pizza','8925623898','Good'),
     (104,'The Pizza Dine','9949698490','Very Good'),
     (105,'Oven Story','7298684812','Good');
     
insert into soldby (pid,sid,Price)
values
     (1,101,99.0),
     (2,101,80.0),
     (3,102,150.0),
     (1,102,93.0),
     (5,105,70.0);
     
     select * from pizza;
     select * from store;
     select * from soldby;
     
     
                	/*iii) Find the names of all stores that sell both veggie and cheese pizzas.*/
    
select s1.sname from store s1 join soldby o1 on s1.sid = o1.sid join pizza p1 on o1.pid =p1.pid ,
     store s2 join soldby o2 on s2.sid = o2.sid join pizza p2 on o2.pid =p2.pid where p1.pname like "%Veggie" and p2.pname like "%cheese%" and s1.sid =s2.sid;
    

                      /*iv) Find the name and phone numbers of all stores that sell Good or excellent veggie pizza under $100.*/
     
select distinct s.sname,s.phone from store s join soldby  o on s.sid = o.sid join pizza p on o.pid =p.pid 
   where o.price<100 and p.pname ="%veggie" and s.Qualityrating ="Good" or s.Qualityrating ="Excellent" ;
   
                         /*v) Demonstrate how you update the price of a vegcheese pizza by 10%*/
      
update soldby set price =price +(0.1*price) where pid =(select pid from pizza where pname ="veg cheese");
select * from soldby;

                         /*vi) List the stores whose average price for pizza is higher than the overall average prize.*/

select s.*,avg(price) from store s join soldby o on s.sid = o.sid where o.sid in(select sid from soldby group by sid having avg(o.price)> (select avg(price) from soldby));

                        /*vii) Create a View which contains(Pname,Totalprice,Avgprice) for each pizza sold .*/

create view pizzaview as select p.pname,sum(s.price),avg(s.price) from  soldby s ,pizza p where p.pid =s.pid group by s.pid ;
select * from pizzaview;
drop view pizzaview;