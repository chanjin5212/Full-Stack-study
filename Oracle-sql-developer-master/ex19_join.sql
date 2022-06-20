 -- ex19_join.sql

/*

    관계형 데이터베이스 시스템이 지양하는 것들
    - 테이블 다시 수정해야 고쳐지는 것들
    1. 테이블에 기본키가 없는 상태 > 데이터 조작 곤란
    2. null이 많은 상태의 테이블 > 공간 낭비
    3. 데이터가 중복되는 상태 > 공간 낭비 + 데이터 관리 곤란
    4. 하나의 속성값이 원자값이 아닌 상태 > 더 이상 쪼개지지 않는 값을 넣어야 한다.

*/

create table tblTest (
    name varchar2(30) not null,
    age number(3) not null,
    nick varchar2(30) not null,
    id varchar2(30) not null
);

-- 홍길동, 20, 바보, hong
-- 아무개, 25, 바보, any
-- 테스트, 20, 멍멍이, test
-- 홍길동, 20, 바보, hong     -- 물리적 문제?

-- 홍길동 별명 수정
update tblTest set nick = '고양이' where id = 'hong'

-- 홍길동 탈퇴
delete from tblTest where 조건?




create table tblTest (
    name varchar2(30) primary key,
    age number(3) not null,
    hobby1 varchar2(300) null,
    hobby2 varchar2(300) null,
    hobby3 varchar2(300) null,
    ..
    hobby8 varchar2(300) null
);

-- 홍길동, 20, 독서, null, null, null, null, null, null, null
-- 아무개, 25, 달리기,헬스,게임, null, null, null, null, null
-- 테스트, 22, 달리기,헬스,게임,독서,낮잠,맛집,여행,코딩
-- 홍길동, 20, 독서, null, null, null, null, null, null, null
-- 홍길동, 20, 독서, null, null, null, null, null, null, null
-- 홍길동, 20, 독서, null, null, null, null, null, null, null
-- 홍길동, 20, 독서, null, null, null, null, null, null, null
-- 홍길동, 20, 독서, null, null, null, null, null, null, null
-- 홍길동, 20, 독서, null, null, null, null, null, null, null
-- 홍길동, 20, 독서, null, null, null, null, null, null, null
-- 홍길동, 20, 독서, null, null, null, null, null, null, null
-- 홍길동, 20, 독서, null, null, null, null, null, null, null
-- 홍길동, 20, 독서, null, null, null, null, null, null, null
-- 홍길동, 20, 독서, null, null, null, null, null, null, null
-- 홍길동, 20, 독서, null, null, null, null, null, null, null
-- 홍길동, 20, 독서, null, null, null, null, null, null, null
-- 홍길동, 20, 독서, null, null, null, null, null, null, null
-- 홍길동, 20, 독서, null, null, null, null, null, null, null



-- 직원 정보
-- 직원(번호(PK), 직원명, 급여, 거주지, 담당프로젝트)
create table tblStaff (
    seq number primary key,         --직원번호(PK)
    name varchar2(30) not null,     --직원명
    salary number not null,         --급여
    address varchar2(300) not null, --거주지
    project varchar2(300) null      --담당프로젝트
);

insert into tblStaff(seq, name, salary, address, project)
    values (1, '홍길동', 300, '서울시', '홍콩 수출');
insert into tblStaff(seq, name, salary, address, project)
    values (2, '아무개', 250, '인천시', 'TV 광고');
insert into tblStaff(seq, name, salary, address, project)
    values (3, '하하하', 350, '의정부시', '매출 분석');    
    
    
-- '홍길동"에게 담당 프로젝트가 1건 추가 > '고객 관리'
insert into tblStaff(seq, name, salary, address, project)
    values (4, '홍길동', 300, '서울시', '고객 관리');


-- '호호호' 직원 추가 + '게시판 관리, 회원 응대'
insert into tblStaff(seq, name, salary, address, project)
    values (5, '호호호', 250, '서울시', '게시판 관리,회원 응대');


-- 'TV 광고' 담당자 호출
select * from tblStaff where project = 'TV 광고';

-- 'TV 광고' > 'SNS 광고'
update tblStaff set project = 'SNS 광고' where project = 'TV 광고'; -- O,X


-- '회원 응대' 담당자 호출
-- 문제점!! > 데이터가 원자값이 아니다;;;
select * from tblStaff where project = '회원 응대';
select * from tblStaff where instr(project, '회원 응대') > 0;

-- '회원 응대' > '고객 불만 대응'
-- 문제점!! > 데이터가 원자값이 아니다;;;
update tblStaff set project = '고객 불만 대응' where instr(project, '회원 응대') > 0;

-- '고객 회원 응대 처리'


-- '홍길동' > 연봉 인상 > 350만원
update tblStaff set salary = 350 where seq = 1;










-- 급여 지급 > 담당자 > '홍길동' 급여 확인
-- 문제점!!! > 같은 데이터를 2번 이상 저장 > 데이터 설계문제!!!
select * from tblStaff where name = '홍길동'; -- 350 vs 300

select * from tblStaff;





drop table tblStaff;
drop table tblProject;


-- 직원 정보
-- 직원(번호(PK), 직원명, 급여, 거주지)
create table tblStaff (
    seq number primary key,         --직원번호(PK)
    name varchar2(30) not null,     --직원명
    salary number not null,         --급여
    address varchar2(300) not null  --거주지
); -- 부모 테이블


-- 프로젝트 정보
-- 프로젝트(프로젝트명)
create table tblProject (
    seq number primary key,                                 --프로젝트번호(PK)
    project varchar2(30) not null,                          --프로젝트명
    staff_seq number not null references tblStaff(seq)      --직원번호(FK) 외래키(참조키)
); -- 자식 테이블


insert into tblStaff (seq, name, salary, address) values (1, '홍길동', 300, '서울시');
insert into tblStaff (seq, name, salary, address) values (2, '아무개', 250, '인천시');
insert into tblStaff (seq, name, salary, address) values (3, '하하하', 350, '부산시');

insert into tblProject (seq, project, staff_seq) values (1, '홍콩 수출', 1);    --홍길동
insert into tblProject (seq, project, staff_seq) values (2, 'TV 광고', 2);      --아무개
insert into tblProject (seq, project, staff_seq) values (3, '매출 분석', 3);    --하하하
insert into tblProject (seq, project, staff_seq) values (4, '노조 협상', 1);    --홍길동
insert into tblProject (seq, project, staff_seq) values (5, '대리점 분양', 2);  --아무개

-- 1. 원자값 보장
-- 2. 데이터 중복 X
select * from tblStaff;
select * from tblProject;

-- A. 신입 사원 입사 > 신규 프로젝트 담당
-- A.1 신입 사원 추가(O)
insert into tblStaff (seq, name, salary, address) values (4, '호호호', 250, '성남시');

-- A.2 신규 프로젝트 추가(O)
insert into tblProject (seq, project, staff_seq) values (6, '자재 매입', 4);

-- A.3 신규 프로젝트 추가 > 문제 발생!!! > 유령 직원???
-- ORA-02291: integrity constraint (HR.SYS_C007139) violated - parent key not found
insert into tblProject (seq, project, staff_seq) values (7, '고객 유치', 5); --**** 논리 오류

-- 사장님!! '고객 유치' 담당자!!
select staff_seq from tblProject where project = '고객 유치';

select * from tblStaff where seq = 5;

select * from tblStaff where seq = (select staff_seq from tblProject where project = '고객 유치');




-- B. '홍길동' 퇴사
-- B.1 '홍길동' 삭제 -> 문제 발생!!!
-- ORA-02292: integrity constraint (HR.SYS_C007147) violated - child record found
delete from tblStaff where seq = 1;

select * from tblStaff where seq = (select staff_seq from tblProject where project = 'TV 광고');
select * from tblStaff where seq = (select staff_seq from tblProject where project = '홍콩 수출');

-- B.2 '아무개' 퇴사 > 인수 인계(위임)

update tblProject set staff_seq = 3 where staff_seq = 2;

update tblProject set staff_seq = (select seq from tblStaff where name = '하하하')
    where staff_seq = (select seq from tblStaff where name = '홍길동');

-- B.3 '아무개' 퇴사 > 삭제
delete from tblStaff where seq = 2;


select * from tblStaff;
select * from tblProject where staff_seq = 1;







-- 고객 테이블
create table tblCustomer (
    seq number primary key,         --고객번호(PK)
    name varchar2(30) not null,     --고객명
    tel varchar2(15) not null,      --연락처
    address varchar2(100) not null  --주소
);

-- 판매내역 테이블
create table tblSales (
    seq number primary key,                             --판매번호(PK)
    item varchar2(50) not null,                         --제품명
    qty number not null,                                --판매수량
    regdate date default sysdate not null,              --판매날짜
    cseq number not null references tblCustomer(seq)    --판매한 고객번호(FK)
);






-- [비디오 대여점]

-- 장르 테이블
create table tblGenre (
    seq number primary key,         --장르 번호(PK)
    name varchar2(30) not null,     --장르명
    price number not null,          --대여가격
    period number not null          --대여기간(일)
);

-- 비디오 테이블
create table tblVideo (
    seq number primary key,                         --비디오 번호(PK)
    name varchar2(100) not null,                    --비디오 제목
    qty number not null,                            --보유 수량
    company varchar2(50) null,                      --제작사
    director varchar2(50) null,                     --감독
    major varchar2(50) null,                        --주연배우
    genre number not null references tblGenre(seq)  --장르 번호(FK)
);


-- 고객 테이블
create table tblMember (
    seq number primary key,         --고객번호(PK)
    name varchar2(30) not null,     --고객명
    grade number(1) not null,       --고객등급(1,2,3)
    byear number(4) not null,       --생년
    tel varchar2(15) not null,      --연락처
    address varchar2(300) null,     --주소
    money number not null           --예치금
);

-- 대여 테이블
create table tblRent (
    seq number primary key,                             --대여번호(PK)
    member number not null references tblMember(seq),   --회원번호(FK)
    video number not null references tblVideo(seq),     --비디오번호(FK)
    rentdate date default sysdate not null,             --대여시각
    retdate date null,                                  --반납시각
    remark varchar2(500) null                           --비고
);


-- 장르 <- 비디오 <- 대여 -> 고객
select * from tblGenre;     --6
select * from tblVideo;     --11
select * from tblMember;    --10
select * from tblRent;      --6


/*

    조인, Join
    - (서로 관계를 맺은) 2개(1개) 이상의 테이블을 1개의 결과셋을 만드는 기술

    
    조인의 종류
    1. 단순 조인, CROSS JOIN, 카티션곱(데카르트곱)
    2. 내부 조인, INNER JOIN *****
    3. 외부 조인, OUTER JOIN *****
    4. 셀프 조인, SELF JOIN
    5. 전체 외부 조인, FULL OUTER JOIN

*/

-- 1. 단순 조인, CROSS JOIN, 카티션곱(데카르트곱)
--      - A 테이블 레코드 개수 x B 테이블 레코드 개수 = 결과셋 레코드 개수
--      - 쓸모없다. > 가치있는 행과 가치없는 행이 뒤섞여 있어서.. 
--      - 결과셋 행 개수 > 27개
--      - 결과셋 컬럼 개수 > 9개

select * from tblCustomer; --3명

select * from tblSales; --9건


select * from tblCustomer cross join tblSales; --ANSI-SQL(추천)
select * from tblCustomer, tblSales; --Oracle



/*
    
    2. 내부 조인, INNER JOIN *****
    - 단순 조인에서 유효한 레코드만 추출한 조인
    

    SELECT 컬럼리스트 FROM 테이블A CROSS JOIN 테이블B;
    
    SELECT 컬럼리스트 FROM 테이블A INNER JOIN 테이블B ON 테이블A.PK = 테이블B.FK; --ANSI-SQL
    
    SELECT 컬럼리스트 FROM 테이블A, 테이블B WHERE 테이블A.PK = 테이블B.FK; --Oracle
    
    
    SELECT 
        컬럼리스트 
    FROM 테이블A 
        INNER JOIN 테이블B 
            ON 테이블A.PK = 테이블B.FK; --조인 조건

*/

-- 직원 테이블, 프로젝트 테이블

-- 직원명단을 가져오시오.(+담당하는 프로젝트명를 포함해서)
select * from tblStaff;

select * from tblProject;

select
    *
from tblStaff cross join tblProject;

select
    *
from tblStaff inner join tblProject
    on tblStaff.seq = tblProject.staff_seq;

-- 고객 정보와 판매내역을 가져오기 > tblCustomer(고객명, 연락처), tblSales(어떤 물건, 몇개)?

-- 대부분의 상황에서 > 내부 조인의 결과는 자식 테이블 레코드와 동일한 레코드가 나온다. > 스스로 생각 ***
-- 대부분의 상황에서 > 내부 조인의 결과는 부모 테이블 레코드가 반복되는 현상이 생긴다. > 스스로 생각 ***
select
    name,
    tel,
    item,
    qty
from tblCustomer
    inner join tblSales
        on tblCustomer.seq = tblSales.cseq;
        -- on 부모테이블.PK = 자식테이블.FK



select * from tblGenre; --Parent Table

select * from tblVideo; --Child Table

-- 비디오 제목(tblVideo)과 대여 가격(tblGenre)을 가져오시오.
-- ORA-00918: column ambiguously defined > 컬럼이 모호하게 정의되었습니다.
select
    tblVideo.name,
    price
from tblGenre               --부모 테이블
    inner join tblVideo     --자식 테이블
        on tblGenre.seq = tblVideo.genre;



select
    tblVideo.name,
    tblGenre.price
from tblGenre              
    inner join tblVideo    
        on tblGenre.seq = tblVideo.genre;



select
    v.name,
    g.price,
    g.name
from tblGenre g           
    inner join tblVideo v
        on g.seq = v.genre;



select * from tblMan;
select * from tblWoman;


-- 커플 테이블
select
    m.name as "남자",
    w.name as "여자"
from tblMan m
    inner join tblWoman w
        on m.couple = w.name;



select * from tblCustomer;
select * from tblSales;

-- 고객명 + 판매물품명 가져오시오.
-- 1. 조인 > 고비용 + 속도 느림
select
    c.name as "고객명",
    s.item as "판매물품명"
from tblCustomer c
    inner join tblSales s
        on c.seq = s.cseq;

-- 2. 서브 쿼리 > 저비용 + 속도 빠름
select
    --cseq as "고객번호",
    (select name from tblCustomer where seq = tblSales.cseq) as "고개명",
    item as "판매물품명"
from tblSales; -- 자식 테이블



select * from tblGenre; -- 부모 
select * from tblVideo; -- 자식    부모
select * from tblRent;  --         자식

-- 3개의 테이블을 조인
select
    v.name,     --어떤 비디오?
    r.rentdate, --언제?
    g.price     --얼마?
from tblGenre g                              -- tblGenre x tblVideo
    inner join tblVideo v                    -- tblGenre x tblVideo
        on g.seq = v.genre                   -- tblGenre x tblVideo
            inner join tblRent r             -- tblVideo x tblRent
                on r.video = v.seq;          -- tblVideo x tblRent
                                             -- tblGenre x tblVideo x tblRent


-- 4개의 테이블을 조인
select
    --* 조인의 결과에는 *를 잘 사용하지 않는다.
    m.name as "회원명",
    v.name as "비디오명",
    r.rentdate as "언제",
    g.price as "가격"
from tblGenre g
    inner join tblVideo v
        on g.seq = v.genre
            inner join tblRent r
                on v.seq = r.video
                    inner join tblMember m
                        on m.seq = r.member;




select * from tblStaff; --직원
select * from tblSales; --판매

-- 100% 쓸모없는 결과
select
    *
from tblStaff f
    inner join tblSales e
        on f.seq = e.cseq; --아무 상관없는 관계



-- HR > 7개
select * from employees;    -- 직원 정보
select * from departments;  --직원들의 부서 정보
select * from locations;    --부서가 위치한 지역 정보
select * from countries;    -- 지역이 속한 국가 정보
select * from regions;      -- 국가가 속한 대륙 정보

select * from jobs;         -- 직원들의 직업 정보
select * from job_history;  --직원들이 이직 이력



select 
    e.first_name || ' ' || e.last_name as "직원명",
    d.department_name as "부서명",
    l.city as "도시명",
    c.country_name as "국가명",
    r.region_name as "대륙명",
    j.job_title as "직업"    
from employees e
    inner join departments d
        on d.department_id = e.department_id
            inner join locations l
                on l.location_id = d.location_id
                    inner join countries c
                        on c.country_id = l.country_id
                            inner join regions r
                                on r.region_id = c.region_id
                                    inner join jobs j
                                        on j.job_id = e.job_id;




/*
    
    3. 외부 조인, OUTER JOIN *****
    - 내부 조인의 반대(X)
    - 내부 조인 결과 + 결과 셋에 포함되지 못한 부모 테이블의 나머지 레코드를 합하는 행동
    
    SELECT 
        컬럼리스트
    FROM 테이블A
        INNER JOIN 테이블B
            ON 테이블A.컬럼 = 테이블B.컬럼;
            
    SELECT 
        컬럼리스트
    FROM 테이블A
        (LEFT|RIGHT) OUTER JOIN 테이블B
            ON 테이블A.컬럼 = 테이블B.컬럼;

*/

select * from tblCustomer;  --3명 > 4명
select * from tblSales;     --9건

insert into tblCustomer values (4, '호호호', '010-1234-5678', '서울시');


-- 9개 > 9개
-- 문장: 절의 실행 순서대로 읽는 연습!!! + 부드럽게(업무 상) 표현
-- + A > 물건을 한번이라도 구매한 이력이 있는 고객의 정보와 그 고객이 사간 판매내역을 가져오시오.(*****************)

-- 내부 조인 > 두 테이블에 동시에 존재하는 정보만 가져온다(**************)
--             회원 정보O + 그회원 구매한 정보O -> 가져옴
select
    *
from tblCustomer c
    inner join tblSales s
        on c.seq = s.cseq;


select
    *
from tblCustomer c
    cross join tblSales s;


-- 단순 조인 > 테이블 행 X 테이블 행 > 유효O + 유효X > 더미 데이터
-- 내부 조인 > 단순 조인 결과 > 유효한 행 추출
--               > 양쪽 테이블 모두 존재하는 데이터만 가져온다.

select * from tblCustomer;  --4명(3명-구매이력있음, 1명-구매이력없음)
select * from tblSales;        --9건(3명이 구매한 이력)

-- 고객 정보와 함께 구매 이력을 가져오시오.
select
    *
from tblCustomer c
    inner join tblSales s
        on c.seq = s.cseq;

-- 구매 이력과 상관없이              > 고객 정보와 함께 구매 이력을 가져오시오.
select
    *
from tblCustomer c 
    left outer join tblSales s 
        on c.seq = s.cseq;


-- tblVideo, tblRent

-- 대여가 한번이라도 된 비디오와 그 대여 내역을 가져오시오.
select * from tblVideo;
select * from tblRent;

select
    *
from tblVideo v
    inner join tblRent r on v.seq = r.video;

-- 대여가 한번이라도 됐었던 상품의 개수?
select
    count(distinct v.name) as "대여 기록있는 개수"
from tblVideo v
    inner join tblRent r on v.seq = r.video;


-- 대여와 상관없이 모든 비디오와 그 대여 내역을 가져오시오.
select 
    *
from tblVideo v
    left outer join tblRent r 
        on v.seq = r.video;

-- 대여를 한번이라도 한 고객의 정보와 대여 내역을 가져오시오.
select
    *
from tblMember m
    inner join tblRent r
        on m.seq = r.member;
        
-- 대여와 상관없이 모든 고객의 정보와 대여 내역을 가져오시오.
select
    *
from tblMember m
    left outer  join tblRent r
        on m.seq = r.member;


-- 대여 기록이 있는 회원의 이름과 대여 횟수를 가져오시오.
select
    m.name,
    count(*)
from tblMember m
    inner join tblRent r
        on m.seq = r.member
            group by m.name;

-- 대여 기록과 무관 > 모든 회원의 이름과 대여 횟수를 가져오시오.
select
    m.name,
    count(rentdate)
from tblMember m
    left outer  join tblRent r
        on m.seq = r.member
            group by m.name
                order by count(rentdate) desc;



/*
    
    4. 셀프 조인, SELF JOIN
    - 1개의 테이블을 사용해서 조인
    - 테이블이 스스로 관계를 맺는 경우
    - 다중 조인 + 내부 조인
    - 다중 조인 + 외부 조인
    - 셀프 조인 + 내부 조인
    - 셀프 조인 + 외부 조인
    
*/

-- 직원 테이블
create table tblSelf(
    seq number primary key,                     --직원번호(PK)
    name varchar2(30) not null,                  --직원명
    department varchar2(50) null,               --부서명
    super number null references tblSelf(seq) --상사번호(FK)
);

insert into tblSelf values (1, '홍사장', null, null);
insert into tblSelf values (2, '깁부장', '영업부', 1);
insert into tblSelf values (3, '이과장', '영업부', 2);
insert into tblSelf values (4, '정대리', '영업부', 3);
insert into tblSelf values (5, '최사원', '영업부', 4);
insert into tblSelf values (6, '박부장', '개발부', 1);
insert into tblSelf values (7, '하과장', '개발부', 6);


-- 직원 명단을 가져오시오. 단 상사의 이름까지
-- 1. join
-- 2. sub query
select
    b.name as "직원명",
    b.department as "부서명",
    a.name as "상사명"
from tblSelf a
    inner join tblSelf b
        on a.seq = b.super;

select
    b.name as "직원명",
    b.department as "부서명",
    a.name as "상사명"
from tblSelf a
    right outer join tblSelf b
        on a.seq = b.super;

select
    name as "직원명",
    department as "부서",
    super,
    (select name from tblSelf where seq = super) as "상사명"
from tblSelf a;


-- 직원명 + 매니저명
select * from employees;

select
    b.first_name as "직원명",
    a.first_name as "매니저명"
from employees a
    inner join employees b
        on a.employee_id = b.manager_id;


-- 5. 전체 외부조인, FULL OUTER JOIN
-- 서로 참조하고 있는 관계에서만 사용이 가능한 조인

select * from tblMan;
select * from tblWoman;

select
    *
from tblMan m
    right outer join tblWoman w
        on m.couple = w.name;


select
    *
from tblMan m
    full outer join tblWoman w
        on m.couple = w.name;











