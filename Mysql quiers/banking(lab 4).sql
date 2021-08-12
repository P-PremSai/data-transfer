create database banking;

use banking;

create table branch
(
 branch_name varchar(30),
 branch_city varchar(20),
 assets real,
 primary key(branch_name)
 );
 
create table accounts
(
 accno int,
 branch_name varchar(30),
 balance real,
 primary key(accno),
 foreign key(branch_name) references branch(branch_name) on delete cascade on update cascade
 );
 
create table customer
(
 customer_name varchar(30),
 customer_street varchar(30),
 customer_city varchar(20),
 primary key(customer_name)
 );
 
create table depositor
(
customer_name varchar(30),
accno int,
primary key(customer_name ,accno),
foreign key (accno) references accounts(accno) on delete cascade on update cascade,
foreign key (customer_name) references customer(customer_name) on delete cascade on update cascade
);

create table loan
(
 loan_number int,
 branch_name varchar(30),
 amount real,
 primary key(loan_number),
 foreign key (branch_name) references branch(branch_name) 
 );
 
create table borrower
(
 customer_name varchar(30),
 loan_number int,
 primary key(customer_name, loan_number),
 foreign key(customer_name) references customer(customer_name) on delete cascade on update cascade,
 foreign key (loan_number) references loan(loan_number) on delete cascade on update cascade
 );

insert into branch(branch_name,branch_city,assets)
values
     ('SBI PD NAGAR' ,'BANGALORE',200000),
     ('SBI RAJAJI NAGAR','BANGALORE',500000),
	 ('SBI JAYANAGAR','BANGALORE',660000),
	 ('SBI VIJAY NAGAR','BANGALORE',870000),
	 ('SBI HOSAKEREHALLI','BANGALORE',550000);
commit;

 insert into accounts(accno,branch_name,balance)
 values
      (1234602,'SBI HOSAKEREHALLI',5000),
	  (1234603,'SBI VIJAY NAGAR',5000),
      (1234604,'SBI JAYANAGAR',5000),
      (1234605,'SBI RAJAJI NAGAR',10000),
      (1234503,'SBI VIJAY NAGAR',40000),
      (1234504,'SBI PD NAGAR',4000),
      (1234505,'SBI VIJAY NAGAR',20000),
      (1234506,'SBI PD NAGAR',9000),
      (1234606,'SBI VIJAY NAGAR',14000),
      (1234607,'SBI JAYANAGAR',36000),
      (1234608,'SBI PD NAGAR',15000);
commit;

insert into customer(customer_name,customer_street,customer_city)
values
      ('KEZAR','M G ROAD','BANGALORE'),
      ('LAL KRISHNA','ST MKS ROAD','BANGALORE'),
	  ('RAHUL','AUGSTEN ROAD','BANGALORE'),
	  ('LALLU','V S ROAD','BANGALORE'),
	  ('FAIZAL','RESEDENCY ROAD','BANGALORE'),
      ('RAJEEV','DICKNSN ROAD','BANGALORE');
commit;
 
insert into depositor(customer_name,accno)
values
     ('KEZAR',1234602),
     ('KEZAR',1234605),
     ('LAL KRISHNA',1234604),
     ('RAHUL',1234603),
     ('RAHUL',1234503),
     ('LALLU',1234504),
     ('FAIZAL',1234505),
     ('RAJEEV',1234506),
     ('KEZAR',1234606),
     ('KEZAR',1234607),
     ('KEZAR',1234608);
     
insert into loan(loan_number,branch_name,amount)
values
     (10011,'SBI JAYANAGAR',10000),
     (10012,'SBI VIJAY NAGAR',5000),
	 (10013,'SBI HOSAKEREHALLI',20000),
     (10014,'SBI PD NAGAR',15000),
     (10015,'SBI RAJAJI NAGAR',25000);
commit;

insert into borrower(customer_name,loan_number)
values
     ('KEZAR',10011),
     ('LAL KRISHNA',10012),
	 ('RAHUL',10013),
     ('LALLU',10014),
     ('LAL KRISHNA',10015);
commit;

select * from  branch;
select * from  accounts;
select * from  customer;
select * from  depositor;
select * from  loan;
select * from  borrower;

                   /*Find all the customers who have at least two accounts at the Main branch.   */
select customer_name from depositor A join accounts B on A.accno=B.accno where B.branch_name ="SBI VIJAY NAGAR" group by A.customer_name having count(A.customer_name)>=2;
                   
                   
                   /*Find all the customers who have an account at all the branches located in a specific city. */
select customer_name from depositor A join accounts B on A.accno=B.accno join branch C on B.branch_name=C.branch_name where C.branch_city="Bangalore" group by A.customer_name having count(distinct C.branch_name) =(select count(branch_name) from branch where branch_city="Bangalore");
				
                
                /* Demonstrate how you delete all account tuples at every branch located in a specific city.  */
delete from accounts where branch_name in (select branch_name from branch where branch_city="Delhi");


				  /*Generate suitable reports.   */
				 /*Create suitable front end for querying and displaying the results.    */