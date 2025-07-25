drop database if exists mydb0724;
create database mydb0724;
use mydb0724;

create table table1(
	num_pk int,
    constraint primary key(num_pk)
);

create table table2(
	no_pk int,
    constraint primary key(no_pk),
    num_fk int,
    constraint foreign key(num_fk) references table1(num_pk) on delete cascade on update cascade
    -- num_pk 외래키
    # on update/delete cascade : 참조중인 레코드가 수정/삭제되면 같이 수정/삭제
    # on update/delete set null : 참조중인 레코드가 수정/삭제되면 fk 값을 null로 지정
    # on update/delete restrict : (기본값) 참조중인 레코드가 수정/삭제될 수 없게 설정
);

insert into table1 values(1), (2), (3), (4), (5);
insert into table2 values(1, 1), (2, 2), (3, 1), (4, 1), (5, 2);
select * from table1;
select * from table2;

# 서로 다른 테이블 합치기
# 두 개 이상의 테이블 조회 (데카르트 곱 -> 5*5 = 25개 레코드 조회)
select * from table1, table2;

# 교집합 (5개 레코드 조회) - join과 조건절 구분이 어려움
select * from table1, table2 where table1.num_pk = table2.num_fk;

# inner join
# where 일반조건, having 그룹조건, on 집합조건
select * from table1 inner join table2 on table1.num_pk = table2.num_fk;
select * from table1 join table2 on table1.num_pk = table2.num_fk; -- inner 생략 가능
select * from table1 as t1 join table2 t2 on t1.num_pk = t2.num_fk; -- 별칭 사용 가능
select t1.num_pk as 식별키, t2.num_fk 참조키 from table1 t1 inner join table2 t2 on t1.num_pk = t2.num_fk;

# natural join : pk와 fk 속성명이 일치할 때만 가능 (의도와 다르게 동일한 속성명이 존재할 수 있으므로 비권장)
select * from table1 natural join table2;
select * from table1 join table2 using(num_pk);

# outer join
# left : 왼쪽 테이블 (t1)에 있는 모든 레코드와 오른쪽 테이블 (t2)에 교집합 되는 레코드 조회
# left : 오른쪽 테이블 (t2)에 있는 모든 레코드와 왼쪽 테이블 (t1)에 교집합 되는 레코드 조회
select * from table1 t1 left outer join table2 t2 on t1.num_pk = t2.num_fk;
select * from table1 t1 right outer join table2 t2 on t1.num_pk = t2.num_fk;
select * from table1 t1 left join table2 t2 on t1.num_pk = t2.num_fk; -- outer 생략 가능

# 합집합 ([mysql] union, [oracle] full outer join)
# union : 2개 이상의 select를 하나로 합치기 (left outer + (union) + right outer)
select * from table1 t1 left join table2 t2 on t1.num_pk = t2.num_fk union
select * from table1 t1 right join table2 t2 on t1.num_pk = t2.num_fk;

# 차집합 (left outer join에서 교집합 제외)
select * from table1 t1 left join table2 t2 on t1.num_pk = t2.num_fk where t2.num_fk is null;
select * from table1 t1 right join table2 t2 on t1.num_pk = t2.num_fk where t1.num_pk is null;

/*
	교집합 : 두 테이블 간의 테이블 A의 PK 레코드와 테이블 B의 FK 값이 동일한 레코드를 하나의 테이블로 조회
		where, inner join on, join on, natural join, join using
    차집합 : 두 테이블 간의 테이블 A의 레코드를 제외한 테이블 B의 레코드 조회
		outer join ~ on ~ where is null
    합집합 : 두 테이블 간의 모든 레코드를 하나의 테이블로 조회
		oracle db : full outer join
        mysql db : left outer join union right outer join
*/