-- ex24_transaction.sql

/*

    트랜잭션, Transaction
    - 데이터를 조작하는 업무의 물리적(시간적) 단위
    - 1개 이상의 명령어(행동,SQL)로 구성된 작업 단위(기간)
    - 1개 이상의 명령어를 하나의 목적(논리 집합)으로 묶어 놓은 단위
    

    트랜잭션 명령어, DCL(TCL)
    1. COMMIT
    2. ROLLBACK
    3. SAVEPOINT

*/


create table tblTrans
as
select name, buseo, jikwi from tblInsa where city = '서울';



select * from tblTrans;


-- 로그인(접속) > 트랙잭션이 시작됨.

-- INSERT, UPDATE, DELETE 명령어는 실행 즉시 데이터베이스에 반영 되지 않는다.
-- > 임시 적용한다.
delete from tblTrans where name = '박문수';

select * from tblTrans;

commit;     -- "현재 트랜잭션에서 했던 모든 행동"을 진짜 데이터베이스에 반영해라
rollback;   -- "현재 트랜잭션에서 했던 모든 행동"을 진짜 데이터베이스에 반영하지 말고 없었던 일로 취소해라(되돌려라, 타임머신)


select * from tblTrans;

delete from tblTrans where name = '박문수';

select * from tblTrans;

commit;

select * from tblTrans;

rollback;

select * from tblTrans;

delete from tblTrans where name = '김인수';

select * from tblTrans;


update tblCountry set capital = '세종';

select * from tblCountry;

rollback;

select * from tblCountry;

update tblCountry set capital = '세종' where name = '대한민국';

select * from tblCountry;

commit;



-- SQL + 트랜잭션

-- insert
-- delete
-- update
-- insert
-- delete
-- update
-- insert
-- delete
-- update
-- insert
-- delete
-- update
-- insert
-- delete
-- update
-- insert
-- delete
-- update
-- insert
-- delete
-- update
-- insert
-- delete
-- update
-- insert
-- delete
-- update
-- insert
-- delete
-- update
-- insert
-- delete
-- update
-- insert
-- delete
-- update > 실수;;;;

-- select > 확인
-- commit or rollback



-- insert
-- commit

-- update
-- commit

-- delete
-- commit

-- rollback;

-- 업무별로 묶기
-- 시간대별로 묶기


/*

    트랜잭션이 언제 시작하고? 언제 끝나는지?
    
    새로운 트랜잭션이 시작하는 경우
    1. 클라이언트 접속 직 후
    2. commit 실행 직 후
    3. rollback 실행 직 후
    
    현재 트랜잭션이 종료되는 경우
    1. commit 실행 > 현재 트랜잭션을 DB에 반영함
    2. rollback 실행 > 현재 트랜잭션을 DB에 반영 안함
    3. 클라이언트 접속 종료
        a. 정상 종료
            - 현재 트랜잭션에 아직 반영안된 명령어가 남아있으면 사용자에게 질문?            
        b. 비정상 종료 
            - 무조건 rolllback 처리
    4. DDL 실행
        - CREATE, ALTER, DROP > 실행 > 그 즉시 commit 동반 > Auto Commit
        - DDL 성격 > 구조 변경 > 데이터 영향 O > 사전에 미리 저장(Commit)
    
    클라이언트 도구
    - SQL Developer
    - Auto Commit 옵션(사용자 선택)

*/


select * from tblTrans;

commit; --지금부터 새로운 트랜잭션 시작의 의미!!!

delete from tblTrans where buseo = '영업부';

select * from tblTrans;


-- + commit
create table tblTest (
    seq number primary key
);


rollback;

select * from tblTrans;

commit;

delete from tblTrans where buseo = '기획부';

select * from tblTrans;

rollback;













































