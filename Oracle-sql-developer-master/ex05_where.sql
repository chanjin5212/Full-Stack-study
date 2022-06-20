-- ex05_where.sql

/*

    SELECT 컬럼리스트
    FROM 테이블
    WHERE 조건;
    
    실행 순서
    1. FROM 테이블
    2. WHERE 조건
    3. SELECT 컬럼리스트
    
    
    1. FROM
        - 데이터 소스를 지정한다.
        - 테이블 선택
        
    2. WHERE
        - 가져올 레코드(***)를 선별한다.
        - 조건을 제시한 후 그 조건에 만족하는 레코드만 가져온다.
        - 셀렉션 연산
    
    3. SELECT
        - 가져올 컬럼(***)을 선별한다.
        - 가져올 컬럼명을 작성하면 그 컬럼만 가져온다.
        - 프로젝션 연산

*/

-- 차수(5) 카디날리티(14)
select name from tblCountry where continent = 'AS';

select * from tblInsa;

-- 직원의 이름, 부서, 급여을 가져오시오.
select name, buseo, basicpay
from tblInsa;

-- 영업부 직원을 가져오시오.
select *
from tblInsa
    where buseo = '영업부';

-- 영업부 직원의 이름, 부서, 급여만 가져오시오.
select name, buseo, basicpay
from tblInsa
    where buseo = '영업부';

-- 영업부 + 서울
select * from tblInsa
    where buseo = '영업부' and city = '서울';

-- 영업부 + 서울 + (사원/대리)
select * from tblInsa
    where buseo = '영업부' and city = '서울' and (jikwi = '사원' or jikwi = '대리');

-- 급여가 150만원 이상 직원
select * from tblInsa
    where basicpay >= 1500000;

-- 급여가 150만원 이상 200만원 미만
select * from tblInsa
    where basicpay >= 1500000 and basicpay < 2000000;


-- tblComedian
select * from tblComedian;

--1. 몸무게가 60kg 이상이고, 키가 170cm 미만인 사람을 가져오시오.
-- 3명
select * from tblComedian
    where weight >= 60 and height < 170;

--2. 몸무게가 70kg 이하인 여자만 가져오시오.
-- 1명
select * from tblComedian
    where weight <= 70 and gender = 'f';



-- tblInsa
-- 3. 부서가 '개발부'이고 급여를 150만원 이상 받는 직원을 가져오시오.
-- 4명
select * from tblInsa
    where buseo = '개발부' and basicpay >= 1500000;

-- 4. 급여(basicpay) + 수당(sudang)한 금액이 200만원 이상 받는 직원을 가져오시오.
-- 26명
select * from tblInsa
    where (basicpay + sudang) >= 2000000;




-- 조건절(where)에서 사용하는 여러가지 구문들..
/*

    between
    - where절에서 사용 > 조건으로 사용
    - 컬럼명 between 최솟값 and 최댓값
    - 범위 조건
    - 가독성(***)
    - 최솟값, 최댓값 > 포함
    
*/
select * from tblComedian where weight >= 60 and weight <= 70;
select * from tblComedian where 70 >= weight and weight >= 60;

select * from tblComedian where weight between 64 and 66;



-- 비교 연산에 사용 가능한 자료형
-- 1. 숫자형
select * from tblInsa where basicpay >= 1500000;
select * from tblInsa where basicpay >= 1500000 and basicpay <= 2000000;
select * from tblInsa where basicpay between 1500000 and 2000000;


-- 2. 문자형
select * from tblInsa where name >= '박';
select * from tblInsa where name >= '박' and name <= '유';
select * from tblInsa where name between '박' and '유';


-- 3. 날짜형
-- SQL Developer > 날짜 시간 출력 > YY/MM/DD
select * from tblInsa where ibsadate >= '2010-01-01'; --2010년 이후 입사한 직원 명단
select * from tblInsa where ibsadate >= '2010-01-01' and ibsadate <= '2010-12-31'; --2010년도 입사한 직원 명단
select * from tblInsa where ibsadate between '2010-01-01' and '2010-12-31';




/*

    in
    - where절에서 사용 > 조건으로 사용
    - 열거형 조건
    - 컬럼명 in (값, 값, 값..)
    - 제시된 값들 중 하나와 일치하면 만족    
    - 가독성(***)
    
*/

-- 홍보부 + 개발부 + 총무부
select * from tblInsa where buseo = '홍보부' or buseo = '개발부' or buseo = '총무부';
select * from tblInsa where buseo in ('홍보부', '개발부', '총무부');


select * from tblInsa
    where jikwi in ('과장', '부장')
            and city in ('서울', '인천')
            and basicpay between 2500000 and 2600000;





/*

    like
    - where절에서 사용 > 조건으로 사용
    - 패턴 비교
    - 컬럼명 like '패턴 문자열'
    
    
    패턴 문자열 구성 요소
    1. _: 임의의 문자 1개
    2. %: 임의의 문자 N개(0~무한대)
    
*/

select name from tblInsa;

-- '김'씨 > 김OO
select name from tblInsa where name like '김__';
select name from tblInsa where name like '__수';
select name from tblInsa where name like '_길_';

select name from tblInsa where name like '김%';



select * from employees where first_name like 'S_____';
select * from employees where first_name like 'S%';

select * from employees where first_name like '%a';
select * from employees where first_name like '%%a';

select * from employees where first_name like '%a%'; --Nancy

select * from employees where first_name like 'S%a%'; --Sundar, Shanta, Samuel






select * from tblInsa where tel like '010-____-____';
select * from tblInsa where tel like '010%';

select * from tblinsa where jikwi like '_장';

-- tblInsa. 여자 직원만 가져오시오.
select * from tblInsa where ssn like '______-2______';
select * from tblInsa where ssn like '%-2%';

select * from 도서정보 where 제목 like '%SQL%';




/*

    RDBMS에서의 null
    - 자바의 null 유사
    - 컬럼값(셀)이 비어있는 상태
    - null 상수 제공
    - 보통의 언어에서는 null값은 연산의 대상이 될 수 없다.(***)    
    
*/
select * from tblCountry;

-- 인구수가 미기재된 나라는?
select * from tblCountry where population = null;

-- if (pop == null) { }








































