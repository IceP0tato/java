#Comment
-- Comment
/*
Comment
*/

# 데이터베이스가 저장된 로컬 경로 확인
show variables like 'datadir';
# 데이터베이스 생성
create database mydb0714;
# 데이터베이스 삭제
drop database mydb0714;
drop database if exists mydb0714;
# db 서버 내 데이터베이스 목록 확인
show databases;
# 데이터베이스 활성화
use mydb0714;

