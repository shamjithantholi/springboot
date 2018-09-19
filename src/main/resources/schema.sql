create table Employee
(
   empid integer,
   empname varchar(255) not null,
   salary integer not null,
   department varchar(100) not null,
   create_date timestamp DEFAULT CURRENT_TIMESTAMP
);