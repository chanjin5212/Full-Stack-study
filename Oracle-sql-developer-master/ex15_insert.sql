-- ex15_insert.sql

/*
    
    INSERT
    - DML
    - 테이블에 데이터를 추가하는 명령어(행 추가, 레코드 추가, 튜플 추가)
    
    INSERT 구문
    - INSERT INTO 테이블명(컬럼리스트) VALUES(값리스트);
    
*/


drop table tblMemo;

create table tblMemo (

    seq number(3) primary key,   
    name varchar2(30) default '익명',    
    memo varchar2(1000), 
    regdate date default sysdate not null
);

drop sequence seqMemo;
create sequence seqMemo;


--1. 표준: 원본테이블의 정의된 컬럼 순서대로 컬럼리스트와 값리스트를 구성하는 방법
--         : 특별한 이유가 없으면 이 방식 사용
insert into tblMemo(seq, name, memo, regdate) values(seqMemo.nextVal, '홍길동', '메모', sysdate);


--2. 컬럼리스트의 순서는 원본 테이블과 상관없다.
--  *** 컬럼리스트의 순서와 값리스트의 순서가 일치해야한다.
insert into tblMemo(name, memo, regdate, seq) values('홍길동', '메모', sysdate, seqMemo.nextVal);


--3. ORA-00947: not enough values
insert into tblMemo(seq, name, memo, regdate) values(seqMemo.nextVal, '홍길동', sysdate);


--4. ORA-00913: too many values
insert into tblMemo(seq, name, regdate) values(seqMemo.nextVal, '홍길동', '메모', sysdate);

--3+4. 컬럼리스트의 개수와 값리스트의 개수는 반드시 일치해야한다.

--*** 컬럼리스트와 값리스트의 순서와 개수는 일치해야한다.


--5. null 컬럼 조작
--5.a null 상수
insert into tblMemo(seq, name, memo, regdate) values(seqMemo.nextVal, '홍길동', null, null);

--5. b 컬럼 생략
insert into tblMemo(seq, name) values(seqMemo.nextVal, '홍길동');

--6. default 컬럼 조작
--6.a 컬럼 생략 > null 처리(5.b)
insert into tblMemo(seq, memo, regdate) values(seqMemo.nextVal, '메모', sysdate);
insert into tblMemo(seq, memo) values(seqMemo.nextVal, '메모');

--6.b null 상수 > 사용자 명시적 의지 표현 > default 동작 안함
insert into tblMemo(seq, name, memo, regdate) values(seqMemo.nextVal, null, '메모', sysdate);

--6.c default 상수 > 컬럼리스트를 생략하지 않고 default를 동작하는 방법
insert into tblMemo(seq, name, memo, regdate) values(seqMemo.nextVal, default, '메모', default);    --AAAA(생략X)

--7. 단축
-- 컬럼리스트를 생략할 수 있다.
insert into tblMemo values(seqMemo.nextVal, '홍길동', '메모', sysdate);

-- 컬럼리스트를 생략하면 테이블의 원본 컬럼 순서를 적용한다.(***)
insert into tblMemo values('홍길동', '메모', sysdate, seqMemo.nextVal);

-- null 조작
insert into tblMemo values(seqMemo.nextVal, '메모', sysdate); -- X
insert into tblMemo values(seqMemo.nextVal, null, '메모', sysdate); -- O

--default 조작
insert into tblMemo values(seqMemo.nextVal, '홍길동', '메모', sysdate);
insert into tblMemo values(seqMemo.nextVal, '메모', sysdate);

select * from tblMemo;


--8.
-- tblMemo 테이블 복사 -> 새 테이블 생성

create table tblMemoCopy (

    seq number(3) primary key,   
    name varchar2(30) default '익명',    
    memo varchar2(1000), 
    regdate date default sysdate not null
);


-- Sub Query
insert into tblMemoCopy select * from tblMemo;

select * from tblMemoCopy;



--9. *** 테이블 생성 + 데이터 복사
-- 테이블 만들 때 제약 사항은 복사하지 않는다.(not null만 복사한다.)
-- 개발자들이 더미 데이터 만드는 용도로 사용한다.(실사용 X)
create table tblMemoCopy2 as select * from tblMemo;

select * from tblMemoCopy2;

desc tblMemoCopy2;


insert into tblMemoCopy2(seq, name, memo, regdate) values(13, '홍길동', '메모', sysdate);



/*

    오라클 수업
    - ANSI-SQL 1.5주~2주 > 설계(=모델링) 1일 > PL/SQL 3~5일
    -                                                           > 프로젝트 시작
    
    오라클 프로젝트
    - 아이템 선정 > 요구분석서 작성 > .. > 데이터 구조 + 더미 데이터 생성 > .. > 구현
    - 아이템 선정 > 요구분석서 작성 > .. > 데이터 구조 + 더미 데이터 생성
    
    - 아이템 선정(완료) > 요구 사항서 작성(완료) 
        > 요구 분석서 작성(O) > 데이터 구조(테이블..) + 더미 데이터 생성(insert..)
        > 업무별 SQL 작성
        > 데이터베이스 객체 생성 + 테스트
        

*/

commit;
rollback;


select * from tblCountry;

-- 대한민국: 서울 > 세종
update tblCountry set capital = '세종';

update tblCountry set capital = '세종' where name = '대한민국';

-- 전체 레코드 업데이트
-- 전세계 인구수 증가 > 10% 증가
update tblCountry set population = population * 1.1;

update tblCountry set capital = '부산', continent = 'EU', area = 30 where name = '대한민국';


-- 회원 > 주소 수정
update 회원 set address = '서울시 서대문구 불광동';



-- tblInsa
select * from tblInsa;

-- 구조조정
-- basicpay 180~200만원
delete from tblInsa where basicpay between 1800000 and 2000000;


update tblInsa set tel = null where num = 1001;













