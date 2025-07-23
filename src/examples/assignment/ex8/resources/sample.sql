drop database if exists exam08;
create database exam08;
use exam08;
create table list (
	num int auto_increment,
    phone varchar(20) not null,
    count int not null,
    constraint primary key(num)
);

select * from list;