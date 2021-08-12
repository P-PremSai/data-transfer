/*Consider the following database for student enrolment for course:
STUDENT (snum: integer, sname: string, major: string, level: string, age: integer) 
CLASS (name: string, meets at: time, room: string, fid: integer) 
ENROLLED (snum: integer, cname: string) 
FACULTY (fid: integer, fname: string, deptid: integer)
The meaning of these relations is straightforward; for example, Enrolled has one record per student-class pair such that the student is enrolled in the class. 
Level is a two character code with 4 different values (example:  Junior: JR etc)
Write the following queries in SQL. No duplicates should be printed in any of the answers.
i. Find the names of all Juniors (level = JR) who are enrolled in a class taught by 
ii. Find the names of all classes that either meet in room R128 or have five or more Students enrolled.
iii. Find the names of all students who are enrolled in two classes that meet at the same time.
iv. Find the names of faculty members who teach in every room in which some class is taught.
v. Find the names of faculty members for whom the combined enrolment of the courses that they teach is less 
than five.
vi. Find the names of students who are not enrolled in any class. 
vii. For each age value that appears in Students, find the level value that appears most often. For example, if 
there are more FR level students aged 18 than SR, JR, or SO students aged 18, you should print the pair (18, FR).*/

create database Student_Faculty;

use Student_Faculty;

create table STUDENT 
(
 snum int,
 sname varchar(30),
 major varchar(3),
 level varchar(2),
 age int,
 primary key(snum)
 );
 
create table CLASS 
(
 cname varchar(30),
 meets_at time,
 room varchar(30),
 fid int,
 primary key(cname),
 foreign key(fid) references FACULTY(fid) on delete cascade on update cascade 
 );
 
create table ENROLLED 
(
 snum int,
 cname varchar(30),
 foreign key(snum) references student(snum) on delete cascade on update cascade,
 foreign key(cname) references class(cname) on delete cascade on update cascade
 ) ;
 
create table FACULTY 
(
 fid int,
 fname varchar(30),
 deptid int,
 primary key(fid) 
 );

insert into STUDENT (snum, sname, major, level, age)
values
	(1,'Prem Sai','CS','FR',18),
    (2,'Nithish','CS','FR',18),
    (3,'Nikhil','CS','SR',17),
    (4,'Harsha','CS','SR',17),
    (5,'Tarun','CS','JR',16),
    (6,'Krishna','CS','JR',16),
    (7,'Larthik','CS','JR',17),
    (8,'Rohan','CV','FR',17);
    
insert into CLASS (cname, meets_at, room, fid) 
values
     ('DBMS','9:00','R128',101),
     ('ADA','9:00','R129',102),
     ('OS','11:00','R130',101),
     ('TFCS','12:00','R129',101),
     ('LA','14:00','R130',102);
     
insert into ENROLLED (snum, cname) 
values
     (1,'ADA'),
     (2,'ADA'),
     (3,'ADA'),
     (4,'ADA'),
     (5,'ADA'),
     (1,'DBMS'),
     (1,'OS'),
     (1,'TFCS'),
     (1,'LA');
     
insert into FACULTY (fid, fname, deptid)
values
      (101,'Vikranth',201),
      (102,'Rajeshwari',202);

select * from student;
select * from class;
select * from enrolled;
select * from faculty;

                                    /*i. Find the names of all Juniors (level = JR) who are enrolled in a class taught by Rajeshwari*/
                                    
select s.sname from student s join enrolled e on s.snum =e.snum join class c on e.cname = c.cname join faculty f on c.fid = f.fid where f.fname ='Rajeshwari' and s.level="JR";

									/*ii. Find the names of all classes that either meet in room R128 or have five or more Students enrolled.*/
                                    
select cname from class 
where room ='R128' or 
cname in (select cname  from enrolled 
     group by cname 
     having count(cname)>=5);

                                    /*iii. Find the names of all students who are enrolled in two classes that meet at the same time.*/
                                    
SELECT DISTINCT s.sname
FROM student s
WHERE s.snum IN (
SELECT e1.snum
	FROM enrolled e1,enrolled e2,class c1,class c2
	WHERE e1.snum=e2.snum   AND
		e1.cname<>e2.cname      AND
		e1.cname=c1.cname       AND
		e2.cname=c2.cname       AND
		c1.meets_at=c2.meets_at  );
        
                                     /*iv. Find the names of faculty members who teach in every room in which some class is taught.*/
                                     

select f.fname from faculty f 
where f.fid in 
(select c.fid from class c 
     group by fid 
     having count(distinct room) = 
           (select count(distinct room) from class )
);


/*# showing error as  except, don't know the reason
SELECT DISTINCT F.fname
FROM Faculty F
WHERE NOT EXISTS (( SELECT *
FROM Class C )
EXCEPT
(SELECT C1.room
FROM Class C1
WHERE C1.fid = F.fid ));*/

                                       /*v. Find the names of faculty members for whom the combined enrolment of the courses that they teach is less than five.*/
                                       
select f.fname from faculty f 
where f.fid in 
      (select fid from class c 
       where 
			(select count(snum) from enrolled e 
            join class c1 on e.cname = c1.cname 
            where c1.fid = f.fid 
            group by c.fid )<5
		);
        
        
                                     /*vi. Find the names of students who are not enrolled in any class.*/
                                     
select s.sname from student s 
where s.snum not in 
       (select distinct e.snum from enrolled e 
       where e.snum = s.snum);

								/*vii. For each age value that appears in Students, find the level value that appears most often. For example, if 
                                       there are more FR level students aged 18 than SR, JR, or SO students aged 18, you should print the pair (18, FR).*/
                                       
SELECT S.age, S.level FROM Student S 
GROUP BY S.age, S.level 
HAVING S.level IN 
		(SELECT S1.level FROM Student S1 
         WHERE S1.age = S.age 
         GROUP BY S1.level, S1.age 
         HAVING COUNT(S1.snum) >= ALL 
                    (SELECT COUNT(S2.snum) FROM Student S2 
                     WHERE s1.age = S2.age 
                     GROUP BY S2.level, S2.age)
		 );
                                       