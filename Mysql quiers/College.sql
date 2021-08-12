/*Consider the schema for College Database:
STUDENT(USN, SName, Address, Phone, Gender) 
SEMSEC(SSID, Sem, Sec) 
CLASS(USN, SSID) 
SUBJECT(Subcode, Title, Sem, Credits) 
IAMARKS(USN, Subcode, SSID, Test1, Test2, Test3, FinalIA) 
Write SQL queries to
i. List all the student details studying in fourth semester ‘C’ section. 
ii. Compute the total number of male and female students in each semester and in each section. 
iii. Create a view of Test1 marks of student USN ‘1BI15CS101’ in all subjects. 
iv. Calculate the FinalIA (average of best two test marks) and update the corresponding table for all students.
v. Categorize students based on the following criterion: 
If FinalIA = 17 to 20 then CAT = ‘Outstanding’ 
If FinalIA = 12 to 16 then CAT = ‘Average’
If FinalIA< 12 then CAT = ‘Weak’ 
Give these details only for 8th semester A, B, and C section students.*/

create database college;

use college;

create table STUDENT
(
 USN varchar(10),
 SName varchar(30),
 Address varchar(100),
 Phone bigint,
 Gender varchar(6),
 primary key(USN)
 );
 
create table SEMSEC
(
 SSID int,
 Sem int,
 Sec varchar(1),
 primary key(SSID)
 );
 
create table CLASS
(
 USN varchar(10) unique,
 SSID int,
 foreign key(USN) references student(USN) on delete cascade on update cascade,
 foreign key(SSID) references semsec(SSID) on delete cascade on update cascade
 );
 
create table SUBJECT
(
 Subcode varchar(10),
 Title varchar(30),
 Sem int,
 Credits int,
 primary key(Subcode)
 );
 
create table IAMARKS
(
 USN varchar(10),
 Subcode varchar(10),
 SSID int,
 Test1 float check(test1>=0 and test1<=20),
 Test2 float check(test2>=0 and test2<=20), 
 Test3 float check(test3>=0 and test3<=20), 
 FinalIA float check(FinalIA>=0 and FinalIA<=20),
 foreign key(USN) references student(USN) on delete cascade on update cascade,
 foreign key(Subcode) references subject(Subcode) on delete cascade on update cascade,
 foreign key(SSID) references semsec(SSID) on delete cascade on update cascade
 ) ;
 
insert into STUDENT(USN, SName, Address, Phone, Gender) 
values
     ('1BI15CS101','Arun','Bangalore','9346597210','Male'),
     ('1BM19CS109','Prem Sai','2/60,Yanakallu(V),Bramhasamudram(M),Ananthapur(Dis),Andhra Pradesh-515763','9440450120','Male'),
     ('1BM19CS107','Nithish','Thumkur','9985442261','Male'),
     ('1BM19CS102','Nikhil','Chikbalapur','9908585115','Male'),
     ('1BM17CS095','Ramya','Bangalore','9492137365','Female'),
     ('1BM17CS119','Raji','Delhi','9578412369','Female'),
     ('1BM19CS120','Ram','Mumbai','9508595115','Male'),
     ('1BM19CS145','Swathi','Hyderabad','9852585145','Female');
     
     update student set usn ='1BM19CS102' where usn ='1BM19cs102';

insert into SEMSEC(SSID, Sem, Sec) 
values
	(1,4,'C'),
    (2,8,'A'),
    (3,8,'B'),
    (4,4,'A'),
    (5,4,'B'),
    (6,8,'C');
    
insert into CLASS(USN, SSID) 
values
     ('1BI15CS101',2),
     ('1BM19CS109',5),
     ('1BM19CS107',4),
     ('1BM19CS102',1),
     ('1BM17CS095',3),
     ('1BM17CS119',6),
     ('1BM19CS120',5),
     ('1BM19CS145',5);
     
insert into SUBJECT (Subcode, Title, Sem, Credits) 
values 
      ('19CS4PCDBM','DBMS',4,4),
	  ('19CS4PCADA','ADA',4,4),
	  ('19CS8PCDOT','DOT',8,5),
	  ('19CS8PCBZC','BZC',8,3),
	  ('19CS8PCAXC','AXC',8,5);
      
      update subject set credits =15 where Subcode ='19CS8PCAXC';
insert into IAMARKS(USN, Subcode, SSID, Test1, Test2, Test3, FinalIA) 
values
     ('1BI15CS101','19CS8PCDOT',2,17,19,19.5,12),
     ('1BI15CS101','19CS8PCBZC',2,19,18.5,20,12),
     ('1BI15CS101','19CS8PCAXC',2,12,15,19,12),
     ('1BM17CS095','19CS8PCBZC',3,10.25,12,15,12),
     ('1BM17CS119','19CS8PCAXC',6,12,9.5,18,12),
     ('1BM19CS109','19CS4PCDBM',5,18.25,19,20,12),
     ('1BM19CS102','19CS4PCADA',1,19,20,18.25,12),
     ('1BM19CS107','19CS4PCDBM',4,20,20,19,12);
     
select * from STUDENT;
select * from SEMSEC;
select * from CLASS;
select * from SUBJECT;
select * from IAMARKS;
     
                     /*i. List all the student details studying in fourth semester ‘C’ section. */
                     
select s.* from student s 
join class c on s.usn = c.usn 
join semsec ss on c.ssid =ss.ssid 
where ss.sem =4 and sec ='C';

                    /*ii. Compute the total number of male and female students in each semester and in each section. */
                    
select ss.sem,ss.sec,s.gender,count(s.gender) as count from student s 
join class c on s.usn =c.usn 
join semsec ss on c.ssid = ss.ssid  
group by ss.sem,ss.sec,s.gender;

				/*iii. Create a view of Test1 marks of student USN ‘1BI15CS101’ in all subjects. */
           
create view Test1_marks 
as select subcode,Test1 from IAMarks 
where usn ='1BI15CS101';

select * from Test1_marks;

                 /*iv. Calculate the FinalIA (average of best two test marks) and update the corresponding table for all students.*/
update IAMarks set FinalIA = 
case when  (test1+test2)/2 >=(test2+test3)/2 and (test1+test2)/2 >=(test1+test3)/2 
                     then (test1+test2)/2
when (test2+test3)/2>=(test1+test3)/2  and (test2+test3)/2>=(test1+test2)/2 
					 then (test2+test3)/2
else (test1+test3)/2
end ;

select * from IAMarks;

			/*v. Categorize students based on the following criterion: 
                       If FinalIA = 17 to 20 then CAT = ‘Outstanding’ 
                       If FinalIA = 12 to 16 then CAT = ‘Average’
                       If FinalIA< 12 then CAT = ‘Weak’ 
                 Give these details only for 8th semester A, B, and C section students.*/
                 
select usn,subcode,FinalIA,
case when FinalIA>=17 and FinalIA<=20 
          then 'Outstanding' 
when FinalIA >=12 and FinalIA<17 
		  then 'Average'
else 'Weak' 
end as CAT
from IAMarks m 
join semsec ss on m.ssid =ss.ssid 
where ss.sem =8 
and (ss.sec ='B' OR SS.SEC= 'A' OR SS.SEC ='C');

                           /*EXTRA QUIRES */
                           
                           /*List all the student details whose final marks is greater than 45/50 */
                           
select distinct s.* from student s join IAMarks i on s.usn =i.usn where (i.FinalIA*2.5) > 45;

                           /*Display the Test1,Test2,Test3 and FinalIA marks of the student course wise*/
                           
select  subcode,Test1,Test2,Test3,FinalIA from IAMarks  where usn ="1BI15CS101";

                           /*Demonstrate the use of views with suitable examples*/
                           
                           /*5.List all the Student details who have taken a maximum credit of 20 for that particular sem.*/
                           
select * from student where usn in (select i.usn from IAMarks i join subject s on i.Subcode =s.Subcode group by i.usn having sum(credits) <=20);

