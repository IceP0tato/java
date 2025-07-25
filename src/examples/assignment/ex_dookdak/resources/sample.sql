drop database if exists dookdak;
create database dookdak;
use dookdak;

create table product(
	pId int auto_increment,
    pUser varchar(10) not null,
    pName varchar(30) not null,
    pDesc text not null,
    pPrice int not null,
    pPw varchar(20) not null,
    isSold boolean default false,
    pDate date default (current_date()),
    constraint primary key(pId)
);
create table question(
	qId int auto_increment,
    pId int not null,
    qUser varchar(10) not null,
    qDesc text not null,
    qPw varchar(20) not null,
    qDate date default (current_date()),
    constraint primary key(qId),
    constraint foreign key(pId) references product(pId)
);

drop table product;
drop table question;

# sample
INSERT INTO product (pUser, pName, pDesc, pPrice, pPw, isSold, pDate) VALUES
('김하린', '텀블러', '하얀색 세라믹 텀블러, 350ml 용량입니다.', 3000, 'Harin@321', false, '2025-07-24'),
('이준호', '에코백', '캔버스 소재의 감성 에코백입니다.', 5200, 'Junho#88', true, '2025-07-23'),
('박지민', '수세미', '천연 수세미 2개 세트, 설거지용으로 적합.', 800, 'JMin_09!', false, '2025-07-22'),
('최예린', '손소독제', '향이 은은한 젤 타입 소독제입니다.', 1800, 'Yer!n2025', true, '2025-07-22'),
('정현우', '유리병', '밀폐 가능한 작은 유리병 세트.', 1500, 'Woohyun33$', false, '2025-07-21'),
('윤지수', '메모지', '일러스트가 그려진 귀여운 메모지 100매입.', 700, 'YJsoo#123', false, '2025-07-20'),
('강도윤', '마스킹테이프', '다이어리 꾸미기에 좋은 패턴 테이프입니다.', 1100, 'DoYun_78!', true, '2025-07-19'),
('안도현', '티스푼세트', '스테인리스 소재 티스푼 4종 세트.', 3200, 'AhnDH@44', false, '2025-07-18'),
('조민재', '재사용 빨대', '실리콘 재질, 다양한 색상 세트입니다.', 2400, 'Minjae99!', false, '2025-07-17'),
('백지현', '머그컵', '감성 일러스트가 새겨진 도자기 머그컵.', 2500, 'JiHyun@91', true, '2025-07-16');
INSERT INTO question (pId, qUser, qDesc, qPw, qDate) VALUES
(1, '김하린', '텀블러 색상은 몇 가지인가요?', 'Harin@321', '2025-07-24'),
(3, '이준호', '에코백은 손잡이가 튼튼한가요?', 'Junho_88!', '2025-07-23'),
(2, '박지민', '향균비누 재입고 예정 있나요?', 'Jimin#04', '2025-07-22'),
(1, '최예린', '텀블러 보온 기능도 있나요?', 'Yerin!999', '2025-07-22'),
(3, '정현우', '칫솔은 몇 개 구성인가요?', 'HyunWoo12$', '2025-07-21'),
(1, '윤지수', '텀블러 세척이 편한가요?', 'YJisu_77', '2025-07-20'),
(3, '강도윤', '칫솔 색상 선택 가능한가요?', 'DoYun@21', '2025-07-19'),
(2, '안도현', '향균비누는 어떤 향인가요?', 'Dohyun#33', '2025-07-18'),
(1, '조민재', '텀블러 포장은 어떻게 되어 있나요?', 'Minjae88!', '2025-07-17'),
(3, '백지현', '칫솔모는 부드러운 편인가요?', 'JiHyun!1102', '2025-07-16');

select * from product;
select pUser, count(pUser) from product group by pUser order by count(pUser) desc limit 10;
select * from product where pName like '%텀%' or pDesc like '%텀%';
select * from question;

delete from product where pId = 13;
select * from product where pId = 11 and pPw = 123;
update product set pUser = "test", pName = "test2" where pId = 11;
select * from question join product on question.pId = product.pId where question.pId = 1;