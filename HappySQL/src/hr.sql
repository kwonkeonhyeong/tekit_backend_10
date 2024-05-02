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

