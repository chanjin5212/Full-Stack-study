-- 문제02.sql

--요구사항.001.employees
--직업이 어떤것들이 있는지 가져오시오.

select distinct job_id from employees;

--요구사항.002.employees
--고용일이 2002~2004년 사이인 직원들은 어느 부서에 근무합니까?

select distinct department_id from employees where hire_date between '2002-01-01' and '2004-12-31';

--요구사항.003.employees
--급여가 5000불 이상인 직원들은 담당 매니저가 누구?

select distinct manager_id from employees where salary >= 5000;

--요구사항.004.tblInsa
--남자 직원 + 80년대생들의 직급은 뭡니까?

select distinct jikwi from tblInsa where ssn like '8%-1%';

--요구사항.005.tblInsa
--수당 20만원 넘는 직원들은 어디 삽니까?
    
select distinct city from tblInsa where sudang > 200000;

--요구사항.006.tblInsa
--연락처가 아직 없는 직원은 어느 부서입니까?

select distinct buseo from tblInsa where tel is null;