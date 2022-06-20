-- ex20_view.sql

/*

    View, 뷰
    - 데이터베이스 객체 중 하나(CREATE,ALTER,DROP > 테이블, 시퀀스, 제약사항, 뷰)
    - 가상 테이블, 복사 테이블, 뷰 테이블 등..
    - 테이블처럼 사용한다.(*********)
    - 반복된 SELECT or 긴 SELECT > 뷰 생성 > 효과
    
    

    CREATE VIEW 뷰이름
    AS
    SELECT 문;
    
    CREATE OR REPLACE VIEW 뷰이름
    AS
    SELECT 문;

*/

create view vwInsa 
as 
select * from tblInsa;


select * from vwInsa; --tblInsa 처럼 행동


create or replace view vwInsa
as
select * from tblInsa where buseo = '영업부';

select * from vwInsa; --영업부 직원 테이블


-- 뷰 사용 용도? > 쿼리의 양을 줄이는게 목적
-- select * from tblInsa where buseo = '영업부' vs select * from vwInsa



-- 비디오 가계 사장 > 하루 업무
create or replace view 대여체크
as
select
    m.name as mname,
    v.name as vname,
    to_char(r.rentdate, 'yyyy-mm-dd') as rentdate,
    case
        when r.retdate is not null then '완료'
        else '미완료'
    end as state
from tblRent r
    inner join tblVideo v
        on v.seq = r.video
            inner join tblMember m
                on m.seq = r.member;



select * from 대여체크;






















































