-- ex03_select.sql
/*

    SQL, Query(질의)
    
    
    SELECT 문
    - DML, DQL
    - 관계대수 연산 중 셀렉션 작업을 구현한 명령어
    - 대상 테이블로부터 원하는 행(튜플)을 추출하는 작업 > 오라클 서버에게 데이터 주세요~ 요청
    
    

*/

select first_name from employees;


desc tblCountry; -- 해당 테이블의 스키마? > 컬럼 구조


-- 단일 컬럼
select name from tblCountry;
select capital from tblCountry;
select population from tblCountry;

-- 여러개
select name, capital from tblCountry;

select name, capital, population, continent, area from tblCountry; 

select * from tblCountry; --와일드 카드(*) > 모든 컬럼


select name, length(name) from tblCountry;

-- 컬럼 리스트의 순서는 원본 테이블의 컬럼 순서와 무관하ㄷ아.
select name, capital from tblCountry;
select capital, name from tblCountry;
































