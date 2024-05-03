use tekitexam;

show tables;

desc dept;
desc SALGRADE;

# 조회 select 컬럼명들-,로 구분한다. from 테이블명들...
SELECT grade, losal, hisal from SALGRADE;
select * from SALGRADE; -- 사용은 편하나.. 가독성은 떨어질 수 있으므로, 칼럼명을 명시하는것이 더 좋다.
select losal, grade, hisal from SALGRADE;

desc emp;

# distinct 중복되는 값은 제거하고 보여줌, 보여주고자하는 모든 칼럼을 대상을 중복을 찾아냄.
select distinct mgr, empno from emp;

select distinct deptno from emp;

select distinct deptno, ename from emp;

# Alias 지정
select empno 사번, ename 사원이름 from emp;
select empno as 사번, ename as "사원 이름" from emp;

select current_date;

select concat('test','hello',empno) from emp;
select concat(ename, '사원의 매니저는 ', mgr, ' 입니다.') from emp;

# 정렬 order by 컬럼명, 컬럼명

select ename, sal, mgr from emp order by sal, mgr, ename asc;
-- 정렬할때 칼럼명 대신 번호
select ename, sal, mgr from emp order by 2 desc , 3, 1 asc;

-- 조건에 따라서 원하는 값만 조회 where
select * from emp where sal>2000 or deptno = 20; -- 부서번호사 20번이거나 급여가 2000보다 큰 사원들
select * from emp where sal>2000 and deptno = 20; -- 부서번호가 20번이면서 급여가 2000보다 큰 사원들

-- 연산자 = != > <=, >=
select * from emp where deptno != 20;

desc emp;
select * from emp where comm is null ;
select * from emp where comm is not null ;

-- 비교 연산자 IN, ANY, ALL
select * from emp where deptno = 10 or deptno = 20;
select * from emp where deptno in (10,20);

-- 일반적으로 DB 안에 값은 대소문자를 구분해요. Mysql은 구분 안한다.
select * from emp where job = "MANAG"; -- = 완전히 일치할때만 검색
-- like 와일드 카드를 이용해서 검색
-- _, % _문자 하나 % 문자 0~여러개.
select  * from emp where job like '_anager';
select ename from emp;
select * from emp where ename like '__RD';
select * from emp where ename like 'T%';

-- 이름의 3번째 글자가 A인 사원을 조회하고 싶어요.
select * from emp where ename like '__A%';

select * from emp where hiredate like '__81%'

-- 문자형 함수
select upper('Seoul'); -- select upper('Seoul') from dual; -- 오라클인 경우
select upper(ename) from emp;
select * from emp where upper(ename) = 'SMITH';
select substr('happy day',3,2); -- index가 1부터 시작!

select * from emp where substr(hiredate,3,2) = '81';

select insert("www..com",5,0,"google");
select trim(' test ');
select RTRIM('       test        '),trim('          test      '), ltrim('       test  s');
select LPAD('hi', 5, '*'), RPAD('hi',5,'#');
select lpad(ename, 10, '*') from emp;

-- 숫자형 함수
select abs(2), abs(-2); -- 절대값
select mod(34, 10), 34 % 4 나눈나머지값;
select floor(1.23), ceiling(1.23), round(1.4), round(1.8);
select round(1.264, 1), round(1.264, 2);
select pow(2,2), sign(-32), sign(32), sign(0);
select GREATEST(4,6,3,589,3213), least(3,4,5,21,3,3,1);

select ename from emp;
select sign(ename) from emp;
select sign('hi');
select upper(sal) from emp;
select sal from emp;

-- 날짜형 함수
select current_date(), curdate();
select current_time, current_timestamp;
select now(), sysdate(), current_timestamp();
select date_format(curdate(),'%y.%m.%w %Y-%M-%W');

-- 형변환 함수
select now();
select cast(now() as date);
select cast('123' as signed );
select cast(123 as char );
select cast(now() as char );

-- 함수 -- 단일행 함수, 그룹함수
select upper(ename) from emp; -- 단일 행 함수 => 함수가 실행됐을 때에 모든 레코드에 결과 값 반환
select sum(sal) from emp; -- 그룹함수 => 행 여러 개에 대해서 결과 값 하나만 반환

select ename, sum(sal) from emp; -- 그룹함수와 함께 그룹핑이 참여하지 않은 칼럼이 같이 나올 수 없다.

-- 부서 번호별(그룹핑) 급여총합을 구해 주세요.
select deptno, sum(sal) from emp group by deptno ;
select count(ename) from emp; -- ename은 null이 없으므로 14
select count(comm) from emp; -- 해당 칼럼이 null값이 아닌 레코드만 개수한다. 4
select count(*) from emp; -- 전체 사원수를 잘 셀 수 있다.

-- 부서별 사원수를 구해주세요.
select deptno, count(*) from emp group by deptno;

-- 부서별 최대 급여를 조회해주세요.
select deptno, max(sal) 사원수 from emp group by deptno ;
select deptno, avg(sal) 사원수 from emp group by deptno ;

-- 그룹별로 값을 구했는데.. 여기에도 조건을 줄 수 있어요.
-- 그룹별 평균급여를 구해주세요. 단 평균급여가 2000 이하인 부서는 제외하고 조회하세요.
select deptno, avg(sal) from emp group by deptno having avg(sal) > 2000;

-- 급여가 4500이상 1000 이하의 사원은 제외하고,
-- 부서별 평균급여를 구해주세요. 단 평균 급여가 2000이하인 부서는 제외하고 조회하세요.
select deptno, avg(sal)
from emp
where sal > 1000 and sal < 4500
group by deptno having avg(sal) > 2000;

-- extract extract(필드 from 소스)
select extract(YEAR from curdate());
select extract(YEAR from emp.hiredate) from emp;

select extract(Month from curdate());
select extract(Month from emp.hiredate) from emp;

select extract(DAY from emp.hiredate) from emp;

select extract(HOUR from current_timestamp());
select extract(MINUTE from current_timestamp());
select extract(SECOND from current_timestamp());

select ename, job, sal from emp where deptno between 20 and 10;
select ename, job, sal from emp where sal between 1800 and 3000;

desc emp;
desc dept;

select * from emp;
select * from dept;
select deptno, ename from emp;

-- 사원 이름과 부서 이름을 알고 싶다.
select ename, dname from emp, dept;
select e.ename, d.dname from emp e, dept d;
select ename, dname from emp e, dept d;
select ename, dname, e.deptno from emp e, dept d; -- 중복되는 칼럼명앞에는 반드시 테이블을 명시해야함.

select e.ename, d.dname from emp e, dept d
where e.deptno = d.deptno; -- 조인 조건


-- 사원이름, 부서면, 급여를 조회해주세요. 단 급여가 2500이상이고, 부서가 research 부서 사원만 조회하세요.
select e.ename, e.sal
from emp e, dept d
where e.deptno = d.deptno
  and e.sal >= 2500
  and d.dname = 'RESEARCH';

desc SALGRADE;
select * from SALGRADE;

-- 이름, 급여, 등급을 조회하세요. theta join!!
select e.ename, e.sal, g.grade
from emp e, SALGRADE g
where e.sal between g.LOSAL and g.HISAL;

desc emp;
desc dept;
select e.ename, d.dname
from emp e
natural join dept d; -- 두 테이블에 같은 이름의 칼럼들을 모두 조인조건으로 사용한다.

select * from emp;

-- join using 칼럼명을 지정해줌 .. 두개 테이블에 칼럼이 같은 이름 되어있어야함.
select e.ename, d.dname
from emp e join dept d using (deptno);

-- join on 조건을 직접 기술.
select e.ename, d.dname
from emp e join dept d on (e.deptno = d.deptno)
where d.deptno = 20;


INSERT INTO EMP VALUES (1000,'KWON','CLERK',7902,STR_TO_DATE('17-12-1980','%d-%m-%Y'),800,NULL,NULL);

-- outer join 조건에 만족하지 않은 데이터도 같이 보고 싶을때.
select e.ename, d.dname from emp e, dept d
where e.deptno = d.deptno;

select e.ename, d.dname
from emp e left outer join dept d using (deptno)
union
select e.ename, d.dname
from emp e right outer join dept d using (deptno);

select * from emp;

select e.empno 사원명, m.ename 매니저명
from emp e, emp m
where e.mgr = m.empno;

-- 사원이름, 매니저이름을 출력하세요. 단 매니저가 없는 사원도 출력하세요.
select e.ename 사원이름, m.ename 매니저이름 from emp e left outer join emp m on (e.mgr = m.empno);


-- subquery
select * from emp;

-- SMITH가 속한 부서의 급여 평균을 알고 싶어요.
-- 1. 스미스의 부서 번호는??
-- 2. 급여 평균을 ...
-- 쿼리 한 번에 원하는 결과를 얻어내지 못할 때가 있어요.
select * from emp;
select avg(sal) from emp where deptno = (select deptno from emp where ename='MARTIN');

-- SCOTT 급여보다 높은 급여를 받는 사람의 이름을 출력하시오.
-- 1. SCOTT 급여는??
select ename from emp
where sal = (select sal from emp where ename = 'SCOTT');

select ename
from emp
order by ename
limit 1;

select MIN(ename) from emp;

select ename, sal
from emp
where sal < (select avg(sal) from emp);

select deptno from dept d where d.dname = 'SALES';

select ename,deptno from emp where deptno = (select deptno from dept d where d.dname = 'SALES');

select min(ename) from emp group by deptno;

select ename, sal, deptno from emp
where ename = (select min(ename) from emp group by deptno); -- 오류

select ename, sal, deptno from emp
where ename in (select min(ename) from emp group by deptno);


-- in (= or) 결함.
select *
from emp
where ename in ('KANG','CLARK','ADAMS','ALLEN');

select *
from emp
where ename = 'KANG' or ename = 'CLARK' or ename = 'ADAMS' or ename = 'ALLEN';

-- any all > any < any <= any any - or all - and

-- > any or
select avg(sal) from emp group by deptno;

select * from emp
where sal > any (select avg(sal) from emp group by deptno);

select * from emp
where sal > 2916 or sal > 1782 or sal > 1566 or sal > 800;

-- >all > and
select * from emp
where sal > all  (select avg(sal) from emp group by deptno);

select * from emp
where sal > 2916 and sal > 1782 and sal > 1566 and sal > 800;

-- =any ( = or ) = in 하고 같다

-- 서브 쿼리가 실행될 때 바깥쪽 row의 값을 이용해서 결과 값을 얻어내는 쿼리.

-- 각 부서별로 최고 급여를 받는 사원정보를 출력하시오.

-- 자기 부서의 평균 급여보다 많이 받는 사원의 정보를 출력해주세요.
# select avg(sal) from emp where deptno = ?;

select * from emp;

select * from emp oe
where sal > (select avg(sal) from emp ie where ie.deptno = oe.deptno);

-- 부서별로 최고 급여를 받는 사원의 정보를 출력
select deptno,max(sal) from emp group by deptno;

select * from emp
where (deptno, sal) in (select deptno,max(sal) from emp group by deptno);

select s.deptno,max(s.sal) msal from emp s group by deptno;

select e.deptno, e.empno, e.ename, e.sal from emp e, (select s.deptno,max(s.sal) msal from emp s group by deptno) m
where e.deptno = m.deptno and e.sal = m.msal;


select deptno, empno, ename, sal
from emp e
where e.sal = (select max(sal) from emp where deptno = e.deptno);

select max(sal) from emp where deptno = 30;

create table a(
    name int
);

create table b (
    name int
);

show tables;

insert into a (name) value ('1');
insert into a value ('2');
insert into a value ('3');

select * from a;

insert into b value ('2');
insert into b value ('3');
insert into b value ('4');

select * from b;

select * from a
union
select * from b;

select * from a
union all
select * from b;

-- mysql에서는 intersect가 지원되지 않아서 다른 구문으로 사용해야함.
select a.name from a,b where a.name = b.name;

-- mysql에서는 minus가 지원되지 않아서 다른 구문으로 사용해야함.
select a.name from a where a.name not in (select name from b);

drop table a;
drop table b;

show tables;

select sal, emp.ename, rank() over (order by sal desc )
from emp;