drop database if exists library;
create database library;
use library;

create table member(
	mno int auto_increment,
    mid varchar(20) not null unique,
    mpw varchar(20) not null,
    mname varchar(10) not null,
    mphone varchar(13) not null unique,
    constraint primary key(mno)
);

create table book(
	bno int auto_increment,
    btitle varchar(30) not null,
    bwriter varchar(30) not null,
    constraint primary key(bno)
);

create table checkoutLog(
	cno int auto_increment,
    mno int not null,
    bno int not null unique,
    borrowDate datetime not null default now(),
    returnDate datetime,
    constraint primary key(cno),
    constraint foreign key(mno) references member(mno),
    constraint foreign key(bno) references book(bno)
);