-- 문제03.sql

-- 1. tblCountry. 아시아(AS)와 유럽(EU)에 속한 나라의 개수?? -> 7개

select count(*) from tblCountry where continent in ('AS', 'EU');
        

-- 2. 인구수가 7000 ~ 20000 사이인 나라의 개수?? -> 2개

select count(*) from tblCountry where population between 7000 and 20000;

-- 3. hr.employees. job_id > 'IT_PROG' 중에서 급여가 5000불이 넘는 직원이 몇명? -> 2명

select count(*) from employees where job_id = 'IT_PROG' and salary >= 5000;

-- 4. tblInsa. tel. 010을 안쓰는 사람은 몇명?(연락처가 없는 사람은 제외) -> 42명

select count(*) from tblInsa where tel not like '010%';
    
    
-- 5. city. 서울, 경기, 인천 -> 그 외의 지역 인원수? -> 18명

select count(*) from tblInsa where city not in ('서울', '경기', '인천');

-- 6. 여름태생(7~9월) + 여자 직원 총 몇명? -> 7명

select count(*) from tblInsa where ssn like '%07__-2%' or ssn like '%08__-2%' or ssn like '%09__-2%';

-- 7. 개발부 + 직위별 인원수? -> 부장 ?명, 과장 ?명, 대리 ?명, 사원 ?명

select
    count(case
        when jikwi = '부장' then 1
    end) as "부장",
    count(case
        when jikwi = '과장' then 1
    end) as "과장",
    count(case
        when jikwi = '대리' then 1
    end) as "대리",
    count(case
        when jikwi = '사원' then 1
    end) as "사원"
from tblInsa;




