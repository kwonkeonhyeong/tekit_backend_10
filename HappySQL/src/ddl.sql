show tables;

-- Books
-- book_id : 책번호 (기본키)
-- title : 책제목
-- author : 저자이름
-- published_year : 출판연도

create table books
(
    book_id        int,
    title          varchar(100),
    author         varchar(50),
    published_year date
);
desc books;

drop table books;
select *
from books;


-- 데이터 입력
# insert into 테이블명 (컬럼명 리스트) values (값 리스트);  주의점. 반드시 컬럼리스트랑 값 리스트의 짝이 맞아야해요.
insert into books
values (1, '모두의 자바', '강경미', '2020-09-09');
insert into books(title)
values ('재밌는 sql');
insert into books(book_id, title)
values (10, 'test');
# insert into books(book_id,title) values (10);  -- 오류!!

create table books
(
    book_id        int primary key,
    title          varchar(100) not null,
    author         varchar(50),
    published_year date
);

create table books
(
    book_id        int primary key auto_increment,
    title          varchar(100) not null,
    author         varchar(50) default 'carami',
    published_year date
);
insert into books(title)
values ('재밌는 sql');
insert into books(title, author)
values ('sql 잘해봐요', default);
insert into books(author, title)
values ('강경미', 'test');
insert into books(title)
values ('sql 잘해봐요');

desc books;

drop table books;
select *
from books;
insert into books
values (1, '모두의 자바', '강경미', '2020-09-09');
# insert into books(title) values ('재밌는 sql');  --pk 가 null 이 올수 없으므로 오류!!!
insert into books(book_id, author, published_year)
values (3, '김길동', '2020-03-22');
-- 은행프로젝에서 나올 수 있는 테이블들 생각해보기!!

desc majors;
select *
from majors;
create table majors
(
    id         int primary key auto_increment,
    major_name varchar(100) not null
);

insert into majors(major_name)
values ('컴퓨터 과학');
insert into majors(major_name)
values ('수학');

drop table majors;
drop table students;

create table students
(
    id       int primary key,
    name     varchar(50) not null,
    email    varchar(100) unique,
    reg_date date default (current_date),
    major_id int,
    FOREIGN KEY (major_id) REFERENCES majors (id)
#                              on delete cascade # 부모키가 삭제될 때 같이 삭제됨.
        on delete set null, # 부모키가 삭제될 때 student의 major_id를 null로 바꿔줌.
    # update 도 on update cascade, on update set null 가능
    check ( email like '%@%.%')
);

SELECT @@AUTOCOMMIT;

insert into students(id, name, email, reg_date, major_id)
values (1, 'carami', 'carami@gmail.com', '2020-10-10', 1);
insert into students(id, name, email, major_id)
values (2, 'carami2', 'carami2@gmail.com', 1);
insert into students(id, name, email, reg_date, major_id)
values (3, 'carami3', 'carami3@gmail.com', default, 1);
insert into students(id, name, email, reg_date, major_id)
values (4, 'carami4', 'abd@f.fd', default, 1);

-- 수정
# update 테이블명 set 칼럼명 = 수정할 값, 칼럼명 = 수정할 값 ... -- 적절한 where을 사용하지 않으면 모든 데이터가 수정될 수 있다.
update books
set author = 'kang'
where book_id = 1;

-- 삭제
delete
from books
where author = 'kang'; -- 적절한 where을 사용하지 않으면 모든 데이터가 삭제됨.

select *
from books;
select *
from students;

-- 메뉴  (menu)
-- item_id : 메뉴아이템의 고유번호 (기본키)
-- item_name :  메뉴 아이템 이름
-- price : 가격
-- category : 예: 커피, 차 , 디저트

create table menu
(
    item_id   int primary key auto_increment,
    item_name varchar(100),
    price     int,
    category  varchar(50),
    check ( category in ('커피','차','디저트','음료') ),
    check ( price > 1500 and price < 10000 )
);

show tables;
desc menu;
drop table menu;
select *
from menu;

insert into menu(item_id, item_name, price, category)
values (3, '햄버거', 9000, '패스트푸드');
insert into menu(item_id, item_name, price, category)
values (4, '피자', 19000, '적당히패스트푸드');
insert into menu(item_name, price, category)
values ('라면', 1000, '매우패스트푸드');
insert into menu
values (5, '라면', 1000, '매우패스트푸드');
insert into menu
values (6, '아메리카노', 1500, '커피');

update menu
set item_id = 1
where item_name = '라면';
update menu
set item_id = 6
where item_name = '피자';

insert into menu(item_name, price, category)
values ('짜장면', 6000, '매우패스트푸드');

truncate menu;
-- 데이블구조만 남기고 데이터만 모두 삭제할때..
-- 트렌잭션 제어를 받지않으므로 빠르다.롤백할 수 없으므로 주의해서 사용!!