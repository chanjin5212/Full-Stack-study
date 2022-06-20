
-- ex32_synonym.sql


/*

    동의어, Synonym
    - 시노님
    - 데이터베이스 객체의 별칭(Alias 차이 있음)
    - 다른 사용자 소유의 객체를 접근 > 별칭 사용
    
    
    테이블 등 자원은 계정 소속이다.
    
*/

-- hr
show user;

select * from tabs where table_name = 'TBLINSA';

-- system
-- 다른 계정의 자원을 접근할 권한이 있다.
show user;

select * from tabs where table_name = 'TBLINSA';

select * from tblInsa;
select * from hr.tblInsa; -- 다른 계정의 자원 접근  > 계정명.자원명

select fnSum(10, 20) from dual; --hr
select hr.fnSum(10, 20) from dual; --hr.fnSum


-- scott에게 hr.tblInsa을 접근할 수 있는 권한 부여
grant select, delete
    on hr.tblInsa 
        to scott;

revoke delete 
    on hr.tblInsa 
        from scott;        


-- 일반 다른 계정 > scott
create user scott identified by java1234;

grant connect, resource to scott;

-- 시노님
grant create synonym to scott;






-- scott
show user;

select * from tabs;

select * from hr.tblInsa; -- 다른 계정의 자원은 접근 불가능


--ORA-01031: insufficient privileges
update hr.tblInsa set basicpay = 3000000 where name = '홍길동'; --일반키 > 비인덱스
update hr.tblInsa set basicpay = 3000000 where num = 1001; --PK > 인덱스

--ORA-01031: insufficient privileges
delete from hr.tblInsa where num = 1001;


-- 홍길동 > hong
-- 테스트 > test

-- 개발용 > dev
-- 용도별 계정 > xxx


-- 영구적으로 hr의 tblInsa를 scott이 접근해야 하는 경우

select * from hr.tblInsa;

select i.name, i.buseo, i.jikwi from hr.tblInsa i;


-- create synonym 별칭 for 자원;
create synonym insa for hr.tblInsa;

select * from hr.tblInsa;
select * from insa; --소유주 명시X > hr.tablInsa > insa

select * from tabs;

select * from hr.departments;
select * from dept;





























