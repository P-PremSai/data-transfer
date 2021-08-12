create database movie;

use movie;

create table actor
(
 act_id int,
 act_name varchar(30),
 act_gender varchar(6),
 primary key(act_id)
 );
 
create table director
(
 dir_id int,
 dir_name varchar(30),
 dir_phone varchar(15),
 primary key(dir_id)
 );
 
create table movies
(
 mov_id int,
 mov_title varchar(30),
 mov_year year,
 mov_lang varchar(20),
 dir_id int,
 primary key(mov_id)
 );
 
create table movie_cast
(
 act_id int,
 mov_id int,
 role varchar(30),
 foreign key(act_id) references actor(act_id) on delete cascade on update cascade,
 foreign key(mov_id) references movies(mov_id) on delete cascade on update cascade
 );
 
create table rating 
(
 mov_id int,
 rev_stars float
 );
 
 show tables;
 alter table rating add check(rev_stars>=0 and rev_stars<=5);
 
 
insert into actor(act_id,act_name,act_gender)
values
     (1,'Tom Hanks','Male'),
     (2,'Tippi Hedren','Female'),
     (3,'Sean Connery','Male'),
     (4,'Tom Cruise','Male');
     
insert into director(dir_id,dir_name,dir_phone)
values
	(101,'Steven Spielberg','9645127843'),
    (102,'Hitchcock','8563472761'),
    (103,'Christopher','9487613754');
    
insert into movies(mov_id,mov_title,mov_year,mov_lang,dir_id)
values
      (201,'The Terminal',2004,'English',101),
      (202,'Marine',1964,'English',102),
      (203,'The Birds',1963,'English',102),
      (204,'Jack Reacher',2012,'English',103);
      
insert into movie_cast(act_id,mov_id,role)
values
      (1,201,'Hero'),
      (2,203,'Heroine'),
      (3,202,'Hero'),
      (2,202,'Heroine'),
      (4,204,'Hero');
      
insert into rating(mov_id,rev_stars)
values
      (201,4.0),
      (202,3.5),
      (204,4.9),
      (204,4.1),
      (204,4.4);
      
      
      insert into movies values(205,'The Birds 2',2017,'English',103);
      insert into movie_cast values(2,205,'Hero');
                                                 /*1. List the titles of all movies directed by ‘Hitchcock’.*/
	select m.mov_title from movies m join director d on m.dir_id =d.dir_id where d.dir_name ='Hitchcock' ;
    
												/*2. Find the movie names where one or more actors acted in two or more movies.*/
    /* select act_id,count(mov_id) from movie_cast  group by act_id having count(mov_id)>=2;*/
     select m.mov_title from movies m join movie_cast c on m.mov_id =c.mov_id  where c.act_id in (select act_id from movie_cast  group by act_id having count(mov_id)>=2);
     
     /*3. List all actors who acted in a movie before 2000 and also in a movie after 2015 (use JOIN operation).*/
     
     select distinct a1.act_name from actor a1 join movie_cast c1 on a1.act_id =c1.act_id join movies m1 on c1.mov_id =m1.mov_id, 
     actor a2 join movie_cast c2 on a2.act_id =c2.act_id join movies m2 on c2.mov_id =m2.mov_id where m1.mov_year<2000 and m2.mov_year>2015 and a1.act_id =a2.act_id;
     /*creating two join tables for different years */
     
     /*4. Find the title of movies and number of stars for each movie that has at least one rating and find the highest number of stars that movie received. Sort the result by movie title.*/
    
    select  m.mov_title,max(r.rev_stars)  from movies m join rating r on m.mov_id =r.mov_id group by m.mov_id order by m.mov_title;
    
    /*5. Update rating of all movies directed by ‘Steven Spielberg’ to 5*/
    
    update rating  set rating.rev_stars =5.0 where rating.mov_id in (select m.mov_id from movies m  join director d on m.dir_id = d.dir_id where d.dir_name ='Steven Spielberg');
    
    select * from rating;
    
    
    
    