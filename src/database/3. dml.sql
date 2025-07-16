drop database if exists mydb0716;
create database mydb0716;
use mydb0716;

create table test(
	mno int auto_increment,
    mname varchar(30) not null unique,
    mcount int default 2,
    constraint primary key(mno)
);

# 레코드 삽입 (insert into ~ values ~)
insert into test(mno, mname, mcount) values (1, "유재석", 30);
insert into test(mcount, mno, mname) values (40, 2, "강호동");
insert into test(mcount, mname) values (50, "신동엽");
insert into test(mname) values ("서장훈");
insert into test(mno, mcount) values (5, 40); -- Err: no default value
insert into test(mname) values ("유재석"); -- Err: duplicate key
insert into test values (5, "하하", 10);
insert into test values (6, "박명수", 50), (7, "박명수2", 60);

# 레코드 조회 (select ~ from ~ [where ~])
select * from test;
select mname, mcount, mno from test;
select * from test where mname = "유재석";
select * from test where mno = 3;

# 레코드 수정 (update ~ set ~ [where ~])
update test set mcount = 0; -- Err: safe update mode
set SQL_SAFE_UPDATES = 0; -- safeMode config
update test set mcount = 10 where mname = "유재석";
update test set mcount = 20, mname = "강호동2" where mno = 2;

# 레코드 삭제 (delete from ~ [where ~])
delete from test where mno = 2;
delete from test; -- Err: safe update mode