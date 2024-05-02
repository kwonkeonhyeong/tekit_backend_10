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
