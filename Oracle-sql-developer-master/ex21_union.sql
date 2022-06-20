-- ex21_union.sql

/*

    관계 대수 연산
    1. 셀렉션 > select where
    2. 프로젝션 > select column
    3. 조인 > a join b
    4. 합집합, 차집합, 교집합

    
    UNION, 유니온
    - 합집합
    
    INTERSECT
    - 교집합
    
    MINUS
    - 차집합

*/

-- 조인 : 컬럼 + 컬럼
-- 유니온 : 레코드 + 레코드

-- 결과셋 + 결과셋
select * from tblMan 
union 
select * from tblWoman;


select * from 영업부게시판;
select * from 총무부게시판;
select * from 기획부게시판;

--사장님 > 모든 부서의 게시판 > 한꺼번에..
select * from 영업부게시판
union
select * from 총무부게시판
union
select * from 기획부게시판;

--야구선수 > 공격수, 수비수
select * from 공격수;
select * from 수비수;

select * from 공격수
union
select * from 수비수;

--싸이월드 > 게시판 > 년도별로
select * from 모든게시판; --테이블 규모!

select * from 2020게시판;
select * from 2021게시판;
select * from 2022게시판;

select * from 2020게시판
union
select * from 2021게시판
union
select * from 2022게시판;


-- 전제조건 > 스키마가 동일해야한다.
select * from tblCountry
union
select * from tblInsa;

select name, capital, population from tblCountry
union
select name, buseo, basicpay from tblInsa;


create table tblUnionA (
    name varchar2(30) not null
);

create table tblUnionB (
    name varchar2(30) not null
);

insert into tblUnionA values ('강아지'); --*
insert into tblUnionA values ('고양이'); --*
insert into tblUnionA values ('토끼');
insert into tblUnionA values ('거북이');
insert into tblUnionA values ('병아리');

insert into tblUnionB values ('강아지'); --*
insert into tblUnionB values ('고양이'); --*
insert into tblUnionB values ('호랑이');
insert into tblUnionB values ('사자');
insert into tblUnionB values ('코끼리');

-- union > 수학의 집합 개념 > 중복값 허용X
select * from tblUnionA
union
select * from tblUnionB;

-- union all > 중복값 허용O
select * from tblUnionA
union all
select * from tblUnionB;


-- intersect > 교집합
select * from tblUnionA
intersect
select * from tblUnionB;



-- minus > 차집합
select * from tblUnionA
minus
select * from tblUnionB;

select * from tblUnionB
minus
select * from tblUnionA;










