create database mydb0715;
use mydb0715;

# 데이터베이스 안에 테이블 생성
create table test1( field1 int );
# 데이터베이스 내 테이블 목록 확인
show tables;

create table test2(field1 int, field2 double);
# 테이블 삭제
drop table test1;
drop table if exists test1;

create table test3(
	integer1 tinyint, integer2 smallint, integer3 mediumint,
    integer4 int, integer5 bigint, integer6 int unsigned,
    float1 float, float2 double, float3 decimal,
    date1 date, date2 time, date3 datetime,
    char1 char(3), char2 varchar(3),
    char3 text, char4 longtext,
    bool1 bool
);
show tables;
# 테이블 전체 조회
select * from test3;

create table board(
	content longtext,
    writer varchar(30)
);
select * from board;

create table waiting(
	phone char(13),
    count tinyint
);
select * from waiting;

create table test4(
	field1 tinyint not null,
    field2 smallint unique,
    field3 int default 10,
    field4 bigint auto_increment,
    constraint primary key(field4)
);
select * from test4;

create table test5(
	field1 bigint,
    constraint foreign key(field1) references test4(field4)
    # 두 속성의 타입이 일치해야 함
);
select * from test5;

drop database if exists boardService0715;
create database boardService0715;
use boardService0715;
create table member(
	mno int auto_increment,
    mid varchar(30) not null unique,
    mpwd varchar(30) not null,
    mname varchar(10),
    constraint primary key(mno)
);
select * from member;
create table board(
	bno int auto_increment,
    btitle varchar(100) not null,
    bcontent longtext,
    bdate datetime default now(),
    bview int default 0,
    constraint primary key(bno),
    mno int,
    constraint foreign key(mno) references member(mno)
);
select * from board;

/* [제약조건]
not null: null 값을 저장하지 않음
unique: 중복 값을 허용하지 않음
default 값: 값 생략 시 기본값으로 초기화
auto_increment: [MySQL] 순서대로 자동 번호 초기화
primary key: 기본/식별키(PK), 식별 가능한 고유 값 필드 키, unique not null
	선언) constraint primary key(필드명);
foreign key: 참조/외래키(FK), 다른 테이블의 기본키(PK) 참조
	선언) constraint foreign key(FK필드명) references 참조할테이블명(잠초할필드명); */

/* [데이터 타입]
정수
tinyint 1바이트 | -128 ~ 127
smallint 2바이트 | ~ +-3만
mediumint 3바이트 | ~ +-800만
int 4바이트 | ~ +-21억
bigint 8바이트 | ~ +-21억 이상
(unsigned: 부호가 없음)
(int unsigned: 42억까지 (음수가 없음))

실수
float 4바이트 | 소수점
double 8바이트 | 소수점
decimal 문자타입 | 소수점을 문자로 처리 (오차 없음)

날짜/시간
date 날짜 | 2025-07-15
time 시간 | 10:02:30
datetime 날짜/시간표현 | 2025-07-15 10:02:30

문자
char(길이) 문자열표현 | 고정 길이 (char(5) -> "유재석" --> [유][재][석][][])
varchar(길이) 문자열표현 | 가변 길이 (varchar(5) -> "유재석" --> [유][재][석])
text 문자열표현 | 고정 길이 (최대 6만 자)
longtext 문자열표현 | 최대 42억 자 (4GB 대용량)

논리
bool 논리표현 | true or false */