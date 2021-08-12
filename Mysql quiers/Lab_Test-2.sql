/*Consider the following relations for an Order Processing database application in a company.
CUSTOMER (CUST #: int, cname: String, city: String)
ORDER (order #: int, odate: date, cust #: int, ord-Amt: int)
ITEM (item #: int, unit-price: int)
ORDER-ITEM (order #: int, item #: int, qty: int)
WAREHOUSE (warehouse #: int, city: String)
SHIPMENT (order #: int, warehouse #: int, ship-date: date)
i) Create the above tables by properly specifying the primary keys and the foreign keys and the foreign
keys.
ii) Enter at least five tuples for each relation.
iii) Produce a listing: CUSTNAME, #of orders, AVG_ORDER_AMT, where the middle column is the total
numbers of orders by the customer and the last column is the average order amount for that customer.
iv) List the order# for orders that were shipped from all warehouses that the company has in a specific city.
v) Demonstrate how you delete item# 10 from the ITEM table and make that field null in the ORDER_ITEM table.
Vi)For each itemid List out all the details of Order Id ,Shipment details and its average price.*/

create database Order_Processing_lab;

use Order_Processing_lab;

create table customer
(
 cust_no int,
 cname varchar(30),
 city varchar(20),
 primary key(cust_no)
 );
 
create table Orders
(
 order_no int,
 odate date,
 cust_no int,
 order_amount int,
 primary key(order_no),
 foreign key(cust_no) references customer(cust_no) on delete cascade
 );
 
create table item
(
 item_no int,
 unit_price int,
 primary key(item_no)
 );
 
create table warehouse
(
 warehouse_no int,
 city varchar(20),
 primary key(warehouse_no)
 );
 
create table order_item
(
 order_no int,
 item_no int,
 quantity int,
 foreign key(order_no) references orders(order_no) on delete cascade,
 foreign key(item_no) references item(item_no) on delete SET NULL
 );
 
create table shipment
(
 order_no int,
 warehouse_no int,
 ship_date date,
 foreign key(order_no) references orders(order_no) on delete cascade,
 foreign key(warehouse_no) references warehouse(warehouse_no) on delete cascade
 );
 
insert into customer(cust_no,cname,city)
values 
	(771,'P PREM SAI','BANGALORE'),
    (772,'NITHISH','MUMBAI'),
    (773,'NIKHIL','CAICULT'),
    (774,'RADHA','HYDERABAD'),
    (775,'BHARATHI','BANGALORE');
    
insert into orders(order_no,odate,cust_no,order_amount)
values 
	(111,'2022-01-22',771,18000),
    (112,'2002-07-30',774,6000),
    (113,'2003-04-03',775,9000),
    (114,'2003-11-03',775,29000),
    (115,'2003-12-10',773,29000),
    (116,'2004-08-19',772,56000),
    (117,'2004-09-10',771,20000),
    (118,'2004-11-20',775,29000),
    (119,'2005-02-13',774,29000),
    (120,'2005-10-13',775,29000);
    
insert into item(item_no,unit_price)
values
      (20,503),
      (30,750),
      (40,150),
      (50,600),
      (10,890);
      
	insert into order_item(order_no,item_no,quantity)
    values
		(111,20,50),
		(112,40,20),
		(113,30,50),
		(114,10,60),
		(115,50,90),
		(116,20,10),
		(117,40,80),
		(118,10,50),
		(119,30,10),
		(120,50,45);
        
insert into warehouse(warehouse_no,city)
values
    (1,'DELHI'),
    (2,'BOMBAY'),
    (3,'CHENNAI'),
    (4,'BANGALORE'),
    (5,'BANGALORE'),
    (6,'DELHI'),
    (7,'BOMBAY'),
    (8,'CHENNAI'),
    (9,'DELHI'),
    (10,'BANGALORE');
    
insert into shipment(order_no,warehouse_no,ship_date)
values
	(111,1,'2002-02-10'),
	(112,5,'2002-09-10'),
	(113,8,'2003-02-10'),
	(114,3,'2003-12-10'),
    (115,9,'2004-01-19'),
    (116,1,'2004-09-20'),
    (117,5,'2004-09-10'),
    (118,7,'2004-11-30'),
    (119,7,'2005-04-30'),
    (120,6,'2005-12-05');
             
select * from customer;
select * from orders;
select * from item;
select * from order_item;
select * from warehouse;
select * from shipment;

                                                      /*iii) Produce a listing: CUSTNAME, No of orders, AVG_ORDER_AMT, where the middle column is the total
                                                          numbers of orders by the customer and the last column is the average order amount for that customer.*/

SELECT C.CNAME as CUSTNAME, COUNT(*) as no_of_orders,AVG(O.order_amount) as AVG_ORDER_AMT FROM CUSTOMER C, ORDERS O WHERE C.cust_no=O.cust_no GROUP BY C.CNAME;

                                                     /*iv) List the order no for orders that were shipped from all warehouses that the company has in a specific city.*/

SELECT order_no FROM WAREHOUSE W, SHIPMENT S WHERE W.warehouse_no=S.warehouse_no AND CITY='BANGALORE';


                                                    /*v) Demonstrate how you delete item no 10 from the ITEM table and make that field null in the ORDER_ITEM table.*/

delete from ITEM where item_no=10;
select *from ITEM;
select *from ORDER_ITEM;

                                                    /*Vi)For each itemid List out all the details of Order Id ,Shipment details and its average price.*/
                                                    
select i.item_no, o.order_no , s.* ,avg(i.unit_price) from item i join order_item o on i.item_no = o.item_no join shipment s on o.order_no = s.order_no group by i.item_no;