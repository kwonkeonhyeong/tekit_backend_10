show tables;

use hr;

show tables;

desc countries;
select * from countries;
select * from countries where country_id like 'R%';

-- select 문 사용 연습 문제
select employees.first_name, employees.last_name from employees;
select department_name, location_id from departments;
select job_id,job_title from jobs;
select street_address, postal_code from locations;
select countries.country_id, countries.country_name from countries;
select regions.region_id, regions.region_name from regions;
select employees.job_id from employees;
select departments.department_id, departments.department_name from departments;
select job_history.employee_id, job_history.department_id from job_history;
select employee_id, first_name, last_name from employees;

-- where 구문 사용 (조건 검색)
select first_name,last_name,salary from employees where salary > 10000;
select department_name, location_id from departments where location_id = 1700;
select * from employees where job_id='IT_PROG';
select first_name,salary from employees where department_id = 90;
select job_title, min_salary from jobs where min_salary >= 5000;
select * from employees where last_name = 'King';
select * from locations where country_id='US';
select * from job_history where start_date < DATE '2001-01-01';
select first_name, last_name, email from employees where last_name like '%a%';
SELECT e.* FROM employees e JOIN departments d ON e.department_id = d.department_id WHERE d.department_name = 'Sales';

-- 날짜형 함수 사용 (날짜 데이터 처리)
select extract(YEAR from employees.hire_date) as hire_year from employees;
select department_id,job_id,(extract(YEAR from end_date) - extract(YEAR from start_date))*12+
    extract(MONTH from end_date) - extract(MONTH from start_date) from job_history;
SELECT first_name, last_name, hire_date FROM employees WHERE hire_date >= ADDDATE(CURDATE(), INTERVAL -20 YEAR);

SELECT first_name,last_name,hire_date FROM employees WHERE EXTRACT(month FROM hire_date) = EXTRACT(month FROM CURDATE());
select first_name,last_name,hire_date from employees where hire_date >= ADDDATE(curdate(), INTERVAL -3 year);

-- 날짜를 조회하세요.
select employee_id, datediff(end_date,start_date) from job_history;
select first_name,last_name, hire_date from employees where hire_date = (select MIN(hire_date) from employees) ;
select datediff(curdate(),DATE(CONCAT(YEAR(CURDATE()) - 1, '-', MONTH(hire_date), '-', DAY(hire_date))))from employees;
select datediff(curdate(),DATE(CONCAT(EXTRACT(YEAR FROM CURDATE()) - 1, '-', EXTRACT(MONTH FROM hire_date), '-', EXTRACT(DAY FROM hire_date)))) as dd from employees;
select * from job_history where extract(year from start_date) >= 1999;
select date_format(hire_date,'%W') from employees;
select employee_id, date_format(hire_date,'%Y-%m-%W') from employees;
SELECT DATE(
               EXTRACT(YEAR FROM CURDATE()) - 1,
               EXTRACT(MONTH FROM hire_date),
               EXTRACT(DAY FROM hire_date)
       ) AS new_date FROM employees;

-- 숫자형 함수 사용 (수치 데이터 처리)
select first_name,last_name,salary,(salary +  (salary * 0.1)) as increseSal from employees;
select max_salary,min_salary, (max_salary - min_salary) as diff from jobs;
select first_name,last_name,salary,salary*1200 from employees;
select first_name,last_name,salary from employees where (select AVG(salary) from employees) < employees.salary;
select first_name,last_name,salary - (select AVG(salary) from employees) from employees;
select STDDEV(employees.salary) from employees;
select first_name,last_name,employees.salary * 12  as  year_salary from employees order by year_salary desc;
select employee_id, count(*) from job_history group by employee_id;
select first_name,last_name,salary from employees order by salary asc ;

-- 문자 함수를 이용한 SQL 연습 문제
select Upper(last_name) from employees;
select substr(first_name,1,1) from employees;
select last_name, length(last_name), length(replace(last_name,'a','')) from employees;
SELECT email, SUBSTR(email, INSTR(email, '@') + 1) AS domain FROM employees;
SELECT CONCAT(employees.first_name,' ',employees.last_name) from employees;
select substr(employees.first_name,3,3) from employees;
select length(employees.first_name) from employees;
select first_name,employees.last_name from employees where last_name = 'king';
select employees.last_name from employees where last_name like 'M%';


-- 모든 사원의 사번, first_name, email, department_name, city을 조회하고 싶어요
select e.employee_id,e.first_name,e.email,d.department_name, l.city, c.country_name, r.region_name
from employees e join departments d
    using (department_id)
    join locations l
        using (location_id)
    join countries c
        using (country_id)
    join regions r
        using (region_id)
where e.department_id = d.department_id
  and d.location_id = l.location_id
  and l.country_id = c.country_id
  and c.region_id = r.region_id;

-- 사원이름, 부서면, 급여를 조회해주세요. 단 급여가 2500이상인 사원만 조회해주세요.
select first_name,last_name,e.salary from employees e, departments d where e.department_id = d.department_id and e.salary >= 2500


-- 1. 각 직원의 이름과, 그들이 속한 부서 이름을 조회하세요.
    -- 풀이 1
    select e.first_name, e.last_name, d.department_name
    from employees e, departments d
    where e.department_id = d.department_id;

    -- 풀이 2
    select e.first_name, e.last_name, d.department_name
    from employees e join departments d using (department_id);

-- 2. 모든 직원의 이름과 그들의 job_title 을 조회하세요.
    -- 풀이 1
    select e.first_name, e.last_name, j.job_title
    from employees e, jobs j
    where e.job_id = j.job_id;

    -- 풀이 2
    select e.first_name, e.last_name, j.job_title
    from employees e
        join jobs j
            using (job_id);

-- 3. 모든 직원의 이름, 부서이름, 근무하는 국가이름(country_name) 을 조회하세요.
    -- 풀이 1
    select e.first_name, e.last_name, d.department_name, c.country_name
    from employees e, departments d, locations l, countries c
    where e.department_id = d.department_id
      and d.location_id= l.location_id
      and l.country_id = c.country_id;

    -- 풀이 2
    select e.first_name, e.last_name, d.department_name, c.country_name
    from employees e
        join departments d
            using (department_id)
        join locations l
            using (location_id)
        join countries c
            using (country_id);

-- 4. 1999년 이후에 입사한 직원들과 그들의 job-title을 조회하세요.
    -- 풀이 1
    select e.first_name, e.last_name, e.hire_date, j.job_title
    from employees e, jobs j
    where YEAR(hire_date) > 1999
      and e.job_id = j.job_id;
    -- 풀이 2
    select e.first_name, e.last_name, j.job_title, e.hire_date
    from employees e
        join jobs j
            using (job_id)
    where YEAR(hire_date) > 1999;

-- 5. 모든 직원의 이름과 그들이 근무한 지역 이름(region_name)을 조회하세요.
    -- 풀이 1
    select e.first_name, e.last_name, r.region_name
    from employees e, departments d, locations l, countries c, regions r
    where e.department_id = d.department_id
    and d.location_id = l.location_id
    and l.country_id = c.country_id
    and c.region_id = r.region_id;

    -- 풀이 2
    select e.first_name, e.last_name, r.region_name
        from employees e
            join departments d
                using (department_id)
            join locations l
                using (location_id)
            join countries c
                using (country_id)
            join regions r
                using (region_id);

-- 6. 각 부서에서 근무하는 직원 수를 부서 이름과 함께 조회하세요. (join, group by)
    -- 풀이 1
    select department_name, count(*)
    from employees e
        left join departments d
            using (department_id)
    group by d.department_name;

    -- 풀이 2
    select department_name,count(*)
    from employees e
         join departments d
            using (department_id)
    group by department_name;

-- 조인 연습문제
-- 1. 각 직원의 이름과 그들이 속한 부서 이름을 조회하세요.
select e.first_name, e.last_name, d.department_name
from employees e
    join departments d
        using (department_id);

-- 2. 모든 직원의 이름과 그들의 직무 타이틀을 조회하세요.
select e.first_name, e.last_name, j.job_title
    from employees e
        join jobs j
            using (job_id);

-- 3. 모든 직원의 이름, 부서 이름 및 그들이 근무하는 국가 이름을 조회하세요.
select e.first_name, e.last_name, d.department_name, c.country_name
    from employees e
        join departments d using (department_id)
        join locations l using (location_id)
        join countries c using (country_id);

-- 4. 1999년 이후에 입사한 직원들과 그들의 직무 타이틀을 조회하세요.
select e.first_name, e.last_name, j.job_title, e.hire_date
    from employees e
        join jobs j using (job_id)
    where YEAR(e.hire_date) > 1999;

-- 5. 모든 직원의 이름과 그들이 근무한 지역 이름을 조회하세요.
select e.first_name, e.last_name, r.region_name
    from employees e
        join departments d using (department_id)
        join locations l using (location_id)
        join countries c using (country_id)
        join regions r using (region_id);

-- 6. 각 부서에서 근무하는 직원 수를 부서 이름과 함께 조회하세요.
select d.department_name, count(*) from employees e join departments d using (department_id) group by department_name;

-- 7. 모든 지역(region)과 해당 지역에 위치한 국가들을 조회하세요.
select r.region_name, c.country_name from regions r right join countries c using (region_id);
select r.region_name, c.country_name from regions r join countries c using (region_id);

-- 8. 각 부서의 위치 정보와 해당 위치의 도시 이름을 조회하세요.
select d.department_name, c.country_name from departments d
    join locations l using (location_id)
    join countries c using (country_id);

-- 9. 각 부서에서 근무하는 모든 직원의 이름과 부서 이름, 그리고 직무를 조회하세요.
select e.first_name, e.last_name, d.department_name, j.job_title
    from employees e
        join departments d using (department_id)
        join jobs j using (job_id);

-- 10. 각 직원의 이름과 그들의 입사 날짜, 그리고 그들이 근무한 모든 부서의 이름을 조회하세요.
select e.first_name, e.last_name, e.hire_date, d.department_name
    from employees e
        join job_history j using (employee_id)
       join departments d on (j.department_id = d.department_id);

SELECT e.first_name, e.last_name, e.hire_date, d.department_name
FROM employees e
         JOIN job_history jh ON e.employee_id = jh.employee_id
         JOIN departments d ON jh.department_id = d.department_id;

-- 문제 1: 각 부서의 평균 급여를 조회하세요.
select avg(salary) from employees group by department_id;
select department_name, avg(salary)
    from employees e
        join departments d using (department_id)
    group by department_name;

-- 문제 2: 최고 급여를 받는 직원의 이름과 급여를 조회하세요.
select e.first_name, e.last_name, e.salary from employees e where e.salary = (select max(salary) from employees);
