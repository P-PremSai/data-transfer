/*Consider the following database of student enrollment in courses and books adopted for
each course.
STUDENT (regno(pk): String, name: String, major: String, bdate: date)
COURSE (course_no(pk): int, cname: String, dept: String)
ENROLL (regno(fk): String, course_no(fk): String, sem: int, marks: int)
BOOK_ADOPTION (course_no(fk): int, sem: int, book-ISBN: int)
TEXT(book-ISBN(pk):int, book-title: String, publisher:String, author:String)
i) Create the above tables by properly specifying the primary keys and the foreign keys.
ii) Enter at least five tuples for each relation.
iii) Demonstrate how you add a new text book to the database and make this book be
adopted by some department.
iv) Produce a list of text books (include Course #, Book-ISBN, Book-title) in the
alphabetical order for courses offered by the ‘CS’ department that use more than two
books.
v) List any department that has all its adopted books published by a specific publisher.
vi.) Create a View which contains(Course, TotalBook-ISBN,Publisher)from the above
relation schemas.
vii.) Retrieve the Course Names where that Courses are Published by Springer Publisher.
*/


create database student_enrollment;

use student_enrollment;

create table student
(
 regno varchar(20),
 name varchar(20),
 major varchar(20),
 bdate date,
 primary key(regno)
 );
 
create table course 
(
 course_no int,
 cname varchar(20),
 dept varchar(20),
 primary key(course_no)
 );
 
create table enroll
( 
 regno varchar(20),
 course_no int,
 sem int,
 marks int,
 foreign key(regno) references student(regno) on delete cascade on update cascade,
 foreign key(course_no) references course(course_no) on delete cascade on update cascade
 );
 
create table book_adoption
(
 course_no int,
 sem int,
 book_ISBN int,
 foreign key(course_no) references course(course_no) on delete cascade on update cascade
 );
 
create table text 
( 
 book_ISBN int,
 book_title varchar(20),
 publisher varchar(20),
 author varchar(20),
 primary key(book_ISBN)
 );
 
insert into student(regno,name,major,bdate)
values
     ('CS01','RAM','DS','1986-03-12'),
	 ('IS02','SMITH','USP','1987-12-23'),
	 ('EC03','AHMED','SNS','1985-04-17'),
	 ('CS03','SNEHA','DBMS','1987-01-01'),
	 ('TC05','AKHILA','EC','1986-10-06');
     
insert into course(course_no,cname,dept)
values
	  (11,'DS','CS'),
      (22,'USP','IS'),
	  (33,'SNS','EC'),
	  (44,'DBMS','CS'),
      (55,'EC','TC');

insert into enroll(regno,course_no,sem,marks)
values
      ('CS01',11,4,85),
	  ('IS02',22,6,80),
      ('EC03',33,2,80),
      ('CS03',44,6,75),
	  ('TC05',55,2,8);

insert into book_adoption(course_no,sem,book_ISBN)
values
      (11,4,1),
      (11,4,2),
      (44,6,3),
      (44,6,4),
      (55,2,5),
	  (22,6,6);

insert into text(book_ISBN,book_title,publisher,author)
values
(1,'DS and C','Princeton','Padma Reddy'),
(2,'Fundamentals of DS','Princeton','Godse'),
(3,'Fundamentals of DBMS','Princeton','Navathe'),
(4,'SQL','Princeton','Foley'),
(5,'Electronic circuits','TMH','Elmasri'),
(6,'Adv unix prog','TMH','Stevens');
     
     
select * from student;
select * from course;
select * from enroll;
select * from text;
select * from book_adoption;

alter table book_adoption add foreign key(book_ISBN) references text(book_ISBN) on delete cascade on update cascade;

                             /*Demonstrate how you add a new text book to the database and make this book be adopted by some department.*/
                             
insert into text  values (7,'OS','THM','GACOBS');
insert into book_adoption values(11,4,7);
select * from text;
select * from book_adoption;

insert into text values (8,'Algorithm','Springer','Alpha');
insert into book_adoption values(11,4,8);
insert into book_adoption values(22,4,8);


                            /*Produce a list of text books (include Course_no, Book-ISBN, Book-title) in the alphabetical order for courses offered by the ‘CS’ department that use more than two books.*/
                            
 select c.course_no, b.book_ISBN, t.book_title from course c join book_adoption b on b.course_no = c.course_no  join text t on b.book_ISBN = t.book_ISBN where c.dept ="CS" and (select count(b.course_no) from book_adoption b where c.course_no =b.course_no)>=2 
 order by t.book_title asc;                    
 
                           /*List any department that has all its adopted books published by a specific publisher.*/
select distinct c.dept from course c join book_adoption ba on c.course_no=ba.course_no join text t on ba.book_ISBN=t.book_ISBN where t.publisher="Princeton";

                           /*vi.) Create a View which contains(Course, TotalBook-ISBN,Publisher)from the above relation schemas.*/

create view studentview as select c.*,t.book_ISBN,t.publisher from course c ,text t ,book_adoption b where t.book_ISBN = b.book_ISBN and b.course_no =c.course_no;
select * from studentview;

drop view studentview;
                           /*vii.) Retrieve the Course Names where that Courses are Published by Springer Publisher.*/
 select cname from course c join book_adoption b on c.course_no = b.course_no join text t on b.book_ISBN = t.book_ISBN  where t.publisher ='Springer';