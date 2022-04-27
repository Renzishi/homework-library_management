create database bookstore;
use bookstore;

CREATE TABLE `book` (
  `name` varchar(255) DEFAULT NULL,
  `number` int NOT NULL,
  `borrowed` tinyint DEFAULT '0',
  `remain` int DEFAULT '1',
  primary key(`number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

insert into book value ("CS:APP", 1001, true, 2);
insert into book value ("C", 1002, true, 3);
insert into book value ("C++", 1003, true, 1);
insert into book value ("JAVA", 1004, false, 1);

CREATE TABLE `admin` (
  `account` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  primary key(`account`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

insert into admin value ("root", MD5("admin"));
insert into admin value ("admin", MD5("admin"));

