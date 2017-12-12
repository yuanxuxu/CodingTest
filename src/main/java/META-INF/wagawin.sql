use test;

drop table if exists person;
CREATE TABLE person
(
   id int PRIMARY KEY NOT NULL AUTO_INCREMENT,
   name varchar(100) NOT NULL,
   age int NOT NULL
)ENGINE=InnoDB;

drop table if exists child;
CREATE TABLE child
(
   id int PRIMARY KEY NOT NULL AUTO_INCREMENT,
   name varchar(100) NOT NULL,
   age int NOT NULL,
   person_id int not null,
   sex VARCHAR(100) not null,
   hairColor VARCHAR(100),
   bicyclColor VARCHAR(100),
   FOREIGN key (person_id) references person(id)
   on delete no action on update no action
)ENGINE=InnoDB;

drop table if exists meal;
CREATE TABLE meal
(
   id int PRIMARY KEY NOT NULL AUTO_INCREMENT,
   name varchar(100) NOT NULL,
   invented date NULL,
   child_id int not null,
   foreign key (child_id) references child(id)
)ENGINE=InnoDB;

drop table if exists house;
CREATE TABLE house
(
   id int PRIMARY KEY NOT NULL AUTO_INCREMENT,
   address varchar(100) NOT NULL,
   zipCode varchar(100) NOT NULL,
   type varchar(100) not null,
   foreign key (id) references person(id)
)ENGINE=InnoDB;
