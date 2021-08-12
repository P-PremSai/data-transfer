create database book_dealer;

use book_dealer;

create table author
(
 author_id int,
 name varchar(20),
 city varchar(20),
 country varchar(20),
 primary key(author_id)
 );
 
create table publisher
(
 publisher_id int,
 name varchar(20),
 city varchar(20),
 country varchar(20),
 primary key(publisher_id)
 );
 
create table catalog
(
 book_id int,
 title varchar(20),
 author_id int,
 publisher_id int,
 category_id int,
 year int,
 price int,
 primary key(book_id),
 foreign key(publisher_id) references publisher(publisher_id) on delete cascade,
 foreign key(category_id) references category(category_id) on delete cascade
 );
 
 create table category
 (
  category_id int,
  description varchar(100),
  primary key(category_id)
  );
  
create table order_details
(
 order_no int,
 book_id int,
 quantity int,
 primary key(order_no),
 foreign key(book_id) references catalog(book_id) on delete cascade
 );
 
insert into author(author_id,name,city,country)
values
     (1001,'TERAS CHAN','CA','USA'),
     (1002,'STEVENS','ZOMBI','UGANDA'),
     (1003,'M MANO','CAIR','CANADA'),
     (1004,'KARTHIK B.P.','NEW YORK','USA'),
     (1005,'WILLIAM STALLINGS','LAS VEGAS','USA');
     
insert into publisher(publisher_id,name,city,country)
values
    (1,'PEARSON','NEW YORK','USA'),
    (2,'EEE','NEW SOUTH VALES','USA'),
    (3,'PHI','DELHI','INDIA'),
    (4,'WILLEY','BERLIN','GERMANY'),
    (5,'MGH','NEW YORK','USA');
    
insert into category(category_id,description)
values
     (1001,'COMPUTER SCIENCE'),
     (1002,'ALGORITHM DESIGN'),
     (1003,'EECTRONICS'),
     (1004,'PROGRAMMING'),
     (1005,'OPERATING SYSTEMS');
     
insert into catalog(book_id,title,author_id,publisher_id,category_id,year,price)
values
     (11,'Unix System Prg',1001,1,1001,2000,251),
     (12,'Digital Signals',1002,2,1003,2001,425),
     (13,'Logic Design',1003,3,1002,1999,225),
     (14,'server Prg',1004,4,1004,2001,333),
     (15,'Linux Prg',1005,5,1005,2003,326),
     (16,'C++ Bible',1005,5,1001,2000,526),
     (17,'Cosol Handbook',1005,4,1001,2000,658);
     
insert into order_details(order_no,book_id,quantity)
values
     (1,11,5),
     (2,12,8),
     (3,13,15),
     (4,14,22),
     (5,15,3);
   /*  (2,17,10);*/
     
select * from author;
select * from publisher;
select * from category;
select * from catalog;
select * from order_details;

/*iii) Give the details of the authors who have 2 or more books in the catalog and the price of the books in the catalog and the year of publication is after 2000.*/

select a.author_id,a.name,a.city,a.country from author a join catalog c on a.author_id = c.author_id where c.year>2000 and (select count(c.author_id) from catalog c where c.author_id = a.author_id)>=2;

/*iv) Find the author of the book which has maximum sales.*/

select a.author_id,a.name,a.city,a.country from author a join catalog c on a.author_id = c.author_id join order_details d on d.book_id = c.book_id where d.quantity =(select max(d.quantity) from order_details d );

/*v) Demonstrate how you increase the price of books published by a specific publisher by 10%.*/
update catalog set price = price*1.10 where publisher_id = 2;
select * from catalog;