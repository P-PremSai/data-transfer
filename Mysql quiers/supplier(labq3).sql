create database supplier;
use supplier;

create table suppliers(
sid int,
sname  varchar(30),
saddress varchar(30),
primary key(sid)
);

create table parts(
pid int,
pname varchar(30),
color varchar(30),
primary key(pid)
);

create table catalog(
sid int,
pid int,
cost real,
foreign key(sid)references suppliers(sid)on delete cascade on update cascade,
foreign key(pid)references parts(pid)on delete cascade on update cascade
);

insert into suppliers values(11,"niti","m g road");
insert into suppliers values(22,"prem","chruch street");
insert into suppliers values(33,"nikil","jayanagar");
insert into suppliers values(44,"harsha","gokulnagar");
insert into suppliers values(55,"noor","j p nagar");
insert into suppliers values(66,"niharika","basavanagudi");
select *from suppliers;

insert into parts values(001,"pen","red");
insert into parts values(002,"pencil","blue");
insert into parts values(003,"eraser","red");
insert into parts values(004,"calculator","green");
insert into parts values(005,"scale","pink");
insert into parts values(006,"sharpner","black");
select * from parts;

insert into catalog values(11,001,5000);
insert into catalog values(22,002,10000);
insert into catalog values(33,003,8000);
insert into catalog values(44,004,70000);
insert into catalog values(55,005,50000);
insert into catalog values(66,006,22000);
select *from catalog;

/*iii--*/

alter table suppliers add mobile_no int;
select *from suppliers;

/*iv--*/
delete from parts where color="pink";
select *from parts;


/*v-*/
select s.sname from suppliers s join catalog c on s.sid = c.sid join parts p on p.pid = c.pid where p.color ="red" and c.cost<10000;
              /*or*/
select s.sname from suppliers s where s.sid in
(select c.sid from catalog c,parts p where p.pid=c.pid and p.color="red" and c.cost<10000);