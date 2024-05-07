-- 은행 프로젝트에서 나올 수 있는 테이블들 생각해보기!!!

-- 테이블 2개 정도 ...
    create table bank(
        account int primary key
    );

    create table account(
        account_number int primary key,
        holder_name varchar(50),
                    check (CHAR_LENGTH(holder_name) = 3)
    );

    insert into account() values (0033,'ffe');

    select * from account;

-- 생성할때 제약조건...
-- 입력, 수정, 삭제를 연습해보세요.

-- DML (insert,update,delete)이 시작될때 자동으로 트랜잭션이 시작...
-- insert 10 건

-- update 5 건 실행